drop table if exists product;
create table product
(
    id    int primary key auto_increment,
    name  varchar(255)   not null,
    price decimal(10, 2) not null,
    image varchar(255)   not null
);

drop table if exists item;
create table item
(
    id         int primary key auto_increment,
    product_id int not null,
    quantity   int not null
);
