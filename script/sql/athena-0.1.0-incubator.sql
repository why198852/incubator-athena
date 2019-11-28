use athena;

drop table if exists user;
create table user (
    id       int(20) auto_increment comment 'primary key, unique id',
    userName varchar(20) comment 'User Name',
    password varchar(120) comment 'login password',
    primary key (id)
)
    default charset 'utf8'
