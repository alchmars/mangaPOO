CREATE TABLE IF NOT EXISTS manga (
    id SERIAL PRIMARY KEY,
    nomemanga VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    descricao TEXT,
    nota DECIMAL(3,1),
    estadomanga VARCHAR(20),
    urlcapa VARCHAR(500)
);
