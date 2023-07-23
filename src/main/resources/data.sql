/*
create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);
*/

-- spring boot auto-config understand the there is JPA in classpath so rather than having to create table in data.sql
-- it triggers schema update of hibernate automatically for us from our entity (Person class)...... soo... smart, right :)
-- but this is the case of in memory database only (we are using H2).


INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10004,  'jaggu', 'Nasik',CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'sachin', 'lonawala',CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'Onkar', 'Latur',CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10005,  'Hitesh', 'Satana',CURRENT_TIMESTAMP());


