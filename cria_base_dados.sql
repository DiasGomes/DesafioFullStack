DROP DATABASE IF EXISTS `DB_Desafio_Full_Stack`;
CREATE DATABASE `DB_Desafio_Full_Stack`;
USE `DB_Desafio_Full_Stack`;



CREATE TABLE fornecedor (
  id INT NOT NULL AUTO_INCREMENT,
  cpf_cnpj VARCHAR(18) UNIQUE NOT NULL,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  rg VARCHAR(14),
  data_nascimento DATE,
  PRIMARY KEY (id)
);

CREATE TABLE empresa (
  id INT NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(18) UNIQUE NOT NULL,
  nome_fantasia VARCHAR(50) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE empresa_fornecedor (
  id INT NOT NULL AUTO_INCREMENT,
  id_empresa int NOT NULL,
  id_fornecedor int NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO fornecedor (id, cpf_cnpj, nome, email, cep, rg, data_nascimento)
VALUES
(1, '123.456.789-02', 'Andy', 'Andy@g.com', '10111-011', 'AA-11.222.333', STR_TO_DATE('31-08-2000', '%d-%m-%Y')),
(2, '123.456.789-03','Tom', 'Tom@g.com', '20111-012', 'AA-22.222.333', STR_TO_DATE('01-03-1995', '%d-%m-%Y')),
(3, '123.456.789-04', 'April', 'April@g.com', '30111-013', 'AA-33.222.333', STR_TO_DATE('03-10-1990', '%d-%m-%Y')),
(4, '123.456.789-05', 'Jerry', 'Jerry@g.com', '40111-014', 'AA-44.222.333', STR_TO_DATE('11-02-2002', '%d-%m-%Y')),
(5, '123.456.789-06', 'Donna', 'Donna@g.com', '50111-015', 'AA-55.222.333', STR_TO_DATE('29-12-2004', '%d-%m-%Y')),
(6, '123.456.789-07', 'Ana', 'Ana@g.com', '60111-016', 'AA-66.222.333', STR_TO_DATE('17-10-1984', '%d-%m-%Y')),
(7, '123.456.789-08', 'Chris', 'Chris@g.com', '70111-017', 'AA-77.222.333', STR_TO_DATE('07-07-1997', '%d-%m-%Y')),
(8, '123.456.789-01','Leslie', 'Leslie@g.com', '00111-010', 'AA-88.222.333', STR_TO_DATE('14-09-2001', '%d-%m-%Y')),
(9, '123.456.789-09', 'Ben', 'Ben@g.com', '80111-018', 'AA-99.222.333', STR_TO_DATE('19-11-2002', '%d-%m-%Y')),
(10, '44.440.987/6543-21', 'Leslie Corp', 'Leslie@Corp.com', '01234-560', null, null),
(11, '77.210.987/6543-21', 'Ben 11', 'ben@Corp.com', '31234-563', null, null),
(12, '77.310.987/6543-21', 'Andy Toys', 'buzz@Corp.com', '41234-564', null, null),
(13, '99.210.987/6543-21', 'A Empresa do Malvado Doofenshmirtz', 'perry@Corp.com', '80530-230', null, null),
(14, '99.910.987/6543-21', 'Ronaldo Corp', 'fenomeno@Corp.com', '77234-567', null, null);


INSERT INTO empresa (id, cnpj, nome_fantasia, cep)
VALUES
(1, '44.440.987/6543-21', 'Leslie Corp', '01234-560'),
(2, '44.441.987/6543-21', 'Ron Industry', '11234-561'),
(3, '44.421.098/7654-21', 'Tom & Jerry', '21234-562'),
(4, '77.210.987/6543-21', 'Ben 11', '31234-563'),
(5, '77.310.987/6543-21', 'Andy Toys', '41234-564'),
(6, '99.210.987/6543-21', 'A Empresa do Malvado Doofenshmirtz', '80530-230'),
(7, '99.910.987/6543-21', 'Ronaldo Corp', '77234-567');

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