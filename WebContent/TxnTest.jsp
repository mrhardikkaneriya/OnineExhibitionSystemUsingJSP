<%-- <%@page import="jpc.User" %>
<%@page import="jpc.UserDAO" %>
<%@page import="membersship.Membership"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ include file="Header.jsp"%>
<%@page import="java.text.*" %>
<%@page import="java.util.*" %>

<%

DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
Date dat = new Date();
String cd = df.format(dat).toString();

%>
<!Doctype html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en-gb" class="no-js"> <!--<![endif]-->


<!-- Mirrored from wedesignthemes.com/html/redart/default/contact.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 12 Dec 2020 13:34:03 GMT -->
<!-- <head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="author" content="Jobboard">
    <title>Membership Plan-JobPortal</title>

    <link rel="shortcut icon" href="assets/img/favicon.png">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/jasny-bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/bootstrap-select.min.css" type="text/css">

    <link rel="stylesheet" href="assets/css/material-kit.css" type="text/css">

    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css" type="text/css">
   <link rel="stylesheet" href="assets/fonts/themify-icons.css">

    <link rel="stylesheet" href="assets/css/color-switcher.css" type="text/css">

    <link rel="stylesheet" href="assets/extras/animate.css" type="text/css">

    <link rel="stylesheet" href="assets/extras/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/extras/owl.theme.css" type="text/css">

    <link rel="stylesheet" href="assets/extras/settings.css" type="text/css">

    <link rel="stylesheet" href="assets/css/slicknav.css" type="text/css">

    <link rel="stylesheet" href="assets/css/main.css" type="text/css">

    <link rel="stylesheet" href="assets/css/responsive.css" type="text/css">

    <link rel="stylesheet" type="text/css" href="assets/css/colors/red.css" media="screen" />
 -->    
    <style type="text/css">
 		#i1
 		{
 			width: 100px;
 			margin-top:20px;
 			margin-left: 750px;
 		}
 	
 </style>  
</head>

<body>

    <section class="page-header bg_img padding-tb">
        <div class="overlay"></div>
        <div class="container">
            <div class="page-header-content-area">
                <h2 class="ph-title">Payment Confirmation</h2>
                <!-- <ul class="lab-ul">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#">Feature</a></li>
                    <li><a class="active">Shop</a></li>
                </ul> -->
            </div>
        </div>
    </section>


<c:set var="id" value="${sessionScope.id }"></c:set>
<c:set var="total_amount" value="${sessionScope.total_amount }"></c:set>

<%
//String amount=request.getParameter("total_amount");
//int amt=Integer.parseInt(amount);
//System.out.println("AMT : "+amt);
String type=request.getParameter("type");
System.out.println(">>"+type);
%>
<!-- **Wrapper** -->
<div class="wrapper">
	<div class="inner-wrapper">
    	    
        <div id="main">
        	<div class="breadcrumb"><!-- *BreadCrumb Starts here** -->
                <div class="container">
                    <h2><center>Are you sure you want to make online payment?</center></h2>
                    
                </div>
        	</div><!-- *BreadCrumb Ends here** -->
            <form method="post" action="pgRedirect.jsp?">
            <%-- <input type="text" value="${sessionScope.id }">
            <input type="text" value="${sessionScope.mamt }"> --%>
            
				<input type="hidden" id="ORDER_ID" tabindex="1" maxlength="20" size="20" name="ORDER_ID" autocomplete="off" value="<%=cd%>"> 
				<input type="hidden" id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST001">
				<input type="hidden" id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12" size="12" name="INDUSTRY_TYPE_ID" autocomplete="off" value="Retail">
				 
				    <input type="hidden" id="CHANNEL_ID" tabindex="4" maxlength="12" size="12" name="CHANNEL_ID" autocomplete="off" value="WEB">
				    
				    <input type="hidden" title="TXN_AMOUNT" tabindex="10" type="text" name="TXN_AMOUNT" value="${sessionScope.total_amount}">
				    
		
					<%-- <input type="hidden" value="<%= type%>" name="u_typ"> --%>
					
				    <input id="i1" class="button" value="Yes" type="submit" onclick="">
				    
		  </form>
		  <br>
		  <a href="index.jsp"><input id="i1" class="button" type="submit" value="No"></a>
		   
          <br><br>
        </div><!-- Main Ends Here-->
	</div>
</div><!-- **Wrapper Ends** -->

</body>


</html>
