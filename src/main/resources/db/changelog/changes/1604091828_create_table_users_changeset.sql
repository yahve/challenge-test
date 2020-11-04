-- liquibase formatted sql

-- changeset xvierd:1

create table `users` (
    id bigint auto_increment not null,
    name varchar(100) not null,
    email varchar(100) not null,
    birth_date datetime not null,
    constraint usertable_pk primary key (id)
)
    engine=innodb
    default charset=utf8
    collate=utf8_general_ci;
