CREATE TABLE cliente (
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    nome 		        VARCHAR(100) NOT NULL,
    cpf 		        VARCHAR(14) NOT NULL,
    email 		        VARCHAR(100) NOT NULL,
    telefone 	        VARCHAR(15) NOT NULL,
    ativo               BOOLEAN NOT NULL
);

CREATE TABLE cartao (
    id       		    INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id 		    INT NOT NULL,
    numero 			    VARCHAR(16) NOT NULL,
    validade 		    VARCHAR(7) NOT NULL,
    cvv 			    VARCHAR(3) NOT NULL,
    limite 			    DECIMAL(10,2) NOT NULL,
    status 			    BOOLEAN NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE compra (
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    cartao_id 			INT NOT NULL,
    valor 				DECIMAL(10,2) NOT NULL,
    data 				DATETIME,
    estabelecimento 	VARCHAR(150) NOT NULL,
    categoria 			VARCHAR(90) NOT NULL,
    FOREIGN KEY (cartao_id) REFERENCES cartao(id)
);