set names utf8;
set charset utf8;
SET SQL_SAFE_UPDATES = 0;
use fietsacademy;
alter table docenten ADD COLUMN geslacht int NOT NULL;
update docenten SET geslacht = 0;
update docenten SET geslacht = 1 WHERE voornaam IN ('Marianne','Jeanine','Grace','Brigitta','Sanne')