drop database if exists dbfutebolmanager;
create database dbfutebolmanager;

use dbfutebolmanager;
    
create table jogador(
    idJogador int not null auto_increment primary key,
    login varchar(50),
    pass varchar(50),
    nomeJogador varchar(255),
    dtNascimento date,
    endereco varchar(255),
    cpf int ,
    rg int ,
    posicao varchar(255),
    email varchar(255)
	
);

create table image(
    idimage int not null auto_increment primary key,
    nome varchar(100),
    descricao varchar(255),
    tamanho varchar(255),
    caminho varchar(255)
    
);

create table telefone(
    idTelefone int not null auto_increment primary key,
    numeroTelefone int
);



insert into useradmin(`name`, login, pass) values ("Marcelo","Marcelosoad","teobmx");
insert into useradmin(`name`, login, pass) values ("Marcelo 2","Marcelobuf1","teobmx");
insert into useradmin(`name`, login, pass) values ("Marcelo 3","Marcelobuf2","teobmx");
insert into useradmin(`name`, login, pass) values ("Marcelo 4","Marcelobuf3","teobmx");

select * from `useradmin` where login = "marcelosoad" and pass = "teobmx";