set names utf8mb4;
set charset utf8mb4;

alter table fietsacademy.docenten
drop column versie,
add column versie timestamp not null default current_timestamp on update current_timestamp;
update fietsacademy.docenten set versie=current_timestamp;