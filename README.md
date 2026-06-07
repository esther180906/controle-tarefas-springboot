# Controle de Tarefas - Spring Boot

## Descrição

API REST desenvolvida com Spring Boot para gerenciamento de usuários e tarefas.

## Objetivo

Permitir o cadastro e gerenciamento de usuários e tarefas através de uma API REST utilizando Spring Boot.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- PostgreSQL
- Swagger/OpenAPI
- Maven
- JUnit 5
- Mockito

## Estrutura do Projeto

- Controller
- Service
- Repository
- DTO
- Model
- Exception

## Funcionalidades

- CRUD de usuários
- CRUD de tarefas
- Relacionamento entre usuários e tarefas
- Tratamento global de exceções
- Documentação Swagger
- Testes unitários

## Como Executar

1. Clonar o repositório
2. Abrir no IntelliJ IDEA
3. Executar a classe `ControleTarefasApplication`
4. Acessar o Swagger

## Swagger

Após iniciar a aplicação:

http://localhost:8080/swagger-ui/index.html

## Banco de Dados

Desenvolvimento:
- H2 Database

Produção:
- PostgreSQL

## Integrantes

- Esther
- João Nelson
- Demais integrantes do grupo

## Deploy em Produção

A aplicação poderá ser publicada em serviços como Render, Railway ou Heroku utilizando PostgreSQL como banco de dados principal.