# projeto-conta-bancaria
Projeto Conta Bancária


Rodar o sistema na maquina Local
- Criar o Banco de dados no postgres;
- gerar o jar (mvn clean install)
- executar o jar (java -jar projeto-conta-bancaria-0.0.1-SNAPSHOT.jar)


Rodar o sistema em Docker.


Configuração do Banco de Dados

 -  docker ps
 -  docker exec -it db-conta-bancaria-app bash
 -  su postgres
 -  psql
 -  create database nome_banco_dados;
 
Configuração do projeto jar.
  
 - mvn clean install
 - docker build -t conta-bancaria-app .

Executar docker composer
 - docker-compose up

Documentação Swagger

http://localhost:8080/swagger-ui.html

