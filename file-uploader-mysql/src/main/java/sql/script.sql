create database spring_practice;

use spring_practice;

create table photo_upload(
    id bigint auto_increment primary key,
    image_name varchar(255),
    image_binary longblob
);