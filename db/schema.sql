CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE categoria(
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE autor(
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(50)
);

CREATE TABLE livro(
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    ano_publicacao INT,
    id_categoria INT NOT NULL,

    FOREIGN KEY(id_categoria)
    REFERENCES categoria(id_categoria)
);

CREATE TABLE usuario(
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20)
);

CREATE TABLE emprestimo(
    id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,

    id_usuario INT NOT NULL,
    id_livro INT NOT NULL,

    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,

    status VARCHAR(20) NOT NULL,

    FOREIGN KEY(id_usuario)
    REFERENCES usuario(id_usuario),

    FOREIGN KEY(id_livro)
    REFERENCES livro(id_livro),

    CHECK(status IN ('EMPRESTADO','DEVOLVIDO'))
);

CREATE TABLE livro_autor(

    id_livro INT,
    id_autor INT,

    PRIMARY KEY(id_livro,id_autor),

    FOREIGN KEY(id_livro)
    REFERENCES livro(id_livro),

    FOREIGN KEY(id_autor)
    REFERENCES autor(id_autor)
);