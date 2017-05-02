
CREATE TABLE AUTHOR (id INTEGER, lastName varchar(50), firstName varchar(50))
insert into AUTHOR values(100, 'Rowling', 'JK')

CREATE TABLE BOOK (id INTEGER, title varchar(50), ISBN varchar(30), author_id INTEGER)

insert into BOOK values(10, 'Harry Potter et la coupe de feu', '00448U573', null, 1)

CREATE table ARTICLE(id INTEGER, price INTEGER, description varchar(20))

// un article peut etre un livre, un disque ou un dvd
// un livre à un ou plusieurs auteurs
// un cd peut etre realisé par un artiste ou un groupe
// un cd appartient a un style musical
// un dvd a une categorie , un realisateur et une ou plusieures vedettes

// je veux pouvoir recuperer la totalité des oeuvre d'un artiste
// je veux pouvoir connaitre la somme (prix) des ventes effectuée par categorie d'articles
// je veux savoir quel style musical connait les meilleures ventes
// je veux resister à l'injection sql
// je veux pouvoir mettre à jour le prix des articles
// les opérations CRUD doivent etre disponible pour chaque table
