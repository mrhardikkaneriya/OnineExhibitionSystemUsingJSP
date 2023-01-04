<%@page import="java.util.*"%>
<%@page import="login.User" %>
<%@page import="registration.RegistrationDAO" %>
<%@page import="registration.Registration" %>
<%@ include file="Header.jsp" %>
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
                <h4 class="ph-title">PROFILE</h4>
                <!-- <ul class="lab-ul">
                    <li><a href="#">Home</a></li>
                    <li><a href="#" class="active">Profile</a></li>
                </ul> -->
            </div>
        </div>
    </section>
    <!-- Page Header Section Ending Here -->

    <!-- Registration section start Here -->
    <div class="login-section padding-tb">
        <div class="container">
            <div class="account-wrapper">
                <h3 class="title">Your Profile</h3>
                
                <%
                							//User user=new User();
                							System.out.println("USER VALUE IN HPP "+user.getHost_id()+"TYPE "+user.getUser_type());
                							//Registration regis=null;
                							List<Registration> reg=new ArrayList<>();
                							int user_id=0,user_type=0;
                							if(user.getUser_type().equalsIgnoreCase("Host"))
                							{
                								user_type=1;
                								user_id=user.getHost_id();
                								System.out.println("GHUSI GAYA HOST");
                                		  		reg=RegistrationDAO.getRecordByHostId(user.getHost_id());
                							}
                							if(user.getUser_type().equalsIgnoreCase("Viewer"))
                							{
                								user_type=2;
                								user_id=user.getViewer_id();
                								System.out.println("GHUSI GAYA VIEW");
                                		  		reg=RegistrationDAO.getRecordByViewerId(user.getViewer_id());
                							}
                							if(user.getUser_type().equalsIgnoreCase("ADMIN"))
                							{
                								user_type=3;
                								user_id=user.getAdmin_id();
                								System.out.println("GHUSI GAYA VIEW");
                                		  		reg=RegistrationDAO.getRecordByAdminId(user.getAdmin_id());
                							}
                							
                %>
                
                <form action="EditProfileServlet" method="post" class="account-form">
                
                <%
                	for(Registration r1:reg)
                    {               				
                		
                 %>
                <!-- <form class="account-form" action="RegistrationServlet" method="post"> -->
                    <div class="form-group">
                    <% if(user_type==1)
                    	{
                    	%>
                        <input type="text" value="HOST" name="type">
                        <%} 
                        if(user_type==2)
                        {
                        %>
                        <input type="text" value="VIEWER" name="type">
                        <%} %>
                        <%
                        if(user_type==3)
                        {
                        %>
                        <input type="text" value="ADMIN" name="type">
                        <%} %>
                    </div>
                    
                    <div class="form-group">
                    <% if(user_type==1)
                    	{
                    	%>
                        <input type="text" value=<%=r1.getHost_id() %> name="u_id">
                        <%} 
                        if(user_type==2)
                        {
                        %>
                            <input type="text" value=<%=r1.getViewer_id() %> name="u_id">
                        <%} 
                        if(user_type==3)
                        {
                        %>
                            <input type="text" value=<%=r1.getAdmin_id() %> name="u_id">
                        <%} %>
                    </div>
                                        
                    <div class="form-group">
                        <input type="text" value="<%=r1.getName() %>" name="username">
                    </div>
                    
                    <div class="form-group">
                        <input type="text" value=<%=r1.getEmail() %> name="email">
                    </div>
                    
                    <div class="form-group">
                        <input type="text" value=<%=r1.getContact() %> name="contact">
                    </div>
                    
             
                    
                    
                    <%if(user_type==1 || user_type==2){ %>
                    <div class="form-group">
                        <input type="text" value=<%=r1.getGender() %> name="gender">
                    </div>
                    
                    <div class="form-group">
                        <input type="password" value=<%=r1.getPassword() %> name="password">
                    </div>
                    
                    <div class="form-group">
                        <button class="d-block lab-btn"><span>Update</span></button>
                    </div>
				<%}}%>
                </form>
                
            </div>
        </div>
    </div>
    <!-- Registration section end Here -->

    <%@ include file="Footer.jsp"%>
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
