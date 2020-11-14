drop table if exists leg;

create table leg (
    id bigint not null auto_increment,
    flightFrom varchar(255),
    flightTo varchar(255),
    primary key (id)
) engine=InnoDB;
