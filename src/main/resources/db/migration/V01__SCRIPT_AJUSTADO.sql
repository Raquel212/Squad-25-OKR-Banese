CREATE DATABASE IF NOT EXISTS squad_25;

CREATE TABLE squad_25.Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    dataCadastro DATE,
    ativo BIT
);

CREATE TABLE squad_25.Responsavel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(300),
    CONSTRAINT FK_Usuario FOREIGN KEY (id) REFERENCES squad_25.Usuario(id)
);

CREATE TABLE squad_25.Objetivo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20),
    dataCadastro DATE,
    dataPrevisao DATE,
    dataConclusao DATE,
    descricao VARCHAR(300)
);

CREATE TABLE squad_25.KeyResult (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idResponsavel INT,
    tipo VARCHAR(20),
    descricao VARCHAR(300),
    idObjetivo INT,
    dataCadastro DATE,
    dataConclusao DATE,
    status VARCHAR(20),
    FOREIGN KEY (idResponsavel) REFERENCES squad_25.Usuario(id),
    FOREIGN KEY (idObjetivo) REFERENCES squad_25.Objetivo(id)
);

CREATE TABLE squad_25.Meta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idKeyResult INT,
    dataCadastro DATE,
    status VARCHAR(20),
    dataConclusao DATE,
    descricao VARCHAR(300),
    FOREIGN KEY (idKeyResult) REFERENCES squad_25.KeyResult(id)
);

CREATE TABLE squad_25.Atividade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idKeyResult INT,
    dataCadastro DATE,
    status VARCHAR(20),
    dataConclusao DATE,
    descricao VARCHAR(300),
    FOREIGN KEY (idKeyResult) REFERENCES squad_25.KeyResult(id)
);

CREATE TABLE squad_25.Medicao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idKeyResult INT,
    idMeta INT,
    dataCadastro DATE,
    dataMedicao DATE,
    descricao VARCHAR(300),
    FOREIGN KEY (idKeyResult) REFERENCES squad_25.KeyResult(id),
    FOREIGN KEY (idMeta) REFERENCES squad_25.Meta(id)
);
