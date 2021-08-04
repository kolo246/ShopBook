CREATE TABLE users
(
    id           serial primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    email        varchar(50) not null,
    city         varchar(50) not null,
    phone_number varchar(12) not null,
    age          integer
);
CREATE TABLE books
(
    id       serial primary key,
    title    varchar(50) not null,
    author   varchar(50) not null,
    isbn     integer,
    quantity integer,
    price    float
);
CREATE TABLE orders
(
    id      serial primary key,
    user_id integer,
    items   integer,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);
