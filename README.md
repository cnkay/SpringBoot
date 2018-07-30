# SpringBoot
Spring Boot - Spring Data - REST Service - InMemory - Spring Data - MySQL JDBC - Hibernate

REST Service
----------------
HTTP Request's with JSON(I used Postman, its like browser addons, HTTP Request Maker etc)

InMemoryDatabase
----------------
Stored Employee's information in Map's.

SpringData
----------------
Stored Employee's information in H2 database with JpaRepository without querying.

MYSQL JDBC
----------------
Stored Employee's information in MySQL database(change application.properties) with JDBC Template.
Added ResultSetExtractor and RowMapper implementation classes for JDBC Template.

Hibernate
----------------
Added "Project" entity for using save as Employee's Projects.
"entityManagerFactory" bean added for database operations.
Used entityManager, no session.
