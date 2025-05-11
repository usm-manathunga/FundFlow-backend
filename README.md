# FundFlow Backend – Spring Boot

This is the backend API for the **FundFlow Microfinance System**, built using **Spring Boot**, **MySQL**, and **MongoDB**. It handles customer management, loan applications, credit scoring, and MongoDB-based audit logging.

---

##Setup Instructions

### Requirements
- Java 17+
- Maven
- MySQL
- MongoDB

### 🔧 Configuration

Edit the `application.properties` file:


# MySQL DB config
spring.datasource.url=jdbc:mysql://localhost:3306/fundflow
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

# MongoDB config for logging
spring.data.mongodb.uri=mongodb://localhost:27017/fundflow_logs

---

### API

REST API Endpoints
Customer Management

GET	/api/v1/admin/customer/getAllCustomer	-> Get all customers
POST	/api/v1/admin/customer/createCustomer	-> Create a new customer
PUT	/api/v1/admin/customer/updateCustomer/{id}	-> Update customer
DELETE	/api/v1/admin/customer/deleteCustomer/{id}	-> Delete customer

Loan Management

POST	/api/v1/customer/loan/apply	-> Submit a loan application
GET	/api/v1/admin/loan/getAllLoans	-> Get all loan applications

Authentication

POST	/api/v1/login	-> Login with email & password
