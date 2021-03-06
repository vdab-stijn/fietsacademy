set names utf8;
set charset utf8;

drop database if exists fietsacademy;
create database fietsacademy charset utf8;
use fietsacademy;

CREATE TABLE campussen (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(45) NOT NULL,
  straat varchar(45) NOT NULL,
  huisNr varchar(45) NOT NULL,
  postCode varchar(45) NOT NULL,
  gemeente varchar(45) NOT NULL
);

INSERT INTO campussen(naam,straat,huisNr,postCode,gemeente) VALUES
('Andros','Somersstraat','22','2018','Antwerpen'),
('Delos','Oude Vest','17','9200','Dendermonde'),
('Gavdos','Europalaan','37','3600','Genk'),
('Hydra','Interleuvenlaan','2','3001','Heverlee'),
('Ikaria','Vlamingstraat','10','8560','Wevelgem'),
('Paros','Keizerslaan','11','1000','Brussel');

CREATE TABLE campussentelefoonnrs (
  nummer varchar(50) NOT NULL,
  opmerking varchar(50) DEFAULT NULL,
  campusId int unsigned NOT NULL,
  fax tinyint NOT NULL,
  CONSTRAINT fk_campussentelefoonnrs_campussen FOREIGN KEY (campusId) REFERENCES campussen(id)
);

INSERT INTO campussentelefoonnrs(nummer,opmerking,campusId,fax) 
VALUES ('02 506 04 01',NULL,6,0),
('02 506 04 30',NULL,6,1),
('0800 30 700','gratis',6,0),
('03 202 17 11',NULL,1,0),
('03 202 17 00',NULL,1,1),
('052 46 97 40',NULL,2,0),
('052 46 97 69',NULL,2,1),
('089 30 14 11',NULL,3,0),
('089 36 40 84',NULL,3,1),
('016 38 00 00',NULL,4,0),
('016 40 02 29',NULL,4,1),
('056 43 80 80',NULL,5,0),
('056 42 13 43',NULL,5,1);

CREATE TABLE docenten (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  voornaam varchar(30) NOT NULL,
  familienaam varchar(30) NOT NULL,
  wedde decimal(10,2) NOT NULL,
  emailAdres varchar(60) NOT NULL unique
);

