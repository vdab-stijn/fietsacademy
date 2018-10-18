INSERT INTO docentenverantwoordelijkheden(docentid,verantwoordelijkheidid)
VALUES(	(SELECT id FROM docenten WHERE voornaam='testM'),
		(SELECT id FROM verantwoordelijkheden WHERE naam='test'));