AI-Powered Product Recommendation API
Overview

This project is a Spring Boot REST API that generates personalized product recommendations using OpenAI’s GPT model.
It collects user activity, combines it with the product catalog, sends it to the AI model, and returns structured recommendations with explanations.

This project demonstrates backend development, AI integration, and Spring Boot best practices.

🔧 Tech Stack

Backend: Java 17, Spring Boot 3

AI Integration: OpenAI GPT-4o-mini API

Database: MySQL

Build & Dependency Management: Maven

HTTP Client: Spring RestTemplate

Configuration: Spring application.yml + environment variables

Version Control: Git & GitHub

⚙️ Features

User Activity Tracking – store user actions in the database

Product Catalog Management – store product data in MySQL

AI Recommendations – generate 5 personalized product recommendations per user with short explanations

Secure API Key Management – API key loaded via environment variable

Spring Boot Best Practices – proper service, repository, controller separation

Error Handling – handles AI API errors gracefully
