# 📚 **Digital Library System**

This project is a **microservices architecture** application that enables users to create their own digital libraries. Users can interact only with the **Library Service** to manage their libraries and add books by searching for their ISBN numbers in the database. 🚀

---

## 💻 **Technologies Used**

- **Java**: Developed using the Spring Boot framework.
- **Spring Cloud Netflix Eureka**: For service discovery.
- **Spring Cloud Gateway**: API Gateway.
- **MySQL**: For database management.
- **Spring Data JPA**: For database operations.
- **Maven**: For dependency and build management.

---

## 🏗️ **Microservices**

### 1️⃣ **Book Service** 📘
- Manages book information (e.g., searching by ISBN).  
- Communicates with **Library Service** to provide book details.  

### 2️⃣ **Library Service** 📚
- The **main service** accessible by users.  
- Allows users to create libraries, add books, and list their libraries.  
- Communicates with **Book Service** to add books by ISBN.  

### 3️⃣ **Eureka Server** 🛰️
- Facilitates **service discovery** between microservices.  
- Enables dynamic load balancing and seamless communication.  

### 4️⃣ **API Gateway** 🚪
- Provides a **single entry point** for all services.  
- Manages security and performance.  

---

## 🛠️ **User Flow**

1. The user creates a library through the **Library Service**.  
2. Searches for a book by ISBN. 🔍  
3. Adds the found book to their library.  

---

## 📊 **Database**

- **MySQL** is used for data storage.  
- Book Service manages book information in its own database.  
- Library Service maintains a separate table for managing user libraries.  

---

## 🛡️ **Exception Handling**

- **Global Exception Handler** provides custom error messages.  
- **Custom Exception Classes**:  
  - `BookNotFoundException` 📕  
  - `LibraryNotFoundException` 📂  
  - `TheBookAlreadyExistException` ⚠️  

---

## 🔗 **Sample API Endpoints**

### **Library Service**
- 🆕 **Create a Library**:  
  `POST /v1/library`
  
- 📋 **List All Libraries**:  
  `GET /v1/library`
  
- 📚 **Retrieve Books in a Library**:  
  `GET /v1/library/{id}`
  
- ➕ **Add a Book to a Library**:  
  `PUT /v1/library/{id}/add-book`

### **Book Service** (Accessible only by Library Service)
- 🔍 **Search for a Book by ISBN**:  
  `GET /v1/book/isbn/{isbn}`  

---

## ⚡ **Key Highlights**

- The system has been designed to separate book and library operations, ensuring a **modular and secure architecture**.  
- Communication between microservices is handled via **Eureka** and **API Gateway**.  

---

## 🎯 **Improvements During Development**
- The modular structure ensures clear separation of concerns between services.  
- Optimized system design to enhance user experience and streamline book management.  
