INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Polna 44', '04-222', 'Warszawa', 'Polska');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Leśna 3', '25-554', 'Wrocław', 'Polska');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Szkolna 17', '18-322', 'Białystok', 'Polska');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Słoneczna 13', '44-123', 'Poznań', 'Polska');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Marszałkowska 321', '00-932', 'Warszawa', 'Polska');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Józefa Piłsudskiego', '83-324', 'Szczecin', 'Polska');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Hell', '12-234', 'Berlin', 'Niemcy');
INSERT INTO ADDRESS (STREET, POSTAL_CODE, CITY, COUNTRY) VALUES ('Schnitzel', '45-234', 'Frankfurt', 'Niemcy');

INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES (TO_DATE('30/03/1975', 'DD/MM/YYYY'), TO_DATE('13/04/1995', 'DD/MM/YYYY'), 'Tomasz', 'Złomiarz', 1);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1945-07-05T00:00:00', '1967-03-22T00:00:00', 'Jurek', 'Ogórek', 2);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1967-11-23T00:00:00', '1986-10-09T00:00:00', 'Karolina', 'Malina', 3);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1988-01-28T00:00:00', '2010-01-12T00:00:00', 'Zenek', 'Błazenek', 4);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1997-05-06T00:00:00', '2016-04-29T00:00:00', 'Jan', 'Kowalski', 5);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1952-09-11T00:00:00', '1972-12-19T00:00:00', 'Piotr', 'Nowak', 6);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1976-10-08T00:00:00', '1995-03-25T00:00:00', 'Bogdan', 'Schetyna', 7);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1972-12-14T00:00:00', '1998-02-13T00:00:00', 'Mirosław', 'Kwiatkowski', 8);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('2001-02-17T00:00:00', '2020-07-23T00:00:00', 'Remigiusz', 'Sztacheta', 1);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1992-07-02T00:00:00', '2012-11-08T00:00:00', 'Barbara', 'Kwiatkowska', 3);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1990-03-15T00:00:00', '2018-08-11T00:00:00', 'Anna', 'Jaki', 4);
-- INSERT INTO PERSON (BIRTH_DATE, DRIVING_LICENCE_DATE, NAME, SURNAME, ADDRESS_ID) VALUES ('1958-03-09T00:00:00', '1989-05-19T00:00:00', 'Teresa', 'Palikot', 5);

-- INSERT INTO CAR_MODEL (BRAND, ENGINE_CAPACITY, ENGINE_TYPE, MODEL_GENERATION, MODEL_NAME) VALUES ('Porsche', 3000, 'Diesel', '3', '488');
-- INSERT INTO CAR_MODEL (BRAND, ENGINE_CAPACITY, ENGINE_TYPE, MODEL_GENERATION, MODEL_NAME) VALUES ('Tesla', 3000, 'Diesel', '3', '488');
-- INSERT INTO CAR_MODEL (BRAND, ENGINE_CAPACITY, ENGINE_TYPE, MODEL_GENERATION, MODEL_NAME) VALUES ('Porsche', 3000, 'Diesel', '3', '488');
-- INSERT INTO CAR_MODEL (BRAND, ENGINE_CAPACITY, ENGINE_TYPE, MODEL_GENERATION, MODEL_NAME) VALUES ('Porsche', 3000, 'Diesel', '3', '488');
-- INSERT INTO CAR_MODEL (BRAND, ENGINE_CAPACITY, ENGINE_TYPE, MODEL_GENERATION, MODEL_NAME) VALUES ('Porsche', 3000, 'Diesel', '3', '488');
--
-- INSERT INTO ACCIDENT_PARTICIPANT (CAR_NUMBER, IS_RESPONSIBLE) VALUES ();
--
-- INSERT INTO ACCIDENT (ACCIDENT_DATE, TYPE) VALUES ();
--
-- INSERT INTO CAR (VIN_NUMBER, MANUFACTURE_YEAR, REGISTRATION_NUMBER, CAR_MODEL_ID) VALUES ();
--
-- INSERT INTO INSURANCE_POLICY (CREATION_DATE, EXPIRATION_DATE, INSURANCE_AMOUNT, INSURANCE_PRICE, CAR_VIN_NUMBER)  VALUES ();
--
-- INSERT INTO ACCIDENT_PARTICIPANT_PERSONS (ACCIDENT_PARTICIPANT_ID, PERSONS_ID) VALUES ();
--
-- INSERT INTO ACCIDENT_PARTICIPANTS (ACCIDENT_ID, PARTICIPANTS_ID) VALUES ();
--
-- INSERT INTO CAR_PERSON (CAR_ID, PERSON_ID) VALUES ();