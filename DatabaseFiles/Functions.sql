CREATE OR REPLACE FUNCTION AvaragePriceForPlatform(platform BIGINT)
  RETURNS FLOAT 
  AS '
  BEGIN
  DECLARE avarage FLOAT;
  BEGIN
	
      SELECT AVG(GP.PRICE) INTO avarage FROM GAME_PLAT GP WHERE GP.PLATFORM_ID = platform GROUP BY GP.PLATFORM_ID;
	
	RETURN avarage;
END;
END;'
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION 
Sale(INOUT discount FLOAT,platform BIGINT)
AS '
BEGIN
    
    UPDATE GAME_PLAT SET PRICE = PRICE*discount WHERE PLATFORM_ID = platform;
    
END; '
LANGUAGE 'plpgsql';

INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'strategy game', 'RTS');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'shooting in first person view', 'FPS');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'shooting in third person view', 'TPS');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'jump on platforms', 'platformer');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'broadest type', 'action-adventure');

INSERT INTO PLATFORM(id, name, premiere, producent, sales) VALUES (nextval('platform_seq'), 'Xbox One', '2015-04-03', 'Microsoft', 1234567);
INSERT INTO PLATFORM(id, name, premiere, producent, sales) VALUES (nextval('platform_seq'), 'Playstation 4', '2015-04-03', 'Sony', 2345678);

INSERT INTO PUBLISHER(id, main_loc, name, value_of ) VALUES (nextval('publisher_seq'), 'Boston', 'Activision', 1);
INSERT INTO PUBLISHER(id, main_loc, name, value_of ) VALUES (nextval('publisher_seq'), 'Texas', 'Bethesda', 76);


CREATE SEQUENCE GAMES_ID
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE DEVS_ID
MINVALUE 100
START WITH 100
INCREMENT BY 1;

CREATE SEQUENCE REVIEW_ID
MINVALUE 1
START WITH 1
INCREMENT BY 1;