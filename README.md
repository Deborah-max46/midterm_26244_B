# Consumer's Voice System

**Author:** Uwase Ketsia Deborah  
**ID:** 26244  
**Technology Stack:** Spring Boot 3, Java 17, PostgreSQL, Spring Data JPA

---

## 📋 Project Overview

Consumer's Voice System is a backend REST API that allows consumers in Rwanda to submit complaints and enables officials to manage and respond to them. The system follows Rwanda's administrative structure (Province → District → Sector → Cell → Village).

---

## 🗄️ Database Design

### Tables (7 Total)

1. **location** - Stores Rwanda's administrative locations
2. **users** - Stores user accounts (consumers and officials)
3. **user_profile** - Stores additional user information
4. **complaint** - Stores consumer complaints
5. **category** - Stores complaint categories
6. **response** - Stores official responses to complaints
7. **complaint_category** - Join table for Many-to-Many relationship

### Entity Relationships

| Relationship | Entities | Type |
|--------------|----------|------|
| Location → User | One-to-Many | One location has many users |
| User ↔ UserProfile | One-to-One | Each user has one profile |
| User → Complaint | One-to-Many | One user submits many complaints |
| Complaint ↔ Category | Many-to-Many | Complaints can have multiple categories |
| Complaint → Response | One-to-Many | One complaint has many responses |
| User → Response | One-to-Many | One official writes many responses |

---

## ✅ Requirements Implemented

1. ✅ **5+ Database Tables** - 6 entity tables + 1 join table
2. ✅ **One-to-One Relationship** - User ↔ UserProfile
3. ✅ **One-to-Many Relationship** - Location → User, User → Complaint, etc.
4. ✅ **Many-to-Many Relationship** - Complaint ↔ Category (using complaint_category join table)
5. ✅ **Save Location** - LocationService.saveLocation()
6. ✅ **Sorting** - ComplaintController with Sort parameter
7. ✅ **Pagination** - ComplaintController with Pageable (page, size, sortBy, direction)
8. ✅ **existsBy() Method** - UserRepository.existsByEmail()
9. ✅ **Province Query** - findByLocationProvinceName() and findByLocationProvinceCode()
10. ✅ **GenerationType.IDENTITY** - Used in all entities
11. ✅ **No Lombok** - All getters/setters/constructors written manually

---

## 🚀 Getting Started

### Prerequisites

- Java 17
- PostgreSQL
- Maven

### Database Setup

1. Create PostgreSQL database:
```sql
CREATE DATABASE "ConsumerVoice";
```

2. Update `application.properties` with your PostgreSQL credentials:
```properties
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

Application runs on: `http://localhost:8085`

---

## 📡 API Endpoints

### Locations
- `POST /api/locations` - Create location
- `GET /api/locations` - Get all locations
- `GET /api/locations/{id}` - Get location by ID

### Users
- `POST /api/users` - Create user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/exists/{email}` - Check if email exists
- `GET /api/users/province/name/{provinceName}` - Get users by province name
- `GET /api/users/province/code/{provinceCode}` - Get users by province code

### User Profiles
- `POST /api/profiles` - Create user profile
- `GET /api/profiles` - Get all profiles
- `GET /api/profiles/{id}` - Get profile by ID

### Complaints
- `POST /api/complaints` - Create complaint
- `GET /api/complaints` - Get all complaints
- `GET /api/complaints/paginated?page=0&size=5&sortBy=title&direction=ASC` - Get paginated complaints
- `GET /api/complaints/{id}` - Get complaint by ID

### Categories
- `POST /api/categories` - Create category
- `GET /api/categories` - Get all categories
- `GET /api/categories/{id}` - Get category by ID

### Responses
- `POST /api/responses` - Create response
- `GET /api/responses` - Get all responses
- `GET /api/responses/{id}` - Get response by ID

---

## 📝 Sample API Requests

### Create Location
```json
POST /api/locations
{
  "provinceName": "Kigali City",
  "provinceCode": "KGL",
  "district": "Gasabo",
  "sector": "Remera",
  "cell": "Rukiri I",
  "village": "Nyabisindu"
}
```

### Create User
```json
POST /api/users
{
  "fullName": "Jean Uwimana",
  "email": "jean@example.com",
  "password": "pass123",
  "location": {
    "id": 1
  }
}
```

### Create Complaint with Pagination
```json
POST /api/complaints
{
  "title": "No water for 3 days",
  "description": "Our sector has no water supply",
  "submissionDate": "2024-01-15",
  "user": {
    "id": 1
  },
  "categories": [
    {"id": 1}
  ]
}
```

### Get Paginated Complaints
```
GET /api/complaints/paginated?page=0&size=5&sortBy=submissionDate&direction=DESC
```

---

## 🏗️ Project Structure

```
src/main/java/com/example/consumer_voice_system/
├── entity/
│   ├── Location.java
│   ├── User.java
│   ├── UserProfile.java
│   ├── Complaint.java
│   ├── Category.java
│   └── Response.java
├── repository/
│   ├── LocationRepository.java
│   ├── UserRepository.java
│   ├── UserProfileRepository.java
│   ├── ComplaintRepository.java
│   ├── CategoryRepository.java
│   └── ResponseRepository.java
├── service/
│   ├── LocationService.java
│   ├── UserService.java
│   ├── UserProfileService.java
│   ├── ComplaintService.java
│   ├── CategoryService.java
│   └── ResponseService.java
├── controller/
│   ├── LocationController.java
│   ├── UserController.java
│   ├── UserProfileController.java
│   ├── ComplaintController.java
│   ├── CategoryController.java
│   └── ResponseController.java
├── DataLoader.java
└── ConsumerVoiceSystemApplication.java
```

---

## 🎯 Key Features

- **Location Management** - Rwanda's 5-level administrative structure
- **User Management** - Consumer and official accounts
- **Complaint System** - Submit and track complaints
- **Category System** - Organize complaints by type
- **Response System** - Officials respond to complaints
- **Pagination & Sorting** - Efficient data retrieval
- **Province-based Queries** - Find users by location
- **Email Validation** - Check email existence

---

## 🔧 Configuration

**application.properties:**
```properties
spring.application.name=consumer-voice-system
server.port=8085

spring.datasource.url=jdbc:postgresql://localhost:5432/ConsumerVoice
spring.datasource.username=postgres
spring.datasource.password=123
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

---

## 📊 Sample Data

The application includes a DataLoader that automatically populates the database with sample data:
- 3 Locations (Kigali, Southern, Eastern provinces)
- 3 Users (2 consumers, 1 official)
- 2 User Profiles
- 4 Categories (Water Supply, Electricity, Roads, Healthcare)
- 4 Complaints
- 3 Responses

---

## 🛠️ Technologies Used

- **Spring Boot 4.0.3** - Application framework
- **Spring Data JPA** - Database operations
- **PostgreSQL** - Database
- **Maven** - Dependency management
- **Java 17** - Programming language

---

## 📄 License

This project is developed for educational purposes.

---

**Developed by Uwase Ketsia Deborah (ID: 26244)**
