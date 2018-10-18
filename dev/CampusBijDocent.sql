set names utf8mb4;
set charset utf8mb4;

use fietsacademy;
ALTER TABLE docenten ADD COLUMN campusid INT UNSIGNED,
 ADD CONSTRAINT FK_campussen FOREIGN KEY FK_campussen (campusid)
    REFERENCES campussen(id);
UPDATE docenten SET campusid=1+(id+length(voornaam)+length(familienaam)) mod 6;