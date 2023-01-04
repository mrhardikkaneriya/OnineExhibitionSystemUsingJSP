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
                <h2 class="ph-title">Add New Products</h2>
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
                <h3 class="title">Add Product Details</h3>
                <form class="account-form" action="ProductServlet" method="post" enctype="multipart/form-data"> 
                
                
                <%
	String hostid=request.getParameter("hid");
	int id=Integer.parseInt(hostid);
	
	System.out.println("ID in product.jsp "+hostid+">>"+id);
%>

                <input type="hidden" value="<%= hostid%>" name="ho_id" id="ho_id">
                
                
               <%
               System.out.println("ID before passing"+id);
               List<Event> list=EventDAO.getEventsByHid(id);
				request.setAttribute("list",list);
			%>
               
                    <div class="form-group">
                        <select name="eventid">
                        <%
                        	System.out.println("before for");
											for(Event e:list)
											{
                               			%>
                            <option value=<%=e.getE_id() %>><%=e.getE_name() %></option>
                           
                            <%} %>
                           
                        </select>
                    </div>
                   
                    <div class="form-group">
                        <input type="text" placeholder="Product Name" name="product_name">
                    </div>
                    
                    <div class="form-group">
                        <input type="text" placeholder="Product Description" name="product_desc">
                    </div>
                    
                    <div class="form-group">
                        <input type="text" placeholder="Product Price" name="product_price">
                    </div>
                    <div class="form-group">
                        <input type="file"  placeholder="Upload Image" id="img" name="img">
                    </div>
                    
                    <div class="form-group">
                        <button class="d-block lab-btn"><span>Upload</span></button>
                    </div>
</form>
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
