/** Creating Player Table.*/
CREATE TABLE "mySchema"."Player" (
  "id" bigint(20) NOT NULL AUTO_INCREMENT,
  "firstName" varchar(50) NOT NULL,
  "lastName" varchar(50) DEFAULT NULL,
  "phoneNumber" varchar(50) DEFAULT NULL,
  "gender" varchar(10) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8;