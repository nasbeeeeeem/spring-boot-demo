drop table if exists item;

create table item (
  id integer not null AUTO_INCREMENT,
  item_name varchar(20),
  primary key(id)
);