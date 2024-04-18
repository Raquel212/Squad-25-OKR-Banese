CREATE TABLE squad_25.Medicao (
    id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idKeyResult INT(10) UNSIGNED,
    idMeta INT(10) UNSIGNED,
    dataCadastro DATE,
    dataMedicao DATE,
    descricao VARCHAR(300),
    FOREIGN KEY (idKeyResult) REFERENCES KeyResult(id),
    FOREIGN KEY (idMeta) REFERENCES Meta(id)
);
