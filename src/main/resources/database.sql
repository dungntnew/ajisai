create database if not exists ajisai character set utf8;
create user 'test'@'%' identified by 'test';
grant all on ajisai.* to 'test'@'%';