<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>TechThreads</title>
    <link rel="shortcut icon" href="assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/assets/css/fontawsom-all.min.css">
    <link rel="stylesheet" type="text/css" href="./resources/assets/css/style.css" />
</head>

<body>
 
       <!--########################### Header Starts Here ###################### -->
        <div class="home-screen container-fluid" >
          <div class="home-cover">
                <div id="menu-jk" class="header">
                   <div class="container">
                       <div class="row">
                           <div class="col-md-3 logo">
                               <img class="logo-wt" style="margin-top: 20px;"src="./resources/assets/images/Logo.png" alt="">     
                               <a data-toggle="collapse" data-target="#menu" href="#menu"><i class="fas d-block d-md-none small-menu fa-bars"></i></a>
                           </div>

                       </div>
                   </div>
               </div>
                <div class="container">
                   <div class="row home-detail">
                      
                      <div class="col-md-7 homexp">
								    <h5>Welcome to</h5>
								    <h2>TechThreads</h2>
								    <span>Your Ultimate <a>Technology Discussion Hub</a></span>
								    <p>Join TechThreads to dive into dynamic discussions, share insights, and stay ahead in the world of technology. Connect with tech enthusiasts and experts from around the globe!</p>

                          <a href="/TechThreads/adminLogin"> <button class="btn btn-success">Admin Login</button> </a>
                          
                       </div>
                       
                     <div class="col-md-5 hom-form">
    <div class="registration-form row no-margin text-center">
        <h5>Sign In</h5>
        <form action="afterUserLogin" method="post" style="margin: 0 auto; max-width: 300px;">
            <div style="margin-left: 10px;">
                <input placeholder="Enter Phone Number" name="contact" type="text" class="form-control" style="width: 100%;">
            </div>
            <div style="margin-left: 12px;">
                <input placeholder="Enter Password" name="password" type="password" class="form-control" style="width: 100%;">
            </div>
            <button class="btn btn-success" style="width: 90%;">Login</button>
        </form>
        <div class="mt-3"  style="margin-left: 60px;">
            <a href="/TechThreads/signUp" class="sign-up-link">Don't have an account?<span style="color: blue;"> Sign Up</span></a>
        </div>
    </div>
</div>

                   </div>
                </div>
          </div>
        </div>
   </body>

</html>
