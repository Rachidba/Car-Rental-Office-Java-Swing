/* creation of database */
CREATE DATABASE carrentaloffice;
USE carrentaloffice;

/* create tables */

/* car table */
CREATE  TABLE car(registrationNumber VARCHAR(50) PRIMARY KEY, 
					brand VARCHAR(50), 
					model VARCHAR(50), 
					price DOUBLE);
/* client table */
CREATE TABLE client(CIN VARCHAR(50) PRIMARY KEY, 
					firstName VARCHAR(50), 
					lastName VARCHAR(50));
/* ranting table */
CREATE TABLE ranting(rantID INT PRIMARY KEY AUTO_INCREMENT, 
					registrationNumber VARCHAR(50), 
					CIN VARCHAR(50), 
					isReturned BIT, 
					rentalDate DATE, 
					returnDate DATE);

/* CAR DATA */

insert into car values ('X15P98A', 'Acura', 'NSX', 47075);
insert into car values ('Z85P385', 'Audi', 'A8', 63890);
insert into car values ('Z95P385', 'BMW', 'M-Series', 108900);
insert into car values ('A85P345', 'Buick', 'Lucerne', 31599);
insert into car values ('YK12974', 'Cadilac', 'XLR', 62777);
insert into car values ('SL12697', 'Chevrolet', 'Corvette', 74999);
insert into car values ('KDG1578', 'Chrysler', 'Sebring', 89595);
insert into car values ('MFS6723', 'Daewoo', 'Leganza', 10590);
insert into car values ('NFM4879', 'Dodge', 'Ram 2500', 38825);
insert into car values ('BDX2367', 'Eagle', 'Talon', 5995);
insert into car values ('NXJ3215', 'Ford', 'F250', 47440);
insert into car values ('KST4512', 'Geo', 'Metro LSI', 3495);
insert into car values ('MQN1459', 'GMC', 'Yukon XL Denali', 46355);
insert into car values ('LST5479', 'Honda', 'Odyssey', 34895);
insert into car values ('MPZ1235', 'Hummer', 'H1', 119999);
insert into car values ('PEY9876', 'Hyundai', 'Azera', 27950);
insert into car values ('NDG4587', 'Infiniti', 'QX56', 44995);
insert into car values ('MSG4578', 'Isuzu', 'Hombre', 30545);
insert into car values ('MAH1358', 'Jaguar', 'XK', 91675);
insert into car values ('QMT1458', 'Jeep', 'Commander', 37497);
insert into car values ('MST2548', 'Kia', 'Amanti', 25988);
insert into car values ('NVHF458', 'Land Rover', 'Range Rover', 89350);
insert into car values ('DRST753', 'Lexus', 'SC 430', 61321);
insert into car values ('MK15DH9', 'Lincoln', 'Navigator', 42500);
insert into car values ('MG98P2P', 'Mazda', 'CX-7', 27988);
insert into car values ('QSZD654', 'Mercedes-Benz', 'CLS Class', 86900);
insert into car values ('OIRZ325', 'Mercury', 'Mariner', 30995);
insert into car values ('PLKD987', 'MINI', 'Cooper', 32930);
insert into car values ('ML658PS', 'Mitsubishi', 'Eclipse', 31995);
insert into car values ('KFS6A21', 'Nissan', 'Armada', 36777);
insert into car values ('NBWC987', 'Oldsmobile', 'Silhouette', 17500);
insert into car values ('MPAT147', 'Plymouth', 'Voyager', 9995);
insert into car values ('POIU986', 'Pontiac', 'Firebird', 39999);
insert into car values ('MDGR458', 'Porche', '911 Carrera', 399999);
insert into car values ('15HG6AR', 'Saab', '9-3', 35999);
insert into car values ('PKR67H6', 'Saturn', 'Sky', 27499);
insert into car values ('SGAN88S', 'Scion', 'tC', 21530);
insert into car values ('1233SFW', 'Subaru', 'B9 Tribeca', 34999);
insert into car values ('LQ515DK', 'Suzuki', 'XL-7', 25880);
insert into car values ('MD58VC8', 'Toytota', 'MR2 Spyder', 99999);
insert into car values ('KDTO875', 'Volkswagen', 'Touareg', 51274);
insert into car values ('MZPH558', 'Volvo', 'XC90', 45845);

/* CLIENT DATA */

INSERT INTO  client VALUES ('A007', 'Schmitt','Carine ');
INSERT INTO  client VALUES ('A003', 'King','Jean');
INSERT INTO  client VALUES ('A008', 'Ferguson','Peter');
INSERT INTO  client VALUES ('A011', 'Labrune','Janine ');
INSERT INTO  client VALUES ('A010', 'Bergulfsen','Jonas ');
INSERT INTO  client VALUES ('A012', 'Nelson','Susan');
INSERT INTO  client VALUES ('A005', 'Anderson', 'Brisban');
INSERT INTO  client VALUES ('A001', 'Keitel','Roland');
INSERT INTO  client VALUES ('A002', 'Mukesh', 'Mumbai');
INSERT INTO  client VALUES ('A006', 'McDen', 'London');
INSERT INTO  client VALUES ('A004', 'Ivan', 'Torento');
INSERT INTO  client VALUES ('A009', 'Benjamin', 'Hampshair');