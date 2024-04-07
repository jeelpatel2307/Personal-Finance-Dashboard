# Personal Finance Dashboard

This is a sample project demonstrating a Personal Finance Dashboard implemented using Java and Spring Boot.

## Overview

The Personal Finance Dashboard allows users to manage their personal financial information, including transactions and budgets. The application provides an API to retrieve the user's dashboard, which includes a list of transactions and the current budget.

## Architecture

The application is built using a Spring Boot application, which provides the following functionality:

1. **Dashboard Endpoint**: The `DashboardController` class exposes a RESTful API endpoint for retrieving the user's personal finance dashboard.
2. **Transaction Management**: The `TransactionService` class handles the CRUD operations for transactions, allowing users to create, retrieve, and manage their transactions.
3. **Budget Management**: The `BudgetService` class handles the retrieval and update of the user's budget.
4. **Data Models**: The `Transaction` and `Budget` entities represent the data models for the application.
5. **Data Repositories**: The `TransactionRepository` and `BudgetRepository` interfaces provide the necessary data access methods for the entities.
6. **Data Transfer Object**: The `DashboardResponse` class is a simple data transfer object used to return the dashboard data.

## Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory database for simplicity)

## Getting Started

1. Clone the repository.
2. Build and run the application using the following command:
    
    ```bash
    ./gradlew bootRun
    
    ```
    
3. The application will start running on [http://localhost:8080](http://localhost:8080/).

## Usage

You can use tools like Postman or cURL to interact with the dashboard API. Here's an example request:

**Retrieve the Dashboard**

```
GET /dashboard

```

This will return the following response:

```
{
    "transactions": [
        {
            "id": 1,
            "description": "Groceries",
            "amount": -50.0,
            "date": "2023-04-07"
        },
        {
            "id": 2,
            "description": "Salary",
            "amount": 2500.0,
            "date": "2023-04-01"
        }
    ],
    "budget": {
        "id": 1,
        "income": 2500.0,
        "expenses": 1500.0
    }
}

```

## Future Enhancements

- Implement user authentication and authorization to allow users to manage their own financial data.
- Provide the ability to create, update, and delete transactions and budgets.
- Implement categorization of transactions for better analysis and visualization.
- Add support for goal tracking and alerts based on the user's budget and spending.
- Integrate with financial institutions to automatically fetch transaction data.
- Provide a web-based or mobile application for a better user experience.
- Implement more advanced features, such as investment tracking, tax planning, and financial reporting.
