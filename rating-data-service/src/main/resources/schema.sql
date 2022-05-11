DROP TABLE IF EXISTS rating;

CREATE TABLE rating(
id int not null primary key auto_increment,
movie_id varchar(255) not null,
user_id varchar(255) not null,
rating int not null
)