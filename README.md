
# Article Management API

This is a simple RESTful API for managing articles using Kotlin and Spring Boot. The API supports CRUD (Create, Read, Update, Delete) operations for articles.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [Testing the API](#testing-the-api)
- [License](#license)

## Features
- Create new articles
- Read all articles or specific articles by slug
- Update existing articles
- Delete articles by slug

## Technologies
- Kotlin
- Spring Boot
- IntelliJ IDEA
- Gradle (for dependency management)

## API Endpoints

| Method | Endpoint                          | Description                                 |
|--------|-----------------------------------|---------------------------------------------|
| GET    | `/api/v1/articles`                | Get all articles                           |
| GET    | `/api/v1/articles/{slug}`         | Get a specific article by slug             |
| POST   | `/api/v1/articles`                | Create a new article                       |
| PUT    | `/api/v1/articles/{slug}`         | Update an existing article by slug         |
| DELETE | `/api/v1/articles/{slug}`         | Delete an article by slug                  |

### Request and Response Format

- **Create Article (POST)**

  **Request Body:**
  ```json
  {
    "title": "Article Title",
    "content": "Content of the article."
  }
  ```

  **Response:**
  - Status: `201 Created`
  - Body: `{"message": "Article created successfully"}`

- **Get All Articles (GET)**

  **Response:**
  - Status: `200 OK`
  - Body: 
  ```json
  [
    {
      "title": "Article Title",
      "content": "Content of the article.",
      "createdAt": "2023-10-17T12:00:00",
      "slug": "article-title"
    }
  ]
  ```

## Getting Started

### Prerequisites
- Java 11 or higher
- Kotlin
- Gradle
- IntelliJ IDEA

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/article-management-api.git
   cd article-management-api
   ```

2. Open the project in IntelliJ IDEA.

3. Build the project using Gradle:
   ```bash
   ./gradlew build
   ```

4. Run the application:
   ```bash
   ./gradlew bootRun
   ```

The application will be running at `http://localhost:8080`.

## Testing the API

You can test the API using the built-in HTTP Client in IntelliJ IDEA. Create a file named `article-api-test.http` and use the sample requests provided in the **Testing the API** section.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```

### Customization Tips:
- Update the repository URL in the **Installation** section to your own GitHub or project repository.
- Add any additional instructions or notes specific to your project.
- Adjust the **Features** and **Technologies** sections to match any changes you make in your implementation. 
