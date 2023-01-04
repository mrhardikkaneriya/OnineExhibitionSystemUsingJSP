<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Exhibit</title>
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
    <section class="page-header bg_img padding-tb">
        <div class="overlay"></div>
        <div class="container">
            <div class="page-header-content-area">
                <h2 class="ph-title">Registration</h2>
                <!-- <ul class="lab-ul">
                    <li><a href="#">Home</a></li>
                    <li><a href="#" class="active">Registration</a></li>
                </ul> -->
            </div>
        </div>
    </section>
    <!-- Page Header Section Ending Here -->

    <!-- Registration section start Here -->
    <div class="login-section padding-tb">
        <div class="container">
            <div class="account-wrapper">
                <h3 class="title">Register Now</h3>
                <form class="account-form" action="RegistrationServlet" method="post">
                    <div class="form-group">
                        <select name="type">
                            <option value="viewer">Viewer</option>
                            <option value="host">Host</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Your Name" name="username" required="required">
                    </div>
                    <div class="form-group">
                        <input type="email" placeholder="Email" name="email" required="required">
                    </div>
                    
                    <div class="form-group">
                        <input type="text" placeholder="Contact Number" name="contact" required="required">
                    </div>
                    
                    <div class="form-group">
                        <input type="password" placeholder="Password" name="password" required="required">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Confirm Password" name="confirmpassword" required="required">
                    </div>
                    <div class="form-group">
                        <select class="form-group" name="gender">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                    
                    <%
                    User u = new User();
                		
                    if(u.getReg_status() == 1)
                    {
                    	%>
                    	<div class="form-group">
                    	<p style="color:Red">Enter Same Password</p>                          
                     </div>
                    	<% 
                    	u.setReg_status(0);
                    }                    	
                    	%>
                    
                    <div class="form-group">
                        <button class="d-block lab-btn"><span>Get Started Now</span></button>
                    </div>

                </form>
                <div class="account-bottom">
                    <span class="d-block cate pt-10">Are you a member? <a href="login.jsp">Login</a></span>
                    <span class="or"><span>AND</span></span>
                    <h5 class="subtitle">Follow us on Social Media</h5>
                    <ul class="social-media social-color justify-content-center d-flex lab-ul">
                        <li>
                            <a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a>
                        </li>
                        <li>
                            <a href="#" class="twitter"><i class="fab fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a>
                        </li>
                        <li>
                            <a href="#" class="instagram"><i class="fab fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#" class="pinterest"><i class="fab fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Registration section end Here -->


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
