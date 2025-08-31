DROP DATABASE IF EXISTS `DB_Desafio_Full_Stack`;
CREATE DATABASE `DB_Desafio_Full_Stack`;
USE `DB_Desafio_Full_Stack`;



CREATE TABLE fornecedor (
  id INT NOT NULL AUTO_INCREMENT,
  cpf_cnpj VARCHAR(14) UNIQUE NOT NULL,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  rg VARCHAR(15),
  data_nascimento DATE,
  PRIMARY KEY (id)
);

CREATE TABLE empresa (
  id INT NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(14) UNIQUE NOT NULL,
  nome_fantasia VARCHAR(50) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO fornecedor (id, cpf_cnpj, nome, email, cep, rg, data_nascimento)
VALUES
(1, '12345678902', 'Andy', 'Andy@g.com', '10111011', 'AA-11.222.333', STR_TO_DATE('31-08-2000', '%d-%m-%Y')),
(2, '12345678903','Tom', 'Tom@g.com', '20111012', 'AA-22.222.333', STR_TO_DATE('01-03-1995', '%d-%m-%Y')),
(3, '12345678904', 'April', 'April@g.com', '30111013', 'AA-33.222.333', STR_TO_DATE('03-10-1990', '%d-%m-%Y')),
(4, '12345678905', 'Jerry', 'Jerry@g.com', '40111014', 'AA-44.222.333', STR_TO_DATE('11-02-2002', '%d-%m-%Y')),
(5, '12345678906', 'Donna', 'Donna@g.com', '50111015', 'AA-55.222.333', STR_TO_DATE('29-12-2004', '%d-%m-%Y')),
(6, '12345678907', 'Ana', 'Ana@g.com', '60111016', 'AA-66.222.333', STR_TO_DATE('17-10-1984', '%d-%m-%Y')),
(7, '12345678908', 'Chris', 'Chris@g.com', '70111017', 'AA-77.222.333', STR_TO_DATE('07-07-1997', '%d-%m-%Y')),
(8, '12345678901','Leslie', 'Leslie@g.com', '00111010', 'AA-88.222.333', STR_TO_DATE('14-09-2001', '%d-%m-%Y')),
(9, '12345678909', 'Ben', 'Ben@g.com', '80111018', 'AA-99.222.333', STR_TO_DATE('19-11-2002', '%d-%m-%Y')),
(10, '43210987654321', 'Leslie Corp', 'Leslie@Corp.com', '01234560', null, null);


INSERT INTO empresa (id, cnpj, nome_fantasia, cep)
VALUES
(1, '43210987654321', 'Leslie Corp', '01234560'),
(2, '53210987654321', 'Ron Industry', '11234561'),
(3, '63210987654321', 'Tom & Jerry', '21234562'),
(4, '73210987654321', 'Ben 11', '31234563'),
(5, '83210987654321', 'Andy Toys', '41234564'),
(6, '93210987654321', 'a empresa do malvado doofenshmirtz', '51234565');