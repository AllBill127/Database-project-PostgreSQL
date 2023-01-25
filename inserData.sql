INSERT INTO 
	asmuo (asmens_kodas,vardas,pavarde,gimimo_data)
VALUES
	(29512055297,	'Rokas',		'Adomaitis',		'1995-12-05'),
	(67310290266,	'Gvidas',		'Stankevicius',		'1973-10-29'),
	(97809035079,	'Mykolas',		'Simonis',			'1978-09-03'),
	(49808241003,	'Leonas',		'Paulauskas',		'1998-08-24'),
	(80205066200,	'Aleksandras',	'Zukauskas',		'2002-05-06'),
	(18907147882,	'Martynas',		'Butkus',			'1989-07-14'),
	(67810210359,	'Ernestas',		'Urbonas',			'1978-10-21'),
	(76811153854,	'Augustinas',	'Urbonas',			'1968-11-15'),
	(56906062877,	'Gintautas',	'Petraukas',		'1969-06-06'),
	(17007053054,	'Gintaras',		'Kazlauskas',		'1970-07-05'),
	(97210172296,	'Vaslijus',		'Simonis',			'1972-10-17'),
	(77506282645,	'Adomas',		'Jonaitis',			'1975-06-28'),
	(87707238623,	'Adele',		'Stankeviciute',	'1977-07-23'),
	(37710163312,	'Karolina',		'Paulauskiene',		'1977-10-16'),
	(17812284922,	'Vidmantas',	'Vasiliauskas',		'1978-12-28'),
	(48209096571,	'Vida',			'Urboniene',		'1982-09-09'),
	(68306190530,	'Vilhelmas',	'Urbonaitis',		'1983-06-19'),
	(38804079833,	'Anzelika',		'Vasiliauskiene',	'1988-04-07'),
	(19004281625,	'Edgaras',		'Zaliauskas',		'1990-04-28'),
	(49106121201,	'Solveiga',		'Rimaite',			'1991-06-12'),
	(89106241348,	'Romualdas',	'Astrauskas',		'1991-06-24'),
	(69211249594,	'Aurelijus',	'Liaukys',			'1992-11-24'),
	(89305064256,	'Edmundas',		'Giriauskas',		'1993-05-06'),
	(89601270262,	'Vytenis',		'Kiliauskas',		'1996-01-27'),
	(40105230329,	'Marijus',		'Urbonas',			'2001-05-23'),
	(86503128626,	'Renata',		'Kavaliauskiene',	'1965-03-12'),
	(27707223752,	'Jonas',		'Kavaliauskas',		'1977-07-22'),
	(88512224336,	'Valdas',		'Kavaliauskas',		'1985-12-22'),
	(68803140568,	'Arturas',		'Petrauskas',		'2005-03-14'),
	(65509106252,	'Marius',		'Stankevicius',		'1955-09-10')
;





INSERT INTO
	firma (id,pavadinimas,sukurimo_data,verte,kapitalas)
VALUES
	(101,	'Bilduva',		'1984-04-15',		50210.54,	280000),
	(202,	'Savita',		'1995-06-26',		105620.45,	500000)
;

INSERT INTO
	firma (id,pavadinimas,sukurimo_data,verte)
VALUES
	(303,	'Plytuva',		'2001-08-04',		-10890.67)
;
	
INSERT INTO
	firma (id,pavadinimas,verte,kapitalas)
VALUES
	(404,	'Statuva',		-108500.12,		20000)
;
/* --Capital constraint
INSERT INTO firma (id,pavadinimas,verte,kapitalas)
VALUES (404,	'Statuva',		'-108500.12',		-10);*/





INSERT INTO
	savininkas (asmens_kodas,firmos_id)
VALUES
	(40105230329,	101),
	(88512224336,	101),
	(86503128626,	202),
	(27707223752,	202),
	(88512224336,	202),
	(89601270262,	303),
	(40105230329,	404)
;





INSERT INTO
	pastatas (adresas,pradejimo_data,statybu_kaina,pardavimo_kaina,firmos_id)
VALUES
	('kaimo g. 27, Vilnius, Lietuva',	'2019-03-15',		80000,	90000,		202),
	('kaimo g. 28, Vilnius, Lietuva',	'2019-03-15',		80000,	90000,		202),
	('kaimo g. 29, Vilnius, Lietuva',	'2019-03-15',		80000,	90000,		202),
	('kaimo g. 30, Vilnius, Lietuva',	'2019-03-15',		80000,	90000,		202),
	('kaimo g. 31, Vilnius, Lietuva',	'2019-03-15',		80000,	90000,		202),
	('gerviu g. 123, Moletai, Lietuva',	'2022-03-24',		150000,	170000,		101)
