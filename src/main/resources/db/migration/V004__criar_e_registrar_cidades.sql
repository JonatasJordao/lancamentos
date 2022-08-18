CREATE TABLE cidade (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
codigo_estado BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_estado) REFERENCES estado(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (1, 'Belo Horizonte', 11);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (2, 'Uberlândia', 11);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (3, 'Uberaba', 11);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (4, 'São Paulo', 26);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (5, 'Campinas', 26);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (6, 'Rio de Janeiro', 19);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (7, 'Angra dos Reis', 19);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (8, 'Goiânia', 9);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (9, 'Caldas Novas', 9);