
CREATE TABLE AUTHOR (id INTEGER, lastName varchar(50), firstName varchar(50))
insert into AUTHOR values(100, 'Rowling', 'JK')

CREATE TABLE BOOK (id INTEGER, title varchar(50), ISBN varchar(30), summary varchar(30), published date, author_id INTEGER)

insert into BOOK values(10, 'Harry Potter et ta mère', '00448U573', '"Tu es un sorcier Harry"', null, 1)
