<%@page import="login.User" %>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <title>E-Exhibit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo/01.png">

    <link rel="stylesheet" href="assets/css/animate.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/all.min.css">
    <link rel="stylesheet" href="assets/css/icofont.min.css">
    <link rel="stylesheet" href="assets/css/lightcase.css">
    <link rel="stylesheet" href="assets/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

    <!-- preloader start here -->
    <div class="preloader">
        <div class="preloader-inner">
            <div class="preloader-icon">
                <span></span>
                <span></span>
            </div>
        </div>
    </div>
    <!-- preloader ending here -->

    
    <!-- Page Header Section Start Here -->
    <section class="page-header padding-tb">
        <div class="overlay"></div>
        <div class="container">
            <div class="page-header-content-area">
                <h2 class="ph-title">Login</h2>
                <!-- <ul class="lab-ul">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="aboutus.jsp">About Us</a></li>
                    <li><a href="contact.jsp" class="active">Contact Us</a></li>
                </ul> -->
            </div>
        </div>
    </section>
    <!-- Page Header Section Ending Here -->

    <!-- Login Section Section Starts Here -->
    <div class="login-section padding-tb">
        <div class=" container">
            <div class="account-wrapper">
                <h3 class="title">Login</h3>
                <form class="account-form" action="LoginServlet" method="post">
                    <div class="form-group">
                        <input type="text" placeholder="User Email" name="usermail"  required="required">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" name="password" required="required">
                    </div>
                    <%
                    User u = new User();
                		
                    if(u.getLogin_status() == 1)
                    {
                    	%>
                    	<div class="form-group">
                    	<p style="color:Red">message</p>                          
                     </div>
                    	<% 
                    	u.setLogin_status(0);
                    }                    	
                    	%>
                    
                    <div class="form-group">
                        <div class="d-flex justify-content-between flex-wrap pt-sm-2">
                            
                            <a href="ForgetPassword.jsp" style="text-decoration: none;">Forget Password?</a>
                        </div>
                    </div>
                         
                    <div class="form-group">
                        <button class="d-block lab-btn"><span>Submit Now</span></button>
                    </div>
                </form>
                <div class="account-bottom">
                    <span class="d-block cate pt-10">Don't Have any Account? <a href="registration.jsp"> Sign
                            Up</a></span>
                </div>
            </div>
        </div>
    </div>
    <!-- Login Section Section Ends Here -->

        <!-- scrollToTop start here -->
    <a href="#" class="scrollToTop"><i class="icofont-bubble-up"></i><span class="pluse_1"></span><span
            class="pluse_2"></span></a>
    <!-- scrollToTop ending here -->

    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/fontawesome.min.js"></script>
    <script src="assets/js/waypoints.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/swiper.min.js"></script>
    <script src="assets/js/circularProgressBar.min.js"></script>
    <script src="assets/js/isotope.pkgd.min.js"></script>
    <script src="assets/js/lightcase.js"></script>
    <script src="assets/js/functions.js"></script>
</body>
</html>