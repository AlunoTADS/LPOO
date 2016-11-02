--select 'DROP TABLE ' || name || ';' from sqlite_master where type = 'table';
DROP TABLE unidadefederativa;
DROP TABLE cliente;
DROP TABLE estado;
DROP TABLE marca;
DROP TABLE categoria;
DROP TABLE veiculo;
DROP TABLE locacao;
DROP TABLE modelomotocicleta;
DROP TABLE motocicleta;
DROP TABLE modelovan;
DROP TABLE van;
DROP TABLE modeloautomovel;
DROP TABLE automovel;

CREATE TABLE UnidadeFederativa (
	siglaUF CHAR(2) NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT UnidadeFederativa_pk PRIMARY KEY (siglaUF)
);

CREATE TABLE Cliente (
	idCliente INTEGER NOT NULL,
	nome VARCHAR(256) NOT NULL,
	sobrenome VARCHAR(256),
	rg VARCHAR(32),
	rgSiglaUF CHAR(2) NOT NULL,
	cpf VARCHAR(32),
	endereco VARCHAR(256),
	CONSTRAINT Cliente_pk PRIMARY KEY (idCliente),
	FOREIGN KEY (rgSiglaUF) REFERENCES UnidadeFederativa (siglaUF)
);

CREATE TABLE Estado (
	idEstado INTEGER NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT Estado_pk PRIMARY KEY (idEstado)
);

CREATE TABLE Marca (
	idMarca INTEGER NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT Marca_pk PRIMARY KEY (idMarca)
);

CREATE TABLE Categoria (
	idCategoria INTEGER NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT Categoria_pk PRIMARY KEY (idCategoria)
);

CREATE TABLE Veiculo (
	idVeiculo INTEGER NOT NULL,
	idMarca INTEGER NOT NULL,
	idEstado INTEGER NOT NULL,
	idCategoria INTEGER NOT NULL,
	valorCompra NUMERIC NOT NULL,
	placa VARCHAR(32) NOT NULL,
	ano INTEGER NOT NULL,
	CONSTRAINT Veiculo_pk PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idMarca) REFERENCES Marca (idMarca),
	FOREIGN KEY (idEstado) REFERENCES Estado (idEstado),
	FOREIGN KEY (idCategoria) REFERENCES Categoria (idCategoria)
);

CREATE TABLE Locacao (
	idVeiculo INTEGER NOT NULL,
	idCliente INTEGER NOT NULL,
	dataInicio DATE NOT NULL,
	dias INTEGER NOT NULL,
	valor NUMERIC NOT NULL,
	CONSTRAINT Locacao_pk PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente),
	FOREIGN KEY (idVeiculo) REFERENCES Estado (idVeiculo)
);

CREATE TABLE ModeloMotocicleta (
	idModeloMotocicleta INTEGER NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT ModeloMotocicleta_pk PRIMARY KEY (idModeloMotocicleta)
);

CREATE TABLE Motocicleta (
	idVeiculo INTEGER NOT NULL,
	idModeloMotocicleta INTEGER NOT NULL,
	CONSTRAINT Motocicleta_pk PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo (idVeiculo),
	FOREIGN KEY (idModeloMotocicleta) REFERENCES ModeloMotocicleta (idModeloMotocicleta)
);

CREATE TABLE ModeloVan (
	idModeloVan INTEGER NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT ModeloVan_pk PRIMARY KEY (idModeloVan)
);

CREATE TABLE Van (
	idVeiculo INTEGER NOT NULL,
	idModeloVan INTEGER NOT NULL,
	CONSTRAINT Van_pk PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo (idVeiculo),
	FOREIGN KEY (idModeloVan) REFERENCES ModeloVan (idModeloVan)
);

CREATE TABLE ModeloAutomovel (
	idModeloAutomovel INTEGER NOT NULL,
	descricao VARCHAR(256) NOT NULL,
	CONSTRAINT ModeloAutomovel_pk PRIMARY KEY (idModeloAutomovel)
);

CREATE TABLE Automovel (
	idVeiculo INTEGER NOT NULL,
	idModeloAutomovel INTEGER NOT NULL,
	CONSTRAINT Automovel_pk PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo (idVeiculo),
	FOREIGN KEY (idModeloAutomovel) REFERENCES ModeloAutomovel (idModeloAutomovel)
);
