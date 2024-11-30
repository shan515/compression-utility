# Approach 
## Step 1 : Setting up Spring Boot Project 
## Step 2 : Controller to upload a file from user
## Step 3 : Compression logic implemetation 
## Step 4 : File uplaod via HTML form
## Step 5 : Proving link of compressed file

+-------------------+       +-------------------+       +-------------------+
|                   |       |                   |       |                   |
|   User Interface  | ----> |   Spring Boot     | ----> |   File Storage    |
|  (HTML/JavaScript)|       |   Application      |       | (Local/Cloud)     |
|                   |       |                   |       |                   |
+-------------------+       +-------------------+       +-------------------+
                                |          |
                                |          |
                                v          v
                       +-------------------+  
                       |   Compression      |  
                       |   Service          |  
                       +-------------------+  