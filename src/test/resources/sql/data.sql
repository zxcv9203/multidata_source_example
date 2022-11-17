CREATE TABLE product
(
    id    bigint not null,
    name  varchar(255),
    price decimal(19, 2),
    primary key (id)
);

create sequence hibernate_sequence start with 1 increment by 1;


INSERT INTO product VALUES (1, "cola", 1500);
INSERT INTO product VALUES (2, "juice", 2000);
INSERT INTO product VALUES (3, "yogurt", 3500);