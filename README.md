

# Employee Management System - Backend API

## Overview

The `EmployeeController` class is a Spring Boot REST controller that provides CRUD operations for managing employee data in the Employee Management System (EMS). It leverages the `EmployeeService` to perform the underlying business logic.

## API Endpoints

### Base URL

All endpoints are accessible under the base URL:

```
/api/employees
```

### 1. Create Employee

- **Endpoint:** `POST /api/employees`
- **Description:** Adds a new employee to the system.
- **Request Body:**
  - Type: `application/json`
  - Example:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "position": "Software Engineer",
      "department": "Development",
      "salary": 75000
    }
    ```
- **Response:**
  - Status Code: `201 Created`
  - Body:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "position": "Software Engineer",
      "department": "Development",
      "salary": 75000
    }
    ```

### 2. Get Employee by ID

- **Endpoint:** `GET /api/employees/{id}`
- **Description:** Retrieves a specific employee by their ID.
- **Path Variable:**
  - `id` (Long) - The ID of the employee to retrieve.
- **Response:**
  - Status Code: `200 OK`
  - Body:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "position": "Software Engineer",
      "department": "Development",
      "salary": 75000
    }
    ```

### 3. Get All Employees

- **Endpoint:** `GET /api/employees`
- **Description:** Retrieves a list of all employees.
- **Response:**
  - Status Code: `200 OK`
  - Body:
    ```json
    [
      {
        "id": 1,
        "name": "John Doe",
        "position": "Software Engineer",
        "department": "Development",
        "salary": 75000
      },
      {
        "id": 2,
        "name": "Jane Smith",
        "position": "Product Manager",
        "department": "Product",
        "salary": 85000
      }
    ]
    ```

### 4. Update Employee

- **Endpoint:** `PUT /api/employees/{id}`
- **Description:** Updates the details of an existing employee.
- **Path Variable:**
  - `id` (Long) - The ID of the employee to update.
- **Request Body:**
  - Type: `application/json`
  - Example:
    ```json
    {
      "name": "John Doe",
      "position": "Senior Software Engineer",
      "department": "Development",
      "salary": 80000
    }
    ```
- **Response:**
  - Status Code: `200 OK`
  - Body:
    ```json
    {
      "id": 1,
      "name": "John Doe",
      "position": "Senior Software Engineer",
      "department": "Development",
      "salary": 80000
    }
    ```

### 5. Delete Employee

- **Endpoint:** `DELETE /api/employees/{id}`
- **Description:** Deletes a specific employee by their ID.
- **Path Variable:**
  - `id` (Long) - The ID of the employee to delete.
- **Response:**
  - Status Code: `200 OK`
  - Body:
    ```json
    "Employee deleted successfully!"
    ```

## Dependencies

- Spring Boot
- Lombok

## Error Handling

- **Not Found (404):** Returned if an employee with the specified ID does not exist.
- **Bad Request (400):** Returned if the request payload is invalid.

