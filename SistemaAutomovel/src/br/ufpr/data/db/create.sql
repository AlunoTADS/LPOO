--select 'DROP TABLE ' || name || ';' from sqlite_master where type = 'table';
DROP TABLE Sequence;
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
--SELECT 'seq_'||lower(name)||'dao' FROM sqlite_master WHERE type = 'table';
SELECT 'seq_'||lower(tablename)||'dao' FROM pg_catalog.pg_tables WHERE schemaname = 'public';
--gera reorder sequences...
/*SELECT 
    'UPDATE Sequence SET valor = (SELECT MAX(id'||lower(tablename)
    ||' FROM '||lower(tablename)
    ||' WHERE idsequence = ''seq_'||lower(tablename)||'dao'''
FROM 
    pg_catalog.pg_tables 
WHERE schemaname = 'public';
*/
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('AC', 'Acre');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('AL', 'Alagoas');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('AP', 'Amapá');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('AM', 'Amazonas');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('BA', 'Bahia');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('CE', 'Ceará');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('DF', 'Distrito Federal');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('ES', 'Espírito Santo');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('GO', 'Goiás');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('MA', 'Maranhão');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('MT', 'Mato Grosso');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('MS', 'Mato Grosso do Sul');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('MG', 'Minas Gerais');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('PA', 'Pará');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('PB', 'Paraíba');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('PR', 'Paraná');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('PE', 'Pernambuco');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('PI', 'Piauí');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('RJ', 'Rio de Janeiro');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('RN', 'Rio Grande do Norte');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('RS', 'Rio Grande do Sul');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('RO', 'Rondônia');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('RR', 'Roraima');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('SC', 'Santa Catarina');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('SP', 'São Paulo');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('SE', 'Sergipe');
INSERT INTO unidadefederativa (siglauf, descricao) VALUES ('TO', 'Tocantins');

insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (1, 'Andrea', 'Roberts', '372.486.269-34', '95.753.076-0', 'AC', '95137 Talmadge Road');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (2, 'Lawrence', 'Morrison', '354.274.406-19', '15.966.193-8', 'AL', '8606 Pine View Pass');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (3, 'Kathleen', 'Collins', '583.865.267-40', '49.493.478-7', 'AC', '295 Artisan Parkway');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (4, 'George', 'Warren', '677.286.802-81', '31.996.040-3', 'AL', '9131 Cordelia Parkway');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (5, 'Gregory', 'Ford', '830.112.368-75', '99.756.583-0', 'AP', '86 Comanche Street');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (6, 'Laura', 'Patterson', '630.106.826-25', '82.033.656-9', 'PB', '335 Roxbury Drive');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (7, 'Steve', 'Henderson', '464.771.838-72', '41.456.728-9', 'AC', '2 Park Meadow Lane');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (8, 'Lois', 'Watkins', '186.873.044-42', '00.893.405-7', 'BA', '884 Fulton Junction');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (9, 'Sharon', 'Burns', '856.027.218-64', '02.433.324-7', 'AL', '1 Dovetail Plaza');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (10, 'Douglas', 'Shaw', '989.056.706-32', '77.499.844-4', 'CE', '37272 Ryan Point');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (11, 'Christine', 'Taylor', '724.485.761-53', '94.632.451-9', 'CE', '468 Kenwood Junction');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (12, 'Joyce', 'Hill', '826.377.826-44', '80.769.234-8', 'DF', '3 Mcguire Place');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (13, 'Joseph', 'Warren', '433.981.652-95', '62.646.983-2', 'PB', '521 Autumn Leaf Circle');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (14, 'Mildred', 'Knight', '449.461.137-85', '30.006.991-9', 'PR', '7727 Chinook Crossing');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (15, 'Jeffrey', 'Burton', '352.848.362-32', '50.802.100-2', 'AP', '88574 Dryden Court');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (16, 'Emily', 'Campbell', '381.867.565-28', '35.195.430-6', 'PR', '6 Katie Lane');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (17, 'Bobby', 'Moreno', '333.361.324-36', '19.684.014-9', 'PR', '430 Spohn Drive');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (18, 'Craig', 'Adams', '940.820.239-82', '63.860.633-5', 'SP', '5055 Utah Way');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (19, 'Benjamin', 'Lawson', '031.735.187-23', '14.389.199-9', 'RS', '839 Onsgard Road');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (20, 'Helen', 'West', '074.135.603-48', '31.167.610-3', 'CE', '9 Northwestern Pass');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (21, 'Gregory', 'Shaw', '298.205.178-54', '40.431.288-6', 'SP', '61 Kropf Junction');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (22, 'Margaret', 'Howell', '893.800.929-92', '22.748.305-6', 'SP', '011 Hermina Plaza');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (23, 'Daniel', 'Cruz', '482.540.260-44', '06.296.945-7', 'SP', '6 Evergreen Parkway');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (24, 'Evelyn', 'Lewis', '041.106.137-06', '65.418.576-7', 'AC', '70785 Grasskamp Drive');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (25, 'Marie', 'Ramirez', '446.679.881-97', '53.840.845-8', 'SE', '3068 Main Pass');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (26, 'Denise', 'Hall', '014.763.266-24', '01.614.540-0', 'TO', '17038 Birchwood Park');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (27, 'Willie', 'Simpson', '017.295.478-01', '13.379.247-8', 'TO', '8845 Golf View Road');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (28, 'Carl', 'Harris', '563.270.918-68', '77.690.329-7', 'RS', '40844 Green Ridge Circle');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (29, 'Ryan', 'Brooks', '227.252.631-44', '25.021.258-4', 'RS', '1636 Del Mar Plaza');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (30, 'Brenda', 'Bradley', '436.506.812-33', '00.838.810-0', 'TO', '0 Mcguire Drive');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (31, 'Brenda', 'Ramirez', '086.361.857-87', '42.095.756-1', 'TO', '598 Starling Center');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (32, 'Walter', 'Perez', '027.017.081-46', '64.169.376-4', 'AC', '810 Chive Alley');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (33, 'Christina', 'Duncan', '660.544.559-95', '05.980.246-9', 'AC', '92 Bluestem Alley');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (34, 'Mary', 'Gordon', '202.599.144-75', '14.929.592-9', 'SP', '689 Carpenter Crossing');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (35, 'Phyllis', 'Oliver', '353.547.147-24', '85.029.344-2', 'SP', '34235 Parkside Parkway');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (36, 'Pamela', 'Johnston', '707.775.024-70', '52.209.981-2', 'SP', '4 Morningstar Crossing');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (37, 'Karen', 'Jenkins', '515.106.863-04', '93.430.973-6', 'RS', '5 8th Way');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (38, 'Jessica', 'Kelley', '658.644.106-44', '34.436.836-3', 'SP', '2 Manitowish Pass');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (39, 'Joshua', 'Hawkins', '368.733.615-43', '95.628.681-1', 'RS', '5 Monterey Crossing');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (40, 'Debra', 'Matthews', '395.683.639-46', '65.116.546-2', 'CE', '1 Old Gate Point');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (41, 'Gloria', 'Chapman', '698.216.232-51', '17.838.021-3', 'SP', '8347 Wayridge Center');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (42, 'Benjamin', 'White', '470.461.885-34', '65.725.451-1', 'AC', '6049 Truax Crossing');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (43, 'Keith', 'Holmes', '336.358.553-00', '43.003.679-0', 'AC', '8 Vahlen Trail');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (44, 'Janet', 'Mitchell', '161.350.400-21', '41.298.265-8', 'SP', '19 Elka Street');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (45, 'Kathleen', 'Perez', '265.642.461-76', '85.314.582-3', 'AC', '1087 Linden Place');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (46, 'Martin', 'Hunter', '263.419.661-86', '48.721.774-6', 'AC', '3 Warbler Hill');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (47, 'Rachel', 'Price', '512.722.900-18', '61.321.237-2', 'RS', '31939 Helena Trail');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (48, 'Gloria', 'Kim', '501.892.903-02', '75.542.733-2', 'AL', '7 Lotheville Junction');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (49, 'Kevin', 'Sanchez', '824.195.086-79', '34.541.442-9', 'RS', '53 Lillian Point');
insert into cliente (idcliente, nome, sobrenome, cpf, rg, rgsiglauf, endereco) values (50, 'Willie', 'Garrett', '883.204.722-41', '38.521.297-7', 'SC', '3 Glacier Hill Parkway');


UPDATE Sequence SET valor = (SELECT MAX(idcliente) + 1 FROM cliente) WHERE idsequence = 'seq_clientedao';
UPDATE Sequence SET valor = (SELECT MAX(idveiculo) + 1 FROM veiculo) WHERE idsequence = 'seq_veiculodao';
