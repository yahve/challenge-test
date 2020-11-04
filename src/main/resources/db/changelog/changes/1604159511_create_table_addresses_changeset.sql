-- liquibase formatted sql

-- changeset xvierd:1

create table `addresses` (
    id bigint auto_increment not null,
    street varchar(100)  null,
    state varchar(100) null,
    city varchar(100)  null,
    country varchar(100)  null,
    zip varchar(100)  null,
    constraint address_pk primary key (id)
)
    engine=innodb
    default charset=utf8
    collate=utf8_general_ci;
