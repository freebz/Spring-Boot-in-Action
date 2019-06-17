-- 코드 8-2 Flyway용 데이터베이스 초기화 스크립트(resources/db/migration/V1__initialize.sql)

create table Reader (    // Reader 테이블 생성
    id serial primary key,
    username varchar(25) unique not null,
    password varchar(25) not null,
    fullname varchar(50) not null
);

create table Book (    // Book 테이블 생성
    id serial primary key,
    author varchar(50) not null,
    description varchar(1000) not null,
    isbn varchar(10) not null,
    title varchar(250) not null,
    reader_username varchar(25) not null,
    foreign key (reader_username) references Reader(username)
);

create sequence hibernate_sequence;    // 시퀀스 생성

insert into Reader (username, password, fullname)    // Reader 초깃값
            values ('craig', 'password', 'Craig Walls');
