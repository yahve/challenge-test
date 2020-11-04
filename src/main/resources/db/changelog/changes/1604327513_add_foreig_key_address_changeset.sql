-- liquibase formatted sql

-- changeset xvierd:1
alter table challenge.users add address_id bigint null;

-- changeset xvierd:2
alter table challenge.users
    add constraint users_fk
        foreign key (address_id)
            references challenge.addresses(id);