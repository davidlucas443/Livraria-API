# 📚 Biblioteca API – Spring Boot

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de livros em uma biblioteca.  
O projeto tem foco em **boas práticas de desenvolvimento backend**, arquitetura em camadas e padrão REST.

---

## 🚀 Funcionalidades

- 📌 Cadastrar livros
- 📖 Listar todos os livros
- 🔍 Buscar livro por ID
- ✏️ Atualizar informações de um livro
- 🗑️ Remover um livro
- 🔄 Emprestar um livro (controle de status)

---

## 🧠 Conceitos Utilizados

- Spring Boot
- API REST
- Arquitetura em camadas (Controller, Service, Repository)
- JPA / Hibernate
- DTOs (Request e Response)
- `record` para DTOs
- Validações com Bean Validation
- Enum com `@Enumerated(EnumType.STRING)`
- Transações com `@Transactional`
- Stream API (`stream().map()`)
- Status HTTP semânticos (`201`, `200`, `204`, `404`)

---

## 🏗️ Estrutura do Projeto

src/main/java/com/seuprojeto/biblioteca
│
├── controller
│ └── LivroController.java
│
├── service
│ └── LivroService.java
│
├── repository
│ └── LivroRepository.java
│
├── domain
│ ├── entity
│ │ └── Livro.java
│ │
│ └── enums
│ ├── Categoria.java
│ └── StatusLivro.java
│
├── dto
│ ├── LivroRequestDto.java
│ └── LivroResponseDto.java
│
└── BibliotecaApplication.java


---

## 📘 Modelo de Dados

### Entidade: Livro

| Campo | Tipo |
|---|---|
| id | Long |
| titulo | String |
| autor | String |
| anoPublicacao | Integer |
| categoria | Enum |
| status | Enum |

### Enums

**Categoria**


**StatusLivro**


---

## 🌐 Endpoints

### ➕ Criar livro
`POST /livros`

```json
{
  "titulo": "O Senhor dos Anéis",
  "autor": "J.R.R. Tolkien",
  "anoPublicacao": 1954,
  "categoria": "FANTASIA"
}

📤 201 Created

📄 Listar livros

GET /livros

📤 200 OK

🔍 Buscar livro por ID

GET /livros/{id}

📤 200 OK
📤 404 Not Found

✏️ Atualizar livro

PUT /livros/{id}

{
  "titulo": "Novo título",
  "autor": "Novo autor",
  "anoPublicacao": 2024,
  "categoria": "ROMANCE"
}

📤 200 OK

🗑️ Deletar livro

DELETE /livros/{id}

📤 204 No Content

🔄 Emprestar livro

PATCH /livros/{id}/emprestar

📤 200 OK

📌 Regra: um livro não pode ser emprestado se já estiver com status EMPRESTADO.

⚠️ Regras de Negócio

Todo livro inicia com status DISPONIVEL

Não é permitido emprestar um livro já emprestado

Atualizações e empréstimos utilizam transações

A API não expõe entidades diretamente

🛠️ Tecnologias

Java 17+

Spring Boot

Spring Data JPA

Hibernate

Maven

Lombok

Banco de dados relacional (H2 / MySQL)

▶️ Como Executar
git clone https://github.com/seu-usuario/biblioteca-api
cd biblioteca-api
./mvnw spring-boot:run


A aplicação estará disponível em:

http://localhost:8080

🎯 Objetivo

Projeto desenvolvido para estudo e prática de desenvolvimento backend com Java e Spring Boot, aplicando padrões utilizados no mercado.

👤 Autor

Desenvolvido por David Sousa
