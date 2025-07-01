# Challenge-Forum-Hub

🗣️ Forum Hub API
API REST para um fórum de discussão, com CRUD completo de tópicos e autenticação via Token JWT.

🛠️ Tecnologias
Java 17

Spring Boot 3

Spring Security & JWT

JPA/Hibernate

Maven

MySQL

⚙️ Como Executar
Clone o repositório:

Bash

git clone https://github.com/seu-usuario/forum-hub.git
Configure a Base de Dados:

Crie uma base de dados MySQL chamada forumhub_db.

No ficheiro src/main/resources/application.properties, configure o seu utilizador e senha do MySQL:

Properties

spring.datasource.username=SEU_USUARIO_AQUI
spring.datasource.password=SUA_SENHA_AQUI
Execute a Aplicação:

Bash

mvn spring-boot:run
A API estará disponível em http://localhost:8080.

📖 Endpoints da API
Método

Rota

Descrição

Autenticação?

Corpo (Exemplo)

POST

/login

Obtém um token de autenticação.

Não

{"login": "user@email.com", "senha": "123"}

GET

/topicos

Lista todos os tópicos ativos.

Sim

N/A

POST

/topicos

Cria um novo tópico.

Sim

{"titulo": "...", "mensagem": "...", ...}

GET

/topicos/{id}

Detalha um tópico específico.

Sim

N/A

PUT

/topicos/{id}

Atualiza um tópico.

Sim

{"titulo": "...", "mensagem": "..."} (opcional)

DELETE

/topicos/{id}

Apaga (logicamente) um tópico.

Sim

N/A


Exportar para as Planilhas
(Para aceder aos endpoints que requerem autenticação, envie o token recebido no /login no cabeçalho: Authorization: Bearer <seu_token>).


