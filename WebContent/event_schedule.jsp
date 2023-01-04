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
<%
	String hostid=request.getParameter("hid");
	int id=Integer.parseInt(hostid);
	
	System.out.println("ID in event schedule "+id);
%>
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
                <h2 class="ph-title">Host Event</h2>
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
                <h3 class="title">Add New Event</h3>
                <form class="account-form" action="EventServlet" method="post">
                
                	<input type="hidden" value=<%=id %> name="hid">
                    <div class="form-group">
                        <p style="text-align: left;">Event Name</p>
                        <input type="text" placeholder="Event Name" name="eventname">
                    </div>

                    <div class="form-group">
                        <p style="text-align: left;">Event Start Time</p>
                        <input type="datetime-local" placeholder="Event Start Date and Time" name="eventstart">
                    </div>

                    <div class="form-group">
                        <p style="text-align: left;">Event End Time</p>
                        <input type="datetime-local" placeholder="Event End Date and Time" name="eventend">
                    </div>
                    <div class="form-group">
                        <p style="text-align: left;">Event Description</p>
                        <textarea name="eventdes" placeholder="Event Description"></textarea>
                    </div>
                    <div class="form-group">
                        <button class="d-block lab-btn"><span>Create Event</span></button>
                    </div>

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
