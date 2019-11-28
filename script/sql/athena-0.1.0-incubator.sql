use athena;

drop table if exists user;
create table user (
    id       int(20) auto_increment comment 'primary key, unique id',
    userName varchar(20) comment 'User Name',
    password varchar(120) comment 'login password',
    primary key (id)
)
    default charset 'utf8';

drop table if exists appmeta;
create table appmeta (
    id          int(20) auto_increment comment 'primary key, unique id',
    name        varchar(100) not null comment 'name, unique',
    code        varchar(100) not null comment 'generate code',
    active      boolean               default true comment 'active status',
    token       varchar(100) not null comment 'token unique, generate by name+code+now()',
    displayName varchar(100) not null comment 'displayName, unique',
    deadTime    timestamp    not null comment 'dead time',
    createTime  timestamp    not null default current_timestamp comment 'create time',
    modifyTime  timestamp    not null default current_timestamp on update current_timestamp comment 'last modfiy time',
    deleted     boolean               default false comment 'delete status',
    locked      boolean               default false comment 'lock status',
    userId      int(20)      not null comment 'user table primary key',
    primary key (id)
)
    default charset 'utf8';
