create database db_conta_bancaria;

create schema cadastro;

CREATE TABLE cadastro.tb_conta_bancaria (
id  serial not null,
nome varchar(250),
numero integer,
agencia integer,
cheque_especial_liberado boolean NOT NULL DEFAULT false, 
saldo numeric(13,2),
cheque_especial numeric(13,2),
taxa numeric(13,2));