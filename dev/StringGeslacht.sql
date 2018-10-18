set names utf8;
set charset utf8;
use fietsacademy;
alter table docenten DROP COLUMN geslacht;
alter table docenten ADD COLUMN geslacht ENUM('MAN','VROUW') NOT NULL;
update docenten SET geslacht = 'MAN';
update docenten SET geslacht = 'VROUW' WHERE voornaam IN ('Marianne','Jeanine','Grace','Brigitta','Sanne')