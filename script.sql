CREATE DATABASE entrega_facil;
USE entrega_facil;

-- Criação das tabelas
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(15),
    cpf VARCHAR(11) UNIQUE NOT NULL
);

CREATE TABLE Funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(15),
    cargo VARCHAR(50),
    salario DECIMAL(10, 2),
    dtAdmissao DATE
);

CREATE TABLE Motorista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(15),
    cargo VARCHAR(50),
    salario DECIMAL(10, 2),
    dtAdmissao DATE,
    cnh VARCHAR(20) UNIQUE NOT NULL,
    rota VARCHAR(100),
    disponivel BOOLEAN DEFAULT TRUE
);

CREATE TABLE Veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) UNIQUE NOT NULL,
    modelo VARCHAR(50),
    capacidade DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Carga (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    peso DECIMAL(10, 2) NOT NULL,
    volume DECIMAL(10, 2) NOT NULL,
    emRota BOOLEAN DEFAULT FALSE
);

CREATE TABLE Entrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status text,
    data_saida DATE,
    data_entrega DATE,
    id_cliente INT,
    id_motorista INT,
    id_veiculo INT,
    id_carga INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
    FOREIGN KEY (id_motorista) REFERENCES Motorista(id),
    FOREIGN KEY (id_veiculo) REFERENCES Veiculo(id),
    FOREIGN KEY (id_carga) REFERENCES Carga(id)
);
