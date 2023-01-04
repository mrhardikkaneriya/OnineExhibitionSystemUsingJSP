<%@page import="com.sun.glass.events.ViewEvent"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="java.text.ParseException"%>
<%@ include file="Header.jsp"%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<%@page import="event.EventDAO" %>
<%@page import="event.*" %>
<%@page import="login.User" %>
<% DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0"); Date cd = new Date(); %>
<% List<Event> list = EventDAO.getAllProductListByDate(); request.setAttribute("list",list); %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Kagont</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo/01.png">

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

    <!-- ==========Banner Section start Here========== -->
    <section class="banner-section">
        <div class="container">
            <div class="banner-wrapper shape-a">
                <div class="row gy-5 align-items-center">
                    <div class="col-lg-6 col-12">
                        <div class="banner-content">
                            <ul id="countdown" class="countdown count-down" data-date="Jan 1, 2022 21:14:01">
                                <li class="clock-item"><span class="count-number days">56</span>
                                    <p class="count-text">Days</p>
                                </li>

                                <li class="clock-item"><span class="count-number hours">16</span>
                                    <p class="count-text">Hour</p>
                                </li>

                                <li class="clock-item"><span class="count-number minutes">25</span>
                                    <p class="count-text">Min</p>
                                </li>

                                <li class="clock-item"><span class="count-number seconds">19</span>
                                    <p class="count-text">Sec</p>
                                </li>
                            </ul>
                            <h1>Exhibit
                                </h1>
                            <p>One stop solution to showcase your talent</p>
                            <%if(session.getAttribute("user")==null){ %>
                            <a href="registration.jsp" class="lab-btn"><span>Register Now</span> </a>
                            <%} %>
                            <!-- <div class="event-sponsored">
                                <p>Event Sponsored By:</p>
                                <img src="assets/images/banner/02.png" alt="sponsor">
                            </div> -->
                        </div>
                    </div>
                    <div class="col-lg-6 col-12">
                        <div class="banner-image">
                            <img src="assets/images/banner/03.png" alt="banner-img">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ==========Banner Section end Here========== -->

    <!-- ==========About Section start Here========== -->
    <section class="about-section padding-tb padding-b">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-10">
                    <div class="section-header text-center">
                        <h2>Biggest Exhibition Platform</h2>
                        <p>EXHIBIT - The Digital Exhibition Event 2022</p>
                    </div>
                    <div class="section-wrapper text-center">
                        <p>
                            
                            Host virtual exhibitions to encourage knowledge-sharing, build networks & help businesses as well as attendees to connect with each other globally on a seamless virtual expo platform.</p>
                            <%if(session.getAttribute("user")==null){ %>
                        <div class="about-btn-grp">
                            <a href="registration.jsp" class="lab-btn "><span>Register Now</span> </a>
                        </div>
                        <%} %>
                        
                            <%if(session.getAttribute("user")!=null){ %>
                        <div class="about-btn-grp">
                            <a href="aboutus.jsp" class="lab-btn "><span>Read More >>></span> </a>
                        </div>
                        <%} %>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ==========About Section end Here========== -->

    <!-- ==========schedule Section start Here========== -->
    <section class="schedule-section padding-tb padding-b bg-image">
        <div class="container">
            <div class="section-header">
                <h2>Event Schedule</h2>
                <p>A Representation of the event planning</p>
            </div>
            <div class="section-wrapper shape-b">
                <div class="row gx-4 gy-5">
                    <div class="col-lg-6">
                        <div class="schedule-left schedule-pack">
                            <h5>UPCOMING</h5>
                            <div class="schedule-list" id="accordionExample">
                                
                                <%
                    int cnt=0;            
for(Event p:list)
{
	Date sd = df.parse(p.getE_start().toString());
	Date ed = df.parse(p.getE_end().toString());
	

if(sd.compareTo(cd) > 0  && ed.compareTo(cd) > 0)
{
	cnt++;
	if(cnt>5){
		break;
	}
%>
                                
                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="accordion-button collapsed" type="button" aria-expanded="true">
                                            <span class="accor-header-inner d-flex flex-wrap align-items-center">
                                                <span class="accor-thumb">                                                    
                                                </span>
                                                <span class="h7"><%= p.getE_name() %></span>
                                            </span>
                                        </button>
                                    </div>                                   
                                </div>
                                <%}}

