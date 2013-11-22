#my-extjs
This is an Example Extjs Java Application about Clients and their Addresses
##Business Logic / short specification
- The application has a login
- Users can be normal Users or Administrators
- A User can list, add, edit, deactivate Clients.
- A Client can only removed from Database by an Administrator
- Clients can have multiple addresses.
- Adresses can be added, modified and deactivated. (In the first version)
- An Administrator can add/edit/delete Users

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
        - Functionality destroy
    - Implement Testcases
    	- (check) List
    	- (check) create
    	- (check) update
    	- (check) delete
    	- destroy
- **v2**
    - Redesign Frontend
    - Add a oneToMany dependency Client 1:n Address 
    - Add User security
    - Add Admin functionality
    
- **v3**
	- Implement an HTML5 Fileupload with Progressbar 
    - Implement docx4j
    - Add ErrorHandling
    - Add search and filtering
    - Add js/css compression in build process

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
