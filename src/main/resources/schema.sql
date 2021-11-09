create table if not exists department
(
    id bigint(19) not null primary key ,
    name varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists doctor
(
    id bigint(19) not null primary key ,
    name varchar(45),
    department varchar(45),
    details varchar(205),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists medical_records
(
    id bigint(19) not null primary key ,
    patient bigint(19),
    department varchar(45),
    doctor bigint(19),
    details varchar(205),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists medicine
(
    id bigint(19) not null primary key ,
    name varchar(45),
    inventory int(8),
    price int(8),
    details varchar(205),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists prescription
(
    id bigint(19) not null primary key ,
    rid bigint(19),
    medicine varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists regd
(
    id bigint(19) not null primary key ,
    department varchar(45),
    doctor varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists patient
(
    id bigint(19) not null primary key ,
    name varchar(45),
    number varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);
