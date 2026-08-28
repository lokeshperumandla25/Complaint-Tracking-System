# Complaint Tracker

A web-based **Complaint Management System** built using **Java Servlets, JSP, JDBC, and MySQL**. The application allows residents to register, log in, raise and manage complaints, while administrators can view complaints and update their status.

## Overview

Complaint Tracker provides a simple platform for managing complaints from submission to resolution.

The application supports two roles:

* **Resident** – Can register, log in, raise complaints, view complaint history, update complaints, and delete complaints.
* **Admin** – Can log in, view all submitted complaints, and update complaint statuses.

## Features

### Resident

* User registration
* Resident login
* Raise a new complaint
* View submitted complaints
* View complaint history
* Update complaint details
* Delete complaints
* Track complaint status

### Admin

* Admin login
* View all complaints
* View complaint details
* Update complaint status
* Manage complaints based on their current status

### Complaint Management

Each complaint contains:

* Complaint ID
* User ID
* Category
* Subject
* Description
* Status

Supported complaint statuses include:

* Pending
* Progress
* Resolved

## Technology Stack

| Technology    | Usage                              |
| ------------- | ---------------------------------- |
| Java          | Application development            |
| Java Servlets | Request handling and business flow |
| JSP           | Dynamic web pages                  |
| HTML          | Page structure                     |
| JDBC          | Database connectivity              |
| MySQL         | Data persistence                   |
| Apache Tomcat | Servlet container                  |
| Eclipse       | Development environment            |

## Application Architecture

The project follows a basic layered architecture:

```text
Browser
   │
   ▼
JSP / HTML
   │
   ▼
Java Servlets
   │
   ▼
DAO Layer
   │
   ▼
JDBC
   │
   ▼
MySQL Database
```

### Project Structure

```text
ComplaintTracker/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       ├── dao/
│       │       │   ├── AdminDao.java
│       │       │   ├── ComplaintDao.java
│       │       │   └── ResidentDao.java
│       │       │
│       │       ├── model/
│       │       │   ├── Complaint.java
│       │       │   └── Resident.java
│       │       │
│       │       ├── servlet/
│       │       │   ├── AdminViewComplaintServlet.java
│       │       │   ├── ComplaintHistoryServlet.java
│       │       │   ├── DeleteComplaintServlet.java
│       │       │   ├── LoginServlet.java
│       │       │   ├── RaiseComplaintServlet.java
│       │       │   ├── ResidentViewComplaint.java
│       │       │   ├── SignupServlet.java
│       │       │   ├── UpdateComplaintServlet.java
│       │       │   ├── UpdaedComplaintServlet.java
│       │       │   └── UpdateStatusServlet.java
│       │       │
│       │       └── util/
│       │           ├── Constants.java
│       │           └── DBConnection.java
│       │
│       └── webapp/
│           ├── index.html
│           ├── login.jsp
│           ├── signup.jsp
│           ├── RaiseComplaint.jsp
│           ├── residentDashboard.jsp
│           ├── residentViewComplaint.jsp
│           ├── complaintHistory.jsp
│           ├── updateComplaint.jsp
│           ├── adminDashboard.jsp
│           ├── adminViewComplaint.jsp
│           └── UpdateStatus.jsp
│
└── README.md
```

## Database

The application uses **MySQL** for storing users and complaints.

The project contains two main entities:

### User

```text
User
├── id
├── name
├── email
├── password
└── role
```

### Complaint

```text
Complaint
├── complaintId
├── userId
├── category
├── subject
├── description
└── status
```

The complaint is associated with the user who submitted it through `userId`.

## Database Setup

Create the database in MySQL:

```sql
CREATE DATABASE miniproject3;
```

Create the required tables according to the SQL queries used by the application.

The application currently connects using:

```text
jdbc:mysql://localhost:3306/miniproject3
```

### Important

Do **not** commit your actual MySQL username and password to GitHub.

The current project stores database credentials in `Constants.java`. Before publishing the repository, move those credentials to environment variables or another configuration mechanism.

For example:

```java
String url = System.getenv("DB_URL");
String username = System.getenv("DB_USERNAME");
String password = System.getenv("DB_PASSWORD");
```

## How the Application Works

### 1. Registration

A new user provides:

* Name
* Email
* Password
* Role

The registration request is handled by `SignupServlet`, which uses `ResidentDao` to store the user in the database.

### 2. Login

Users log in through the login page.

`LoginServlet` validates the credentials and stores user information in the HTTP session.

The application then redirects the user based on their role:

```text
Admin    → adminDashboard.jsp
Resident → residentDashboard.jsp
```

### 3. Raise Complaint

Residents can submit:

```text
Category
Subject
Description
```

The complaint is stored in the database with its associated user ID and status.

### 4. View Complaints

Residents can view their own complaints through:

```text
residentViewComplaint.jsp
```

They can also access their complaint history.

### 5. Update Complaint

Residents can update complaint information such as:

* Category
* Subject
* Description

### 6. Delete Complaint

Residents can delete their complaints using the complaint management functionality.

### 7. Admin Complaint Management

Administrators can view all complaints and update their status.

The available status values are:

```text
Pending
Progress
Resolved
```

## Main Servlets

| Servlet                     | Responsibility                              |
| --------------------------- | ------------------------------------------- |
| `SignupServlet`             | Handles user registration                   |
| `LoginServlet`              | Handles authentication and session creation |
| `RaiseComplaintServlet`     | Creates a new complaint                     |
| `ResidentViewComplaint`     | Displays resident complaints                |
| `ComplaintHistoryServlet`   | Displays complaint history                  |
| `UpdateComplaintServlet`    | Retrieves complaint information for editing |
| `UpdaedComplaintServlet`    | Processes complaint updates                 |
| `DeleteComplaintServlet`    | Deletes a complaint                         |
| `AdminViewComplaintServlet` | Displays complaints to administrators       |
| `UpdateStatusServlet`       | Updates complaint status                    |

## DAO Layer

The application separates database operations into DAO classes:

### `ResidentDao`

Handles user-related database operations such as registration and authentication.

### `ComplaintDao`

Handles complaint operations such as:

* Insert complaint
* Retrieve complaints
* Retrieve complaint by ID
* Update complaint
* Delete complaint
* Update complaint status

### `AdminDao`

Handles administrator-related complaint operations.

This separation keeps SQL/database operations outside the servlet classes.

## JDBC Database Connectivity

The application uses JDBC to communicate with MySQL.

The database connection is managed through:

```text
com.util.DBConnection
```

SQL queries are centralized in:

```text
com.util.Constants
```

This includes queries for:

* User authentication
* User registration
* Complaint creation
* Complaint retrieval
* Complaint updates
* Complaint deletion
* Complaint status updates

## Running the Project

### Prerequisites

Install:

* Java JDK
* MySQL
* Apache Tomcat
* Eclipse IDE or another Java web development IDE

### Steps

1. Clone the repository.

```bash
git clone https://github.com/lokeshperumandla25/ComplaintTracker.git
```

2. Import the project into Eclipse as a Dynamic Web Project.

3. Configure Apache Tomcat.

4. Create the MySQL database:

```sql
CREATE DATABASE miniproject3;
```

5. Create the required tables.

6. Update the database configuration.

7. Add the MySQL JDBC driver if it is not already available in the server/project configuration.

8. Run the project on Apache Tomcat.

9. Open the application in your browser using your configured Tomcat URL.

Example:

```text
http://localhost:8080/ComplaintTracker/
```


## Author

**Lokesh Perumandla**

GitHub: https://github.com/lokeshperumandla25
