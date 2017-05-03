
insert into PERSON(lastName, firstName, personType) values('Tolkien', 'JRR','AUTHOR');
insert into PERSON(lastName, firstName, personType) values('Martins', 'RR','AUTHOR');
insert into PERSON(lastName, firstName, personType) values('Rowling', 'JK','AUTHOR');
insert into PERSON(lastName, firstName, personType) values('Levy', 'Marc','AUTHOR');

insert into PERSON(lastName, firstName, personType) values('Cruise', 'Tom','VEDETTE');
insert into PERSON(lastName, firstName, personType) values('Diaz', 'Cameron','VEDETTE');

insert into PERSON(lastName, firstName, personType) values('Bay', 'Michael','REALISATEUR');
insert into PERSON(lastName, firstName, personType) values('Nolan', 'Christopher','REALISATEUR');
insert into PERSON(lastName, firstName, personType) values('Lucas', 'Georges','REALISATEUR');

-- Harry Potter
insert into ARTICLE(price, description) values(24.00, 'Le livre 4 d''Harry Potter');

insert into BOOK(idArticle, title, ISBN) 
	values(
		(SELECT idArticle FROM ARTICLE WHERE price = 24.00 AND description = 'Le livre 4 d''Harry Potter'),
		'Harry Potter et la coupe de feu', 
		'00448U573');
		
insert into WROTE_BY_AUTHOR_BOOK(idBook, idAuthor) 
	values (
		(SELECT idArticle FROM BOOK WHERE title = 'Harry Potter et la coupe de feu' AND ISBN='00448U573'), 
		(SELECT id FROM PERSON WHERE lastName = 'Rowling' AND firstName = 'JK' AND personType = 'AUTHOR'));
		
-- Game of thrones
insert into ARTICLE(price, description) values(28.00, 'Valar Morgulhis');

insert into BOOK(idArticle, title, ISBN) 
	values(
		(SELECT idArticle FROM ARTICLE WHERE price = 28.00 AND description = 'Valar Morgulhis'),
		'Song of Ice and Fire', 
		'00448U575');
		
insert into WROTE_BY_AUTHOR_BOOK(idBook, idAuthor) 
	values (
		(SELECT idArticle FROM BOOK WHERE title = 'Song of Ice and Fire' AND ISBN='00448U575'), 
		(SELECT id FROM PERSON WHERE lastName = 'Martins' AND firstName = 'RR' AND personType = 'AUTHOR'));
		
		
-- Caca
insert into ARTICLE(price, description) values(3.00, 'Incontournable');

insert into BOOK(idArticle, title, ISBN) 
	values(
		(SELECT idArticle FROM ARTICLE WHERE price = 3.00 AND description = 'Incontournable'),
		'Le livre de l''été',
		'00448U500');
		
insert into WROTE_BY_AUTHOR_BOOK(idBook, idAuthor) 
	values (
		(SELECT idArticle FROM BOOK WHERE title = 'Le livre de l''été' AND ISBN='00448U500'),
		(SELECT id FROM PERSON WHERE lastName = 'Levy' AND firstName = 'Marc' AND personType = 'AUTHOR'));
		
insert into WROTE_BY_AUTHOR_BOOK(idBook, idAuthor) 
	values (
		(SELECT idArticle FROM BOOK WHERE title = 'Le livre de l''été' AND ISBN='00448U500'),
		(SELECT id FROM PERSON WHERE lastName = 'Rowling' AND firstName = 'JK' AND personType = 'AUTHOR'));

-- Artists
insert into ARTIST(name) values ('Muse');
insert into ARTIST(name) values ('Queen');
insert into ARTIST(name) values ('Chopin');
insert into ARTIST(name) values ('Dr Grims');
		
insert into ARTICLE(price, description) values(19.00, 'Le dernier album du groupe d''anthologie Muse!');
insert into DISK(idArticle, idArtist, style) 
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 19.00 AND description = 'Le dernier album du groupe d''anthologie Muse!'),
		(select id FROM ARTIST WHERE name = 'Muse'), 
		'Rock');

insert into ARTICLE(price, description) values(58.00, 'L''int�grale du groupe culte');
insert into DISK(idArticle, idArtist, style) 
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 58.00 AND description = 'L''int�grale du groupe culte'),
		(select id FROM ARTIST WHERE name = 'Queen'), 
		'ROCK');

insert into ARTICLE(price, description) values(8.00, 'Son plus beau morceau');
insert into DISK(idArticle, idArtist, style) 
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 8.00 AND description = 'Son plus beau morceau'),
		(select id FROM ARTIST WHERE name = 'Chopin'), 
		'CLASSIQUE');

insert into ARTICLE(price, description) values(31.11, 'Encore un album...');
insert into DISK(idArticle, idArtist, style)
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 31.11 AND description = 'Encore un album...'),
		(select id FROM ARTIST WHERE name = 'Dr Grims'), 
		'NODATA');

insert into ARTICLE(price, description) values(35.00, 'Sorti en 1977');
insert into DVD(idArticle, category, idRealisateur) 
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 35.00 AND description = 'Sorti en 1977'),
		'FANTASTIQUE',
		(SELECT id FROM PERSON WHERE lastName = 'Lucas' AND firstName = 'Georges')
	);
	
insert into ARTICLE(price, description) values(23.00, 'Un chef d''oeuvre');
insert into DVD(idArticle, category, idRealisateur) 
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 23.00 AND description = 'Un chef d''oeuvre'),
		'THRILLER',
		(SELECT id FROM PERSON WHERE lastName = 'Nolan' AND firstName = 'Christopher')
	);
	
insert into ARTICLE(price, description) values(29.00, 'Du lourd visuellement');
insert into DVD(idArticle, category, idRealisateur) 
	values (
		(SELECT idArticle FROM ARTICLE WHERE price = 29.00 AND description = 'Du lourd visuellement'),
		'ACTION',
		(SELECT id FROM PERSON WHERE lastName = 'Bay' AND firstName = 'Michael')
	);
	
insert into PLAYED_IN_DVD_PERSON(idDvd, idVedette) 
	values (
		(select idArticle FROM dvd where category = 'ACTION'),
		(SELECT id FROM PERSON WHERE lastName = 'Cruise' AND firstName = 'Tom')
	);