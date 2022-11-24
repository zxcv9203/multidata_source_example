drop table if exists users;

CREATE TABLE users
(
    id    bigint not null auto_increment,
    name  varchar(255),
    age int(11),
    primary key (id)
);