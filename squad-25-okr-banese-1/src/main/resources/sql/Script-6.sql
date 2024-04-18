CREATE TABLE squad_25.Meta (
    id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idKeyResult INT(10) UNSIGNED,
    dataCadastro DATE,
    status VARCHAR(20),
    dataConclusao DATE,
    descricao VARCHAR(300),
    FOREIGN KEY (idKeyResult) REFERENCES KeyResult(id)
);
