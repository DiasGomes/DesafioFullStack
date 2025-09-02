DROP DATABASE IF EXISTS `DB_Desafio_Full_Stack`;
CREATE DATABASE `DB_Desafio_Full_Stack`;
USE `DB_Desafio_Full_Stack`;



CREATE TABLE fornecedor (
  id INT NOT NULL AUTO_INCREMENT,
  cpf_cnpj VARCHAR(15) UNIQUE NOT NULL,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  rg VARCHAR(15),
  data_nascimento DATE,
  PRIMARY KEY (id)
);

CREATE TABLE empresa (
  id INT NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(15) UNIQUE NOT NULL,
  nome_fantasia VARCHAR(50) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE empresa_fornecedor (
  id INT NOT NULL AUTO_INCREMENT,
  id_empresa VARCHAR(15) NOT NULL,
  id_fornecedor VARCHAR(15) NOT NULL,
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
(10, '44440987654321', 'Leslie Corp', 'Leslie@Corp.com', '01234560', null, null),
(11, '77210987654321', 'Ben 11', 'ben@Corp.com', '31234563', null, null),
(12, '77310987654321', 'Andy Toys', 'buzz@Corp.com', '41234564', null, null),
(13, '99210987654321', 'A empresa do malvado doofenshmirtz', 'perry@Corp.com', '51234565', null, null),
(14, '99910987654321', 'Ronaldo Corp', 'fenomeno@Corp.com', '77234567', null, null);


INSERT INTO empresa (id, cnpj, nome_fantasia, cep)
VALUES
(1, '44440987654321', 'Leslie Corp', '01234560'),
(2, '44441987654321', 'Ron Industry', '11234561'),
(3, '444210987654321', 'Tom & Jerry', '21234562'),
(4, '77210987654321', 'Ben 11', '31234563'),
(5, '77310987654321', 'Andy Toys', '41234564'),
(6, '99210987654321', 'A empresa do malvado doofenshmirtz', '51234565'),
(7, '99910987654321', 'Ronaldo Corp', '77234567');

INSERT INTO empresa_fornecedor (id, id_empresa, id_fornecedor)
VALUES
(1, 1, 14),
(2, 1, 13),
(3, 1, 8),
(4, 2, 7),
(5, 2, 6),
(6, 3, 3),
(7, 3, 1),
(8, 3, 13),
(9, 4, 2),
(10, 4, 14),
(11, 4, 4),
(12, 5, 9),
(13, 5, 11),
(14, 5, 13),
(15, 6, 3),
(16, 6, 7),
(17, 6, 10),
(18, 7, 2),
(19, 7, 7),
(20, 7, 12);