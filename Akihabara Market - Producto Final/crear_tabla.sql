create database akihabara_db;
use akihabara_db;

create table producto(
id int primary key auto_increment,
nombre varchar(255) not null,
categoria varchar(100),
precio decimal(10, 2),
stock int
);

create user 'userAkihabara'@'localhost' identified with mysql_native_password by 'curso';
grant all privileges on akihabara_db.producto to 'userAkihabara'@'localhost';

insert into producto (nombre, categoria, precio, stock) values ('Frieren 30cm', 'Figura', 30.45, 20);
insert into producto (nombre, categoria, precio, stock) values ('Broly 230cm', 'Figura', 500.00, 5);
insert into producto (nombre, categoria, precio, stock) values ('Artorias 20cm', 'Figura', 25.13, 17);
insert into producto (nombre, categoria, precio, stock) values ('Natsu 25cm', 'Figura', 40.34, 15);

insert into producto (nombre, categoria, precio, stock) values ('One punch man tomo 1', 'Manga', 9.99, 50);
insert into producto (nombre, categoria, precio, stock) values ('One Piece tomo 7', 'Manga', 12.15, 60);
insert into producto (nombre, categoria, precio, stock) values ('Bleach tomo 12', 'Manga', 10.43, 40);
insert into producto (nombre, categoria, precio, stock) values ('Baki tomo 3', 'Manga', 13.52, 53);

insert into producto (nombre, categoria, precio, stock) values ('Poster One Piece 50x30', 'Poster', 18.72, 24);
insert into producto (nombre, categoria, precio, stock) values ('Poster Attack on Titan 40x40', 'Poster', 20.31, 15);
insert into producto (nombre, categoria, precio, stock) values ('Poster Naruto 60x30', 'Poster', 16.72, 21);
insert into producto (nombre, categoria, precio, stock) values ('Poster HunterXHunter 70x20', 'Poster', 23.16, 27);

insert into producto (nombre, categoria, precio, stock) values ('Llavero Fairy Tail', 'Llavero', 5.82, 62);
insert into producto (nombre, categoria, precio, stock) values ('Llavero Berserk', 'Llavero', 4.86, 52);
insert into producto (nombre, categoria, precio, stock) values ('Llavero Dark Souls', 'Llavero', 7.32, 41);
insert into producto (nombre, categoria, precio, stock) values ('Llavero My Hero Academia', 'Llavero', 3.15, 36);

insert into producto (nombre, categoria, precio, stock) values ('Camisa Dragon Ball', 'Ropa', 15.12, 40);
insert into producto (nombre, categoria, precio, stock) values ('Sudadera The Legend of Zelda', 'Ropa', 23.45, 50);
insert into producto (nombre, categoria, precio, stock) values ('Camisa Fire Emblem', 'Ropa', 14.31, 30);
insert into producto (nombre, categoria, precio, stock) values ('Chaqueta Naruto', 'Ropa', 17.72, 20);

select * from producto

Select * from producto where nombre like '%Dragon%'