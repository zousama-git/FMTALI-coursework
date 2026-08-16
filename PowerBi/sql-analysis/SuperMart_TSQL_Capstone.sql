--Activity 1
CREATE DATABASE SuperMart_Db;

USE SuperMart_Db;

CREATE TABLE Customers (
    CustomerId INT            IDENTITY (1, 1) PRIMARY KEY,
    FirstName  NVARCHAR (50)  NOT NULL,
    LastName   NVARCHAR (50)  NOT NULL,
    City       NVARCHAR (50)  NOT NULL,
    Phone      NVARCHAR (20)  NULL,
    Email      NVARCHAR (100) NOT NULL
);

CREATE TABLE Orders (
    OrderId     INT             IDENTITY (1, 1) PRIMARY KEY,
    CustomerId  INT             NOT NULL,
    OrderDate   DATE            NOT NULL,
    StatusCode  CHAR (1)        NOT NULL CHECK (StatusCode IN ('P', 'D', 'C')), -- Pending, Delivered, Canceled
    TotalAmount DECIMAL (10, 2) NOT NULL,
    CONSTRAINT FK_Orders_Customers FOREIGN KEY (CustomerId) REFERENCES Customers (CustomerId)
);

-- Activity 2
INSERT  INTO Customers (FirstName, LastName, City, Phone, Email)
VALUES                ('John', 'Doe', 'Joburg', '011-1234567', 'jdoe@email.com'),
('Jane', 'Smith', 'Cape Town', NULL, 'jsmith@email.com'),
('Bob', 'Johnson', 'Pretoria', '012-9876543', 'bjohnson@email.com'),
('Alice', 'Williams', 'Joburg', '011-5555555', 'awilliams@email.com'),
('Charlie', 'Brown', 'Cape Town', NULL, 'cbrown@email.com'),
('David', 'Lee', 'Pretoria', '012-3333333', 'dlee@email.com'),
('Eva', 'Green', 'Joburg', '011-7777777', 'egreen@email.com');

INSERT  INTO Orders (CustomerId, OrderDate, StatusCode, TotalAmount)
VALUES             (1, '2026-01-15', 'P', 150.00),
(1, '2026-03-20', 'D', 200.00),
(3, '2026-02-10', 'C', 75.00),
(3, '2026-06-05', 'P', 300.00),
(4, '2026-04-01', 'D', 120.00),
(4, '2026-07-15', 'D', 250.00),
(5, '2026-05-25', 'C', 90.00),
(5, '2026-09-10', 'P', 180.00),
(6, '2026-08-20', 'D', 220.00),
(6, '2026-12-01', 'P', 130.00);

-- Activity 3
SELECT CustomerId,
       FirstName + ' ' + LastName AS [Customer Name],
       'South Africa' AS Country,
       City,
       COALESCE (Phone, 'No Phone Number') AS Phone
FROM   Customers;

-- Activity 4
SELECT FirstName + ' ' + LastName AS [Full Name],
       Email,
       City
FROM   Customers
WHERE  City IN ('Joburg', 'Pretoria');

SELECT OrderId,
       CustomerId,
       OrderDate,
       StatusCode,
       TotalAmount
FROM   Orders
WHERE  OrderDate BETWEEN '2026-01-01' AND '2026-03-31';

-- Activity 5
SELECT FirstName + ' ' + LastName AS [Customer Name],
       Orders.OrderId,
       OrderDate,
       TotalAmount
FROM   Customers
       INNER JOIN
       Orders
       ON Customers.CustomerId = Orders.CustomerId;

SELECT FirstName + ' ' + LastName AS [Customer Name],
       Orders.OrderId,
       OrderDate,
       TotalAmount
FROM   Customers
       LEFT OUTER JOIN
       Orders
       ON Customers.CustomerId = Orders.CustomerId;

SELECT FirstName + ' ' + LastName AS [Customer Name],
       Orders.OrderId,
       OrderDate,
       TotalAmount
FROM   Customers
       RIGHT OUTER JOIN
       Orders
       ON Customers.CustomerId = Orders.CustomerId;

SELECT FirstName + ' ' + LastName AS [Customer Name],
       Orders.OrderId,
       OrderDate,
       TotalAmount
FROM   Customers
       FULL OUTER JOIN
       Orders
       ON Customers.CustomerId = Orders.CustomerId;


-- Activity 6
--Task 1
SELECT   UPPER(FirstName + ' ' + LastName) AS [Customer Name],
         'South Africa' AS Country,
         LEN(FirstName) AS [First Name Length]
FROM     Customers
ORDER BY FirstName ASC;

 --Task 2
SELECT   City AS Country,
         COUNT(*) AS [Total Customers]
FROM     Customers
GROUP BY City
ORDER BY COUNT(*) DESC;

-- Task 3
SELECT COUNT(*) AS [Total Orders],
       AVG(TotalAmount) AS [Average Order Amount],
       MAX(TotalAmount) AS [Highest Order Amount],
       MIN(TotalAmount) AS [Lowest Order Amount]
FROM   Orders;

-- Task 4
SELECT   OrderId,
         OrderDate,
         YEAR(OrderDate) AS OrderYear,
         MONTH(OrderDate) AS OrderMonth,
         DATEDIFF(day, OrderDate, GETDATE()) AS [Days Since Order],
         TotalAmount
FROM     Orders
ORDER BY TotalAmount DESC;

--Activity 7
-- Section A
-- Using IN
SELECT CustomerId,
       FirstName + ' ' + LastName AS [Customer Name],
       City AS Country
FROM   Customers
WHERE  CustomerId IN (SELECT CustomerId
                      FROM   Orders);

-- Using EXISTS
SELECT CustomerId,
       FirstName + ' ' + LastName AS [Customer Name],
       City AS Country
FROM   Customers
WHERE  EXISTS (SELECT 1
               FROM   Orders
               WHERE  Orders.CustomerId = Customers.CustomerId);

-- Section B:
SELECT FirstName + ' ' + LastName AS [Customer Name],
       OrderDate,
       TotalAmount
FROM   Customers
       INNER JOIN
       Orders
       ON Customers.CustomerId = Orders.CustomerId;

WITH   OrderCounts
AS     (SELECT   CustomerId,
                 COUNT(*) AS [Number of Orders]
        FROM     Orders
        GROUP BY CustomerId)
SELECT FirstName + ' ' + LastName AS [Customer Name],
       ISNULL(oc.[Number of Orders], 0) AS [Number of Orders]
FROM   Customers
       LEFT OUTER JOIN
       OrderCounts AS oc
       ON Customers.CustomerId = oc.CustomerId;

-- Section C
CREATE PROCEDURE GetCustomerOrders
@CustomerID INT
AS
SELECT OrderId,
       OrderDate,
       StatusCode AS OrderStatus,
       TotalAmount
FROM   Orders
WHERE  CustomerId = @CustomerID;
EXECUTE GetCustomerOrders @CustomerID = 1;