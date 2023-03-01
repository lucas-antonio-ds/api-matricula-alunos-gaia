create table alunos(

    id serial not null,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    idade varchar(6) not null,
    telefone varchar(20) not null,
    curso varchar(100) not null,
    rua varchar(100) not null,
    numero varchar(20),
    bairro varchar(100) not null,
    cep varchar(9) not null,
    cidade varchar(100) not null,
    uf char(2) not null,
    complemento varchar(100),
 

    primary key(id)

);