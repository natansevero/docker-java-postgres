# docker-java-postgres
## Exemplo de aplicação web Java com Docker e Postgres 

## Rodando a aplicação
1: Construa a imagem do banco
```
    docker build -t <uname>/banco ./postgres
```
2: Execute o container do banco
```
    docker run -p 5434:5432 -d --name banco <uname>/banco
```
3: Limpe e construa a aplicação
```
    mvn clean install
```
4: Construa a imagem da aplicação
```
    docker build -t <uname>/webapp .
```
5: Execute o container da aplicação
```
    docker run -p 8081:8080 -d --name app --link banco:banco-loja <uname>/webapp
```
6: Em seu navegador, acesse:
```
    localhost:8081/docker-java-postgres-1.0/produto
```