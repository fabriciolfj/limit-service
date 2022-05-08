create table limits(
 id int8 not null generated by default as identity,
 account varchar(100) not null,
 rate numeric(15,4) not null,
 withdrawalAmount int not null,
 CONSTRAINT pk_limit primary key (id)
)

create sequence hibernate_sequence