/*DROP TRIGGER kapitalo_uztenka ON pastatas;
DROP TRIGGER trg_01_pastatas_priklauso_firmai ON padalinys;
DROP TRIGGER trg_02_gen_padalinio_nr ON padalinys;
DROP TRIGGER trg_01_firma_dar_nesukurta ON darbuotojas;
DROP TRIGGER trg_02_asmuo_savininkas ON darbuotojas;
DROP TRIGGER trg_03_amziaus_apribojimas ON darbuotojas;
*/

CREATE OR REPLACE FUNCTION kapitalo_uztenka_triggered()
	RETURNS trigger AS
$BODY$
DECLARE kapitalas NUMERIC (12,2);
BEGIN
	SELECT firma.kapitalas
	INTO kapitalas
	FROM firma
	WHERE firma.id = NEW.firmos_id;
	
	IF (NEW.firmos_id IS NULL)
		THEN RETURN NEW;
	ELSEIF (kapitalas >= NEW.statybu_kaina)
		THEN RETURN NEW;
	ELSE
		RAISE NOTICE 'firmos % kapitalo neuztenka pastatui statyti, todel ji nepriskirta', NEW.firmos_id;
		NEW.firmos_id = NULL;
		RETURN NEW;
	END IF;	
END;
$BODY$ 
LANGUAGE plpgsql
;

CREATE TRIGGER kapitalo_uztenka
	BEFORE INSERT OR UPDATE
	ON pastatas
	FOR EACH ROW
	EXECUTE PROCEDURE kapitalo_uztenka_triggered()
;





CREATE OR REPLACE FUNCTION pastatas_nepriklauso_firmai_triggered()
	RETURNS trigger AS
$BODY$
DECLARE firma INTEGER;
BEGIN
	SELECT pastatas.firmos_id
	INTO firma
	FROM pastatas
	WHERE pastatas.id = NEW.pastato_id;
	
	IF (NEW.pastato_id IS NULL)
		THEN RETURN NEW;
	ELSEIF (firma = NEW.firmos_id)
		THEN RETURN NEW;
	ELSE
		RAISE NOTICE 'firma % neatsakinga uz % pastata, todel ji nepriskirta', NEW.firmos_id, NEW.pastato_id;
		NEW.pastato_id = NULL;
		RETURN NEW;
	END IF;	
END;
$BODY$ 
LANGUAGE plpgsql
;

CREATE TRIGGER trg_01_nepastatas_priklauso_firmai
	BEFORE INSERT OR UPDATE
	ON padalinys
	FOR EACH ROW
	EXECUTE PROCEDURE pastatas_nepriklauso_firmai_triggered()
;





CREATE OR REPLACE FUNCTION gen_padalinio_nr_triggered()
	RETURNS trigger AS
$BODY$
DECLARE	firma	INTEGER;
		nrCount	SMALLINT;
BEGIN
	SELECT COUNT(*)
	INTO nrCount
	FROM padalinys
	WHERE padalinys.firmos_id = NEW.firmos_id;
	
	NEW.nr = nrCount + 1;
	RETURN NEW;
END;
$BODY$ 
LANGUAGE plpgsql
;

CREATE TRIGGER trg_02_gen_padalinio_nr
	BEFORE INSERT OR UPDATE
	ON padalinys
	FOR EACH ROW
	EXECUTE PROCEDURE gen_padalinio_nr_triggered()
;





CREATE OR REPLACE FUNCTION firma_dar_nesukurta_triggered()
	RETURNS trigger AS
$BODY$
DECLARE sukurta DATE;
BEGIN
	SELECT firma.sukurimo_data
	INTO sukurta
	FROM firma
	WHERE firma.id = NEW.firmos_id;
	
	IF (sukurta <= NEW.idarbinimo_data)
		THEN RETURN NEW;
	ELSE
		RAISE EXCEPTION 'idarbinimo data ankstesne uz firmos sukurimo data - %', sukurta;
	END IF;	
END;
$BODY$ 
LANGUAGE plpgsql
;

CREATE TRIGGER trg_01_firma_dar_nesukurta
	BEFORE INSERT OR UPDATE
	ON darbuotojas
	FOR EACH ROW
	EXECUTE PROCEDURE firma_dar_nesukurta_triggered()
;





CREATE OR REPLACE FUNCTION asmuo_savininkas_triggered()
	RETURNS trigger AS
$BODY$
DECLARE firma	INTEGER;
BEGIN
	SELECT savininkas.firmos_id
	INTO firma
	FROM savininkas
	WHERE savininkas.asmens_kodas = NEW.asmens_kodas;
	
	IF (firma IS NULL)
		THEN RETURN NEW;
	ELSE
		RAISE EXCEPTION 'asmuo % yra % firmos savininkas', NEW.asmens_kodas, firma;
	END IF;	
END;
$BODY$ 
LANGUAGE plpgsql
;

CREATE TRIGGER trg_02_asmuo_savininkas
	BEFORE INSERT OR UPDATE
	ON darbuotojas
	FOR EACH ROW
	EXECUTE PROCEDURE asmuo_savininkas_triggered()
;





CREATE OR REPLACE FUNCTION amziaus_apribojimas_triggered()
	RETURNS trigger AS
$BODY$
DECLARE gime DATE;
BEGIN
	SELECT asmuo.gimimo_data
	INTO gime
	FROM asmuo
	WHERE asmuo.asmens_kodas = NEW.asmens_kodas;
	
	IF (EXTRACT(YEAR FROM AGE(NEW.idarbinimo_data, gime)) < 18)
		THEN RAISE EXCEPTION 'asmuo % gimes % yra nepilnametis', NEW.asmens_kodas, gime;
	ELSEIF (EXTRACT(YEAR FROM AGE(NEW.idarbinimo_data, gime)) > 65)
		THEN RAISE EXCEPTION 'asmuo % gimes % yra pencijinio amziaus', NEW.asmens_kodas, gime;
	ELSE
		RETURN NEW;
	END IF;	
END;
$BODY$ 
LANGUAGE plpgsql
;

CREATE TRIGGER trg_03_amziaus_apribojimas
	BEFORE INSERT OR UPDATE
	ON darbuotojas
	FOR EACH ROW
	EXECUTE PROCEDURE amziaus_apribojimas_triggered()
;





CREATE OR REPLACE FUNCTION atnaujinti_mat_virt_lentele()
	RETURNS trigger AS
$BODY$
BEGIN
	REFRESH MATERIALIZED VIEW pastatu_statistika;
	RETURN NULL;
END;
$BODY$
LANGUAGE plpgsql
;

CREATE TRIGGER trg_atnaujinti_dirba_objekte
	AFTER INSERT OR UPDATE OR DELETE
	ON firma
	FOR EACH ROW
	EXECUTE PROCEDURE atnaujinti_mat_virt_lentele()
;
CREATE TRIGGER trg_atnaujinti_dirba_objekte
	AFTER INSERT OR UPDATE OR DELETE
	ON savininkas
	FOR EACH ROW
	EXECUTE PROCEDURE atnaujinti_mat_virt_lentele()
;
CREATE TRIGGER trg_atnaujinti_dirba_objekte
	AFTER INSERT OR UPDATE OR DELETE
	ON pastatas
	FOR EACH ROW
	EXECUTE PROCEDURE atnaujinti_mat_virt_lentele()
;
