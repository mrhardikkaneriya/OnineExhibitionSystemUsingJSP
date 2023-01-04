<%@page import="login.User" %>

<!DOCTYPE html>
<html>

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
    <%
		User user=null;
		if(session!=null)
		{
			if(session.getAttribute("user")!=null)
			{
				user=(User)session.getAttribute("user");
	
				if(user.getUser_type().equalsIgnoreCase("Host"))
				{
	%>
       <!-- ==========Header Section Starts Here========== -->
    <header class="header-section">
        <div class="header-bottom">
            <div class="container">
                <div class="header-wrapper">
                    <div class="logo">
                        <a href="index.jsp">
                            <img src="assets/images/logo/01.png" alt="logo">
                        </a>
                    </div>
                    <div class="menu-area">
                        <ul class="menu">
                            <li>
                                <a href="index.jsp">Home
                                </a>
                            </li>
                            <li>
                                <a href="">Events</a>
                                <ul class="submenu">
                                
                                    <li><a href="event_schedule.jsp?hid=<%= user.getHost_id()%>">Add Event</a></li>
                                    <li><a href="view_host_events.jsp?hid=<%= user.getHost_id()%>">View Event</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="">Products</a>
                                <ul class="submenu">
                                    <li><a href="add_product.jsp?hid=<%= user.getHost_id()%>">Add Product</a></li>
                                    <li><a href="view_product.jsp?hid=<%= user.getHost_id()%>">View Product</a></li>
                                    
                                </ul>
                            </li>
                            
                            
                            <li>
                            	<a href="payment_event.jsp?hid=<%= user.getHost_id()%>">Payment</a>
                            </li>
                            
                            <li>
                                <a href="host_profile_page.jsp">Profile</a>
                            </li>
                            
                            <li>
                                <a href="aboutus.jsp">About Us</a>
                            </li>
                            
                        </ul>
                        <ul class="menu">
                            <a href="Logout.jsp" class="ticket-btn lab-btn"
                                style="padding: 0px 20px; line-height: 40px;">
                                <span>Host Logout</span>
                            </a>
                        </ul>

                        <!-- toggle icons -->
                       
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ==========Header Section Ends Here========== -->
    <%}
else if(user.getUser_type().equalsIgnoreCase("Viewer"))
{
%>

    <!-- ==========Header Section Starts Here========== -->
    <header class="header-section">
        <div class="header-bottom">
            <div class="container">
                <div class="header-wrapper">
                    <div class="logo">
                        <a href="index.jsp">
                            <img src="assets/images/logo/01.png" alt="logo">
                        </a>
                    </div>
                    <div class="menu-area">
                        <ul class="menu">
                            <li>
                                <a href="index.jsp">Home</a>
                            </li>
                            
                            <!-- <li>
                                <a href="product_list_viewer.jsp">View Pr_pg</a>
                            </li> -->
                            
                            <li>
                                <a href="">Events</a>
                                <ul class="submenu">
                                    <li><a href="view_live_event.jsp">Live Event</a></li>
                                    <li><a href="view_upcoming_event.jsp">Upcoming Event</a></li>
                                    <li><a href="view_complete_event.jsp">Complete Event</a></li>
                                </ul>
                            </li>
                            
                            <li>
                                <a href="aboutus.jsp">About Us</a>
                            </li>
                            
                             <li>
                                <a href="host_profile_page.jsp">Profile</a>
                            </li>
                        </ul>
                        <ul class="menu">
                            <a href="Logout.jsp" class="ticket-btn lab-btn"
                                style="padding: 0px 20px; line-height: 40px;">
                                <span>View Logout</span>
                            </a>
                        </ul>

                        <!-- toggle icons -->
                        <div class="header-bar d-lg-none">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ==========Header Section Ends Here========== -->

    <%}
else if(user.getUser_type().equalsIgnoreCase("Admin")){
	%>
	<!-- ==========Header Section Starts Here========== -->
    <header class="header-section">
        <div class="header-bottom">
            <div class="container">
                <div class="header-wrapper">
                    <div class="logo">
                        <a href="index.jsp">
                            <img src="assets/images/logo/01.png" alt="logo">
                        </a>
                    </div>
                    <div class="menu-area">
                        <ul class="menu">
                            <li>
                                <a href="index.jsp">Home
                                </a>
                            </li>
                            <li>
                                <a href="">Events</a>
                                <ul class="submenu">
                                    <li><a href="view_live_event.jsp">Live Event</a></li>
                                    <li><a href="view_upcoming_event.jsp">Upcoming Event</a></li>
                                    <li><a href="view_complete_event.jsp">Complete Event</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="view_product_list.jsp">Products</a>
                                
                            </li>
                            <li>
                            	<a href="#">Host</a>
                                <ul class="submenu">
                                    <li><a href="host_verified.jsp">Verified Host</a></li>
                                    <li><a href="host_verification.jsp">UnVerified Host</a></li>
                                    
                                </ul>
                            </li>
                            
                            <li>
                            	<a href="payment_history.jsp">Payment</a>
                            </li>
                            
                            <li>
                                <a href="host_profile_page.jsp">Profile</a>
                            </li>
                            
                            
                        </ul>
                        <ul class="menu">
                            <a href="Logout.jsp" class="ticket-btn lab-btn"
                                style="padding: 0px 20px; line-height: 40px;">
                                <span>Admin Logout</span>
                            </a>
                        </ul>

                        <!-- toggle icons -->
                       
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ==========Header Section Ends Here========== -->
<%}
}
else
{
%>

<!-- ==========Header Section Starts Here========== -->
<header class="header-section">
    <div class="header-bottom">
        <div class="container">
            <div class="header-wrapper">
                <div class="logo">
                    <a href="index.jsp">
                        <img src="assets/images/logo/01.png" alt="logo">
                    </a>
                </div>
                <div class="menu-area">
                    <ul class="menu">
                        <li>
                            <a href="index.jsp">Home</a>
                        </li>
                        <li>
                            <a href="aboutus.jsp">About Us</a>
                        </li>
                        
                    </ul>
                    <ul class="menu">
                        <a href="login.jsp" class="ticket-btn lab-btn"
                            style="padding: 0px 20px; line-height: 40px;">
                            <span>Login</span>
                        </a>
                    </ul>

                    <!-- toggle icons -->
                    <div class="header-bar d-lg-none">
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- ==========Header Section Ends Here========== -->

    <%
}
}
else
{
%>

<!-- ==========Header Section Starts Here========== -->
<header class="header-section">
    <div class="header-bottom">
        <div class="container">
            <div class="header-wrapper">
                <div class="logo">
                    <a href="index.jsp">
                        <img src="assets/images/logo/01.png" alt="logo">
                    </a>
                </div>
                <div class="menu-area">
                    <ul class="menu">
                        <li>
                            <a href="index.jsp">Home</a>
                        </li>
                        <li>
                            <a href="aboutus.jsp">About Us</a>
                        </li>
                        
                    </ul>
                    <ul class="menu">
                        <a href="login.jsp" class="ticket-btn lab-btn"
                            style="padding: 0px 20px; line-height: 40px;">
                            <span>login</span>
                        </a>
                    </ul>

                    <!-- toggle icons -->
                    <div class="header-bar d-lg-none">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- ==========Header Section Ends Here========== -->

    <%
}

%>
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