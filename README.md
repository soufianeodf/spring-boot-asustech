# Swish

A stock management system using JSF and Spring 

# Screenshots

# Features

* Login system
* Show list of products from database
* Make an order
* Display the order invoice in pdf
* Add the order into the list of orders

# Technologies Used

* [JSF](http://www.javaserverfaces.org/)
* [Primefaces](https://www.primefaces.org/)
* [Spring core](https://spring.io/projects/spring-framework)
* [Spring security](https://spring.io/projects/spring-security)
* [Spring boot](https://spring.io/projects/spring-boot)
* [Spring data](https://spring.io/projects/spring-data)
* [Hibernate](https://hibernate.org/)
* [Lombok project](https://projectlombok.org/)
* [Jasper report](https://jasperproject.org/)
* [Datatables](https://datatables.net/)
* [Apache Maven](https://maven.apache.org/)
* [Mysql](https://www.mysql.com/)


# Resources Used

* [Spring documentation](https://spring.io)
* [Primefaces documentation](https://www.primefaces.org/showcase/)
* [Stackoverflow](https://stackoverflow.com/)
* [How to use japser report with spring boot](https://www.youtube.com/watch?v=pc4lfKm8NLY&t=518s)
* [Integrating Spring Boot with Java Server Faces using JoinFaces](https://medium.com/@tsepomaleka/integrating-spring-boot-with-java-server-faces-using-joinfaces-297e64f6a28f)

# Getting Started

1. Fork (optional) and clone repo
```
 git clone https://github.com/soufianeodf/spring-boot-asustech.git

 cd spring-boot-asustech
```
2. Import the project to your IDE.
3. Wait some seconds until maven install all the dependencies.
4. Execute [g_stock](src/main/resources/g_stock.sql), and [g_vente](src/main/resources/g_vente.sql) databases in Mysql.
5. Open [application.properties](src/main/resources/application.properties) file and change the values of port, username and password of the two databases to yours.
6. Run [AsustechApplication.java](src/main/java/com/fst/asustech/AsustechApplication.java) file.
7. For the login :
* **Username** : john
* **Password** : fun123
# License

Licensed under the [MIT License](LICENSE).