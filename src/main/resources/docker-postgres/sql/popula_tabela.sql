-- Set params

set session teste_banco.qtd_endereco = '300';
set session teste_banco.qtd_cliente = '10000';


-- load the pgcrypto extension to gen_random_uuid ()
CREATE EXTENSION pgcrypto;

-- POPULA ENDEREÇO
INSERT INTO endereco (logradouro, bairro, numero) 
select  
	 concat('logradouro ', id) 
	,concat('bairro ', id)  
	,concat('numero ', id) 
FROM GENERATE_SERIES(1, current_setting('teste_banco.qtd_endereco')::int) as id;


-- POPULA CLIENTE
INSERT INTO cliente (nome, abertura, id_endereco)  
select 
	  concat('CLIENTE ', id)
	, current_date
	, floor(random() * (current_setting('teste_banco.qtd_endereco')::int) + 1)::int
FROM GENERATE_SERIES(1, current_setting('teste_banco.qtd_cliente')::int) as id;
