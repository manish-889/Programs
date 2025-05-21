<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<%@ page isELIgnored="false"  %>
<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>OTP Verification</title>  
    <!-- Include Bootstrap CSS -->  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
    <style>  
        body {  
            background-color: #f8f9fa;  
        }  
        .card {  
            margin-top: 100px;  
            padding: 20px;  
            border-radius: 10px;  
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);  
        }  
        .otp-input {  
            width: 70px;  
            height: 70px;  
            font-size: 24px;  
            text-align: center;  
            margin: 5px;  
            border: 2px solid #007bff;  
            border-radius: 5px;  
        }  
        .otp-input:focus {  
            outline: none;  
            border-color: #0056b3;  
        }  
    </style>  
</head>  
<body>  
    <div class="container">  
        <div class="row justify-content-center">  
            <div class="col-md-4">  
                <div class="card">  
                    <h5 class="card-title text-center">Enter Your OTP</h5>  
                    <span class="text-danger">${errMsg }</span>
                    <form action="verifyOtp" method="post" class="text-center">  
                        <input type="number" name="inOtp"  placeholder="Enter 4-digit OTP">  
                        <div class="form-group mt-3">  
                            <button type="submit" class="btn btn-primary btn-block">Submit OTP</button>  
                        </div> 
                         <div class="text-center">  
                            <small>If you didn't receive an OTP, please check your email or resend it.</small>  
                        </div>  
                    </form>  
                </div>  
            </div>  
        </div>  
    </div>  

    <!-- Include Bootstrap JS and dependencies -->  
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
</body>  
</html>