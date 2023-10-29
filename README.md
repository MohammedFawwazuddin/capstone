# Software Requirements Specification (SRS)

## Table of Contents

1. **Introduction**
   1.1. Purpose
   1.2. Scope
   1.3. Definitions, Acronyms, and Abbreviations
   1.4. References
   1.5. Overview of the Document

2. **User Management**
   2.1. User Authentication
      2.1.1. Login
      2.1.2. Signup

3. **Select Page**
   3.1. Functional Requirements
      3.1.1. Customer Information
      3.1.2. Account Status
      3.1.3. Quote Information
   3.2. Next Button Action

4. **Location Page**
   4.1. Functional Requirements
      4.1.1. Display Saved Locations
      4.1.2. Add New Location
      4.1.3. Location Validation
      4.1.4. Location Details
   4.2. Next Button Action

5. **Product Selection Page**
   5.1. Functional Requirements
      5.1.1. Display Products
      5.1.2. Select Products
   5.2. Next Button Action

6. **Configuration Page**
   6.1. Functional Requirements
      6.1.1. Location Selection
      6.1.2. Product Selection
      6.1.3. Enable Product
      6.1.4. Product Details
      6.1.5. Parameter Entry
   6.2. Data Persistence

7. **Billing Page**
   7.1. Functional Requirements
      7.1.1. Display Billing Items
      7.1.2. Calculate Cost

8. **Technologies**
   8.1. User Interface
   8.2. Middleware
   8.3. Backend
   8.4. Server
   8.5. Build Tool

9. **System Architecture**
   9.1. Application Layer
   9.2. Business Logic Layer
   9.3. Data Access Layer
   9.4. Database

10. **APIs and Integration**
    10.1. Spring Boot REST APIs
    10.2. Swagger API Documentation
    10.3. Database Integration

11. **Coding Practices**
    11.1. Use of Java Concepts
    11.2. Table Relationships

12. **Non-Functional Requirements**
    12.1. Performance
    12.2. Security
    12.3. Scalability
    12.4. Usability

13. **Conclusion**
    13.1. Summary of Requirements
    13.2. Future Enhancements

14. **Appendices**
    14.1. Glossary
    14.2. Use Case Diagrams
    14.3. Entity-Relationship Diagram
    14.4. Test Cases

15. **References**

This comprehensive table of contents outlines the structure of the SRS, covering all the functional and non-functional requirements, system architecture, and additional information relevant to the project.

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
