# Software Requirements Specification (SRS)

## 1. Introduction

The Software Requirements Specification (SRS) document outlines the requirements for the development of a web-based application designed to manage and configure product quotes for both new and existing customers. The application encompasses various pages and functionalities, including user authentication, location management, product selection, and configuration. The project will use the following technologies:

- UI / Framework: Angular 16
- Middleware: Java/Spring Boot
- Backend: PostgreSQL
- Server: Embedded Tomcat
- Build Tool: Maven

## 2. System Overview

The proposed system will provide a user-friendly interface for customers to log in, select and configure products, manage locations, and generate quotes. The system consists of the following key modules:

1. **User Authentication**:
   - Allows users to log in as an existing customer or sign up as a new customer.

2. **Select Page**:
   - Displays customer information, account status, and quote details.

3. **Location Page**:
   - Manages saved locations and allows users to add new locations.
   - Validates location data to ensure accuracy.
   
4. **Product Selection Page**:
   - Displays products in a tile format.
   - Enables users to select products.
   
5. **Configuration Page**:
   - Allows users to configure products.
   - Displays selected locations and products.
   - Enables users to enable a product and view associated features and parameters.

6. **Billing Page**:
   - Displays product configurations and calculates costs.

## 3. Detailed Requirements

### 3.1. User Authentication

**Functional Requirements:**

- Users can log in with their credentials.
- New users can sign up.

### 3.2. Select Page

**Functional Requirements:**

- Display customer name, account status, quote name, and quote owner fields.
- Automatically generate a unique quote ID for each quote (not displayed on the UI).
- Provide the option to move to the Location Page.

### 3.3. Location Page

**Functional Requirements:**

- Display saved locations in a tabular structure.
- Allow users to add new locations.
- Validate location data for accuracy.
- Include fields for location name, street name, city, state, country, and pin code.
- Provide a "Next" button to navigate to the Product Selection Page.

### 3.4. Product Selection Page

**Functional Requirements:**

- Display products in a tile format.
- Enable users to select products by clicking on the tiles.
- Provide a "Next" button to proceed to the Configuration Page.

### 3.5. Configuration Page

**Functional Requirements:**

- Display selected locations in a dropdown list.
- Allow users to select a location.
- Display a list of products selected in the Product Selection Page.
- Allow users to select a product from the list.
- Include an "Enable" button next to the product dropdown.
- When the "Enable" button is clicked, display product details and associated features and parameters.
- Allow users to enter values for parameters based on parameter types defined in the Catalog project.
- Persist data to the database.
- Provide a "Next" button to move to the Billing Page.

### 3.6. Billing Page

**Functional Requirements:**

- Display configured product details and costs.
- Generate billing information for the user.

### 3.7. Database

**Table Structure:**

The following tables are used to store data:

1. **Users Table**:
   - Stores user credentials and profile information.
   
2. **Quotes Table**:
   - Contains information about generated quotes.

3. **Locations Table**:
   - Stores location details, including name, street, city, state, country, and pin code.

4. **Products Table**:
   - Contains product information from the Catalog project.
   
5. **Product_Configurations Table**:
   - Stores product configurations, including selected locations and parameters.
   
6. **Billing Table**:
   - Records billing information for each transaction.

## 4. Non-Functional Requirements

- The system should be responsive, providing an optimal user experience on various devices.
- User interfaces should be intuitive and user-friendly.
- Security measures should be implemented for user authentication and data protection.
- The application should have efficient database management to handle concurrent users.
- APIs should be documented and made accessible via Swagger for testing.
- Java concepts like Streams and Lombok should be utilized for efficient coding.
- Appropriate one-to-many and many-to-one relationships should be defined between database tables for data management.

## 5. Conclusion

This Software Requirements Specification defines the requirements for the development of a web-based application for managing and configuring product quotes. It includes user authentication, location management, product selection, configuration, and billing. The project aims to provide a user-friendly interface and robust data management while adhering to best practices in web application development.
