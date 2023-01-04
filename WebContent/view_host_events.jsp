<%@ page import="event.EventDAO" %>
<%@ page import="event.Event" %>
<%@ page import="java.util.List"%>

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
                <h4 class="ph-title">Event Page</h4>
                <!-- <ul class="lab-ul">
                    <li><a href="#">Home</a></li>
                    <li><a href="#" class="active">Payment</a></li>
                </ul> -->
            </div>
        </div>
    </section>
    <!-- Page Header Section Ending Here -->

<section class="news-section padding-tb padding-b">
        <div class="container">
            <div class="section-header">
                <h2>Successfull Events</h2>
            </div>
            <div class="section-wrapper">
                <div class="row g-4 justify-content-center">
    				 <%
	String hostid=request.getParameter("hid");
	int id=Integer.parseInt(hostid);
	
	System.out.println("ID in product.jsp "+hostid+">>"+id);
%>

                <input type="hidden" value="<%= hostid%>" name="ho_id" id="ho_id">
                
                
               <%
               //System.out.println("ID before passing"+id);
               List<Event> list=EventDAO.getEventsByHid(id);
				request.setAttribute("list",list);
				int h_id = Integer.parseInt(request.getParameter("hid"));
				for(Event e:list)
				{
			%>
			
			<div class="col-lg-4 col-sm-6 col-xs-12">	   
                        <div class="news-item">
                            <div class="news-inner">
                                <div class="news-content">
                                    <h6><a><%=e.getE_name() %></a></h6>
                                    <%-- <a href="EditProduct.jsp?id=<%=e.getE_id()%>"><button type="button" class="btn btn-success">Edit</button></a> --%>
                                    <a href="Delete_Event.jsp?eid=<%=e.getE_id()%>&hid=<%=h_id%>"><button type="button" class="btn btn-danger">Delete</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <%} %>
                    
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