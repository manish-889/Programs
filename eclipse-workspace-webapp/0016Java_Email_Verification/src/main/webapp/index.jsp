<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html lang="en">  

<head>  
    <meta charset="UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>User Registration</title>  
    <!-- Bootstrap CSS -->  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
    <style>  
        body {  
            background-color: #282c34; /* Dark grey background */  
            color: #61dafb; /* Light blue font color */  
        }  

        .card {  
            background-color: rgba(255, 255, 255, 0.9); /* Slightly transparent white */  
        }  

        .card-body h2 {  
            color: #282c34; /* Dark grey for card header */  
        }  

        .form-control {  
            background-color: #f8f9fa; /* Light background for input fields */  
            color: #212529; /* Dark text for input fields */  
        }  

        .btn-primary {  
            background-color: #61dafb; /* Bright blue for button */  
            border: none;  
        }  

        .btn-primary:hover {  
            background-color: #21a1f1; /* Darker blue on hover */  
        }  
    </style>  
</head>  

<body>  
    <div class="container mt-5">  
        <div class="card">  
            <div class="card-body">  
                <h2 class="text-center">User Registration</h2>  
                <form action="verification" method="post">  
                    <div class="form-group">  
                        <label for="username">Username:</label>  
                        <input type="text" class="form-control" id="username" name="uname" required>  
                    </div>  
                    <div class="form-group">  
                        <label for="email">Email:</label>  
                        <input type="email" class="form-control" id="email" name="email" required>  
                    </div>  
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>  
                </form>  
            </div>  
        </div>  
    </div>  

    <!-- Bootstrap JS and dependencies -->  
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>  
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
</body>  

</html>