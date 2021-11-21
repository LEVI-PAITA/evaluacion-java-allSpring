
create table ev_auth_user(
    uuid int not null primary key,
    name varchar(100),
    email varchar(100) not null unique,
    password varchar(100),
    isactive boolean,
    created timestamp,
    modified timestamp,
    last_login timestamp,
    token varchar(500)

);

create table ev_user_info(
    info_id int not null primary key,
    uuid int not null,
    number varchar(30),
    city_code varchar(10),
    country_code varchar(20),
    constraint fk_user_info_id foreign key (uuid) references ev_auth_user (uuid)

);

insert into ev_auth_user(uuid,name,email,password,isactive,created,modified,last_login,token)
values (1,'Levi Paita','lpaita@gmail.com','prueba01',true,'2021-11-18 13:10:11','2021-11-19 13:10:11','2021-11-18 14:10:11',
    'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c');

insert into ev_user_info(info_id,uuid,number,city_code,country_code)
values (1,1,'1234567','1','57')
