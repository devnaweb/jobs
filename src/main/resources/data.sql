DROP TABLE IF EXISTS job;

CREATE TABLE job (
  id BIGINT PRIMARY KEY,
  occupation VARCHAR(250) NOT NULL,
  company VARCHAR(250) NOT NULL,
  salary DECIMAL NOT NULL,
  is_home_office VARCHAR(250) NOT NULL
);

INSERT INTO job (id, occupation, company, salary, is_home_office) VALUES
  (1111111, 'Engenheiro de Software', 'Amazon', 10000.00, true),
  (1111112, 'Desenvolvedor Backend', 'IBM', 8000.00, true),
  (1111113, 'Estagiário Devops', 'Devnaweb', 800.00, true);