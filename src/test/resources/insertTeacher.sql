--INSERT INTO docenten(voornaam,familienaam,wedde,emailAdres,geslacht)
--VALUES
--('testM', 'testM', 1000, 'testM@fietsacademy.be',0),
--('testV', 'testV', 1000, 'testV@fietsacademy.be',1);
--
INSERT INTO docenten(voornaam,familienaam,wedde,emailAdres,geslacht,campusId)
VALUES
('testM', 'testM', 1000, 'testM@fietsacademy.be','MAN',
	(SELECT id FROM campussen WHERE naam='test')),
('testV', 'testV', 1000, 'testV@fietsacademy.be','VROUW',
	(SELECT id FROM campussen WHERE naam='test'));

INSERT INTO docentenbijnamen(docentid,bijnaam)
VALUES((SELECT id FROM docenten WHERE voornaam='testM'), 'test');