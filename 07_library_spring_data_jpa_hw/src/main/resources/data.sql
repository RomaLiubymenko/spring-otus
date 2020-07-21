Use Library;

delete from Comments;
DBCC CHECKIDENT ('Library.dbo.Comments',RESEED, 0);

delete from Books;
DBCC CHECKIDENT ('Library.dbo.Books',RESEED, 0);

delete from PublishingHouses;
DBCC CHECKIDENT ('Library.dbo.PublishingHouses',RESEED, 0);

delete from Authors;
DBCC CHECKIDENT ('Library.dbo.Authors',RESEED, 0);

delete from Genres;
DBCC CHECKIDENT ('Library.dbo.Genres',RESEED, 0);

insert into Authors values('Taras','Shevchenko','Ukraine');
insert into Authors values('Ivan','Kotlyarevsky','Ukraine');
insert into Authors values('Lesya','Ukrainka','Ukraine');

insert into Genres values ('Verse');
insert into Genres values ('Poem');
insert into Genres values ('Drama');
insert into Genres values ('Play');

insert into PublishingHouses values ('UkraineShevchenko', 'Ukraine');
insert into PublishingHouses values ('UkraineKotlyarevsky', 'Ukraine');
insert into PublishingHouses values ('UkraineUkrainka', 'Ukraine');

insert into Books values (1,1,1,'Three summers','1865-11-11', 20);
insert into Books values (2,3,2,'Aeneid','1798-11-11',300);
insert into Books values(2,4,3,'Forest Song','1911-11-11', 256);


insert into Comments values(1,'very good', CURRENT_TIMESTAMP );
insert into Comments values(1,'not bad', CURRENT_TIMESTAMP);
insert into Comments values(2,'amazing', CURRENT_TIMESTAMP);
insert into Comments values(2,'best of the best', CURRENT_TIMESTAMP);

