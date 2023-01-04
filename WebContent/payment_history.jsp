<%@page import="payment.PaymentDAO"%>
<%@ include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="payment.Payment" %>
    <%@ page import="java.util.List"%>
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
                <h4 class="ph-title">History</h4>
                <!-- <ul class="lab-ul">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#">Feature</a></li>
                    <li><a class="active">History</a></li>
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
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>User ID</th>
                                <th>User Type</th>
                                <th>Transaction ID</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
				List<Payment> list = PaymentDAO.getAllPaymentRecords();
				request.setAttribute("list",list);
				int cnt=0;
				for(Payment r:list)
				{cnt++;
   			
			%>
                            <tr>                           
                                <td class="product-item">
                                          <%=cnt %>
                                                      </td>
                                <td><%=r.getUser_id() %></td>
                                <td>
                                    <center><%=r.getU_type() %></center>
                                </td>
                                <td><%=r.getTrans_id() %></td>
                                <td>
                                    <%=r.getPay_amt() %>
                                </td>
                            </tr>
                            <%} %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Cart Page Section ending here -->


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