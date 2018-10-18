set names utf8;
set charset utf8;
use fietsacademy; 

DROP TABLE IF EXISTS groepscursussen;
DROP TABLE IF EXISTS individuelecursussen;
DROP TABLE IF EXISTS cursussen;

CREATE TABLE groepscursussen (
  id VARCHAR(255) NOT NULL primary key,
  naam VARCHAR(45) NOT NULL,
  van DATE NOT NULL,
  tot DATE NOT NULL
);

INSERT INTO groepscursussen(id, naam,van,tot)
VALUES (uuid(), 'Wegwielrennen voor beginners',ADDDATE(CURDATE(), INTERVAL 10 DAY),ADDDATE(CURDATE(), INTERVAL 20 DAY));

INSERT INTO groepscursussen(id, naam,van,tot)
VALUES (uuid(), 'Wegwielrennen voor gevorderden',ADDDATE(CURDATE(), INTERVAL 21 DAY),ADDDATE(CURDATE(), INTERVAL 31 DAY));

INSERT INTO groepscursussen(id, naam,van,tot)
VALUES (uuid(), 'Veldrijden voor beginners',ADDDATE(CURDATE(), INTERVAL 10 DAY),ADDDATE(CURDATE(), INTERVAL 20 DAY));

INSERT INTO groepscursussen(id, naam,van,tot)
VALUES (uuid(), 'Veldrijden voor gevorderden',ADDDATE(CURDATE(), INTERVAL 21 DAY),ADDDATE(CURDATE(), INTERVAL 31 DAY));

CREATE TABLE individuelecursussen (
  id VARCHAR(255) NOT NULL primary key,
  naam VARCHAR(45) NOT NULL,
  duurtijd TINYINT NOT NULL
)	;

INSERT INTO individuelecursussen(id, naam,duurtijd)
VALUES (uuid(), 'BMX',5);

INSERT INTO individuelecursussen(id, naam,duurtijd)
VALUES (uuid(), 'Mountainbiken',5);

grant select,insert on groepscursussen to cursist;
grant select,insert on individuelecursussen to cursist;