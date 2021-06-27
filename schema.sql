CREATE schema ditinterview_db;
use ditinterview_db;

CREATE TABLE users
(
	id integer not null auto_increment,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    user_name varchar(20) not null,
    user_password varchar(20) not null,
    last_login_time datetime not null DEFAULT current_timestamp,
    primary key(id),
    constraint uniq_username unique(user_name)
);

select * from users;

DELETE FROM users;


-- DROP TABLE users;

INSERT INTO users(first_name,last_name,user_name,user_password)
values("Kunal","Sukhwani","ksukhwani","demo@1234");
