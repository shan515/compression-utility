# Approach 
## Step 1 : Setting up Spring Boot Project 
## Step 2 : Controller to upload a file from user
## Step 3 : Compression logic implemetation 
## Step 4 : File uplaod via HTML form
## Step 5 : Proving link of compressed file


# System Design Overview 

## 1. Architecture
    The system can be designed using a layered architecture, which typically consists of:

    Client Layer: The web interface where users can select and upload files.
    API Layer: The Spring Boot application that handles HTTP requests, processes uploads, and manages file operations.
    Storage Layer: The file system or cloud storage where uploaded files are stored and managed.
    Compression Service: A service responsible for compressing files into a ZIP format.

## 2. Components

    Frontend: A web application (HTML/CSS/JavaScript) that provides a user interface for file uploads.
    Backend: A Spring Boot application with:
        RESTful APIs for file upload and download.
        Controllers to handle HTTP requests.
        Services for business logic (e.g., file processing and compression).
        Utility classes for file operations (e.g., zipping files).
    File Storage: Local file storage (e.g., on the server's filesystem) or cloud storage solutions (e.g., AWS S3, Google Cloud Storage).
    Database (optional): A database to keep track of uploaded files, user information, and metadata.

## 3. Data Flow

    User Interaction:
        The user accesses the web application and navigates to the file upload page.
        The user selects files or a directory to upload.

    File Upload:
        Upon submission, the frontend sends an HTTP POST request to the backend API with the selected files.
        The request includes multipart form data containing the files.

    Backend Processing:
        The Spring Boot application receives the request in the designated controller.
        The controller validates the incoming files (e.g., checks file types, sizes).
        The files are saved to a temporary directory on the server or directly to a permanent storage location.

    File Compression:
        Once the files are uploaded, the backend invokes the compression service to create a ZIP file from the uploaded files.
        The ZIP file is saved in the designated storage location.

    Response to Client:
        The backend sends a response back to the client with a success message and a download link for the ZIP file.
        The frontend displays the message and provides the link for the user to download the ZIP file.

    File Download:
        When the user clicks the download link, the frontend sends a GET request to the backend to retrieve the ZIP file.
        The backend responds with the ZIP file, which the browser prompts the user to download.
