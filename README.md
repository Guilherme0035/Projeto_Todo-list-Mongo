# Todo-list com Spring Boot 2 e MongoDB

Este projeto é um Todo-list sobre o desenvolvimento de aplicações RESTful utilizando Spring Boot 2 e Spring Data MongoDB.

## Tecnologias Utilizadas

- **Spring Boot 2**
- **Spring Data MongoDB**
- **MongoDB**
- **Swagger**
- **Maven**

## Práticas Adotadas

- **SOLID**
- **DRY**
- **YAGNI**
- **KISS**

## API

A API oferece operações CRUD para gerenciamento de recursos. A documentação completa da API pode ser acessada via Swagger. [Swagger UI](http://localhost:8083/swagger-ui/index.html)

### Endpoints

- **POST TODO**
  - `(http://localhost:8083/todos)´ - Criar Todo

- **GET TODO**
  - `(http://localhost:8083/todos)` - Listar Todos

- **PUT TODO**
  - `(http://localhost:8083/todos/id)` - Atualizar Todo

- **DELETE TODO**
  - `(http://localhost:8083/todos/id)` - Deletar Todo

## Como Rodar a Aplicação

1. **Clone o repositório:**
   - `git clone (https://github.com/Guilherme0035/Projeto_Todo-list-Mongo.git)`

2. **Entre na pasta do projeto:**
   - `cd Projeto_Todo-list-Mongo`

3. **Compile e execute a aplicação:**
   - `mvn spring-boot:run`

## Como Testar os Endpoints

1. **Via Swagger:**
   - Acesse a documentação interativa do Swagger em [Swagger UI](http://localhost:8083/swagger-ui/index.html) para testar os endpoints da API.

  2. **Via Postman ou outra ferramenta de sua preferência:**
- Configure os endpoints e envie requisições para os URLs listados na seção de endpoints.
