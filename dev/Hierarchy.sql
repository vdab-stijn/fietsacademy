set names utf8;
set charset utf8;
use fietsacademy;

DROP TABLE IF EXISTS groepscursussen;
DROP TABLE IF EXISTS individuelecursussen;
DROP TABLE IF EXISTS cursussen;

CREATE TABLE cursussen (
  id INT UNSIGNED not null AUTO_INCREMENT primary key,
  naam VARCHAR(45) NOT NULL,
  van DATE,
  tot DATE,
  duurtijd TINYINT,
  soort ENUM('G','I') not null
);

INSERT INTO cursussen(naam,van,tot,soort)
VALUES ('Wegwielrennen voor beginners',ADDDATE(CURDATE(), INTERVAL 10 DAY),ADDDATE(CURDATE(), INTERVAL 20 DAY),'G');

INSERT INTO cursussen(Naam,Van,Tot,Soort)
VALUES ('Wegwielrennen voor gevorderden',ADDDATE(CURDATE(), INTERVAL 21 DAY),ADDDATE(CURDATE(), INTERVAL 31 DAY),'G');

INSERT INTO cursussen(Naam,Van,Tot,Soort)
VALUES ('Veldrijden voor beginners',ADDDATE(CURDATE(), INTERVAL 10 DAY),ADDDATE(CURDATE(), INTERVAL 20 DAY),'G');

INSERT INTO cursussen(Naam,Van,Tot,Soort)
VALUES ('Veldrijden voor gevorderden',ADDDATE(CURDATE(), INTERVAL 21 DAY),ADDDATE(CURDATE(), INTERVAL 31 DAY),'G');

INSERT INTO cursussen(Naam,Duurtijd,Soort)
VALUES ('BMX',5,'I');

INSERT INTO cursussen(Naam,Duurtijd,Soort)
VALUES ('Mountainbiken',5,'I');

grant select,insert on cursussen to cursist;