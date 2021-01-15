CREATE DATABASE db_estado
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA schema_estados
    AUTHORIZATION postgres;

    CREATE TABLE schema_estados.estado
(
    id bigint NOT NULL DEFAULT nextval('schema_estados.estado_id_seq'::regclass),
    est_nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT estado_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE schema_estados.estado
    OWNER to postgres;

    CREATE TABLE schema_estados.cidade
(
    id bigint NOT NULL DEFAULT nextval('schema_estados.cidade_id_seq'::regclass),
    cid_nome character varying(255) COLLATE pg_catalog."default",
    cid_populacao integer,
    estado_id bigint,
    CONSTRAINT cidade_pkey PRIMARY KEY (id),
    CONSTRAINT fkkworrwk40xj58kevvh3evi500 FOREIGN KEY (estado_id)
        REFERENCES schema_estados.estado (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE schema_estados.cidade
    OWNER to postgres;

INSERT INTO estado (est_nome) VALUES ('Rio Grande do Sul');
INSERT INTO estado (est_nome) VALUES ('Santa Catarina');
INSERT INTO estado (est_nome) VALUES ('Paraná');

INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (1, 'Porto Alegre', 53000);
INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (1, 'Peloras', 50000);
INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (1, 'Gramado', 78000);

INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (2, 'Joinvile', 9980000);
INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (2, 'Florianópolis', 100000);
INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (2, 'Balneário Camboriú', 278234135);

INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (3, 'Curitiba', 2345324);
INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (3, 'Ponta Grossa', 123123123);
INSERT INTO cidade (estado_id, cid_nome, cid_populacao) VALUES (3, 'Foz do Iguaçu', 1234567789);