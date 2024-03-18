CREATE TABLE Cliente (
    ClienteID 	INT AUTO_INCREMENT PRIMARY KEY,
    Nome 		VARCHAR(100),
    CPF 		VARCHAR(11),
    Email 		VARCHAR(100),
    Telefone 	VARCHAR(11),
    Endereco 	VARCHAR(100)
);

CREATE TABLE Cartao (
    CartaoID 		INT AUTO_INCREMENT PRIMARY KEY,
    ClienteID 		INT,
    Numero 			VARCHAR(16),
    Validade 		VARCHAR(7),
    CVV 			VARCHAR(3),
    Limite 			DECIMAL(10,2),
    Status 			BOOLEAN not null,
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID)
);

CREATE TABLE Compra (
    CompraID 	INT AUTO_INCREMENT PRIMARY KEY,
    CartaoID 			INT,
    Valor 				DECIMAL(10,2),
    Data 				DATETIME,
    Estabelecimento 	VARCHAR(150),
    Categoria 			VARCHAR(90),
    FOREIGN KEY (CartaoID) REFERENCES Cartao(CartaoID)
);