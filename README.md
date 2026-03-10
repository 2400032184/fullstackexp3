# fullstackexp3 - Hibernate HQL Advanced Queries

This project demonstrates advanced Hibernate Query Language (HQL) operations including sorting, pagination, filtering, and aggregate functions.

## Project Structure

```
fullstackexp3/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/hibernate/
│       │       ├── Main.java
│       │       ├── entity/
│       │       │   └── Product.java
│       │       ├── dao/
│       │       │   └── ProductDAO.java
│       │       └── util/
│       │           └── HibernateUtil.java
│       └── resources/
│           └── hibernate.cfg.xml
├── pom.xml
└── README.md
```

## Features Implemented

### Task 3: Sorting by Price
- **3a**: Sort products by price in ascending order
- **3b**: Sort products by price in descending order

### Task 4: Sorting by Quantity
- Sort products by quantity (highest first)

### Task 5: Pagination
- **5a**: Retrieve first 3 products
- **5b**: Retrieve next 3 products

### Task 6: Aggregate Functions
- **6a**: Count total number of products
- **6b**: Count products where quantity > 0
- **6c**: Count products grouped by description
- **6d**: Find minimum and maximum price

### Task 7: GROUP BY
- Group products by description with count

### Task 8: WHERE Clause
- Filter products within a price range (100-500)

### Task 9: LIKE Patterns
- **9a**: Find names starting with specific letters
- **9b**: Find names ending with specific letters
- **9c**: Find names containing a pattern (substring)
- **9d**: Find names with exact character length

## Sample Data

8 products are inserted:
1. Laptop - $899.99 (15 units) - Electronics
2. Mouse - $29.99 (50 units) - Electronics
3. Keyboard - $79.99 (30 units) - Electronics
4. Monitor - $299.99 (10 units) - Electronics
5. Desk - $199.99 (5 units) - Furniture
6. Chair - $149.99 (8 units) - Furniture
7. Lamp - $49.99 (0 units) - Furniture
8. Phone - $699.99 (20 units) - Electronics

## Prerequisites

- Java 11+
- MySQL Server
- Maven

## Setup Instructions

1. Create MySQL database:
```sql
CREATE DATABASE fullstackexp3;
```

2. Update `hibernate.cfg.xml` with your MySQL credentials if different from defaults (root/root)

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn exec:java -Dexec.mainClass="com.hibernate.Main"
```

## Dependencies

- Hibernate Core 5.6.14.Final
- MySQL Connector Java 8.0.33
- JPA 2.2

## HQL Queries Used

All queries are implemented in `ProductDAO.java` using Hibernate's Query API with proper session management and resource cleanup.
