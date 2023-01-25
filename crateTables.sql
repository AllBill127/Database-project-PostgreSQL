DROP MATERIALIZED VIEW pastatu_statistika;
DROP VIEW darbuotoju_info;
DROP VIEW firmos_darbuotojai;
DROP VIEW darbuotojai_aukstesniu_atlyginimu;
DROP VIEW nesenai_pradeti_pastatai;
DROP TABLE IF EXISTS asmuo, firma, savininkas, padalinys, pastatas, darbuotojas;

CREATE TABLE IF NOT EXISTS asmuo (
	asmens_kodas 	CHAR (11) 		PRIMARY KEY,
	vardas 			VARCHAR (50) 	NOT NULL,
	pavarde 		VARCHAR (50) 	NOT NULL,
	gimimo_data 	DATE 			NOT NULL
);

CREATE TABLE IF NOT EXISTS firma (
	id 				INTEGER 		PRIMARY KEY,
	pavadinimas 	VARCHAR (50) 	NOT NULL,
	sukurimo_data 	DATE 			NOT NULL 	DEFAULT NOW(),
	verte 			NUMERIC (12,2) 	NOT NULL,
	kapitalas		NUMERIC (12,2)	NOT NULL 	DEFAULT 0
					CONSTRAINT bankrotas CHECK (kapitalas >= 0)
);

CREATE TABLE IF NOT EXISTS savininkas (
	asmens_kodas 	CHAR (11),
	firmos_id 		INTEGER,
	
	PRIMARY KEY (asmens_kodas, firmos_id),
	FOREIGN KEY (asmens_kodas)
		REFERENCES asmuo (asmens_kodas) 		ON DELETE OR UPDATE CASCADE,
	FOREIGN KEY (firmos_id)
		REFERENCES firma (id) 		ON DELETE OR UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS pastatas (
	id 				INTEGER 		PRIMARY KEY
					GENERATED ALWAYS AS IDENTITY (START WITH 1000 INCREMENT BY 1),
	adresas 		TEXT 			UNIQUE 		NOT NULL,
	pradejimo_data 	DATE 			NOT NULL	DEFAULT NOW(),
	statybu_kaina 	NUMERIC (12,2) 	NOT NULL,
	pardavimo_kaina NUMERIC (12,2) 	DEFAULT NULL
					CONSTRAINT nuostolis CHECK (statybu_kaina < pardavimo_kaina),
	firmos_id 		INTEGER 		DEFAULT NULL /*trigger assign if firma.kapitalas > statybu_kaina else default null*/
);

CREATE TABLE IF NOT EXISTS padalinys (
	firmos_id 		INTEGER			NOT NULL,
	nr 				SMALLINT 		NOT NULL,	/*trigger generate nr depending on count(padalinys.firmos_id.)*/
	atsakomybe 		VARCHAR (100) 	NOT NULL	DEFAULT 'N/A',
	pastato_id 		INTEGER			DEFAULT NULL,	/*trigger check if pastatas.firmos_id = padalinys.Firmos_id*/
	
	PRIMARY KEY (firmos_id, nr),
	FOREIGN KEY (firmos_id)
		REFERENCES firma (id) 		ON DELETE OR UPDATE CASCADE,
	FOREIGN KEY (pastato_id)
		REFERENCES pastatas (id) 		ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS darbuotojas (
	id				INTEGER			PRIMARY KEY
					GENERATED ALWAYS AS IDENTITY (START WITH 10000 INCREMENT BY 1),
	idarbinimo_data DATE 			NOT NULL	DEFAULT NOW(),	/*trigger to check if idarbinimo_data >= firma.sukurimo_data*/
	asmens_kodas 	CHAR (11) 		UNIQUE 		NOT NULL,	/*trigger to check if asmens_kodas.gimimo_data + 18 <= idarbinimo_data AND not part of savininkas.asmens_kodas*/	
	atlyginimas 	NUMERIC(12,2) 	NOT NULL	DEFAULT 730
					CONSTRAINT minimumas CHECK (atlyginimas >= 730),
	firmos_id 		INTEGER			NOT NULL,
	padalinio_nr 	SMALLINT		NOT NULL,
	
	FOREIGN KEY (asmens_kodas)
		REFERENCES asmuo (asmens_kodas) 		ON DELETE OR UPDATE CASCADE,
	FOREIGN KEY (firmos_id, padalinio_nr)
		REFERENCES padalinys (firmos_id, nr) 	ON DELETE OR UPDATE CASCADE
);





CREATE UNIQUE INDEX firmosPavadinimas ON firma (
	pavadinimas
);

CREATE INDEX firmosPastatai ON pastatas (
	firmos_id
);

/*test if index is used*/
--explain select * from pastatas where firmos_id = 404;
--explain select * from firma where pavadinimas = 'Savita';