INSERT INTO docenten(voornaam,familienaam,wedde,emailAdres)
VALUES ('Willy','Abbeloos',1400,'willy.abbeloos@fietsacademy.be'),
('Marianne','Vos',1800,'marianne.vos@fietsacademy.be'),
('Joseph','Achten',1300,'joseph.achten@fietsacademy.be'),
('Jeanine','Longo',1700,'jeanine.longo@fietsacademy.be'),
('Jan','Adriaensens',2100,'jan.adriaensens@fietsacademy.be'),
('Grace','Verbeke',1600,'grace.verbeke@fietsacademy.be'),
('Frans','Aerenhouts',1300,'frans.aerenhouts@fietsacademy.be'),
('Brigitta','Roos',1700,'brigitta.roos@fietsacademy.be'),
('Jean','Aerts',1200,'jean.aerts@fietsacademy.be'),
('Sanne','Verhart',1600,'sanne.verhart@fietsacademy.be'),
('Paul','Aerts',2000,'paul.aerts@fietsacademy.be'),
('Stefan','Aerts',1500,'stefan.aerts@fietsacademy.be'),
('François','Alexander',1900,'françois.alexander@fietsacademy.be'),
('Henri','Allard',1600,'henri.allard@fietsacademy.be'),
('Albert','Anciaux',1100,'albert.anciaux@fietsacademy.be'),
('Urbain','Anseeuw',1500,'urbain.anseeuw@fietsacademy.be'),
('Etienne','Antheunis',1900,'etienne.antheunis@fietsacademy.be'),
('Jacques','Arlet',1400,'jacques.arlet@fietsacademy.be'),
('Wim','Arras',1800,'wim.arras@fietsacademy.be'),
('Roger','Baens',2200,'roger.baens@fietsacademy.be'),
('Dirk','Baert',1000,'dirk.baert@fietsacademy.be'),
('Hubert','Baert',1400,'hubert.baert@fietsacademy.be'),
('Jean-Pierre','Baert',1800,'jean-pierre.baert@fietsacademy.be'),
('Armand','Baeyens',1300,'armand.baeyens@fietsacademy.be'),
('Jan','Baeyens',1700,'jan.baeyens@fietsacademy.be'),
('Roger','Baguet',2100,'roger.baguet@fietsacademy.be'),
('Serge','Baguet',1600,'serge.baguet@fietsacademy.be'),
('Gerard','Balducq',1300,'gerard.balducq@fietsacademy.be'),
('Koen','Barbe',1700,'koen.barbe@fietsacademy.be'),
('Georges','Barras',1200,'georges.barras@fietsacademy.be'),
('Auguste','Baumans',1600,'auguste.baumans@fietsacademy.be'),
('Arsene','Bauwens',2000,'arsene.bauwens@fietsacademy.be'),
('Henri','Bauwens',1500,'henri.bauwens@fietsacademy.be'),
('Jules','Bayens',1900,'jules.bayens@fietsacademy.be'),
('Albert','Beckaert',1600,'albert.beckaert@fietsacademy.be'),
('Marcel','Beckaert',1100,'marcel.beckaert@fietsacademy.be'),
('Koen','Beeckman',1500,'koen.beeckman@fietsacademy.be'),
('Kamiel','Beeckman',1900,'kamiel.beeckman@fietsacademy.be'),
('Theophile','Beeckman',1400,'theophile.beeckman@fietsacademy.be'),
('Benoni','Beheyt',1800,'benoni.beheyt@fietsacademy.be'),
('Albert','Beirnaert',2200,'albert.beirnaert@fietsacademy.be'),
('Jean','Belvaux',1000,'jean.belvaux@fietsacademy.be'),
('Adelin','Benoit',1400,'adelin.benoit@fietsacademy.be'),
('Auguste','Benoit',1800,'auguste.benoit@fietsacademy.be'),
('Jef','Berben',1300,'jef.berben@fietsacademy.be'),
('Jean-Pierre','Berckmans',1700,'jean-pierre.berckmans@fietsacademy.be'),
('Albert','Berton',2100,'albert.berton@fietsacademy.be'),
('Frans','Beths',1600,'frans.beths@fietsacademy.be'),
('Rene','Beyens',1300,'rene.beyens@fietsacademy.be'),
('Herman','Beyssens',1700,'herman.beyssens@fietsacademy.be'),
('Albert','Billiet',1200,'albert.billiet@fietsacademy.be'),
('Hector','Billiet',1600,'hector.billiet@fietsacademy.be'),
('Marcel','Blavier',2000,'marcel.blavier@fietsacademy.be'),
('Roger','Blockx',1500,'roger.blockx@fietsacademy.be'),
('Maurice','Blomme',1900,'maurice.blomme@fietsacademy.be'),
('Willy','Bocklandt',1600,'willy.bocklandt@fietsacademy.be'),
('Emile','Bodart',1100,'emile.bodart@fietsacademy.be'),
('Alfons','Boekaerts',1500,'alfons.boekaerts@fietsacademy.be'),
('Cesar','Bogaert',1900,'cesar.bogaert@fietsacademy.be'),
('Jan','Bogaert',1400,'jan.bogaert@fietsacademy.be'),
('Jean','Bogaerts',1800,'jean.bogaerts@fietsacademy.be'),
('Frans','Bonduel',2200,'frans.bonduel@fietsacademy.be'),
('Tom','Boonen',1000,'tom.boonen@fietsacademy.be'),
('Jozef','Boons',1400,'jozef.boons@fietsacademy.be'),
('Gabriel','Borra',1800,'gabriel.borra@fietsacademy.be'),
('Joseph','Bosmans',1300,'joseph.bosmans@fietsacademy.be'),
('Walter','Boucquet',1700,'walter.boucquet@fietsacademy.be'),
('Marcel','Boumon',2100,'marcel.boumon@fietsacademy.be'),
('Ferdinand','Bracke',1600,'ferdinand.bracke@fietsacademy.be'),
('Adolphe','Braeckeveldt',1300,'adolphe.braeckeveldt@fietsacademy.be'),
('Omer','Braekevelt',1700,'omer.braekevelt@fietsacademy.be'),
('Frans','Brands',1200,'frans.brands@fietsacademy.be'),
('Jean','Brankart',1600,'jean.brankart@fietsacademy.be'),
('Emile','Brichard',2000,'emile.brichard@fietsacademy.be'),
('Georges','Brosteaux',1500,'georges.brosteaux@fietsacademy.be'),
('Emile','Bruneau',1900,'emile.bruneau@fietsacademy.be'),
('Jean-Marie','Bruyere',1600,'jean-marie.bruyere@fietsacademy.be'),
('Joseph','Bruyere',1100,'joseph.bruyere@fietsacademy.be'),
('Dave','Bruylandts',1500,'dave.bruylandts@fietsacademy.be'),
('Johan','Bruyneel',1900,'johan.bruyneel@fietsacademy.be'),
('Lucien','Buysse',1400,'lucien.buysse@fietsacademy.be'),
('Christophe','Brandt',1800,'christophe.brandt@fietsacademy.be'),
('Norbert','Callens',2200,'norbert.callens@fietsacademy.be'),
('Johan','Capiot',1000,'johan.capiot@fietsacademy.be'),
('Pino','Cerami',1400,'pino.cerami@fietsacademy.be'),
('Georges','Christiaens',1800,'georges.christiaens@fietsacademy.be'),
('Georges','Claes',1300,'georges.claes@fietsacademy.be'),
('Karel','Clerckx',1700,'karel.clerckx@fietsacademy.be'),
('Alex','Close',2100,'alex.close@fietsacademy.be'),
('Yvan','Corbusier',1600,'yvan.corbusier@fietsacademy.be'),
('Hilaire','Couvreur',1300,'hilaire.couvreur@fietsacademy.be'),
('Wilfried','Cretskens',1700,'wilfried.cretskens@fietsacademy.be'),
('Claude','Criquielion',1200,'claude.criquielion@fietsacademy.be'),
('Emile','Daems',1600,'emile.daems@fietsacademy.be'),
('Gustave','Danneels',2000,'gustave.danneels@fietsacademy.be'),
('Fred','De Bruyne',1500,'fred.debruyne@fietsacademy.be'),
('Arthur','Decabooter',1900,'arthur.decabooter@fietsacademy.be'),
('Hans','De Clerq',1600,'hans.declerq@fietsacademy.be'),
('Roger','Decock',1100,'roger.decock@fietsacademy.be'),
('Georges','Decraeye',1500,'georges.decraeye@fietsacademy.be'),
('Odiel','Defraeye',1900,'odiel.defraeye@fietsacademy.be'),
('Albert','De Jonghe',1400,'albert.dejonghe@fietsacademy.be'),
('Julien','Delbecque',1800,'julien.delbecque@fietsacademy.be'),
('Alfons','Deloor',2200,'alfons.deloor@fietsacademy.be'),
('Gustaaf','Deloor',1000,'gustaaf.deloor@fietsacademy.be'),
('Hubert','Deltour',1400,'hubert.deltour@fietsacademy.be'),
('Paul','Deman',1800,'paul.deman@fietsacademy.be'),
('Marc','Demeyer',1300,'marc.demeyer@fietsacademy.be'),
('Frans','De Mulder',1700,'frans.demulder@fietsacademy.be'),
('Johan','De Muynck',2100,'johan.demuynck@fietsacademy.be'),
('Jef','Demuysere',1600,'jef.demuysere@fietsacademy.be'),
('Jules','Depoorter',1300,'jules.depoorter@fietsacademy.be'),
('Richard','Depoorter',1700,'richard.depoorter@fietsacademy.be'),
('Prosper','Depredomme',1200,'prosper.depredomme@fietsacademy.be'),
('Willy','Derboven',1600,'willy.derboven@fietsacademy.be'),
('Germain','Derijcke',2000,'germain.derijcke@fietsacademy.be'),
('Michel','Dernies',1500,'michel.dernies@fietsacademy.be'),
('Charles','Deruyter',1900,'charles.deruyter@fietsacademy.be'),
('Maurice','Desimpelaere',1600,'maurice.desimpelaere@fietsacademy.be'),
('Gilbert','Desmet',1100,'gilbert.desmet@fietsacademy.be'),
('Georges','Desplenter',1500,'georges.desplenter@fietsacademy.be'),
('Leon','Despontin',1900,'leon.despontin@fietsacademy.be'),
('Eric','De Vlaeminck',1400,'eric.devlaeminck@fietsacademy.be'),
('Roger','De Vlaeminck',1800,'roger.devlaeminck@fietsacademy.be'),
('Stijn','Devolder',2200,'stijn.devolder@fietsacademy.be'),
('Maurice','Dewaele',1000,'maurice.dewaele@fietsacademy.be'),
('Alfons','De Wolf',1400,'alfons.dewolf@fietsacademy.be'),
('Rudy','Dhaenens',1800,'rudy.dhaenens@fietsacademy.be'),
('Michel','D\'Hooghe',1300,'michel.d\'hooghe@fietsacademy.be'),
('Ludo','Dierckxsens',1700,'ludo.dierckxsens@fietsacademy.be'),
('Frans','Dictus',2100,'frans.dictus@fietsacademy.be'),
('Lomme','Driessens',1600,'lomme.driessens@fietsacademy.be'),
('Gustave','Drioul',1300,'gustave.drioul@fietsacademy.be'),
('Marcel','Dupont',1700,'marcel.dupont@fietsacademy.be'),
('Niko','Eeckhout',1200,'niko.eeckhout@fietsacademy.be'),
('Nico','Emonds',1600,'nico.emonds@fietsacademy.be'),
('Peter','Farazijn',2000,'peter.farazijn@fietsacademy.be'),
('Herman','Frison',1500,'herman.frison@fietsacademy.be'),
('Henri','Garnier',1900,'henri.garnier@fietsacademy.be'),
('Frans','Gielen',1600,'frans.gielen@fietsacademy.be'),
('Romain','Gijssels',1100,'romain.gijssels@fietsacademy.be'),
('Walter','Godefroot',1500,'walter.godefroot@fietsacademy.be'),
('Dries','Govaerts',1900,'dries.govaerts@fietsacademy.be'),
('Sylvain','Grysolle',1400,'sylvain.grysolle@fietsacademy.be'),
('Roger','Gyselinck',1800,'roger.gyselinck@fietsacademy.be'),
('Paul','Haghedooren',2200,'paul.haghedooren@fietsacademy.be'),
('Alfred','Hamerlinck',1000,'alfred.hamerlinck@fietsacademy.be'),
('Louis','Hardiquest',1400,'louis.hardiquest@fietsacademy.be'),
('Emile','Hardy',1800,'emile.hardy@fietsacademy.be'),
('Marcel','Hendrikx',1300,'marcel.hendrikx@fietsacademy.be'),
('Joseph','Hoevenaers',1700,'joseph.hoevenaers@fietsacademy.be'),
('Kevin','Hulsmans',2100,'kevin.hulsmans@fietsacademy.be'),
('Raymond','Impanis',1600,'raymond.impanis@fietsacademy.be'),
('Paul','In\'t',1300,'paul.in\'t@fietsacademy.be'),
('Willy','In\'t',1700,'willy.in\'t@fietsacademy.be'),
('Marcel','Janssens',1200,'marcel.janssens@fietsacademy.be'),
('Benjamin','Javaux',1600,'benjamin.javaux@fietsacademy.be'),
('Karel','Kaers',2000,'karel.kaers@fietsacademy.be'),
('Francis','Kemplaire',1500,'francis.kemplaire@fietsacademy.be'),
('Norbert','Kerckhove',1900,'norbert.kerckhove@fietsacademy.be'),
('Desire','Keteleer',1600,'desire.keteleer@fietsacademy.be'),
('Marcel','Kint',1100,'marcel.kint@fietsacademy.be'),
('Firmin','Lambot',1500,'firmin.lambot@fietsacademy.be'),
('Roger','Lambrecht',1900,'roger.lambrecht@fietsacademy.be'),
('Eric','Leman',1400,'eric.leman@fietsacademy.be'),
('Camille','Leroy',1800,'camille.leroy@fietsacademy.be'),
('Roland','Liboton',2200,'roland.liboton@fietsacademy.be'),
('Jules','Lowie',1000,'jules.lowie@fietsacademy.be'),
('Andre','Lurquin',1400,'andre.lurquin@fietsacademy.be'),
('Henri','\'Rik\'',1800,'henri.\'rik\'@fietsacademy.be'),
('Pierrot','Machiels',1300,'pierrot.machiels@fietsacademy.be'),
('Andre','Maelbrancke',1700,'andre.maelbrancke@fietsacademy.be'),
('Freddy','Maertens',2100,'freddy.maertens@fietsacademy.be'),
('Romain','Maes',1600,'romain.maes@fietsacademy.be'),
('Sylvere','Maes',1300,'sylvere.maes@fietsacademy.be'),
('Joseph','Marchand',1700,'joseph.marchand@fietsacademy.be'),
('Rene','Martens',1200,'rene.martens@fietsacademy.be'),
('Jacques','Martin',1600,'jacques.martin@fietsacademy.be'),
('Emile','Pere',2000,'emile.pere@fietsacademy.be'),
('Florent','Mathieu',1500,'florent.mathieu@fietsacademy.be'),
('Nico','Mattan',1900,'nico.mattan@fietsacademy.be'),
('Filip','Meirhaeghe',1600,'filip.meirhaeghe@fietsacademy.be'),
('Axel','Merckx',1100,'axel.merckx@fietsacademy.be'),
('Eddy','Merckx',1500,'eddy.merckx@fietsacademy.be'),
('Andre','Messelis',1900,'andre.messelis@fietsacademy.be'),
('Maurice','Meuleman',1400,'maurice.meuleman@fietsacademy.be'),
('Eloi','Meulenberg',1800,'eloi.meulenberg@fietsacademy.be'),
('Frans','Mintjens',2200,'frans.mintjens@fietsacademy.be'),
('Yvo','Molenaers',1000,'yvo.molenaers@fietsacademy.be'),
('Maurice','Mollin',1400,'maurice.mollin@fietsacademy.be'),
('Arthur','Mommerency',1800,'arthur.mommerency@fietsacademy.be'),
('Jean-Pierre','Monsere',1300,'jean-pierre.monsere@fietsacademy.be'),
('Willy','Monty',1700,'willy.monty@fietsacademy.be'),
('Sammie','Moreels',2100,'sammie.moreels@fietsacademy.be'),
('Alfred','Mottard',1600,'alfred.mottard@fietsacademy.be'),
('Ernest','Mottart',1300,'ernest.mottart@fietsacademy.be'),
('Louis','Mottiat',1700,'louis.mottiat@fietsacademy.be'),
('Johan','Museeuw',1200,'johan.museeuw@fietsacademy.be'),
('Wilfried','Nelissen',1600,'wilfried.nelissen@fietsacademy.be'),
('François','Neuville',2000,'françois.neuville@fietsacademy.be'),
('Andre','Noyelle',1500,'andre.noyelle@fietsacademy.be'),
('Guy','Nulens',1900,'guy.nulens@fietsacademy.be'),
('Nick','Nuyens',1600,'nick.nuyens@fietsacademy.be'),
('Sven','Nys',1100,'sven.nys@fietsacademy.be'),
('Stan','Ockers',1500,'stan.ockers@fietsacademy.be'),
('Petrus','Oellibrandt',1900,'petrus.oellibrandt@fietsacademy.be'),
('Valere','Ollivier',1400,'valere.ollivier@fietsacademy.be'),
('Eddy','Peelman',1800,'eddy.peelman@fietsacademy.be'),
('Edward','Peeters',2200,'edward.peeters@fietsacademy.be'),
('Luc','Petitjean',1000,'luc.petitjean@fietsacademy.be'),
('Victor','\'Louis\'',1400,'victor.\'louis\'@fietsacademy.be'),
('Georges','Pintens',1800,'georges.pintens@fietsacademy.be'),
('Theodore','Pirmez',1300,'theodore.pirmez@fietsacademy.be'),
('Eddy','Planckaert',1700,'eddy.planckaert@fietsacademy.be'),
('Jo','Planckaert',2100,'jo.planckaert@fietsacademy.be'),
('Walter','Planckaert',1600,'walter.planckaert@fietsacademy.be'),
('Willy','Planckaert',1300,'willy.planckaert@fietsacademy.be'),
('Michel','Pollentier',1700,'michel.pollentier@fietsacademy.be'),
('Leon','Poncelet',1200,'leon.poncelet@fietsacademy.be'),
('Louis','Proost',1600,'louis.proost@fietsacademy.be'),
('Robert','Protin',2000,'robert.protin@fietsacademy.be'),
('Albert','Ramon',1500,'albert.ramon@fietsacademy.be'),
('Gaston','Rebry',1900,'gaston.rebry@fietsacademy.be'),
('Jens','Renders',1600,'jens.renders@fietsacademy.be'),
('Guido','Reybrouck',1100,'guido.reybrouck@fietsacademy.be'),
('Marcel','Rijckaert',1500,'marcel.rijckaert@fietsacademy.be'),
('Albert','Ritserveldt',1900,'albert.ritserveldt@fietsacademy.be'),
('Bert','Roesems',1400,'bert.roesems@fietsacademy.be'),
('Louis','Rolus',1800,'louis.rolus@fietsacademy.be'),
('Georges','Ronsse',2200,'georges.ronsse@fietsacademy.be'),
('Andre','Rosseel',1000,'andre.rosseel@fietsacademy.be'),
('Felicien','Salmon',1400,'felicien.salmon@fietsacademy.be'),
('Leopold','Schaeken',1800,'leopold.schaeken@fietsacademy.be'),
('Willy','Scheers',1300,'willy.scheers@fietsacademy.be'),
('Alfons','Schepers',1700,'alfons.schepers@fietsacademy.be'),
('Joseph','Scherens',2100,'joseph.scherens@fietsacademy.be'),
('Jef','Scherens',1600,'jef.scherens@fietsacademy.be'),
('Briek','Schotte',1300,'briek.schotte@fietsacademy.be'),
('Frans','Schoubben',1700,'frans.schoubben@fietsacademy.be'),
('Leon','Scieur',1200,'leon.scieur@fietsacademy.be'),
('Felix','Sellier',1600,'felix.sellier@fietsacademy.be'),
('Edward','Sels',2000,'edward.sels@fietsacademy.be'),
('Albert','Sercu',1500,'albert.sercu@fietsacademy.be'),
('Patrick','Sercu',1900,'patrick.sercu@fietsacademy.be'),
('Andy','de Smet',1600,'andy.desmet@fietsacademy.be'),
('Joseph','Somers',1100,'joseph.somers@fietsacademy.be'),
('Tom','Steels',1500,'tom.steels@fietsacademy.be'),
('Ernest','Sterckx',1900,'ernest.sterckx@fietsacademy.be'),
('Lucien','Storme',1400,'lucien.storme@fietsacademy.be'),
('Tom','Stubbe',1800,'tom.stubbe@fietsacademy.be'),
('Roger','Swerts',2200,'roger.swerts@fietsacademy.be'),
('Arthur','Targez',1000,'arthur.targez@fietsacademy.be'),
('Andrei','Tchmil',1400,'andrei.tchmil@fietsacademy.be'),
('Emmanuel','Thoma',1800,'emmanuel.thoma@fietsacademy.be'),
('Philippe','Thys',1300,'philippe.thys@fietsacademy.be'),
('Hector','Tiberghien',1700,'hector.tiberghien@fietsacademy.be'),
('Leon','Tommies',2100,'leon.tommies@fietsacademy.be'),
('Lode','Troonbeeckx',1600,'lode.troonbeeckx@fietsacademy.be'),
('Greg','Van Avermaet',1300,'greg.vanavermaet@fietsacademy.be'),
('Armand','Van Bruaene',1700,'armand.vanbruaene@fietsacademy.be'),
('Georges','Vanconingsloo',1200,'georges.vanconingsloo@fietsacademy.be'),
('Leon','Van Daele',1600,'leon.vandaele@fietsacademy.be'),
('Charles','Van Den Born',2000,'charles.vandenborn@fietsacademy.be'),
('Frank','Vandenbroucke',1500,'frank.vandenbroucke@fietsacademy.be'),
('Odiel','Vanden Meerschaut',1900,'odiel.vandenmeerschaut@fietsacademy.be'),
('Eric','Vanderaerden',1600,'eric.vanderaerden@fietsacademy.be'),
('Kurt','Van de Wouwer',1100,'kurt.vandewouwer@fietsacademy.be'),
('Richard','Van Genechten',1500,'richard.vangenechten@fietsacademy.be'),
('Martin','Van Geneugden',1900,'martin.vangeneugden@fietsacademy.be'),
('Cyrille','Van Hauwaert',1400,'cyrille.vanhauwaert@fietsacademy.be'),
('Maurice','Van Herzele',1800,'maurice.vanherzele@fietsacademy.be'),
('Jules','Van Hevel',2200,'jules.vanhevel@fietsacademy.be'),
('Edwig','Van Hooydonck',1000,'edwig.vanhooydonck@fietsacademy.be'),
('Lucien','Van Impe',1400,'lucien.vanimpe@fietsacademy.be'),
('Henri','Van Kerkhove',1800,'henri.vankerkhove@fietsacademy.be'),
('Rik','Van Linden',1300,'rik.vanlinden@fietsacademy.be'),
('Rik','Van Looy',1700,'rik.vanlooy@fietsacademy.be'),
('Willy','Vannitsen',2100,'willy.vannitsen@fietsacademy.be'),
('Peter','Van Petegem',1600,'peter.vanpetegem@fietsacademy.be'),
('Peter','Van Santvliet',1300,'peter.vansantvliet@fietsacademy.be'),
('Victor','Van Schil',1700,'victor.vanschil@fietsacademy.be'),
('Herman','van Springel',1200,'herman.vanspringel@fietsacademy.be'),
('Rik','Van Steenbergen',1600,'rik.vansteenbergen@fietsacademy.be'),
('Guillaume','Van Tongerloo',2000,'guillaume.vantongerloo@fietsacademy.be'),
('Noël','Vantyghem',1500,'noël.vantyghem@fietsacademy.be'),
('Rik','Verbrugghe',1900,'rik.verbrugghe@fietsacademy.be'),
('Auguste','Verdyck',1600,'auguste.verdyck@fietsacademy.be'),
('Jozef','Verhaert',1100,'jozef.verhaert@fietsacademy.be'),
('Rene','Vermandel',1500,'rene.vermandel@fietsacademy.be'),
('Stive','Vermaut',1900,'stive.vermaut@fietsacademy.be'),
('Adolf','Verschueren',1400,'adolf.verschueren@fietsacademy.be'),
('Constant','Verschueren',1800,'constant.verschueren@fietsacademy.be'),
('Johan','Verstrepen',2200,'johan.verstrepen@fietsacademy.be'),
('Felicien','Vervaecke',1000,'felicien.vervaecke@fietsacademy.be'),
('Julien','Vervaecke',1400,'julien.vervaecke@fietsacademy.be'),
('Edward','Vissers',1800,'edward.vissers@fietsacademy.be'),
('Lucien','Vlaemynck',1300,'lucien.vlaemynck@fietsacademy.be'),
('Andre','Vlaeyen',1700,'andre.vlaeyen@fietsacademy.be'),
('Jean','Vliegen',2100,'jean.vliegen@fietsacademy.be'),
('Luc','Wallays',1600,'luc.wallays@fietsacademy.be'),
('Rene','Walschot',1300,'rene.walschot@fietsacademy.be'),
('Jean-Marie','Wampers',1700,'jean-marie.wampers@fietsacademy.be'),
('Robert','Wancour',1200,'robert.wancour@fietsacademy.be'),
('Bart','Wellens',1600,'bart.wellens@fietsacademy.be'),
('Wilfried','Wesemael',2000,'wilfried.wesemael@fietsacademy.be'),
('Wouter','Weylandt',1500,'wouter.weylandt@fietsacademy.be'),
('Marc','Wauters',1900,'marc.wauters@fietsacademy.be'),
('Daniel','Willems',1600,'daniel.willems@fietsacademy.be'),
('Joseph','Abelshausen',1800,'joseph.abelshausen@fietsacademy.be'),
('François','Adam',1700,'françois.adam@fietsacademy.be'),
('Rene','Adriaensens',1600,'rene.driaensens@fietsacademy.be'),
('Emile','Aerts',1700,'emile.aerts@fietsacademy.be'),
('Mario','Aerts',1600,'mario.aerts@fietsacademy.be'),
('Jozef','Wouters',1100,'jozef.wouters@fietsacademy.be');

