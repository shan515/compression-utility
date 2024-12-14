# File Compression System

## Approach

### Step 1: Setting Up Spring Boot Project
- Create and set up a Spring Boot project with necessary dependencies like Spring Web, Spring Boot Starter, and others.
  
### Step 2: Controller to Upload a File from User
- Implement a controller in Spring Boot that handles file uploads from users.
  
### Step 3: Compression Logic Implementation
- Implement the logic for compressing the uploaded files, such as creating a ZIP file.
  
### Step 4: File Upload via HTML Form
- Create an HTML form that allows users to upload files.

### Step 5: Providing a Link to the Compressed File
- Once the file is uploaded and compressed, provide the user with a downloadable link to the compressed file.

---

## System Design Overview

### 1. Architecture
The system can be designed using a layered architecture, which typically consists of:

- **Client Layer**: The web interface where users can select and upload files.
- **API Layer**: The Spring Boot application that handles HTTP requests, processes uploads, and manages file operations.
- **Storage Layer**: The file system or cloud storage where uploaded files are stored and managed.
- **Compression Service**: A service responsible for compressing files into a ZIP format.

### 2. Components

- **Frontend**: 
  - A web application (HTML/CSS/JavaScript) that provides a user interface for file uploads.
  
- **Backend**:
  - A Spring Boot application with:
    - RESTful APIs for file upload and download.
    - Controllers to handle HTTP requests.
    - Services for business logic (e.g., file processing and compression).
    - Utility classes for file operations (e.g., zipping files).
  
- **File Storage**: 
  - Local file storage (e.g., on the server's filesystem) or cloud storage solutions (e.g., AWS S3, Google Cloud Storage).
  
- **Database** (optional): 
  - A database to keep track of uploaded files, user information, and metadata.

---

## Instructions

1. **Clone the Repository**:
   - Clone the repository to your local machine to start the setup.
  
2. **Build and Run the Spring Boot Project**:
   - Build the project using Maven/Gradle and run the Spring Boot application.
  
3. **Access the Web Interface**:
   - Open the application in a browser and use the file upload interface to upload files for compression.
  
4. **Download Compressed File**:
   - After uploading and compression, download the compressed file using the provided link.

---

## To-Do:

1. **Improve compression logic**

2. **Host backend on Heroku and Frontend on Vercel**



