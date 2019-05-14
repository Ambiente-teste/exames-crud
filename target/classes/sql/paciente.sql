CREATE TABLE `paciente` (
  `nome` VARCHAR(255) NOT NULL,
  `idade` INT NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(100) DEFAULT NULL,
  `cpf` VARCHAR(100) NOT NULL,
  `dataNascimento` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cpf`)
);

SELECT * FROM paciente;