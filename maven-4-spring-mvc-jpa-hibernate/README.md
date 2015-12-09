Spring MVC + Hibernate + Spring Data + MySQL + Maven
-------------
### About

Learning to implement data persistence in web project. Some basic JSP and JSTL used. Maven dependencies included.

### Development Plan / Tags

> - crud: CRUD operations
> - (TODO) implement validations
> - (TODO) i18n

### Environment

> - Java 1.8
> - Tomcat 8
> - MySQL 5

### DB Table

> 
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `level` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

### References

[Spring Data JPA - Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.custom-implementations)

[Spring JPA Data + Hibernate + MySQL + MAVEN](http://fruzenshtein.com/spring-jpa-data-hibernate-mysql)

[Spring MVC + Hibernate + Maven: CRUD operations example](http://fruzenshtein.com/spring-mvc-hibernate-maven-crud/)

Description
-------------

### CRUD repositories
Abstraction 

### Custom repositories
Lookup rule "Impl"

### JPA repositories

JPA-specifics added to CRUD repositories