-------- Funkcje --------

-- 1
CREATE OR replace FUNCTION calculate_engine_type_ratio(v_year NUMBER, v_country VARCHAR2)
RETURN NUMBER
AS

    v_gasoline_percent NUMBER := 0;
    v_diesel_percent NUMBER := 0;
    v_max_percent NUMBER := 50;
    v_car_number NUMBER;
    v_gasoline_number NUMBER;
    v_diesel_number NUMBER;

BEGIN

    SELECT COUNT(*) INTO v_car_number
    FROM CAR C
    JOIN CAR_PERSON CP on C.VIN_NUMBER = CP.CAR_ID
    JOIN PERSON P on P.ID = CP.PERSON_ID
    JOIN ADDRESS A on P.ADDRESS_ID = A.ID
    WHERE A.COUNTRY = v_country;


    IF v_car_number != 0 THEN

        SELECT COUNT(*) INTO v_gasoline_number
        FROM CAR C
        JOIN CAR_MODEL CM on CM.ID = C.CAR_MODEL_ID
        JOIN CAR_PERSON CP on C.VIN_NUMBER = CP.CAR_ID
        JOIN PERSON P on P.ID = CP.PERSON_ID
        JOIN ADDRESS A on P.ADDRESS_ID = A.ID
        WHERE A.COUNTRY = v_country AND CM.ENGINE_TYPE = 'Gasoline' AND EXTRACT(YEAR FROM C.MANUFACTURE_YEAR) > v_year;

        SELECT COUNT(*) INTO v_diesel_number
        FROM CAR C
        JOIN CAR_MODEL CM on CM.ID = C.CAR_MODEL_ID
        JOIN CAR_PERSON CP on C.VIN_NUMBER = CP.CAR_ID
        JOIN PERSON P on P.ID = CP.PERSON_ID
        JOIN ADDRESS A on P.ADDRESS_ID = A.ID
        WHERE A.COUNTRY = v_country AND CM.ENGINE_TYPE = 'Diesel' AND EXTRACT(YEAR FROM C.MANUFACTURE_YEAR) > v_year;

        v_gasoline_percent := ROUND(v_gasoline_number/v_car_number, 2) * 100;
        v_diesel_percent := ROUND(v_diesel_number/v_car_number, 2) * 100;

        dbms_output.put_line(v_gasoline_percent || ' ' || v_diesel_percent);


    ELSE
        dbms_output.put_line('No cars were found');
    END IF;

    IF v_gasoline_percent > v_diesel_percent THEN
        v_max_percent := v_gasoline_percent;

    ELSIF v_gasoline_percent < v_diesel_percent THEN
        v_max_percent := v_diesel_percent;
    END IF;

    RETURN v_max_percent;

end;
/


DECLARE
CURSOR cr IS
    SELECT DISTINCT COUNTRY FROM ADDRESS;

BEGIN
    FOR country_name IN cr LOOP
        dbms_output.put_line('Max rate in ' || country_name.COUNTRY || ' = ' || calculate_engine_type_ratio(2000, country_name.COUNTRY));
    END LOOP;
END;


-- 2
CREATE OR replace FUNCTION determine_most_popular_car(v_engine_type VARCHAR2, v_country VARCHAR2)
RETURN VARCHAR2
AS

    v_most_popular_car_model VARCHAR2(100) := ' ';
    v_most_popular_number_car NUMBER := 0;
    v_number_car NUMBER := 0;

    CURSOR CUR_car IS
        SELECT DISTINCT BRAND || ' ' || MODEL_NAME AS MODEL FROM CAR_MODEL;

BEGIN

    FOR c_car IN CUR_car
    LOOP
        SELECT COUNT(DISTINCT C.VIN_NUMBER) INTO v_number_car
        FROM CAR C
        JOIN CAR_MODEL CM ON C.CAR_MODEL_ID = CM.ID
        JOIN CAR_PERSON CP on C.VIN_NUMBER = CP.CAR_ID
        JOIN PERSON P on P.ID = CP.PERSON_ID
        JOIN ADDRESS A ON P.ADDRESS_ID = A.ID
        WHERE A.COUNTRY = v_country
        AND CM.BRAND || ' ' || CM.MODEL_NAME = c_car.MODEL
        AND CM.ENGINE_TYPE = v_engine_type;

        IF v_most_popular_number_car < v_number_car THEN
            v_most_popular_number_car := v_number_car;
            v_most_popular_car_model := c_car.MODEL;

        end if;

    end loop;

    RETURN v_most_popular_car_model;
