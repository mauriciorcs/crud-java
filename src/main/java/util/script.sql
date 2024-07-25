create database cadastro_bovino;

CREATE TABLE bovinos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigoRegistro VARCHAR(50),
    raca VARCHAR(50),
    sexo ENUM('M', 'F'),
    peso DECIMAL(5, 2),
    data_nascimento DATE
);
