CREATE TABLE address (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    rua VARCHAR(100),
    numero VARCHAR(20),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    cep VARCHAR(9),
    client_id TEXT,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
);