;

INSERT INTO
	pastatas (adresas,statybu_kaina,pardavimo_kaina,firmos_id)
VALUES
	('lempu g. 1, Kaunas, Lietuva',		75000,	85000,	101)
;

INSERT INTO
	pastatas (adresas,pradejimo_data,statybu_kaina)
VALUES
	('Seskines sen. Vilnius, Lietuva',	'1987-08-15',	150000000)
;
/* --Adress constraint
INSERT INTO pastatas (adresas,pradejimo_data,statybu_kaina,pardavimo_kaina,firmos_id)
VALUES('gerviu g. 123, Moletai, Lietuva',	'2022-03-24',		1500,	1800,		101);*/
/* --Selling_price constraint
INSERT INTO pastatas (adresas,pradejimo_data,statybu_kaina,pardavimo_kaina,firmos_id)
VALUES('gerviu g. 124, Moletai, Lietuva',	'2022-03-24',		150000,	130000,		101);*/
/* --Firm_id.kapitalas constraint
INSERT INTO pastatas (adresas,pradejimo_data,statybu_kaina,pardavimo_kaina,firmos_id)
VALUES('gerviu g. 125, Moletai, Lietuva',	'2022-03-24',		150000,	180000,		404);*/

/* --Update firmos_id
UPDATE pastatas SET firmos_id = 404 WHERE id = 1008;
UPDATE pastatas SET firmos_id = 202 WHERE id = 1008;*/





INSERT INTO
	padalinys (firmos_id,atsakomybe,pastato_id)
VALUES
	(101,	'muryjimas',	1006),
	(101,	'elektros suvedimas',	1006),
	(202,	'vandentiekis',	1001),
	(202,	'elektros suvedinas', 1002)
;

INSERT INTO
	padalinys (firmos_id)
VALUES
	(202)
;
/* --Building_id constraint
INSERT INTO padalinys (firmos_id,pastato_id) 
VALUES(202,	1007);*/

/* --Update pastato_id
UPDATE padalinys SET pastato_id = 1008 WHERE firmos_id = 202 AND nr = 3;*/
/* --Update atsakomybe
UPDATE padalinys SET atsakomybe = 'betonavimas' WHERE firmos_id = 202 AND nr = 3;*/





INSERT INTO 
	darbuotojas (idarbinimo_data,asmens_kodas,atlyginimas,firmos_id,padalinio_nr)
VALUES
	('2015-10-15',	29512055297,	1500,	101,	1),
	('1995-05-23',	67310290266,	1340,	101,	1),
	('1999-08-17',	97809035079,	1500,	101,	2),
	('2020-02-05',	49808241003,	1860,	101,	2),
	('2021-06-26',	80205066200,	1500,	202,	1),
	('2016-06-26',	18907147882,	1200,	202,	2),
	('2003-03-12',	67810210359,	1750,	202,	2),
	('1995-10-15',	76811153854,	950,	202,	3),
	('1995-08-19',	56906062877,	1000,	202,	3)
;

INSERT INTO 
	darbuotojas (asmens_kodas,firmos_id,padalinio_nr)
VALUES
	(17007053054,	101,	1)
;
/* --Owner trigger constraint
INSERT INTO darbuotojas (idarbinimo_data,asmens_kodas,atlyginimas,firmos_id,padalinio_nr)
VALUES ('1986-10-15',	27707223752,	800,	101,	1);*/
/* --Hired_date mismatch with firm_date trigger constraint
INSERT INTO darbuotojas (idarbinimo_data,asmens_kodas,atlyginimas,firmos_id,padalinio_nr)
VALUES ('1982-10-15',	69211249594,	800,	202,	1);*/
/* --Age to young trigger constraint
INSERT INTO darbuotojas (asmens_kodas,atlyginimas,firmos_id,padalinio_nr)
VALUES (68803140568,	800,	101,	1);*/
/* --Age to old trigger constraint
INSERT INTO darbuotojas (asmens_kodas,atlyginimas,firmos_id,padalinio_nr)
VALUES (65509106252,	800,	101,	1);*/
/* --Vage constraint
INSERT INTO darbuotojas (idarbinimo_data,asmens_kodas,atlyginimas,firmos_id,padalinio_nr)
VALUES ('2019-10-15',	89305064256,	600,	101,	1);*/
