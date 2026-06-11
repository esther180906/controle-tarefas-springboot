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
- DTOs e Validações
- Testes Unitários
- Tratamento de Exceções
- Documentação de APIs com Swagger/OpenAPI
- Deploy em Produção

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- H2 Database
- PostgreSQL
- Swagger/OpenAPI
- Maven
- JUnit 5
- Mockito
- JaCoCo
- Railway
- Supabase

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
- DTOs com validação
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

### Ambiente Local

```text
http://localhost:8080/swagger-ui/index.html
```

### Ambiente de Produção

```text
https://controle-tarefas-springboot-production.up.railway.app/swagger-ui/index.html
```

A documentação apresenta todos os endpoints organizados por:

- Usuários
- Tarefas

---

## Banco de Dados

### Desenvolvimento

Banco H2 em memória.

### Produção

Banco PostgreSQL hospedado no Supabase.

---

## Testes

Para executar os testes:

```bash
mvn test
```

Cobertura de testes monitorada com:

- JaCoCo

Cobertura atual:

```text
96%
```

---

## Deploy em Produção

Aplicação publicada na plataforma Railway.

### URL da aplicação

```text
https://controle-tarefas-springboot-production.up.railway.app
```

### Swagger Online

```text
https://controle-tarefas-springboot-production.up.railway.app/swagger-ui/index.html
```

### Banco de Dados

- PostgreSQL (Supabase)

### Variáveis de Ambiente

- SPRING_PROFILES_ACTIVE
- DB_URL
- DB_USERNAME
- DB_PASSWORD

---

## Integrantes

- Esther Santos
- João Nelson
- Kaike Machado
- Duda Gobira
- Henrique
- Gabriel

---

## Divisão de Tarefas

### Esther Santos
- Estruturação inicial do projeto Spring Boot
- Implementação das camadas Controller, Service e Repository
- Desenvolvimento dos DTOs e validações
- Implementação do tratamento global de exceções
- Criação e manutenção dos testes unitários
- Configuração do JaCoCo e análise de cobertura
- Integração final do projeto
- Configuração e validação do deploy

### João Nelson
- Documentação Swagger/OpenAPI
- Documentação dos endpoints da API
- Atualização e organização do README

### Henrique
- Configuração do PostgreSQL para produção
- Criação e configuração dos profiles do Spring Boot
- Configuração das variáveis de ambiente
- Integração com banco de dados de produção

### Kaike Machado
- Apoio no desenvolvimento e validação das funcionalidades
- Testes e revisão da aplicação

### Duda Gobira
- Apoio na documentação e validação das funcionalidades
- Testes da aplicação

### Gabriel
- Apoio na validação do projeto
- Testes e revisão final da aplicacao

## Status do Projeto

✅ CRUD de Usuários

✅ CRUD de Tarefas

✅ Relacionamento entre Entidades

✅ DTOs e Validações

✅ Swagger/OpenAPI

✅ Testes Unitários

✅ JaCoCo (96%)

✅ Tratamento Global de Exceções

✅ PostgreSQL

✅ Deploy em Produção

✅ GitHub Atualizado