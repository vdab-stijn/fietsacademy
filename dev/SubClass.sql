set names utf8;
set charset utf8;
use fietsacademy;

DROP TABLE IF EXISTS groepscursussen;
DROP TABLE IF EXISTS individuelecursussen;
DROP TABLE IF EXISTS cursussen;

CREATE TABLE cursussen (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT primary key,
  naam VARCHAR(45) NOT NULL
);

CREATE TABLE groepscursussen (
  id INT UNSIGNED NOT NULL primary key,
  van DATE NOT NULL,
  tot DATE NOT NULL,
  FOREIGN KEY (id) REFERENCES cursussen(id)
);

CREATE TABLE individuelecursussen (
  id INT UNSIGNED NOT NULL primary key,
  duurtijd TINYINT NOT NULL,
  FOREIGN KEY (id) REFERENCES cursussen(id)
);

INSERT INTO cursussen(naam)
VALUES ('Wegwielrennen voor beginners');
INSERT INTO groepscursussen(id,van,tot)
VALUES (last_insert_id(),ADDDATE(CURDATE(), INTERVAL 10 DAY),ADDDATE(CURDATE(), INTERVAL 20 DAY));

INSERT INTO cursussen(naam)
VALUES ('Wegwielrennen voor gevorderden');
INSERT INTO groepscursussen(id,van,tot)
VALUES (last_insert_id(),ADDDATE(CURDATE(), INTERVAL 21 DAY),ADDDATE(CURDATE(), INTERVAL 31 DAY));

INSERT INTO cursussen(naam)
VALUES ('Veldrijden voor beginners');
INSERT INTO groepscursussen(id,van,tot)
VALUES (last_insert_id(),ADDDATE(CURDATE(), INTERVAL 10 DAY),ADDDATE(CURDATE(), INTERVAL 20 DAY));

INSERT INTO cursussen(naam)
VALUES ('Veldrijden voor gevorderden');
INSERT INTO groepscursussen(id,van,tot)
VALUES (last_insert_id(),ADDDATE(CURDATE(), INTERVAL 21 DAY),ADDDATE(CURDATE(), INTERVAL 31 DAY));

INSERT INTO cursussen(naam)
VALUES ('BMX');
INSERT INTO individueleCursussen(id,duurtijd)
VALUES (last_insert_id(),5);

INSERT INTO cursussen(naam)
VALUES ('Mountainbiken');
INSERT INTO individueleCursussen(id,duurtijd)
VALUES (last_insert_id(),5);

grant select,insert on cursussen to cursist;
grant select,insert on groepscursussen to cursist;
grant select,insert on individuelecursussen to cursist;