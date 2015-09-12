
DROP DATABASE IF EXISTS properties;

CREATE DATABASE properties;

USE properties;

CREATE TABLE Owners(
OwnerName	VARCHAR(20)	NOT NULL,
Street		VARCHAR(50)	NOT NULL,
City		VARCHAR(20)	NOT NULL,
State		VARCHAR(20)	NOT NULL,
Zip		INT		NOT NULL
/*PRIMARY KEY(lastName) */
);

 

CREATE TABLE ResidentialProperties(
PropertyType	VARCHAR(20)	NOT NULL,	
OwnerName	VARCHAR(20)	NOT NULL,
AccountNumber	INT		NOT NULL,
Street		VARCHAR(50)	NOT NULL,
City		VARCHAR(20)	NOT NULL,
State		VARCHAR(20)	NOT NULL,
Zip		INT		NOT NULL,
MarketValue	INT		NOT NULL,
/*DatePurchased	DATE		NOT NULL,  */
Day		INT 		NOT NULL,
Month 		INT		NOT NULL,
Year		INT		NOT NULL,	
SquareFeet	INT		NOT NULL,
PropertyTier	CHAR(6)		NOT NULL,
FloodZone	CHAR(5)		NOT NULL,
Subdivision	VARCHAR(20)	NOT NULL
/*PRIMARY KEY (lastName),
FOREIGN KEY(lastName) REFERENCES Owners */
);

CREATE TABLE CommercialProperties(
PropertyType	VARCHAR(30)	NOT NULL,
OwnerName	VARCHAR(20)	NOT NULL,
AccountNumber	INT		NOT NULL,
Street		VARCHAR(50)	NOT NULL,
City		VARCHAR(20)	NOT NULL,
State		VARCHAR(20)	NOT NULL,
Zip		INT		NOT NULL,
MarketValue	INT		NOT NULL,
/*DatePurchased	DATE		NOT NULL,  */
Day		INT 		NOT NULL,
Month 		INT		NOT NULL,
Year		INT		NOT NULL,		
SquareFeet	INT		NOT NULL,
PropertyTier	CHAR(6)		NOT NULL,
BusinessName	VARCHAR(20)	NOT NULL,
StateCode	CHAR(6)		NOT NULL
/*PRIMARY KEY (lastName),
FOREIGN KEY(lastName) REFERENCES Owners */

);


INSERT INTO Owners(OwnerName,Street,City,State,Zip) VALUES ('Jones','221 Smith','Arlington','Texas',76019);
INSERT INTO Owners(OwnerName,Street,City,State,Zip) VALUES ('Smith','7345 Lane Rd','Dallas','Texas',75000);
INSERT INTO Owners(OwnerName,Street,City,State,Zip) VALUES ('Willis','596 Dale Lane','Fort Worth','Texas',76123);
INSERT INTO Owners(OwnerName,Street,City,State,Zip) VALUES ('Traver','512 Ball Court','Burleson','Texas',76138);
INSERT INTO Owners(OwnerName,Street,City,State,Zip) VALUES ('Merrit','11 Flower Road','North Richland Hills','Texas',77126);


INSERT INTO ResidentialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,FloodZone,Subdivision) VALUES ('Residential','Jones',12345,'111 W 2nd St.','Tulsa','Oklahoma',58934,135000,1,13,2013,1575,'TIER2','True','Stately Estates');
INSERT INTO ResidentialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,FloodZone,Subdivision) VALUES ('Residential','Smith',65892,'92 Davis St.','Arlington','Texas',76019,90000,3,25,2010,2235,'TIER3','False','Green Gables');
INSERT INTO ResidentialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,FloodZone,Subdivision) VALUES ('Residential','Traver',98765,'252 Park Lane','Atlanta','Georgia',60606,155000,2,1,2014,1850,'TIER1','True','King Manor');
INSERT INTO ResidentialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,FloodZone,Subdivision) VALUES ('Residential','Willis',38767,'853 Third Avenue','New York','New York',90123,96000,4,3,2008,3025,'TIER3','False','Kingly Estates');


INSERT INTO CommercialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,BusinessName,StateCode)VALUES ('Commercial','Willis',72634,'3865 Cooper St.','Arlington','Texas',76018,235000,5,2,1990,1300,'TIER4','Joe Paint Shop','A546J');
INSERT INTO CommercialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,BusinessName,StateCode)VALUES ('Commercial','Jones',14256,'111 Smart Rd.','New Orleans','Louisiana',34562,65000,7,15,2005,5000,'TIER4','Tacos Galore','R782D');
INSERT INTO CommercialProperties(PropertyType,OwnerName,AccountNumber,Street,City,State,Zip,MarketValue,Day, Month, Year,SquareFeet,PropertyTier,BusinessName,StateCode)VALUES ('Commercial','Merrit',19385,'605 Green Blvd','Arlington','Texas',76015,275000,10,21,2012,4321,'TIER2','Battery City','G921G');






