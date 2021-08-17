CREATE TABLE IF NOT EXISTS tb_endereco (
    id bigint NOT NULL,
    bairro character varying(255) COLLATE pg_catalog."default",
    cep integer NOT NULL,
    cidade character varying(255) COLLATE pg_catalog."default",
    estado character varying(255) COLLATE pg_catalog."default",
    numero integer NOT NULL,
    rua character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT tb_endereco_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_recursos (
    id bigint NOT NULL,
    n_ambulancia bigint NOT NULL,
    n_enfermeiros bigint NOT NULL,
    n_medicos bigint NOT NULL,
    n_respirador bigint NOT NULL,
    n_tomografo bigint NOT NULL,
    CONSTRAINT tb_recursos_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_hospital (
	id bigint NOT NULL,
    capacidade_atual bigint NOT NULL,
    capacidade_total bigint NOT NULL,
    cnpj character varying(255) COLLATE pg_catalog."default",
    latitude real NOT NULL,
    longitude real NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    endereco_id bigint,
    recursos_id bigint,
    CONSTRAINT tb_hospital_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_recursos_configuracao (
    id bigint NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    pontos bigint NOT NULL,
    CONSTRAINT tb_recursos_configuracao_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_intercambio (
	id bigint NOT NULL,
    hospital_destino bigint NOT NULL,
    hospital_origem bigint NOT NULL,
    recursos_trocados_destino bigint NOT NULL,
    recursos_trocados_origem bigint NOT NULL,
    CONSTRAINT tb_intercambio_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_recursos_trocados (
	id bigint NOT NULL,
	intercambio_destino bigint NOT NULL,
	intercambio_origem bigint NOT NULL,
	CONSTRAINT tb_recursos_trocados_pkey PRIMARY KEY (id)
);

insert into tb_endereco(id, bairro, cep, cidade, estado, numero, rua)
values (1,'Miramar', 84751204, 'João Pessoa', 'PB', 84, 'Rua do Sol'),
	(2,'Bessa', 58047841, 'João Pessoa', 'PB', 468, 'Rua João Cabral de Lucena'),
	(3,'Ipês', 58028860, 'João Pessoa', 'PB', 748, 'Rua 18 de Dezembro'),
	(4,'Bancários', 58051810, 'João Pessoa', 'PB', 152, 'Rua Abelardo Pereira dos Santos'),
	(5,'Portal do Sol', 58046531, 'João Pessoa', 'PB', 526, 'Rua Abel Montenegro Rocha');

insert into tb_recursos(id, n_ambulancia, n_enfermeiros, n_medicos, n_respirador, n_tomografo)
values (1 , 5, 10, 5, 60, 50),
	(2, 4, 14, 6, 70, 40),
	(3, 3, 19, 9, 40, 80),
	(4, 5, 20, 10, 20, 30),
	(5, 4, 10, 9, 10, 20);

insert into tb_hospital(id, capacidade_atual, capacidade_total, cnpj, latitude, longitude, nome, endereco_id, recursos_id) 
values (1, 55, 100, 14137669000134, -76.2561, -71.5324, 'Hospital João Paulo II', 1, 1),
	(2, 30, 100, 29252787000160, -25.5107, 101.4414, 'Hospital de Emergência e Trauma Senador Humberto Lucena', 2, 2),
	(3, 45, 100, 52863246000190, 85.8170, -141.8091, 'Hospital Nossa Senhora das Neves', 3, 3),
	(4, 10, 100, 02572281000182, -64.9618, -111.3439, 'Hospital Memorial São Francisco', 4, 4),
	(5, 40, 100, 95696084000156, -45.4359, -101.9272, 'Hospital Prontovida', 5, 5);	
	
insert into tb_recursos_configuracao(id, nome, pontos)
values(1, 'medico', 3),
	(2, 'enfermeiro', 3),
	(3, 'respirador', 5),
	(4, 'tomografo', 12),
	(5, 'ambulancia', 10);	