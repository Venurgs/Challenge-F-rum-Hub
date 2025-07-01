# Challenge-Forum-Hub

🗣️ Forum Hub API
API REST para um fórum de discussão. A API permite a gestão completa de tópicos, incluindo criação, listagem, detalhamento, atualização e exclusão, com um sistema de autenticação seguro baseado em Tokens JWT.

✨ Funcionalidades Principais
Autenticação e Autorização: Sistema de segurança com Token JWT para proteger os endpoints.

CRUD de Tópicos: Operações completas de CREATE, READ, UPDATE e DELETE para os tópicos do fórum.

Validações: Regras de negócio para garantir a integridade dos dados (ex: não permitir tópicos duplicados).

Paginação e Ordenação: A listagem de tópicos é paginada e pode ser ordenada para uma melhor performance e experiência de uso.

Exclusão Lógica: Os registos não são apagados fisicamente da base de dados, apenas marcados como inativos.

🛠️ Tecnologias Utilizadas
Java 17

Spring Boot 3

Spring Web: para a construção de endpoints REST.

Spring Security: para a implementação da segurança e autenticação.

Spring Data JPA: para a persistência de dados.

Maven: como gestor de dependências.

MySQL: como base de dados relacional.

Lombok: para reduzir o código boilerplate.

JWT (JSON Web Token): para a geração de tokens de autenticação.

⚙️ Configuração e Instalação
Pré-requisitos:

Java 17 (ou superior)

Maven 3.8 (ou superior)

MySQL Server

Passos:

Clonar o repositório:

Bash

git clone https://github.com/seu-usuario/f-rum-hub.git
Configurar a Base de Dados:

Cria uma base de dados no teu MySQL com o nome forumhub_db.

Abre o ficheiro src/main/resources/application.properties.

Altera as seguintes propriedades com as tuas credenciais do MySQL:

Properties

spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
Executar a Aplicação:

Podes executar a aplicação diretamente pela tua IDE (IntelliJ) ou compilando com o Maven:

Bash

mvn spring-boot:run
A API estará disponível em http://localhost:8080.

📖 Documentação da API
Autenticação
POST /login
Gera um token de autenticação para um utilizador. Este token deve ser enviado no cabeçalho Authorization de todas as requisições para endpoints protegidos.

Corpo da Requisição (Request Body):

JSON

{
    "login": "ana.silva@example.com",
    "senha": "123456"
}
Resposta de Sucesso (200 OK):

JSON

{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
Tópicos
Endpoints para a gestão de tópicos. Todos requerem autenticação.

POST /topicos
Cria um novo tópico.

Cabeçalho: Authorization: Bearer <seu_token_jwt>

Corpo da Requisição:

JSON

{
    "titulo": "Dúvida sobre a anotação @RestController",
    "mensagem": "Qual a diferença entre @Controller e @RestController?",
    "autor": "José",
    "curso": "Spring Boot"
}
Resposta de Sucesso (201 Created): Retorna os dados do tópico recém-criado.

GET /topicos
Lista todos os tópicos ativos. Suporta paginação e ordenação.

Cabeçalho: Authorization: Bearer <seu_token_jwt>

Parâmetros de URL (opcionais):

size: número de itens por página (ex: ?size=5)

page: número da página (começa em 0, ex: &page=1)

sort: campo e direção da ordenação (ex: &sort=titulo,desc)

Resposta de Sucesso (200 OK): Retorna um objeto de página com a lista de tópicos.

GET /topicos/{id}
Detalha um tópico específico pelo seu ID.

Cabeçalho: Authorization: Bearer <seu_token_jwt>

Resposta de Sucesso (200 OK): Retorna os dados completos do tópico.

PUT /topicos/{id}
Atualiza os dados de um tópico existente. Os campos no corpo são opcionais.

Cabeçalho: Authorization: Bearer <seu_token_jwt>

Corpo da Requisição:

JSON

{
    "titulo": "Título atualizado",
    "mensagem": "Mensagem atualizada"
}
Resposta de Sucesso (200 OK): Retorna os dados completos do tópico atualizado.

DELETE /topicos/{id}
Realiza a exclusão lógica de um tópico.

Cabeçalho: Authorization: Bearer <seu_token_jwt>

Resposta de Sucesso (204 No Content): Não retorna conteúdo no corpo.
