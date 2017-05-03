
insert into AUTHOR(lastName, firstName) values('Tolkien', 'JRR');

insert into ARTICLE(price, description) values(25, 'Le livre 3 du Seigneur des Anneaux');
insert into BOOK(idArticle, title, ISBN) values((SELECT idArticle FROM ARTICLE WHERE price = 25),'Le retour du roi', '00448U573');
insert into WROTE_BY_AUTHOR_BOOK(idBook, idAuthor) values((SELECT idArticle FROM BOOK WHERE title = 'Le retour du roi' AND ISBN='00448U573'), (SELECT id FROM AUTHOR WHERE lastName = 'Tolkien'));
