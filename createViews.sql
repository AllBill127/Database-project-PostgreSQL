CREATE MATERIALIZED VIEW pastatu_statistika AS
	WITH
		pastatai (firma, skaicius, statybu_suma, pardavimo_suma) AS
		(SELECT firmos_id, COUNT(*) AS skaicius, SUM(statybu_kaina) AS statybu_suma, SUM(pardavimo_kaina) AS pardavimo_suma
		FROM pastatas
		GROUP BY firmos_id) 

	SELECT firma.*, pastatai.skaicius, pastatai.statybu_suma, pastatai.pardavimo_suma
	FROM firma, pastatai
	WHERE firma.id = pastatai.firma
WITH NO DATA;
/*
SELECT * FROM pastatu_statistika;*/





CREATE VIEW darbuotojai_aukstesniu_atlyginimu AS
	SELECT asmens_kodas, firmos_id, padalinio_nr, atlyginimas
	FROM darbuotojas
	WHERE atlyginimas >= 1500
	ORDER BY atlyginimas
;
/*
SELECT * FROM darbuotojai_aukstesniu_atlyginimu;*/





CREATE VIEW nesenai_pradeti_pastatai AS
	SELECT *
	FROM pastatas
	WHERE EXTRACT(YEAR FROM AGE(pradejimo_data)) <= 2
	ORDER BY firmos_id, adresas
;
/*
SELECT * FROM nesenai_pradeti_pastatai;*/





CREATE VIEW firmos_darbuotojai AS
	SELECT padalinys.firmos_id, nr AS "padalinio nr", asmens_kodas AS "darbuotojas"
	FROM padalinys, darbuotojas
	WHERE padalinys.firmos_id = darbuotojas.firmos_id
		AND padalinys.nr = darbuotojas.padalinio_nr
	ORDER BY padalinys.firmos_id, padalinio_nr
;
/*
SELECT * FROM firmos_darbuotojai;*/





CREATE VIEW darbuotoju_info AS 
	SELECT firma.pavadinimas AS "firma", asmuo.vardas, asmuo.pavarde, darbuotojas.atlyginimas, padalinys.atsakomybe, padalinys.pastato_id
	FROM firma, darbuotojas, asmuo, padalinys
	WHERE darbuotojas.firmos_id = firma.id
		AND darbuotojas.asmens_kodas = asmuo.asmens_kodas
		AND darbuotojas.firmos_id = padalinys.firmos_id
		AND darbuotojas.padalinio_nr = padalinys.nr
	ORDER BY firma.pavadinimas, padalinys.pastato_id
;
/*
SELECT * FROM darbuotoju_info;*/