CREATE TABLE docentenbijnamen (
  docentid int unsigned NOT NULL AUTO_INCREMENT,
  bijnaam varchar(45) NOT NULL,
  UNIQUE KEY docentenbijnamenDocentNrBijnaam (docentid,bijnaam),
  CONSTRAINT fk_docentenbijnamen_docenten FOREIGN KEY (docentid) REFERENCES docenten(id)
) AUTO_INCREMENT=314;

INSERT INTO docentenbijnamen VALUES (63,'Bom van Baelen'),(63,'Tommeke'),(63,'Tornado Tom'),(124,'Le gitan'),(124,'Tsjete'),(125,'Volderke'),(181,'Monsieur P'),(184,'De Beethoven van de ronde'),(184,'De beul van de fiets'),(184,'De kannibaal'),(184,'De zwarte van Tervuren'),(198,'De leeuw van Vlaanderen'),(205,'Le Ruse'),(259,'Avi'),(274,'De kleine van Meere'),(279,'De peet'),(279,'De zwarte van Brakel'),(304,'Bartmans'),(307,'De soldaat'),(313,'Le beau Mario'),(313,'Super Mario');

CREATE TABLE verantwoordelijkheden (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(45) NOT NULL unique
);


INSERT INTO verantwoordelijkheden(naam) VALUES ('Brandbestrijding'),('Defectenbeheer'),('EHBO'),('Uitleen boeken');

