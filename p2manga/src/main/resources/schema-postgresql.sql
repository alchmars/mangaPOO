CREATE TABLE manga (
    id SERIAL PRIMARY KEY,
    nomeManga VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    descricao TEXT,
    nota DECIMAL(3,1),
    estadomanga VARCHAR(50)
);
