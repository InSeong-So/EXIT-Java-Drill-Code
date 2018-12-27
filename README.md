# Login Form

## Stack
> Spring Boot, MariaDB, JPA, Lombok

## File Structure
```
project
│   .gitignore
│   pom.xml
│   README.md
│   
└───src
    ├───main
    │   ├───java
    │   │   └───login
    │   │       │  LoginApplication.java
    │   │       │
    │   │       └───┬───controller
    │   │           │     LoginController.java
    │   │           │     RestControllerEx.java   
    │   │           │
    │   │           ├───domain
    │   │           │     UserTable.java 
    │   │           │
    │   │           ├───repository
    │   │           │     LoginRepository.java 
    │   │           │
    │   │           ├───service
    │   │           │     LoginService.java
    │   │           │     LoginServiceImplements.java  
    │   │           │
    │   │           └───util
    │   │                 LoginFunction.java
    │   │                 LoginRegistration.java
    │   │
    │   ├───resources
    │   │   │   application.properties
    │   │   │
    │   │   └───static
    │   │       │
    │   │       └───┬───css
    │   │           │     main.css
    │   │           │
    │   │           └───js
    │   │                 password.js
    │   │
    │   └───webapp
    │       └───WEB-INF
    │           └───views
    │               codePage.html
    │               home.html
    │               home2.html
    │               passwordForm.html
    │
    └───test
        └───java
            └───login
                    LoginApplicationTest.java
```
