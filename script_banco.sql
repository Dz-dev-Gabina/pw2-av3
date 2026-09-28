create database pw2_av3;
use pw2_av3;

create table exercicio_fisico (
	id bigint identity(1,1) not null,
	nome varchar(100) not null,
	grupo_muscular varchar(50) not null,
	imagem varchar(255) null,
	descricao varchar(1000) null,
	numero_series int not null,
	numero_repeticoes int not null,
	carga_sugerida decimal(6,2) not null,
	nivel_dificuldade varchar(10) not null,
	constraint pk_exercicio_fisico primary key (id),
	constraint ck_series check (numero_series > 0),
	constraint ck_repeticoes check (numero_repeticoes > 0),
	constraint ck_carga check (carga_sugerida >= 0),
	constraint ck_nivel check (nivel_dificuldade in ('FACIL', 'MEDIO', 'DIFICIL'))
);

insert into exercicio_fisico 
	(nome, grupo_muscular, imagem, descricao, numero_series, numero_repeticoes, carga_sugerida, nivel_dificuldade) 
values
	('Supino', 'Peitoral', 'supino.jpg', 'Deitado no banco, empurre a barra para cima até estender os braços e depois desça de forma controlada até o peito. Fortalece peitoral, ombros e tríceps.', 3, 15, 70.00, 'DIFICIL');

alter table exercicio_fisico drop constraint ck_carga;

alter table exercicio_fisico alter column carga_sugerida float not null;

alter table exercicio_fisico add constraint ck_carga check (carga_sugerida >= 0);
