# SpringSecurityAdvanced

This is a Spring Boot project showcasing a basic setup of Spring Security with JWT (JSON Web Tokens) authentication. It includes user authentication, token generation, and secure API endpoints.

## Table of Contents
- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Endpoints](#endpoints)
- [Authentication](#authentication)

## Project Overview

This project demonstrates the implementation of Spring Security for securing a RESTful API using JWT for user authentication. It includes the following key components:

- Custom `JwtUtils` for JWT token generation and validation.
- Custom `jwtAuthFilter` for intercepting and validating JWT tokens.
- User data access and authentication using a basic in-memory database.

## Prerequisites

- Java 8 or later
- Spring Boot
- Maven

## Installation

1. Clone the repository:
   ```shell
   git clone https://github.com/ollyskay/spring-security-demo.git

cd spring-security-demo
mvn clean install
mvn spring-boot:run

## Usage

The application runs on `http://localhost:9090` by default. You can access the following API endpoints.

## Project Structure

The project has the following main components:

- `JwtUtils`: Manages JWT token generation, validation, and extraction.
- `jwtAuthFilter`: Custom filter for JWT token validation.
- `UserDao`: In-memory user data store and authentication provider.
- `SecurityConfig`: Security configuration for JWT-based authentication.

## Configuration

You can configure the application behavior in the `application.properties` file.

### Application Properties

- `jwtSigningKey`: The secret key used for JWT token generation. Update this to a more secure value in production.

## Endpoints

### Greetings API

- `/api/v1/greetings`: GET request to get a greeting message.
- `/api/v1/greetings/say-good-bye`: GET request to get a goodbye message.

### Authentication API

- `/api/v1/auth/authenticate`: POST request to authenticate with email and password. It returns a JWT token upon successful authentication.

## Authentication

To authenticate and access secured endpoints, follow these steps:

1. Make a POST request to `/api/v1/auth/authenticate` with a JSON body containing your email and password:

   ```json
   {
     "email": "your-email@example.com",
     "password": "your-password"
   }

