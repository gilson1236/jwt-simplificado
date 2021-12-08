## Desenvolvendo um sistema de autenticação e de registro de usuário API REST com Spring Boot e JWT(Sem Spring Security)

Neste projeto do Digital Innovation One desenvolvemos um pequeno sistema para autenticação e o registro de usuários usando a API REST, criada com o Spring Boot.

Foram desenvolvidos para atingir o objetivo:

* Setup inicial de projeto com o Spring Boot Initialzr
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de registro e de autenticação de usuários.
* Relação de cada uma das operações acima com o padrão arquitetural REST durante o desenvolvimento do projeto.

Utilizei o Sistema Operacional Windows 10 para todo o projeto.

Para o registro de usuários, utilizei o link inserido no postman: http://localhost:8080/user

Para a autenticação de usuários, utilizei o link inserido no postman: http://localhost:8080/login

E para o caso mencionado logo acima, inseri no header do postman o seguinte:

* Para o key ContentType inseri o value application/json.
* Para o key Application inseri o value Bearer com token do registro do usuário.

Utilizei os seguintes requisitos para a execução do projeto:

* Java 17.
* Maven 3.8.1.
* Postman.
* Intellj IDEA Community Edition.
* Controle de versão GIT instalado aqui no computador.
* Conta no GitHub para armazenar o projeto na nuvem.

--------------------------------------------------------------------

##Developing a REST API User Registration and Authentication System with Spring Boot and JWT(No Spring Security)

In this Digital Innovation One project we developed a small system for user authentication and registration using the REST API, created with Spring Boot.

They were developed to achieve the goal:

* Initial Project Setup with Spring Boot Initialzr
* Creating a data model for mapping entities into databases
* Development of user registration and authentication operations.
* Relation of each of the above operations with the REST architectural pattern during project development.

 
I used the Windows 10 Operating System for the entire project.

For user registration, I used the link inserted in postman: http://localhost:8080/user

For user authentication, I used the link inserted in postman: http://localhost:8080/login

And for the case mentioned above, I inserted the following in the postman header:

* For the ContentType key enter the application/json value.
* For the key Application I inserted the value Bearer with token from the user record.

 
I used the following requirements for project execution:

* Java 17.
* Maven 3.8.1.
* Postman.
* Intellj IDEA Community Edition.
* GIT version control installed here on the computer.
* GitHub account to store the project in the cloud.