CREATE TABLE docentenverantwoordelijkheden (
  docentid int unsigned NOT NULL,
  verantwoordelijkheidid int unsigned NOT NULL,
  PRIMARY KEY (docentid,verantwoordelijkheidid),
  CONSTRAINT fk_docenten_veran FOREIGN KEY (docentid) REFERENCES docenten(id) on delete cascade,
  CONSTRAINT fk_verant_docenten FOREIGN KEY (verantwoordelijkheidid) REFERENCES verantwoordelijkheden(id) on delete cascade
);

INSERT INTO docentenverantwoordelijkheden VALUES (3,1),(6,1),(9,1),(12,1),(15,1),(18,1),(21,1),(24,1),(27,1),(30,1),(33,1),(36,1),(39,1),(42,1),(45,1),(48,1),(51,1),(54,1),(57,1),(60,1),(63,1),(66,1),(69,1),(72,1),(75,1),(78,1),(81,1),(84,1),(87,1),(90,1),(93,1),(96,1),(99,1),(102,1),(105,1),(108,1),(111,1),(114,1),(117,1),(120,1),(123,1),(126,1),(129,1),(132,1),(135,1),(138,1),(141,1),(144,1),(147,1),(150,1),(153,1),(156,1),(159,1),(162,1),(165,1),(168,1),(171,1),(174,1),(177,1),(180,1),(183,1),(186,1),(189,1),(192,1),(195,1),(198,1),(201,1),(204,1),(207,1),(210,1),(213,1),(216,1),(219,1),(222,1),(225,1),(228,1),(231,1),(234,1),(237,1),(240,1),(243,1),(246,1),(249,1),(252,1),(255,1),(258,1),(261,1),(264,1),(267,1),(270,1),(273,1),(276,1),(279,1),(282,1),(285,1),(288,1),(291,1),(294,1),(297,1),(300,1),(303,1),(306,1),(309,1),(312,1),(1,2),(4,2),(7,2),(10,2),(13,2),(16,2),(19,2),(22,2),(25,2),(28,2),(31,2),(34,2),(37,2),(40,2),(43,2),(46,2),(49,2),(52,2),(55,2),(58,2),(61,2),(64,2),(67,2),(70,2),(73,2),(76,2),(79,2),(82,2),(85,2),(88,2),(91,2),(94,2),(97,2),(100,2),(103,2),(106,2),(109,2),(112,2),(115,2),(118,2),(121,2),(124,2),(127,2),(130,2),(133,2),(136,2),(139,2),(142,2),(145,2),(148,2),(151,2),(154,2),(157,2),(160,2),(163,2),(166,2),(169,2),(172,2),(175,2),(178,2),(181,2),(184,2),(187,2),(190,2),(193,2),(196,2),(199,2),(202,2),(205,2),(208,2),(211,2),(214,2),(217,2),(220,2),(223,2),(226,2),(229,2),(232,2),(235,2),(238,2),(241,2),(244,2),(247,2),(250,2),(253,2),(256,2),(259,2),(262,2),(265,2),(268,2),(271,2),(274,2),(277,2),(280,2),(283,2),(286,2),(289,2),(292,2),(295,2),(298,2),(301,2),(304,2),(307,2),(310,2),(313,2),(2,3),(5,3),(8,3),(11,3),(14,3),(17,3),(20,3),(23,3),(26,3),(29,3),(32,3),(35,3),(38,3),(41,3),(44,3),(47,3),(50,3),(53,3),(56,3),(59,3),(62,3),(65,3),(68,3),(71,3),(74,3),(77,3),(80,3),(83,3),(86,3),(89,3),(92,3),(95,3),(98,3),(101,3),(104,3),(107,3),(110,3),(113,3),(116,3),(119,3),(122,3),(125,3),(128,3),(131,3),(134,3),(137,3),(140,3),(143,3),(146,3),(149,3),(152,3),(155,3),(158,3),(161,3),(164,3),(167,3),(170,3),(173,3),(176,3),(179,3),(182,3),(185,3),(188,3),(191,3),(194,3),(197,3),(200,3),(203,3),(206,3),(209,3),(212,3),(215,3),(218,3),(221,3),(224,3),(227,3),(230,3),(233,3),(236,3),(239,3),(242,3),(245,3),(248,3),(251,3),(254,3),(257,3),(260,3),(263,3),(266,3),(269,3),(272,3),(275,3),(278,3),(281,3),(284,3),(287,3),(290,3),(293,3),(296,3),(299,3),(302,3),(305,3),(308,3),(311,3),(314,3),(1,4),(3,4),(5,4),(7,4),(9,4),(11,4),(13,4),(15,4),(17,4),(19,4),(21,4),(23,4),(25,4),(27,4),(29,4),(31,4),(33,4),(35,4),(37,4),(39,4),(41,4),(43,4),(45,4),(47,4),(49,4),(51,4),(53,4),(55,4),(57,4),(59,4),(61,4),(63,4),(65,4),(67,4),(69,4),(71,4),(73,4),(75,4),(77,4),(79,4),(81,4),(83,4),(85,4),(87,4),(89,4),(91,4),(93,4),(95,4),(97,4),(99,4),(101,4),(103,4),(105,4),(107,4),(109,4),(111,4),(113,4),(115,4),(117,4),(119,4),(121,4),(123,4),(125,4),(127,4),(129,4),(131,4),(133,4),(135,4),(137,4),(139,4),(141,4),(143,4),(145,4),(147,4),(149,4),(151,4),(153,4),(155,4),(157,4),(159,4),(161,4),(163,4),(165,4),(167,4),(169,4),(171,4),(173,4),(175,4),(177,4),(179,4),(181,4),(183,4),(185,4),(187,4),(189,4),(191,4),(193,4),(195,4),(197,4),(199,4),(201,4),(203,4),(205,4),(207,4),(209,4),(211,4),(213,4),(215,4),(217,4),(219,4),(221,4),(223,4),(225,4),(227,4),(229,4),(231,4),(233,4),(235,4),(237,4),(239,4),(241,4),(243,4),(245,4),(247,4),(249,4),(251,4),(253,4),(255,4),(257,4),(259,4),(261,4),(263,4),(265,4),(267,4),(269,4),(271,4),(273,4),(275,4),(277,4),(279,4),(281,4),(283,4),(285,4),(287,4),(289,4),(291,4),(293,4),(295,4),(297,4),(299,4),(301,4),(303,4),(305,4),(307,4),(309,4),(311,4),(313,4);

CREATE TABLE managers (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  voornaam varchar(45) NOT NULL,
  familienaam varchar(45) NOT NULL
) AUTO_INCREMENT=7;

INSERT INTO managers(voornaam,familienaam) VALUES ('Lomme','Driesens'),('Florent','Van Vaerenbergh'),('Walter','Dalgal'),('Kees','Priem'),('Guido','Van Calster'),('Dirk','Wayenbergh');

create user if not exists cursist identified by 'cursist';
grant select,insert,update,delete on docenten to cursist;
grant select,insert,delete on docentenbijnamen to cursist;
grant select,insert on campussen to cursist;
grant select,insert on campussentelefoonnrs to cursist;
grant insert,select on verantwoordelijkheden to cursist;
grant insert,select,delete on docentenverantwoordelijkheden to cursist;
grant insert,select on managers to cursist;