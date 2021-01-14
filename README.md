# estados
API rest / teste

Para criar o banco de dados basta acessar src/main/resources e executar o arquivo db-estados.sql em em um banco de dados postgres

É possível acessar com docker, criando desta forma

> docker --name db-estados -p5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
> docker run postgres
Após inicializar a imagem, criaremos a base de dados para rodar

Siga estes comandos
> docker exec -it postgres bash
> su postgres
> psql
> CREATE DATABASE employee_database
> \q
> exit
> exit

A documentação pode ser encontrada em http://localhos:8080/swagger-ui.html

Agora basta ir a pasta raiz do projeto e digitar os comandos
>mvn clean install
>java -jar target/estados-0.0.1.jar

Após isso, é hora de acessar o frontend
https://github.com/SyrusAmadeu/estados-angular
