INSERT INTO campussen(naam,straat,huisNr,postCode,gemeente)
VALUES('test','test','test','test','test');

INSERT INTO campussentelefoonnrs(campusid,nummer,fax,opmerking)
VALUES((SELECT id FROM campussen WHERE naam='test'), '1', false, 'test');