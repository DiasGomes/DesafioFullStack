DROP DATABASE IF EXISTS `DB_Desafio_Full_Stack`;
CREATE DATABASE `DB_Desafio_Full_Stack`;
USE `DB_Desafio_Full_Stack`;



CREATE TABLE fornecedor (
  id INT NOT NULL,
  cpf_cnpj VARCHAR(14) UNIQUE NOT NULL,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE empresa (
  id INT NOT NULL,
  cnpj VARCHAR(14) UNIQUE NOT NULL,
  nome_fantasia VARCHAR(50) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO fornecedor (id, cpf_cnpj, nome, email, cep)
VALUES
(0, '12345678901','Leslie', 'Leslie@g.com', '00111010'),
(1, '12345678902', 'Andy', 'Andy@g.com', '10111011'),
(2, '12345678903','Tom', 'Tom@g.com', '20111012'),
(3, '12345678904', 'April', 'April@g.com', '30111013'),
(4, '12345678905', 'Jerry', 'Jerry@g.com', '40111014'),
(5, '12345678906', 'Donna', 'Donna@g.com', '50111015'),
(6, '12345678907', 'Ana', 'Ana@g.com', '60111016'),
(7, '12345678908', 'Chris', 'Chris@g.com', '70111017'),
(8, '12345678909', 'Ben', 'Ben@g.com', '80111018');


INSERT INTO empresa (id, cnpj, nome_fantasia, cep)
VALUES
(1, '43210987654321', 'Leslie Corp', '01234560'),
(2, '53210987654321', 'Ron Industry', '11234561'),
(3, '63210987654321', 'Tom & Jerry', '21234562'),
(4, '73210987654321', 'Ben 11', '31234563'),
(5, '83210987654321', 'Andy Toys', '41234564');