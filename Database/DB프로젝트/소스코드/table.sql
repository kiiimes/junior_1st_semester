CREATE TABLE customer(
  licenseID varchar(45) NOT NULL,
  cusName varchar(45) DEFAULT NULL,
  city varchar(45) DEFAULT NULL,
  ku varchar(45) DEFAULT NULL,
  dong varchar(45) DEFAULT NULL,
  cusPhoneNum varchar(45) DEFAULT NULL,
  cusMail varchar(45) DEFAULT NULL,
  PRIMARY KEY (licenseID)
);

ALTER TABLE campingcar MODIFY(carMaxPeopNum int DEFAULT NULL);
ALTER TABLE campingcar MODIFY(carrentCost int DEFAULT NULL);

출처: http://jwklife.tistory.com/5 [인 생]
CREATE TABLE campingcar(
  carRegtID varchar(45) NOT NULL,
  campingcar_RentCorpID varchar(45) DEFAULT NULL,
  carName varchar(45) DEFAULT NULL,
  carNum varchar(45) DEFAULT NULL,
  carMaxPeopNum int DEFAULT NULL,
  carImage varchar(500) DEFAULT NULL,
  carInfo varchar(45) DEFAULT NULL,
  carrentCost int DEFAULT NULL,
  carRegtDate varchar(45) DEFAULT NULL,
  PRIMARY KEY (carRegtID)
);
CREATE TABLE rentcorp (
  rentCorpID varchar(45) NOT NULL,
  corpName varchar(45) NOT NULL,
  city varchar(45) DEFAULT NULL,
  ku varchar(45) DEFAULT NULL,
  dong varchar(45) DEFAULT NULL,
  corpPhoneNum varchar(45) DEFAULT NULL,
  corpManagerName varchar(45) DEFAULT NULL,
  corpManagerMail varchar(45) DEFAULT NULL,
  PRIMARY KEY (rentCorpID)
);
CREATE TABLE repairshop (
  shopID varchar(45) NOT NULL,
  shopName varchar(45) DEFAULT NULL,
  city varchar(45) DEFAULT NULL,
  ku varchar(45) DEFAULT NULL,
  dong varchar(45) DEFAULT NULL,
  shopPhoneNum varchar(45) DEFAULT NULL,
  shopManagerName varchar(45) DEFAULT NULL,
  shopManagerMail varchar(45) DEFAULT NULL,
  PRIMARY KEY (shopID)
);

CREATE TABLE prevuse (
  prevUseNo int NOT NULL,
  prevUse_licenseID varchar(45) DEFAULT NULL,
  prevUse_carRegtID varchar(45) DEFAULT NULL,
  prevUseDate varchar(45) DEFAULT NULL,
  PRIMARY KEY (prevUseNo)
);
CREATE TABLE rental (
  rentalID varchar(45) NOT NULL,
  rental_carRegtID varchar(45) DEFAULT NULL,
  rental_licenseID varchar(45) DEFAULT NULL,
  rental_rentCompanyID varchar(45) DEFAULT NULL,
  rentStartDate varchar(45) DEFAULT NULL,
  rentPeriod int DEFAULT NULL,
  rentPrice int DEFAULT NULL,
  paymentDue varchar(45) DEFAULT NULL,
  etcBillDetail varchar(100) DEFAULT NULL,
  etcBillPrice int DEFAULT NULL,
  PRIMARY KEY (rentalID)
);
CREATE TABLE repair (
  repairID int NOT NULL,  
  repair_carRegtID varchar(45) DEFAULT NULL,
  repair_shopID varchar(45) DEFAULT NULL,
  repair_rentCompanyID varchar(45) DEFAULT NULL,
  repair_licenseID varchar(45) DEFAULT NULL,
  repairHistory varchar(100) DEFAULT NULL,
  repairDate varchar(45) DEFAULT NULL,
  repairPrice int DEFAULT NULL,
  paymentDue varchar(45) DEFAULT NULL,
  etcRepairInfo varchar(100) DEFAULT NULL,
  PRIMARY KEY (repairID)
);