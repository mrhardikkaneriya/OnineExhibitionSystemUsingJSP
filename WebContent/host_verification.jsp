<%@ page import="registration.RegistrationDAO" %>
<%@ page import="registration.Registration" %>
<%@ page import="java.util.List"%>
<%@ include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <title>Exhibit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/x-icon/01.png">

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
                <h2 class="ph-title">Host Verification</h2>
                <!-- <ul class="lab-ul">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#">Feature</a></li>
                    <li><a class="active">Host Verification</a></li>
                </ul> -->
            </div>
        </div>
    </section>
    <!-- Page Header Section Ending Here -->

    <!-- Shop Cart Page Section start here -->
    <div class="shop-cart padding-tb">
        <div class="container">
            <div class="section-wrapper">
                <div class="cart-top">
                    <table>
                                <%
				List<Registration> list=RegistrationDAO.getAllHostRecords();
				request.setAttribute("list",list);
			%>
			
			
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Name</th>
                                <th>E-Mail</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        
                        <tbody>
            
			<%
					int cnt=0;
											for(Registration r:list)
											{
												if(r.getStatus()==0){
												cnt++;
                               			%>
                            <tr>
                                <td class="product-item">
                                    
                                        <%=cnt %>
                                   
                                </td>
                                <td><%=r.getName() %></td>
                                <td>
                                    <center><%=r.getEmail() %></center>
                                </td>
                                <td>
                                    <a href="HostVerificationServlet?hid=<%=r.getHost_id()%>&hst=1"><button type="button" class="btn btn-success">Accept</button></a>
                                    <a href="HostRejectServlet?hid=<%=r.getHost_id()%>"><button type="button" class="btn btn-danger">Reject</button></a>
                                </td>
                            </tr>
                            <%}} %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    
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