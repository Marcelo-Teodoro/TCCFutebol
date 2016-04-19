drop database if exists dbfutebolmanager;
create database dbfutebolmanager;

use dbfutebolmanager;

create table useradmin(
	iduseradmin int not null auto_increment primary key,
    `name` varchar(100),
    login varchar(50),
    pass varchar(50)
    );
    
create table jogador(
	idJogador int not null auto_increment primary key,
    iduseradmin int not null,
    nomeJogador varchar(255),
    dtNascimento date,
    endereco varchar(255),
    cpf int ,
    rg int ,
    posicao varchar(255),
    email varchar(255)
	
);

create table Team(
	idTeam int not null auto_increment primary key,
    iduseradmin int not null,
    teamName varchar(255),
    endereco varchar(255),
    cnpj int ,
    foundationDate date,
    president varchar(255),
    email varchar(255) ,
		
	CONSTRAINT FK_TEAM_USERADMIN FOREIGN KEY (IDUSERADMIN) REFERENCES USERADMIN(IDUSERADMIN)
);

create table image(
	idimage int not null auto_increment primary key,
    iduseradmin int not null,
    idjogador int not null,
    idteam int not null,
    nome varchar(100),
    descricao varchar(255),
    tamanho varchar(255),
    caminho varchar(255),
	
	CONSTRAINT FK_IMAGE_USERADMIN FOREIGN KEY (IDUSERADMIN) REFERENCES USERADMIN(IDUSERADMIN),
	
	CONSTRAINT FK_IMAGE_JOGADOR FOREIGN KEY (IDJOGADOR) REFERENCES JOGADOR(IDJOGADOR),
		
	CONSTRAINT FK_IMAGE_TEAM FOREIGN KEY (IDTEAM) REFERENCES TEAM(IDTEAM)
    
);

create table telefone(
	idTelefone int not null auto_increment primary key,
    iduseradmin int not null,
    idjogador int not null,
    numeroTelefone int,
	
	CONSTRAINT FK_TELEFONE_USERADMIN FOREIGN KEY (IDUSERADMIN) REFERENCES USERADMIN(IDUSERADMIN),
	
	CONSTRAINT FK_TELEFONE_JOGADOR FOREIGN KEY (IDJOGADOR) REFERENCES JOGADOR(IDJOGADOR)
);



insert into useradmin(`name`, login, pass) values ("Marcelo","Marcelosoad","teobmx");
insert into useradmin(`name`, login, pass) values ("Marcelo 2","Marcelobuf1","teobmx");
insert into useradmin(`name`, login, pass) values ("Marcelo 3","Marcelobuf2","teobmx");
insert into useradmin(`name`, login, pass) values ("Marcelo 4","Marcelobuf3","teobmx");

select * from `useradmin` where login = "marcelosoad" and pass = "teobmx";