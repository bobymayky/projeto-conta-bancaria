/*create database db2_conta_bancaria; */

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


INSERT INTO cadastro.tb_conta_bancaria(
	 nome, numero, agencia, cheque_especial_liberado, saldo, cheque_especial, taxa)VALUES
('Gabrielly Correia Pereira',636497,1135,false,13425.58,0,2.99),
('Jéssica Sales Reeleito',913986,1135,false,51.92,0,2.99),
('Isnaldo Bulhões' ,366936,1158,true,48.18,2000.00,3.56),
('Flaviano Melo Reeleito',355886,1135,false,9186.15,0,2.99),
('Sérgio Toledo' ,861297,1158,true,156.92,0,2.99),
('Severino Pessoa' ,529569,1299,true,0,5000.00,2.99),
('Tereza Nelma' ,553798,1135,true,185299.84,0,2.4),
('Perpetua Almeida',840940,1136,true,956.98,75.74,2.99),
('Nivaldo Albuquerque' ,400590,1136,true,7188.22,3262.86,2.4),
('Leda Sadala' ,374740,1136,true,6.3,954,3.56),
('Aline Gurgel' ,339124,1135,true,78599.10,0,2.99),
('Jesus Sérgio',113784,1158,true,44.73,200,3.56),
('Camilo Capiberibe' ,109163,1299,false,0,0,2.99),
('Luiz Carlos' ,166831,1299,false,0,0,2.99),
('Marcelo Ramos' ,241442,1136,false,0,0,2.99),
('Manuel Marcos',847499,1136,false,1.89,0,2.99),
('Cibelly Torres',262241,1135,false,831.84,0,2.99),
('Alexandra Souza',194470,1135,false,463.52,0,2.99),
('Michele Pereira da Silva',356320,1135,true,500.86,0,2.99),
('Mara Rocha',970381,1136,false,46,0,2.99),
('Hannah Borges',815669,1158,true,940.93,15.95,2.99),
('Karina Zutter',855045,1136,true,2690.45,0,2.99),
('Abadal Mahmed',632053,1158,true,3596.64,2500.00,2.99),
('Vanda Milani',449302,1136,true,5547.31,2500.00,2.99),
('Cleiton Schiodinni',670283,1136,true,9313.84,0,2.99),
('Marcele Rodriguez',558685,1135,false,3.95,0,2.99),
('Felipi Koller',724264,1299,false,1315.67,0,2.99),
('Alan Rick' ,559925,1299,false,3880.98,0,2.99),
('Brian Lohn',933502,1299,false,2612.98,0,2.99);