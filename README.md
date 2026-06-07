# Controle de Tarefas - Spring Boot

## Descrição

API REST desenvolvida com Spring Boot para gerenciamento de usuários e tarefas.

O sistema permite cadastrar usuários, criar tarefas vinculadas a usuários, consultar registros, atualizar informações e remover dados através de endpoints REST documentados com Swagger.

---

## Objetivo

Desenvolver uma aplicação utilizando Spring Boot aplicando conceitos de:

- Arquitetura em camadas
- API REST
- JPA/Hibernate
- Testes unitários
- Tratamento de exceções
- Documentação de APIs com Swagger/OpenAPI

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- PostgreSQL
- Swagger/OpenAPI
- Maven
- JUnit 5
- Mockito
- JaCoCo

---

## Estrutura do Projeto

```text
src
├── controller
├── service
├── repository
├── dto
├── model
├── exception
└── resources
```

---

## Funcionalidades

### Usuários

- Cadastrar usuário
- Listar usuários
- Buscar usuário por ID
- Atualizar usuário
- Remover usuário

### Tarefas

- Cadastrar tarefa
- Listar tarefas
- Buscar tarefa por ID
- Atualizar tarefa
- Remover tarefa
- Buscar tarefas por status

### Recursos adicionais

- Relacionamento entre Usuários e Tarefas
- Tratamento global de exceções
- Documentação Swagger
- Testes unitários
- Cobertura de testes com JaCoCo

---

## Exemplos de Requisições

### Criar Usuário

**POST** `/usuarios`

```json
{
  "nome": "João Nelson",
  "email": "joao@email.com"
}
```

### Atualizar Usuário

**PUT** `/usuarios/1`

```json
{
  "nome": "João Atualizado",
  "email": "joao@email.com"
}
```

### Criar Tarefa

**POST** `/tarefas`

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Finalizar documentação Swagger",
  "status": "PENDENTE",
  "usuarioId": 1
}
```

### Atualizar Tarefa

**PUT** `/tarefas/1`

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Projeto concluído",
  "status": "CONCLUIDA",
  "usuarioId": 1
}
```

---

## Como Executar

### Clonar o repositório

```bash
git clone https://github.com/esther180906/controle-tarefas-springboot.git
```

### Abrir o projeto

Importar o projeto em uma IDE Java compatível:

- IntelliJ IDEA
- Eclipse
- VS Code

### Executar a aplicação

Executar a classe:

```java
ControleTarefasApplication
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## Swagger

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui/index.html
```

A documentação apresenta todos os endpoints organizados por:

- Usuários
- Tarefas

---

## Banco de Dados

### Desenvolvimento

Banco H2 em memória.

### Produção

Preparado para utilização com PostgreSQL.

---

## Testes

Para executar os testes:

```bash
mvn test
```

Cobertura de testes monitorada com:

- JaCoCo

Cobertura atual aproximada:

```text
96%
```

---

## Integrantes

- Esther Santos
- João Nelson
- Kaike Machado
- Duda Gobira
- Henrique
- Gabriel

---

## Deploy em Produção

A aplicação pode ser publicada em plataformas como:

- Render
- Railway
- Heroku

Utilizando PostgreSQL como banco de dados principal.

---

## Status do Projeto

✅ CRUD de Usuários

✅ CRUD de Tarefas

✅ Relacionamento entre entidades

✅ Swagger/OpenAPI

✅ Testes Unitários

✅ JaCoCo

✅ Tratamento de Exceções

✅ GitHub atualizado

🚧 Deploy em produção (opcional)

🚧 Configuração de perfil de produção (opcional)