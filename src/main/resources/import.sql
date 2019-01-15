CREATE OR REPLACE FUNCTION avaragepriceforplatform(platform BIGINT)
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
sale(INOUT discount FLOAT,platform BIGINT)
AS '
BEGIN
    
    UPDATE GAME_PLAT SET PRICE = PRICE*discount WHERE PLATFORM_ID = platform;
    
END; '
LANGUAGE 'plpgsql';

INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'strategy game', 'RTS');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'shooting in first person view', 'FPS');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'shooting in third person view', 'TPS');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'Role playing game', 'RPG');
INSERT INTO GAME_TYPE(id, description, name) VALUES (nextval('type_seq'), 'broadest type', 'action-adventure');

INSERT INTO PLATFORM(id, name, premiere, producent, sales) VALUES (nextval('platform_seq'), 'Xbox One', '2015-04-03', 'Microsoft', 1234567);
INSERT INTO PLATFORM(id, name, premiere, producent, sales) VALUES (nextval('platform_seq'), 'Playstation 4', '2015-04-03', 'Sony', 2345678);

INSERT INTO PUBLISHER(id, main_loc, name, value_of ) VALUES (nextval('publisher_seq'), 'Boston', 'Activision', 1);
INSERT INTO PUBLISHER(id, main_loc, name, value_of ) VALUES (nextval('publisher_seq'), 'Texas', 'Bethesda', 76);

INSERT INTO DEV_STUDIO(id, country, devs_count, main_loc, name, value_of, publisher_id ) VALUES (nextval('devstudio_seq'), 'USA', 562, 'Texas', 'Bethesda', 76, 1);
INSERT INTO DEV_STUDIO(id, country, devs_count, main_loc, name, value_of) VALUES (nextval('devstudio_seq'), 'Poland', 562, 'Krakow', 'CDProjektRed', 120000000);

INSERT INTO DEVELOPER(id, name, salary, status, surname, devstudio_id) VALUES (nextval('developer_seq'), 'Mark', 12102, 'lead developer', 'Darrah', 1);
INSERT INTO DEVELOPER(id, name, salary, status, surname, devstudio_id) VALUES (nextval('developer_seq'), 'Michał', 4043, 'developer', 'Kowalski', 2);

INSERT INTO GAME( id, budget, description, pegi, rel_date, title, devstudio_id, gametype_id) VALUES (nextval('game_seq'), 40000000,'Most famous polish game', 16, '2015-10-24', 'Witcher 3: Wild Hunt', 2, 4);
INSERT INTO GAME( id, budget, description, pegi, rel_date, title, devstudio_id, gametype_id) VALUES (nextval('game_seq'), 40000000,'sci-fi shooter', 18, '2015-10-24', 'Prey', 1, 2);

INSERT INTO DLC( id, description, name, price, rel_date, game_id) VALUES (nextval('dlc_seq'), 'dlc #1', 'hearts of stone', 39.99, '2015-12-20', 1);
INSERT INTO DLC( id, description, name, price, rel_date, game_id) VALUES (nextval('dlc_seq'), 'dlc #2', 'blood and wine', 39.99, '2016-04-08', 1);

INSERT INTO REVIEWER( id, affility, critic, nick) VALUES (nextval('reviewer_seq'), 'None', TRUE, 'Quaz');

INSERT INTO REVIEW(  id, audio, crit_score, gameplay, graphics, user_score, game_id, reviewer_id) VALUES (nextval('review_seq'),98, 87, 95, 90, 98.9, 1,1);
INSERT INTO REVIEW(  id, audio, crit_score, gameplay, graphics, user_score, game_id, reviewer_id) VALUES (nextval('review_seq'),75, 82, 70, 65, 74.3, 2,1);

INSERT INTO GAME_PLAT(id, price, sales, game_id, platform_id) VALUES (nextval('gameplat_seq'),129, 13000000, 1, 1);
INSERT INTO GAME_PLAT(id, price, sales, game_id, platform_id) VALUES (nextval('gameplat_seq'),129, 13000000, 1, 2);
INSERT INTO GAME_PLAT(id, price, sales, game_id, platform_id) VALUES (nextval('gameplat_seq'),79, 13000000, 2, 1);
INSERT INTO GAME_PLAT(id, price, sales, game_id, platform_id) VALUES (nextval('gameplat_seq'),69, 13000000, 2, 2);

CREATE OR REPLACE FUNCTION get_newest_game(id_dev bigint)
RETURNS VARCHAR
AS '
BEGIN
DECLARE mini integer;
DECLARE wynik VARCHAR;
BEGIN
  mini := 0;
	CALL min_lat(id_dev, mini);
	SELECT title INTO wynik FROM GAME WHERE devstudio_id = id_dev AND (EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM rel_date)) = mini;
  RETURN wynik;
END;
END;'
LANGUAGE 'plpgsql';

CREATE OR REPLACE PROCEDURE min_lat(IN id_dev bigint, INOUT mini integer)
AS '
BEGIN
SELECT MIN((EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM rel_date))) INTO mini FROM GAME WHERE devstudio_id=id_dev;
END;'
LANGUAGE plpgsql;






