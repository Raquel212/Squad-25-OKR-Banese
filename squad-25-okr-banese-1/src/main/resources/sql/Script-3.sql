CREATE TABLE squad_25.Usuario (
    id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    dataCadastro DATE,
    ativo BIT
);
