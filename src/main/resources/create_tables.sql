create table accident (
    id number(19,0) generated as identity,
    accident_date timestamp(6) not null,
    type varchar2(255 char) not null,
    primary key (id)
);

create table accident_participants (
   accident_id number(19,0) not null,
   participants_id number(19,0) not null
);

create table accident_participant (
  id number(19,0) generated as identity,
  is_responsible number(1,0) not null,
  car_vin_number varchar2(255 char),
  primary key (id)
);

create table accident_participant_persons (
    accident_participant_id number(19,0) not null,
    persons_id number(19,0) not null
);

create table address (
     id number(19,0) generated as identity,
     city varchar2(255 char),
     country varchar2(255 char),
     postal_code varchar2(255 char),
     street varchar2(255 char),
     primary key (id)
);

create table address_history (
     id number(19,0) generated as identity,
     change_date timestamp(6),
     new_address_id number(19,0),
     old_address_id number(19,0),
     person_id number(19,0),
     primary key (id)
);

create table car (
     vin_number varchar2(255 char) not null,
     manufacture_year timestamp(6),
     registration_number varchar2(255 char) not null,
     car_model_id number(19,0),
     primary key (vin_number)
);

create table car_person (
    car_id varchar2(255 char) not null,
    person_id number(19,0) not null
);

create table car_model (
   id number(19,0) generated as identity,
   brand varchar2(255 char),
   engine_capacity number(19,0),
   engine_type varchar2(255 char),
   model_generation number(19,0),
   model_name varchar2(255 char),
   primary key (id)
);

create table insurance_policy (
    id number(19,0) generated as identity,
    creation_date timestamp(6) not null,
    expiration_date timestamp(6) not null,
    insurance_amount number(19,0),
    insurance_price number(19,0),
    car_vin_number varchar2(255 char),
    primary key (id)
);

create table person (
    id number(19,0) generated as identity,
    birth_date timestamp(6),
    driving_licence_date timestamp(6),
    name varchar2(255 char) not null,
    surname varchar2(255 char) not null,
    address_id number(19,0),
    primary key (id)
);

alter table accident_participants
    add constraint UK_eaxx2qpenc00b0d0fe04mhiig unique (participants_id);

alter table accident_participant_persons
    add constraint UK_t7bugqwtw1u80cc1l9w9ebj5x unique (persons_id);

alter table accident_participants
    add constraint FKhpetfr1k8ran10wvaekcssnbj
        foreign key (participants_id)
            references accident_participant;

alter table accident_participants
    add constraint FKj3sfwypsqrd6l42mj8cmfa01g
        foreign key (accident_id)
            references accident;

alter table accident_participant
    add constraint FKsy3w0i17nn2xeh8mjlyeunk71
        foreign key (car_vin_number)
            references car;

alter table accident_participant_persons
    add constraint FKa9shhduyvi4ruoxwq3k54g1g9
        foreign key (persons_id)
            references person;

alter table accident_participant_persons
    add constraint FKntqfl65j2outap5ltf5rodtko
        foreign key (accident_participant_id)
            references accident_participant;

alter table address_history
    add constraint FK9m6bpl7a88nhwl5pt83bei4ln
        foreign key (new_address_id)
            references address;

alter table address_history
    add constraint FK1rygq23e2wkcx7sssa7e8o59p
        foreign key (old_address_id)
            references address;

alter table address_history
    add constraint FKwjj2bjyvx45pqbg8vodhil4v
        foreign key (person_id)
            references person;

alter table car
    add constraint FKgfht1l5lcn8gbugha10mnt4bg
        foreign key (car_model_id)
            references car_model;

alter table car_person
    add constraint FKhh13udi9yoholh04f4j2f2625
        foreign key (person_id)
            references person;

alter table car_person
    add constraint FKagxyoqot0l8tawnww9d8sn5w6
        foreign key (car_id)
            references car;

alter table insurance_policy
    add constraint FK4s9n6belnm47o9s7myulaod8j
        foreign key (car_vin_number)
            references car;

alter table person
    add constraint FKk7rgn6djxsv2j2bv1mvuxd4m9
        foreign key (address_id)
            references address;