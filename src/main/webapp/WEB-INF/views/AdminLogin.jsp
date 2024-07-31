<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Hey Sayali</title>
    <link rel="shortcut icon" href="assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
    <link rel="stylesheet" href="./resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/assets/css/fontawsom-all.min.css">
    <link rel="stylesheet" type="text/css" href="./resources/assets/css/style.css" />
    <style>
        /* Additional styles for customizing the form */
        body {
            background: url('path/to/your/background-image.jpg') no-repeat center center fixed;
            background-size: cover;
        }

        .login-form {
            background: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            max-width: 400px;
            margin: 0 auto; /* Center the form horizontally */
            margin-top: 100px; /* Adjust vertical margin as needed */
        }

        .login-form h5 {
            text-align: center;
        }

        .login-form .form-control {
            margin-bottom: 15px;
        }

        .login-form button {
            width: 100%;
        }

        .login-form .sign-up-link {
            color: blue;
        }
    </style>
</head>

<body>

    <!-- Login Form -->
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="login-form">
                    <h5>Hey Sayali</h5>
                    <form action="afterLogin" method="post">
                        <input placeholder="Enter Username" type="text" name="name" class="form-control">
                        <input placeholder="Enter Password" type="password" name="password" class="form-control">
                        <button class="btn btn-success">Login</button>
                    </form>
                  
                </div>
            </div>
        </div>
    </div>

    <script src="./resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="./resources/assets/js/popper.min.js"></script>
    <script src="./resources/assets/js/bootstrap.min.js"></script>
    <script src="./resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="./resources/assets/js/script.js"></script>
</body>

</html>
