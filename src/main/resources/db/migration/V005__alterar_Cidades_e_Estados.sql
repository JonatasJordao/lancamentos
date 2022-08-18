ALTER TABLE pessoa DROP COLUMN cidade;

ALTER TABLE pessoa DROP COLUMN estado;

ALTER TABLE pessoa ADD COLUMN codigo_cidade BIGINT(20);

ALTER TABLE pessoa ADD CONSTRAINT fk_pessoa_cidade FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo);



UPDATE pessoa SET codigo_cidade = 2;