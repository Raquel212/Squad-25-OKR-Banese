CREATE TABLE squad_25.KeyResult (
    id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idResponsavel INT(10) UNSIGNED,
    tipo VARCHAR(20),
    descricao VARCHAR(300),
    idObjetivo INT(10) UNSIGNED,
    dataCadastro DATE,
    dataConclusao DATE,
    status VARCHAR(20),
    FOREIGN KEY (idResponsavel) REFERENCES Usuario(id),
    FOREIGN KEY (idObjetivo) REFERENCES Objetivo(id)
);
