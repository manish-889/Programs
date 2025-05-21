<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- index.html -->  

<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>Login Page</title>  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">  
</head>  
<body>  
    <div class="container mt-5">  
        <div class="row justify-content-center">  
            <div class="col-md-4">  
                <h2 class="text-center mb-4">Login</h2>  
                <form action="login" method="post">  
                    <div class="mb-3">  
                        <label for="email" class="form-label">Email:</label>  
                        <input type="email" id="email" name="email" placeholder="Enter your email" class="form-control">  
                    </div>  
                    <div class="mb-3">  
                        <label for="password" class="form-label">Password:</label>  
                        <input type="password" id="password" name="password" placeholder="" class="form-control">  
                    </div>  
                    <button type="submit" class="btn btn-primary btn-block w-100">Login</button>  
                </form>  
            </div>  
        </div>  
    </div>  

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>  
</body>  
</html>