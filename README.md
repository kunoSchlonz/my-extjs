my-extjs
========
This is an Example Extjs Java Application.

Roadmap
--------
- (check) Adding a Simple Testcase
- Implement an ExtJs Frontend (Table and Form)
- Implement an HTML5 Fileupload with Progressbar
- Add a oneToMany dependency Client 1:n Address

Usage
--------
This app is designed to use in JBOSS 7.1.1

Production
--------
To deploy in JBOSS simply use
```sh
mvn clean package jboss-as:deploy
```

Test
--------
For integration tests directly on your jboss use
```sh
mvn clean test -Parq-jbossas-remote
```
