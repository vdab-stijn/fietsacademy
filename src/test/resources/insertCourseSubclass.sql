INSERT INTO cursussen(naam) VALUES('testGroep');
INSERT INTO groepscursussen(id,van,tot)
VALUES((SELECT id FROM cursussen WHERE naam='testGroep'),
	'2018-01-01', '2018-01-01');

INSERT INTO cursussen(naam) VALUES('testIndividueel');
INSERT INTO individuelecursussen(id,duurtijd)
VALUES((SELECT id FROM cursussen WHERE naam='testIndividueel'),3);