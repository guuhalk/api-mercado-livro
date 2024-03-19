-- Criar o banco de dados 
create database db_mercadolivro;

-- Criar tabela de customer

create table customer(
	id int auto_increment primary key,
    name varchar(255) not null, 
    email varchar(255) not null unique
);

