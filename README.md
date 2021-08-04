# Shop Book Application</h1>

Shop Book application present how to create and configure SpringBoot and Java Swing application. The project was built
using Java 8, SpringBoot and Swing.

## Libraries

- ### SpringBoot 2
- ### Spring Data Repositories
- ### Hibernate
- ### Swing
- ### Flyway

### [SpringBoot 2](https://spring.io/projects/spring-boot)

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

### [Spring Data Repositories](https://docs.spring.io/spring-data/jpa/docs/2.5.3/reference/html/#reference)

Spring Data JPA provides repository support for the Java Persistence API (JPA). It eases development of applications
that need to access JPA data sources.

### [Hibernate](https://hibernate.org/orm/)

Hibernate ORM enables developers to more easily write applications whose data outlives the application process.

### [Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)

Provides a set of "lightweight" (all-Java language) components that, to the maximum degree possible, work the same on
all platforms.

### [Flyway](https://flywaydb.org/documentation/)

Flyway is an open-source database migration tool. It strongly favors simplicity and convention over configuration.

### Running the application on macOS/Linux
```bash
##Run Docker container with PostgreSQL
sudo docker run --name $container_name -e POSTGRES_PASSWORD=$db_password -d
```
```bash
##Database access
jdbc:postgresql://localhost:5432/postgres
username = postgres
password = $db_password
```
```bash
## Run Spring boot application using Maven Wrapper or simply run ShopApplication.java class
mvn spring-boot:run
