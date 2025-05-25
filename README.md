# Projeto Blog Pessoal

[![Last Commit](https://img.shields.io/github/last-commit/ViniCristhian/Projeto-Blog-Pessoal?style=for-the-badge)](https://github.com/ViniCristhian/Projeto-Blog-Pessoal/commits/main)
[![Issues](https://img.shields.io/github/issues/ViniCristhian/Projeto-Blog-Pessoal?style=for-the-badge)](https://github.com/ViniCristhian/Projeto-Blog-Pessoal/issues)
[![Top Language](https://img.shields.io/github/languages/top/ViniCristhian/Projeto-Blog-Pessoal?style=for-the-badge)](https://github.com/ViniCristhian/Projeto-Blog-Pessoal)

---

## Descrição

O **Projeto Blog Pessoal** é uma aplicação web criada com **Java** e **Spring Boot** que implementa uma API REST para gerenciamento de postagens. Com uma arquitetura seguindo o padrão MVC, o projeto dispõe de camadas de Model, Controller e Repository - especificamente para a entidade *Postagem* - possibilitando a criação, leitura, atualização e remoção de postagens. Esta aplicação foi desenvolvida como um exercício de boas práticas e organização de código utilizando o Maven.

---

## Funcionalidades

- **CRUD de Postagens**: Criação, leitura, atualização e deleção de postagens.
- **Arquitetura MVC**: Separação clara das responsabilidades entre Model, Controller e Repository.
- **Integração com Maven**: Gerenciamento de dependências e build automatizado via Maven Wrapper.
- **Customização**: Facilidades para adaptar a configuração do banco de dados e demais dependências.

---

## Tecnologias Utilizadas

- **Java** – Linguagem de programação principal.
- **Spring Boot** – Framework para criação de APIs REST robustas.
- **Spring Data JPA** – Persistência e manipulação dos dados da aplicação.
- **Maven** – Gerenciamento de dependências e ciclo de vida do projeto.

> **Observação:** As configurações de persistência podem ser ajustadas no arquivo `application.properties` (ou `application.yml`), permitindo o uso de bancos de dados como H2 (padrão), MySQL, PostgreSQL, entre outros.

---

## Estrutura do Projeto

A estrutura de diretórios segue o padrão Maven, conforme exemplificado abaixo:

```
Projeto-Blog-Pessoal
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/seudominio/ (pacote base)
│   │   │       ├── controller/       # Controladores da API
│   │   │       ├── model/            # Entidades (ex.: Postagem)
│   │   │       └── repository/       # Acesso a dados
│   │   └── resources/
│   │       └── application.properties  # Configurações da aplicação
├── .gitignore
├── mvnw               # Maven Wrapper (Linux/Mac)
├── mvnw.cmd           # Maven Wrapper (Windows)
└── pom.xml            # Configuração do Maven
```

---

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- **JDK 11 ou superior**
- **Maven** (ou utilizar o Maven Wrapper incluso)
- Um banco de dados (o padrão pode ser o H2, mas é possível configurar MySQL, PostgreSQL etc.)

---

## Instalação & Execução

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/ViniCristhian/Projeto-Blog-Pessoal.git
   cd Projeto-Blog-Pessoal
   ```

2. **Build do Projeto**

   Utilize o Maven Wrapper ou o Maven instalado localmente:

   ```bash
   ./mvnw clean install
   ```
   
   Para ambientes Windows:
   
   ```bash
   mvnw.cmd clean install
   ```

3. **Inicie a Aplicação**

   Após a compilação, execute o projeto:

   ```bash
   ./mvnw spring-boot:run
   ```
   
   A aplicação ficará disponível em: [http://localhost:8080](http://localhost:8080)

---

## Uso

Após iniciar a aplicação, você poderá testar os endpoints da API utilizando ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/). Exemplos de endpoints:

- `GET /postagens` – Listar todas as postagens.
- `POST /postagens` – Criar uma nova postagem.
- `PUT /postagens/{id}` – Atualizar uma postagem existente.
- `DELETE /postagens/{id}` – Remover uma postagem.

A estrutura dos endpoints segue os padrões REST, facilitando a integração com clientes Front-End e outros sistemas.

---

## Contribuindo

Contribuições, sugestões e melhorias são muito bem-vindas! Para colaborar:

1. Faça um fork deste repositório.
2. Crie uma branch com a sua feature (`git checkout -b minha-nova-feature`).
3. Realize as alterações e faça commit (`git commit -m 'Adicionando nova feature'`).
4. Envie suas alterações para o seu fork (`git push origin minha-nova-feature`).
5. Abra um Pull Request para revisão.

---

## Licença

Este projeto não possui uma licença definida atualmente. Consulte o repositório para atualizações sobre as definições de licença.

---

## Contato

Desenvolvido por **Vinicius Cristhian**

- **GitHub:** [ViniCristhian](https://github.com/ViniCristhian)
- **LinkedIn:** [Vinicius Cristhian](https://www.linkedin.com/in/vinicristhian/)
