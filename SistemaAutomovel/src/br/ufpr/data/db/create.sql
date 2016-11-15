--select 'DROP TABLE ' || name || ';' from sqlite_master where type = 'table';
DROP TABLE Sequence CASCADE;
DROP TABLE UnidadeFederativa CASCADE;
DROP TABLE Cliente CASCADE;
DROP TABLE Estado CASCADE;
DROP TABLE Marca CASCADE;
DROP TABLE Categoria CASCADE;
DROP TABLE Veiculo CASCADE;
DROP TABLE Locacao CASCADE;
DROP TABLE ModeloMotocicleta CASCADE;
DROP TABLE Motocicleta CASCADE;
DROP TABLE ModeloVan CASCADE;
DROP TABLE Van CASCADE;
DROP TABLE ModeloAutomovel CASCADE;
DROP TABLE Automovel CASCADE;

CREATE TABLE Sequence (
    idSequence VARCHAR(64) PRIMARY KEY,
    valor INTEGER DEFAULT 0
);

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
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo (idVeiculo)
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

INSERT INTO Sequence (idSequence)
--SELECT lower('seq_id'||name) FROM sqlite_master WHERE type = 'table';
SELECT 'seq_'||lower(tablename)||'dao' FROM pg_catalog.pg_tables WHERE schemaname = 'public';
