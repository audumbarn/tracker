This is a Spring Boot based project. Technologies used are:

Java 8

Spring Boot 2.1.15

Mysql 5.7

Spring data jpa


Following rest endpoints have been added:

Add driver(/driver/add) → Add new driver

Add customer(/customer/add) → Add new customer

Book cab(/book)

This api finds the nearest driver for a given customer with status AVAILABLE and creates a new booking. This also updates driver status to BUSY.
Update trip(/book/updateTrip)

This api is used to complete the trip. Once completed it changes driver status to AVAILABLE.

This project contains backend code only.

Schema of the database is available in the tracker.sql file
