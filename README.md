# Car Management System

## Description
The Car Management System is a Spring Boot-based application that allows users to manage car details, such as adding, updating, viewing, and deleting car information. This project includes features like global search, pagination, sorting, and data validation.

## Features
- **CRUD Operations**: Add, update, view, and delete car details.
- **Global Search**: Search cars by name, model, year, color, or fuel type.
- **Validation**: Ensure proper data entry for car details.
- **API Documentation**: Use of Swagger for API documentation.

## Prerequisites

Make sure you have the following installed on your machine:
- **Java 8 or higher**
- **Maven** (for building the project)
- **MySQL** (for the database)
- **Postman/Swagger** (optional, for testing the APIs)

## Setting Up the Project Locally

### Step 1: Download the Project
1. Download the project as a ZIP file from GitHub:
   - [Download ZIP](https://github.com/amansoni7389/Car-Management-System/archive/refs/heads/main.zip)

2. Extract the ZIP file to a location of your choice on your local machine.

### Step 2: Import the Project into Your IDE
- Open your IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
- Import the project as a **Maven** project.

### Step 3: Set Up MySQL Database
1. Install **MySQL** if you haven't already. You can download it from the official [MySQL website](https://dev.mysql.com/downloads/).
2. Create a new database named `car_management` in MySQL:
   - Open the MySQL command line or a MySQL client like MySQL Workbench or phpMyAdmin.
   - Run the following SQL commands:

   ```sql
   CREATE DATABASE car_management;
   USE car_management;

   CREATE TABLE car (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       model VARCHAR(100),
       year INT,
       price DECIMAL(10, 2),
       color VARCHAR(50),
       fuel_type VARCHAR(50)
   );

### Step 4: Configure the Database Connection
In the src/main/resources/application.properties file, update the database connection details with your MySQL username, password, and database name.

Open the application.properties file 
- spring.datasource.url=jdbc:mysql://localhost:3306/car_management
- spring.datasource.username=your_mysql_username
- spring.datasource.password=your_mysql_password
#### Make sure to replace your_mysql_username and your_mysql_password with the correct credentials for your MySQL instance.



### Step 5: Run the Application:

**In STS:**
- Right-click on the project in the **Project Explorer**.
- Select **Run As -> Spring Boot App**.

**In IntelliJ IDEA:**
- Right-click on the `CarManagementSystemApplication.java` file (the main class with `@SpringBootApplication` annotation).
- Click on **Run 'CarManagementSystemApplication'**.

The application should now start, and you can access it at
- For Postman `http://localhost:8080` 
- For Swagger `http://localhost:8080/swagger-ui.html`.

### Step 6: Testing the APIs

You can use **Postman** or **Swagger** to test the API endpoints. The basic API endpoints are as follows:

- **POST /cars** - Add a new car
- **GET /cars** - Get a list of all cars
- **GET /cars/{id}** - Get a specific car by ID
- **PUT /cars/{id}** - Update an existing car by ID
- **DELETE /cars/{id}** - Delete a car by ID
- **GET /cars/search** - Search cars by name, model, year, color, or fuel type





