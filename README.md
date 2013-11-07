#my-extjs
This is an Example Extjs Java Application.

##Roadmap
- **v1**
    - (check) Adding a Simple Testcase
    - Implement an ExtJs Frontend (Table and Form)
        - (check) Setup Main Frontend (mvc and so on)
        - (check) Setup Grid
        - (check) Setup EditForm
        - (check) Functionality read
        - (check) Functionality create
        - (check) Functionality update
        - Functionality delete
    
- **v2**
    - Redesign Frontend
    - Add ErrorHandling
    - Add a oneToMany dependency Client 1:n Address 
    - Add User security
    - Implement an HTML5 Fileupload with Progressbar 
- **v3**
    - Implement docx4j

##Usage
This app is designed to use in JBOSS 7.1.1

###Production

To deploy in JBOSS simply use
```sh
mvn clean package jboss-as:deploy
```

###Test
For integration tests directly on your jboss use
```sh
mvn clean test -Parq-jbossas-remote
```