end;
/

SELECT COUNTRY, determine_most_popular_car('Diesel', COUNTRY) AS MOST_POPULAR_CAR FROM (SELECT DISTINCT COUNTRY FROM ADDRESS);





-------- Procedury --------

-- 1
CREATE OR REPLACE PROCEDURE reduce_car_owner(car_vin_number VARCHAR)
AS
    CURSOR cars IS
        SELECT CAR_ID FROM CAR_PERSON
            WHERE CAR_ID = car_vin_number
            GROUP BY CAR_ID
            HAVING COUNT(CAR_ID) >= 2;
BEGIN
    FOR car IN cars LOOP
        DELETE FROM CAR_PERSON CP
            WHERE CP.PERSON_ID IN
                  (SELECT CP2.PERSON_ID FROM CAR_PERSON CP2
                   JOIN PERSON P on P.ID = CP2.PERSON_ID
                    WHERE CP2.CAR_ID = car.CAR_ID AND P.BIRTH_DATE != (
                        SELECT MIN(P2.BIRTH_DATE) FROM CAR_PERSON CP3
                       JOIN PERSON P2 ON P2.ID = CP3.PERSON_ID
                        WHERE CP3.CAR_ID = car.CAR_ID
                    )) AND car.CAR_ID = CP.CAR_ID;
    END LOOP;
END;

BEGIN
    reduce_car_owner('S2J3N20SJSKWIJWOM');
END;


-- 2
CREATE OR REPLACE PROCEDURE change_person_address(person_id NUMBER, n_street VARCHAR2, n_postalCode VARCHAR2, n_city VARCHAR2, n_country VARCHAR2)
AS
    new_address_id NUMBER;
BEGIN
    INSERT INTO ADDRESS (CITY, COUNTRY, POSTAL_CODE, STREET) VALUES (n_city, n_country, n_postalCode, n_street);
    COMMIT;
    SELECT ID INTO new_address_id FROM ADDRESS
        WHERE CITY = n_city AND COUNTRY = n_country AND POSTAL_CODE = n_postalCode AND STREET = n_street;
    UPDATE PERSON SET ADDRESS_ID = new_address_id WHERE ID = person_id;
    COMMIT;
END;

BEGIN
    change_person_address(1, 'Big', '34-555', 'London', 'Great Britain');
END;




-------- Wyzwalacze --------

-- 1
CREATE OR REPLACE TRIGGER add_address_history
AFTER UPDATE OF ADDRESS_ID ON PERSON FOR EACH ROW
BEGIN
    IF :old.address_id != :new.address_id THEN
        INSERT INTO ADDRESS_HISTORY (CHANGE_DATE, NEW_ADDRESS_ID, OLD_ADDRESS_ID, PERSON_ID) VALUES (CURRENT_DATE, :new.ADDRESS_ID, :old.ADDRESS_ID, :old.id);
    END IF;
END;

UPDATE PERSON SET ADDRESS_ID = 3 WHERE ID = 1;


-- 2
CREATE OR REPLACE TRIGGER print_car_person_info
AFTER INSERT ON CAR_PERSON FOR EACH ROW
DECLARE
    CURSOR persons IS
        SELECT P.NAME, P.SURNAME, A.STREET, A.CITY, A.POSTAL_CODE FROM CAR_PERSON CP
            JOIN PERSON P on P.ID = CP.PERSON_ID
            JOIN ADDRESS A on A.ID = P.ADDRESS_ID
            WHERE CP.CAR_ID = :NEW.CAR_ID;
    PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
    DBMS_OUTPUT.PUT_LINE('New car owner is added');
    DBMS_OUTPUT.PUT_LINE('Prev car owners: ');
    DBMS_OUTPUT.PUT_LINE('##################');
    FOR person IN persons LOOP
        DBMS_OUTPUT.PUT_LINE('Name: ' || person.NAME);
        DBMS_OUTPUT.PUT_LINE('Surname: ' || person.SURNAME);
        DBMS_OUTPUT.PUT_LINE('Street: ' || person.STREET);
        DBMS_OUTPUT.PUT_LINE('City: ' || person.CITY);
        DBMS_OUTPUT.PUT_LINE('Postal code: ' || person.POSTAL_CODE);
        DBMS_OUTPUT.PUT_LINE('----------------');
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;

