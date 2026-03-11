Personal Finance Management System (Java)
Project Overview

The Personal Finance Management System is a console-based Java application that helps users manage their financial transactions.
Users can create an account, log in, add income or expense transactions, view history, and analyze their income based on month or year.

The system also demonstrates Data Structures and Algorithms concepts such as searching, sorting, and list operations.

Features
User Authentication

Sign Up (Create new account)

Login (Verify username and password)

Logout

Transaction Management

Add new transaction (Income / Expense)

View transaction history

Search transaction by ID

Financial Analysis

Monthly income calculation

Yearly income calculation

Data Organization

Sort transactions by amount

Technologies Used

Programming Language: Java

Concepts:

Object Oriented Programming (OOP)

Data Structures

Algorithms

Menu Driven Programming

Data Structures and Algorithms Used
Searching Algorithms

Linear Search

Used for login verification

Used for searching transactions by ID

Time Complexity:
O(n)

Sorting Algorithms

Bubble Sort

Used to sort transactions based on amount.

Time Complexity:
O(n²)

Lists (ADT Concept)

Array-based list structure is used to store:

Users

Transactions

Operations performed:

Insertion

Traversal

Searching

Sorting

System Architecture
User
  |
  v
Main Menu
  |
  |---- Sign Up
  |---- Login
           |
           v
      Finance Menu
           |
           |---- Add Transaction
           |---- View History
           |---- Monthly Income
           |---- Yearly Income
           |---- Sort Transactions
           |---- Search Transaction
           |---- Logout
Program Flow

User starts the application.

User selects:

Sign Up

Login

After successful login, the finance menu appears.

User can perform financial operations.

User logs out or exits the program.

Sample Menu
------ Welcome ------
1 Sign Up
2 Login
3 Exit

After Login:

----- Personal Finance System -----
1 Add Transaction
2 View History
3 Monthly Income
4 Yearly Income
5 Sort Transactions
6 Search Transaction
7 Logout
Example Transaction
ID: 101
Type: Income
Amount: 5000
Month: 3
Year: 2026
Advantages

Simple and easy to use

Demonstrates Data Structures concepts

Useful for beginners learning Java

Limitations

Data is not stored permanently

Uses arrays instead of dynamic data structures

Console based interface only

Future Improvements

Database integration (MySQL)

Graphical User Interface (GUI)

Expense vs income reports

Data export to Excel

User profile management

Author

Akshay Gopisetti
