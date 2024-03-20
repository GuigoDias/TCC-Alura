CREATE TABLE cliente (
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    nome 		        VARCHAR(100),
    cpf 		        VARCHAR(14),
    email 		        VARCHAR(100),
    telefone 	        VARCHAR(15),
    ativo               BOOLEAN DEFAULT TRUE
);

CREATE TABLE cartao (
    id       		    INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id 		    INT,
    numero 			    VARCHAR(16),
    validade 		    VARCHAR(7),
    cvv 			    VARCHAR(3),
    limite 			    DECIMAL(10,2),
    status 			    BOOLEAN not null,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE compra (
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    cartao_id 			INT,
    valor 				DECIMAL(10,2),
    data 				DATETIME,
    estabelecimento 	VARCHAR(150),
    categoria 			VARCHAR(90),
    FOREIGN KEY (cartao_id) REFERENCES cartao(id)
);