USE Library;

IF OBJECT_ID('dbo.Authors') IS NOT NULL
    DROP TABLE dbo.Authors;
IF OBJECT_ID('dbo.Books') IS NOT NULL
    DROP TABLE dbo.Books;
IF OBJECT_ID('dbo.Genres') IS NOT NULL
    DROP TABLE dbo.Genres;
IF OBJECT_ID('dbo.PublishingHouses') IS NOT NULL
    DROP TABLE dbo.PublishingHouses;

create table Authors
(
	idAuthor int identity
		constraint PK_id_Authors
			primary key,
	firstname nvarchar(70) not null,
	lastname nvarchar(70) not null,
	country nvarchar(100) not null
)
go

create table Genres
(
	idGenre int identity
		constraint PK_id_Genres
			primary key,
	nameGenre nvarchar(50)
)
go

create table PublishingHouses
(
	idPublishingHouse int identity
		constraint PK_id_PublishingHouses
			primary key,
	publishingName nvarchar(100) not null,
	country nvarchar(100) not null
)
go

create table Books
(
	idBook int identity
		constraint PK_id_Books
			primary key,
	idAuthor int not null
		references Authors,
	idGenre int not null
		references Genres,
	idPublishingHouse int not null
		references PublishingHouses,
	title nvarchar(50) not null,
	publicationYear date not null,
	numberOfPages int
)
go



