drop table if exists product;

CREATE TABLE product
(
    id    bigint not null auto_increment,
    name  varchar(255),
    price decimal(19, 2),
    primary key (id)
);