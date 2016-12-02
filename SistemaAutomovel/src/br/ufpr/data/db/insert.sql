INSERT INTO Categoria (idCategoria, descricao) VALUES (1,'POPULAR');
INSERT INTO Categoria (idCategoria, descricao) VALUES (2,'INTERMEDIARIO');
INSERT INTO Categoria (idCategoria, descricao) VALUES (3,'LUXO');

INSERT INTO ESTADO (idEstado, descricao) VALUES (1,'NOVO');
INSERT INTO ESTADO (idEstado, descricao) VALUES (2,'LOCADO');
INSERT INTO ESTADO (idEstado, descricao) VALUES (3,'DISPONIVEL');
INSERT INTO ESTADO (idEstado, descricao) VALUES (4,'VENDIDO');

INSERT INTO Marca (idMarca, descricao) VALUES (1,'VOLKSWAGEN');
INSERT INTO Marca (idMarca, descricao) VALUES (2,'GENERAL MOTORS');
INSERT INTO Marca (idMarca, descricao) VALUES (3,'FIAT');
INSERT INTO Marca (idMarca, descricao) VALUES (4,'HONDA');
INSERT INTO Marca (idMarca, descricao) VALUES (5,'MERCEDEZ');
INSERT INTO Marca (idMarca, descricao) VALUES (6,'VOLVO');
INSERT INTO Marca (idMarca, descricao) VALUES (7,'AUDI');
INSERT INTO Marca (idMarca, descricao) VALUES (8,'FORD');
INSERT INTO Marca (idMarca, descricao) VALUES (9,'KIA');
INSERT INTO Marca (idMarca, descricao) VALUES (10,'TOYOTA');
INSERT INTO Marca (idMarca, descricao) VALUES (11,'LAND ROVER');
INSERT INTO Marca (idMarca, descricao) VALUES (12,'DODGE');
INSERT INTO Marca (idMarca, descricao) VALUES (13,'JAGUAR');
INSERT INTO Marca (idMarca, descricao) VALUES (14,'PORSCHE');

INSERT INTO ModeloAutomovel (idModeloAutomovel, descricao) VALUES (1, 'GOL');
INSERT INTO ModeloAutomovel (idModeloAutomovel, descricao) VALUES(2, 'CELTA');
INSERT INTO ModeloAutomovel (idModeloAutomovel, descricao) VALUES(3, 'PALIO');
INSERT INTO ModeloAutomovel (idModeloAutomovel, descricao) VALUES(4, 'CORSA');

INSERT INTO ModeloMotocicleta(idModeloMotocicleta, descricao) VALUES(1, 'CG 125');
INSERT INTO ModeloMotocicleta(idModeloMotocicleta, descricao) VALUES(2, 'CB 500');
INSERT INTO ModeloMotocicleta(idModeloMotocicleta, descricao) VALUES(3, 'CBR 500');
INSERT INTO ModeloMotocicleta(idModeloMotocicleta, descricao) VALUES (4, 'XTZ 125');

INSERT INTO ModeloVan(idModeloVan, descricao) VALUES (1, 'Kombi');
INSERT INTO ModeloVan(idModeloVan, descricao) VALUES (2, 'Sprinter');
INSERT INTO ModeloVan(idModeloVan, descricao) VALUES (3, 'Besta');
INSERT INTO ModeloVan(idModeloVan, descricao) VALUES (4, 'Doblo');
INSERT INTO ModeloVan(idModeloVan, descricao) VALUES (5, 'Transit');

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

INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('AC', 'Acre');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('AL', 'Alagoas');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('AP', 'Amapá');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('AM', 'Amazonas');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('BA', 'Bahia');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('CE', 'Ceará');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('DF', 'Distrito Federal');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('ES', 'Espírito Santo');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('GO', 'Goiás');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('MA', 'Maranhão');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('MT', 'Mato Grosso');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('MS', 'Mato Grosso do Sul');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('MG', 'Minas Gerais');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('PA', 'Pará');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('PB', 'Paraíba');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('PR', 'Paraná');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('PE', 'Pernambuco');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('PI', 'Piauí');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('RJ', 'Rio de Janeiro');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('RN', 'Rio Grande do Norte');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('RS', 'Rio Grande do Sul');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('RO', 'Rondônia');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('RR', 'Roraima');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('SC', 'Santa Catarina');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('SP', 'São Paulo');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('SE', 'Sergipe');
INSERT INTO UnidadeFederativa (siglaUF, descricao) VALUES ('TO', 'Tocantins');

INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (1, 'Andrea', 'Roberts', '372.486.269-34', '95.753.076-0', 'AC', '95137 Talmadge Road');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (2, 'Lawrence', 'Morrison', '354.274.406-19', '15.966.193-8', 'AL', '8606 Pine View Pass');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (3, 'Kathleen', 'Collins', '583.865.267-40', '49.493.478-7', 'AC', '295 Artisan Parkway');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (4, 'George', 'Warren', '677.286.802-81', '31.996.040-3', 'AL', '9131 Cordelia Parkway');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (5, 'Gregory', 'Ford', '830.112.368-75', '99.756.583-0', 'AP', '86 Comanche Street');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (6, 'Laura', 'Patterson', '630.106.826-25', '82.033.656-9', 'PB', '335 Roxbury Drive');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (7, 'Steve', 'Henderson', '464.771.838-72', '41.456.728-9', 'AC', '2 Park Meadow Lane');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (8, 'Lois', 'Watkins', '186.873.044-42', '00.893.405-7', 'BA', '884 Fulton Junction');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (9, 'Sharon', 'Burns', '856.027.218-64', '02.433.324-7', 'AL', '1 Dovetail Plaza');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (10, 'Douglas', 'Shaw', '989.056.706-32', '77.499.844-4', 'CE', '37272 Ryan Point');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (11, 'Christine', 'Taylor', '724.485.761-53', '94.632.451-9', 'CE', '468 Kenwood Junction');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (12, 'Joyce', 'Hill', '826.377.826-44', '80.769.234-8', 'DF', '3 Mcguire Place');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (13, 'Joseph', 'Warren', '433.981.652-95', '62.646.983-2', 'PB', '521 Autumn Leaf Circle');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (14, 'Mildred', 'Knight', '449.461.137-85', '30.006.991-9', 'PR', '7727 Chinook Crossing');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (15, 'Jeffrey', 'Burton', '352.848.362-32', '50.802.100-2', 'AP', '88574 Dryden Court');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (16, 'Emily', 'Campbell', '381.867.565-28', '35.195.430-6', 'PR', '6 Katie Lane');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (17, 'Bobby', 'Moreno', '333.361.324-36', '19.684.014-9', 'PR', '430 Spohn Drive');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (18, 'Craig', 'Adams', '940.820.239-82', '63.860.633-5', 'SP', '5055 Utah Way');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (19, 'Benjamin', 'Lawson', '031.735.187-23', '14.389.199-9', 'RS', '839 Onsgard Road');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (20, 'Helen', 'West', '074.135.603-48', '31.167.610-3', 'CE', '9 Northwestern Pass');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (21, 'Gregory', 'Shaw', '298.205.178-54', '40.431.288-6', 'SP', '61 Kropf Junction');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (22, 'Margaret', 'Howell', '893.800.929-92', '22.748.305-6', 'SP', '011 Hermina Plaza');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (23, 'Daniel', 'Cruz', '482.540.260-44', '06.296.945-7', 'SP', '6 Evergreen Parkway');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (24, 'Evelyn', 'Lewis', '041.106.137-06', '65.418.576-7', 'AC', '70785 Grasskamp Drive');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (25, 'Marie', 'Ramirez', '446.679.881-97', '53.840.845-8', 'SE', '3068 Main Pass');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (26, 'Denise', 'Hall', '014.763.266-24', '01.614.540-0', 'TO', '17038 Birchwood Park');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (27, 'Willie', 'Simpson', '017.295.478-01', '13.379.247-8', 'TO', '8845 Golf View Road');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (28, 'Carl', 'Harris', '563.270.918-68', '77.690.329-7', 'RS', '40844 Green Ridge Circle');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (29, 'Ryan', 'Brooks', '227.252.631-44', '25.021.258-4', 'RS', '1636 Del Mar Plaza');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (30, 'Brenda', 'Bradley', '436.506.812-33', '00.838.810-0', 'TO', '0 Mcguire Drive');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (31, 'Brenda', 'Ramirez', '086.361.857-87', '42.095.756-1', 'TO', '598 Starling Center');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (32, 'Walter', 'Perez', '027.017.081-46', '64.169.376-4', 'AC', '810 Chive Alley');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (33, 'Christina', 'Duncan', '660.544.559-95', '05.980.246-9', 'AC', '92 Bluestem Alley');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (34, 'Mary', 'Gordon', '202.599.144-75', '14.929.592-9', 'SP', '689 Carpenter Crossing');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (35, 'Phyllis', 'Oliver', '353.547.147-24', '85.029.344-2', 'SP', '34235 Parkside Parkway');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (36, 'Pamela', 'Johnston', '707.775.024-70', '52.209.981-2', 'SP', '4 Morningstar Crossing');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (37, 'Karen', 'Jenkins', '515.106.863-04', '93.430.973-6', 'RS', '5 8th Way');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (38, 'Jessica', 'Kelley', '658.644.106-44', '34.436.836-3', 'SP', '2 Manitowish Pass');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (39, 'Joshua', 'Hawkins', '368.733.615-43', '95.628.681-1', 'RS', '5 Monterey Crossing');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (40, 'Debra', 'Matthews', '395.683.639-46', '65.116.546-2', 'CE', '1 Old Gate Point');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (41, 'Gloria', 'Chapman', '698.216.232-51', '17.838.021-3', 'SP', '8347 Wayridge Center');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (42, 'Benjamin', 'White', '470.461.885-34', '65.725.451-1', 'AC', '6049 Truax Crossing');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (43, 'Keith', 'Holmes', '336.358.553-00', '43.003.679-0', 'AC', '8 Vahlen Trail');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (44, 'Janet', 'Mitchell', '161.350.400-21', '41.298.265-8', 'SP', '19 Elka Street');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (45, 'Kathleen', 'Perez', '265.642.461-76', '85.314.582-3', 'AC', '1087 Linden Place');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (46, 'Martin', 'Hunter', '263.419.661-86', '48.721.774-6', 'AC', '3 Warbler Hill');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (47, 'Rachel', 'Price', '512.722.900-18', '61.321.237-2', 'RS', '31939 Helena Trail');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (48, 'Gloria', 'Kim', '501.892.903-02', '75.542.733-2', 'AL', '7 Lotheville Junction');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (49, 'Kevin', 'Sanchez', '824.195.086-79', '34.541.442-9', 'RS', '53 Lillian Point');
INSERT INTO Cliente (idCliente, nome, sobrenome, cpf, rg, rgSiglaUF, endereco) VALUES (50, 'Willie', 'Garrett', '883.204.722-41', '38.521.297-7', 'SC', '3 Glacier Hill Parkway');

INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (1, 1, 3, 1, 13465, 'AAA-0000', 1991);
INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (2, 2, 3, 2, 82371, 'BBB-1111', 1997);
INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (3, 3, 3, 3, 15065, 'CCC-2222', 1997);
INSERT INTO Motocicleta(idVeiculo, idModeloMotocicleta) VALUES (1, 1);
INSERT INTO Motocicleta(idVeiculo, idModeloMotocicleta) VALUES (2, 2);
INSERT INTO Motocicleta(idVeiculo, idModeloMotocicleta) VALUES (3, 3);


INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (4, 4, 3, 3, 23461, 'DDD-3333', 1991);
INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (5, 5, 3, 2, 12357, 'EEE-4444', 1992);
INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (6, 6, 3, 1, 62845, 'FFF-5555', 1993);
INSERT INTO Automovel(idVeiculo, idModeloAutomovel) VALUES (4, 1);
INSERT INTO Automovel(idVeiculo, idModeloAutomovel) VALUES (5, 2);
INSERT INTO Automovel(idVeiculo, idModeloAutomovel) VALUES (6, 3);

INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (7, 7, 3, 1, 10345, 'GGG-6666', 1994);
INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (8, 8, 3, 2, 15355, 'HHH-7777', 1995);
INSERT INTO Veiculo (idVeiculo, idMarca, idEstado, idCategoria, valorcompra, placa, ano) VALUES (9, 9, 3, 1, 37655, 'III-8888', 1996);
INSERT INTO Van(idVeiculo, idModeloVan) VALUES (7, 1);
INSERT INTO Van(idVeiculo, idModeloVan) VALUES (8, 2);
INSERT INTO Van(idVeiculo, idModeloVan) VALUES (9, 3);

UPDATE Sequence SET valor = (SELECT MAX(idCliente) + 1 FROM Cliente) WHERE idsequence = 'seq_clientedao';
UPDATE Sequence SET valor = (SELECT MAX(idveiculo) + 1 FROM Veiculo) WHERE idsequence = 'seq_veiculodao';
