# Challenge-Forum-Hub

# 🗣️ Forum Hub API

![Status do Projeto](https://img.shields.io/badge/status-concluído-green)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)

API REST para um fórum de discussão. A API gerencia tópicos e utiliza autenticação segura com Tokens JWT.

---
## ✨ Funcionalidades

-   **Autenticação e Autorização** com Token JWT.
-   **CRUD Completo** para Tópicos (Criar, Ler, Atualizar, Apagar).
-   **Validações de Negócio** para garantir a integridade dos dados.
-   **Paginação e Ordenação** na listagem de tópicos.
-   **Exclusão Lógica** para manter o histórico dos dados.

---
## 🚀 Tecnologias Utilizadas

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Security**
-   **Spring Data JPA** & **Hibernate**
-   **Maven**
-   **MySQL**
-   **Lombok**

---
## ▶️ Como Executar o Projeto

### Pré-requisitos

-   Java 17 ou superior
-   Maven 3.8 ou superior
-   MySQL Server

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/forum-hub.git](https://github.com/seu-usuario/forum-hub.git)
    cd forum-hub
    ```

2.  **Configure a Base de Dados:**
    -   Crie uma base de dados no MySQL: `CREATE DATABASE forumhub_db;`
    -   Abra o ficheiro `src/main/resources/application.properties` e insira as suas credenciais do MySQL:
        ```properties
        spring.datasource.username=SEU_USUARIO_AQUI
        spring.datasource.password=SUA_SENHA_AQUI
        ```

3.  **Crie o Utilizador de Teste:**
    -   Para fazer login, execute o seguinte comando SQL na sua base de dados `forumhub_db`:
        ```sql
        INSERT INTO usuarios(login, senha) VALUES('ana.silva@example.com', '$2a$10$3g.M3/SEi408W.x26A/C4OOKo8t/IgoLzk99GmL1ein4dCmt8qYAy');
        ```
    -   A senha para este utilizador é `123456`.

4.  **Execute a Aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

---
## 📖 Endpoints da API

*Todos os endpoints, exceto `/login`, requerem um Token JWT no cabeçalho `Authorization: Bearer <seu_token>`.*

| Método | Rota               | Descrição                    |
| :----- | :----------------- | :--------------------------- |
| `POST` | `/login`           | Obtém um token de autenticação. |
| `GET`  | `/topicos`         | Lista todos os tópicos ativos. |
| `POST` | `/topicos`         | Cria um novo tópico.         |
| `GET`  | `/topicos/{id}`    | Detalha um tópico específico.  |
| `PUT`  | `/topicos/{id}`    | Atualiza um tópico.          |
| `DELETE` | `/topicos/{id}`    | Apaga (logicamente) um tópico. |

---
