<p align="center">
  <a href="https://www.codecrafttech.com/resources/wp-content/uploads/2021/06/Multi-Tenancy-Architecture.png"><img src="https://www.codecrafttech.com/resources/wp-content/uploads/2021/06/Multi-Tenancy-Architecture.png" alt="Spring Boot" height="100%" width="100%"></a>
</p>

<p align="center">
    <em>Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.</em>
</p>

<p align="center">
    <em>Multi-tenancy refers to an architecture in which a single instance of a software application serves multiple tenants or customers. 
    It enables the required degree of isolation between tenants so that the data and resources used by tenants are separated from the others.</em>
</p>

---

**Source Code**:

https://github.com/Poojan670/springboot-multitenant

---


---

**Helpful articles and repos**

Extremely helpful references and articles used in this repo.

https://www.baeldung.com/multitenancy-with-spring-data-jpa

https://medium.com/swlh/multi-tenancy-implementation-using-spring-boot-hibernate-6a8e3ecb251a


---


## Project Description

_Java - Spring Boot Applications For Multi Tenant Implementation, Includes Multi Schema and Multiple DB Approach_

## Requirements

JDK 6+

maven

Java 1.8+


## Recommended IDEs

IntelliJ IDEA

Eclipse


## SETUP

cd ./multi-schema-tenant or cd ./multidb-tenant

_Configure application properties as per your DB configurations_

<div class="termy">

Using mvn package

```console
$ mvn install

```
</div>


<div class="termy">

Run the Project
```console
$ mvn spring-boot:run 
```
</div>

# TESTING

**For Multi Schema Tenant**


* `curl -X POST   http://localhost:8080/document/ -H 'Content-Type: application/json' -H 'X-TenantID: test1' -d '{"title":"Test1 title", "description":"Test1 Description}'`


* `curl -X POST   http://localhost:8080/document/ -H 'Content-Type: application/json' -H 'X-TenantID: test2' -d '{"title":"Test2 title", "description":"Test2 Description}'`


* `curl -X GET   http://localhost:8080/document/ -H 'Content-Type: application/json' -H 'X-TenantID: test1'`

* `curl -X GET   http://localhost:8080/document/ -H 'Content-Type: application/json' -H 'X-TenantID: test2'`


**For Multi DB Tenant**

_Tenant 1 would be default tenant db_

* `curl -X POST   http://localhost:8080/document/ -H 'Content-Type: application/json' -H -d '{"title":"Tenant1 title", "description":"Tenant1 Description}'`


* `curl -X POST   http://localhost:8080/document/ -H 'Content-Type: application/json' -H 'X-TenantID: test2' -d '{"title":"Tenant1 title", "description":"Tenant2 Description}'`


* `curl -X GET   http://localhost:8080/document/ -H 'Content-Type: application/json' `

* `curl -X GET   http://localhost:8080/document/ -H 'Content-Type: application/json' -H 'X-TenantID: Tenant2'`

