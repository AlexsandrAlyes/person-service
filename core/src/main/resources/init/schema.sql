drop schema if exists clinic cascade;

create schema if not exists clinic;

comment on schema clinic is 'Медецинское учереждение';

create table if not exists clinic.medical_card
(
    id              bigserial       not null primary key,
    client_status   char(255),
    med_status      char(255),
    registry_date   date,
    comment         text
);

comment on table clinic.medical_card is 'Медицинская карта';

create table if not exists clinic.contact
(
    id              bigserial       not null primary key,
    phone_number    varchar(32)     not null,
    email           varchar(128),
    profile_link    text
);

comment on table clinic.contact is 'Контактная информация';

create table if not exists clinic.illness
(
    id              bigserial       not null primary key,
    type_id         bigint,
    heaviness       char(10),
    appearance_dttm timestamp       not null,
    recovery_dt     date,
    medical_card_id bigint          not null references clinic.medical_card (id)
);

comment on table clinic.illness is 'Заболевание';

create table if not exists clinic.address
(
    id              bigserial       not null primary key,
    country_id      bigint          not null,
    city            varchar(255),
    index           integer,
    street          varchar(255),
    building        varchar(32),
    flat            varchar(32),
    contact_id      bigint          not null references clinic.contact (id)
);

comment on table clinic.address is 'Адрес';

create table if not exists clinic.person_data
(
    id              bigserial       not null primary key,
    first_name      varchar(255)    not null,
    last_name       varchar(255)    not null,
    birth_date      date,
    age             smallint,
    sex             char(10)        not null,
    contact_id      bigint          not null references clinic.contact (id),
    medical_card_id bigint unique   not null references clinic.medical_card (id),
    parent_id       bigint check ( parent_id <> id ) references clinic.person_data (id)
);

comment on table clinic.person_data is 'Персальная информация';
