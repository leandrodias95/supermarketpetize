
# Supermarket Petize

Este projeto é uma aplicação Spring Boot para gerenciar pedidos e produtos. Ele inclui integração com RabbitMQ para mensagens e um banco de dados MySQL.

## Tecnologias Usadas

- Java
- Spring Boot
- RabbitMQ
- MySQL
- Docker
- Swagger

## Como Executar a Aplicação

### Pré-requisitos

Antes de começar, você vai precisar ter instalado na sua máquina:

- Docker
- Docker Compose

### Passo a passo

1. **Clone o repositório**
   
   No terminal, clone o projeto do GitHub:

   ```bash
   git clone https://github.com/leandrodias95/supermarketpetize.git
   ```

2. **Navegue até o diretório do projeto**

   ```bash
   cd supermarketpetize
   ```

3. **Crie a imagem Docker**

   Primeiro, precisamos criar a imagem Docker da aplicação:

   ```bash
   docker build -t supermarketpetize .
   ```

4. **Subir os containers usando o Docker Compose**

   Agora que a imagem está criada, podemos usar o Docker Compose para subir os containers da aplicação, do RabbitMQ e do MySQL.

   ```bash
   docker-compose up
   ```

5. **Acessar a aplicação**

   A aplicação Spring Boot estará rodando na porta `8082`. Acesse pelo navegador:

   ```
   http://localhost:8082/swagger-ui.html
   ```

   Aqui você verá a documentação Swagger da API.

6. **Parar a aplicação**

   Para parar todos os containers, use o seguinte comando:

   ```bash
   docker-compose down
   ```

## Deploy na AWS

### Passo a Passo para Deploy na AWS

1. **Amazon RDS (MySQL)**
   - No console da AWS, crie uma instância do Amazon RDS com o MySQL.
   - Anote a URL, o nome de usuário e a senha para configurar na sua aplicação.

2. **Amazon ECS (Elastic Container Service)**
   - Suba sua aplicação Spring Boot e RabbitMQ como containers no ECS.
   - Use o Amazon ECR para armazenar a imagem Docker.

3. **Configuração no Spring Boot**
   - No `application.properties`, ajuste as configurações do banco de dados para apontar para o RDS.

## Observações

- O Swagger está disponível para a documentação das APIs.
- Qualquer dúvida ou problema, sinta-se à vontade para abrir uma issue no repositório.

GitHub: [leandrodias95](https://github.com/leandrodias95)