if(session!=null && session.getAttribute("user")!=null){
%>
                                <div class="schedule-btns text-center mt-5">
                    <a href="view_upcoming_event.jsp" class="lab-btn">View Upcoming Event</a>
                </div>
                <%} %>
                            </div>
                        </div>
                    </div>
                    
                    

                    <div class="col-lg-6">
                        <div class="schedule-right schedule-pack">
                            <h5>LIVE</h5>
                            <div class="schedule-list" id="accordionExample-2">
                           <% cnt=0; for(Event p:list)
                           {
                        	   Date sd = df.parse(p.getE_start().toString());
                        		Date ed = df.parse(p.getE_end().toString());
                        		
                        	if(sd.compareTo(cd) < 0  && ed.compareTo(cd) > 0)
                        	{
                        		cnt++;
                        		if(cnt>5){
                        			break;
                        		}
                        	   %>    
							<div class="accordion-item">
                                    <div class="accordion-header">                                    
                                        <button class="accordion-button collapsed" type="button" aria-expanded="true">
                                                <span class="accor-thumb">                                                    
                                                </span>
                                                <span class="h7"><%= p.getE_name() %></span>
                                            </span>
                                        </button>                                        
                                    </div>                                   
                                </div>
                                <%} }
                           if(session!=null && session.getAttribute("user")!=null){
                           %>
                                
                                <div class="schedule-btns text-center mt-5">
                    <a href="view_live_event.jsp" class="lab-btn">View Live Event</a>
                </div>
<%} %>
                            </div>                            
                        </div>
                    </div>                    
                </div>
                <%if(session.getAttribute("user")==null){ %>
                <div class="schedule-btns text-center mt-5">
                    <a href="login.jsp" class="lab-btn">LogIn</a>
                </div>
                <%} %>
            </div>
        </div>
    </section>
    <!-- ==========schedule Section end Here========== -->

    <!-- ===== News Section Start here  ==== -->
    <section class="news-section padding-tb padding-b">
        <div class="container">
            <div class="section-header">
                <h2>Successfull Events</h2>
            </div>
            <div class="section-wrapper">
                <div class="row g-4 justify-content-center">
                    
                    <%
                    
                    
                    	cnt=0; for(Event p:list)
                           {
                        	   Date sd = df.parse(p.getE_start().toString());
                        		Date ed = df.parse(p.getE_end().toString());
                        		
                        	if(sd.compareTo(cd) < 0  && ed.compareTo(cd) < 0)
                        	{
                        		
                        		String start=new SimpleDateFormat("dd-MMMM,yyyy").format(sd);
                        		String end = new SimpleDateFormat("dd-MMMM,yyyy").format(ed);
                        		
                        		
                        		cnt++;
                        		if(cnt>6){
                        			break;
                        		}
                        	   %>
                     <div class="col-lg-4 col-sm-6 col-xs-12">	   
                        <div class="news-item">
                            <div class="news-inner">
                                <div class="news-content">
                                    <h6><a><%=p.getE_name() %></a>
                                    </h6>
                                    <p><span><i class="fa fa-calendar" aria-hidden="true"></i>
                                        </span> <%=start %> - <%=end %></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <%}} %>
                    
                </div>
            </div>
        </div>
                        <%
                if(session!=null && session.getAttribute("user")!=null){
                           %>
                                
                                <div class="schedule-btns text-center mt-5">
                    <a href="view_complete_event.jsp" class="lab-btn">View Completed Event</a>
                </div>
<%} %>

<%if(session.getAttribute("user")==null){ %>
                <div class="schedule-btns text-center mt-5">
                    <a href="login.jsp" class="lab-btn">LogIn</a>
                </div>
                <%} %>
    </section>
    <!-- ===== News Section end here  ==== -->

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