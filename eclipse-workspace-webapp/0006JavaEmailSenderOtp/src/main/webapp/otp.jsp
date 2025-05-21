<!DOCTYPE html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> 
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>OTP Verification</title>  
    <style>  
        body {  
            font-family: Arial, sans-serif;  
            background-color: #f7f7f7;  
            display: flex;  
            justify-content: center;  
            align-items: center;  
            height: 100vh;  
            margin: 0;  
        }  

        .container {  
            background-color: white;  
            padding: 20px;  
            border-radius: 10px;  
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);  
            text-align: center;  
        }  

        h1 {  
            margin: 0 0 10px;  
        }  

        p {  
            margin-bottom: 20px;  
        }  

        .otp-input {  
            width: 250px; /* Adjusted width */  
            height: 50px; /* Adjusted height */  
            font-size: 24px;  
            text-align: center;  
            margin: 0 0 20px; /* Added a margin to separate from the button */  
            border: 1px solid #ddd;  
            border-radius: 5px;  
        }  

        .otp-input:focus {  
            outline: none;  
            border-color: #007bff;  
        }  

        .submit-button {  
            padding: 10px 20px;  
            font-size: 16px;  
            color: white;  
            background-color: #007bff;  
            border: none;  
            border-radius: 5px;  
            cursor: pointer;  
        }  

        .submit-button:hover {  
            background-color: #0056b3;  
        }  
    </style>  
</head>  
<body>  
    <div class="container">  
        <h1>OTP Verification</h1>  
        <p>Enter the OTP sent to your registered mobile number.</p>  
        <form action="otp" method="post">  
            <input type="text" class="otp-input" name="otp" maxlength="6" required placeholder="Enter OTP">  
            <button type="submit" class="submit-button">Verify OTP</button>  
            
        </form>  
        <span>${msg}</span>
    </div>  
</body>  
</html>