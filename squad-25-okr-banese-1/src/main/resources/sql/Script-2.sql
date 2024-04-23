CREATE TABLE squad_25.Usuario (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    dataCadastro DATE,
    ativo BIT
);

CREATE TABLE squad_25.Responsavel (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(300),
    CONSTRAINT FK_Usuario FOREIGN KEY (id) REFERENCES Usuario(id)
);