INSERT INTO CAR_PERSON (CAR_ID, PERSON_ID) VALUES ('XCD3D3E3FFJ93JEHE', 10);





-------- Dodatkowe skrypty testujące --------

-- 1
SELECT CM.BRAND, AVG(ENGINE_CAPACITY) AS ENGINE_CAPACITY
FROM CAR_MODEL CM
JOIN CAR C on CM.ID = C.CAR_MODEL_ID
JOIN INSURANCE_POLICY IP on C.VIN_NUMBER = IP.CAR_VIN_NUMBER
WHERE IP.EXPIRATION_DATE > CURRENT_DATE
GROUP BY CM.BRAND;


-- 2
SELECT CM.BRAND, COUNT(*)
FROM CAR C
JOIN CAR_MODEL CM ON CM.ID = C.CAR_MODEL_ID
JOIN ACCIDENT_PARTICIPANT AP on C.VIN_NUMBER = AP.CAR_VIN_NUMBER
JOIN ACCIDENT_PARTICIPANTS P on AP.ID = P.PARTICIPANTS_ID
JOIN ACCIDENT A on P.ACCIDENT_ID = A.ID
WHERE AP.IS_RESPONSIBLE = 1 AND A.TYPE = 'Collision'
GROUP BY CM.BRAND;


-- 3
SELECT A.COUNTRY, AVG(INSURANCE_AMOUNT)
FROM INSURANCE_POLICY
JOIN CAR C1 on C1.VIN_NUMBER = INSURANCE_POLICY.CAR_VIN_NUMBER
JOIN CAR_PERSON CP on C1.VIN_NUMBER = CP.CAR_ID
JOIN PERSON P2 on CP.PERSON_ID = P2.ID
JOIN ADDRESS A on A.ID = P2.ADDRESS_ID
WHERE C1.VIN_NUMBER IN (SELECT DISTINCT C2.VIN_NUMBER FROM CAR C2
                               JOIN CAR_PERSON CP2 on C2.VIN_NUMBER = CP2.CAR_ID
                               JOIN PERSON P on P.ID = CP2.PERSON_ID
                               WHERE EXTRACT(YEAR FROM P.BIRTH_DATE) > 1985)
GROUP BY A.COUNTRY;


-- 4
SELECT A.CITY, COUNT(P.ID) AS DRIVER_NUMBER
FROM CAR C
JOIN CAR_PERSON CP on C.VIN_NUMBER = CP.CAR_ID
JOIN PERSON P on P.ID = CP.PERSON_ID
JOIN ADDRESS A on P.ADDRESS_ID = A.ID
WHERE EXTRACT(YEAR FROM P.DRIVING_LICENCE_DATE) >= 2010
GROUP BY A.CITY
ORDER BY DRIVER_NUMBER DESC;


-- 5
SELECT A.CITY, MAX(IP.INSURANCE_PRICE) AS MAX_INSURANCE_PRICE
FROM INSURANCE_POLICY IP
JOIN CAR C on C.VIN_NUMBER = IP.CAR_VIN_NUMBER
JOIN CAR_PERSON CP on C.VIN_NUMBER = CP.CAR_ID
JOIN PERSON P on CP.PERSON_ID = P.ID
JOIN ADDRESS A on P.ADDRESS_ID = A.ID
WHERE (SELECT COUNT(*)
       FROM CAR
       JOIN CAR_PERSON CP2 on CAR.VIN_NUMBER = CP2.CAR_ID
       JOIN PERSON P2 on CP2.PERSON_ID = P2.ID
       JOIN ADDRESS A2 on P2.ADDRESS_ID = A2.ID
       WHERE A2.CITY = A.CITY) > 1
GROUP BY A.CITY;






