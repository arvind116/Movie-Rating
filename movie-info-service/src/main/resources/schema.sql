DROP TABLE IF EXISTS movie;

CREATE TABLE movie(
id int not null primary key auto_increment,
movie_id varchar(255) not null,
name varchar(255) not null,
descr varchar(255) not null,
message varchar(255) default 'MOVIE FOUND'
)