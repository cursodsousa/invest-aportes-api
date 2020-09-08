create table usuario (
    id bigserial not null primary key ,
    nome varchar(150) not null,
    email varchar(150) not null,
    senha varchar(255) not null
);

create table aporte (
    id bigserial not null primary key ,
    ano int not null,
    mes int not null,
    saldo_anterior numeric(16,2),
    valor numeric(16,2),
    usuarioId bigint references usuario(id)
)