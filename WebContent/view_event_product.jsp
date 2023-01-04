<%@ page import="products.Product"%>
<%@ page import="products.ProductDAO"%>
<%@ page import="java.util.List"%>
<%@ include file="Header.jsp"%>
<%@ page import="event.Event" %>
<!DOCTYPE html>
<html lang="zxx">

<%
Event e = new Event();
int eid =  Integer.parseInt(request.getParameter("id"));

%>

<head>
    <title>Kagont</title>
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
                <h2 class="ph-title">Event Products</h2>
                <ul class="lab-ul">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="#">Feature</a></li>
                    <li><a class="active">Shop</a></li>
                </ul>
            </div>
        </div>
    </section>
    <!-- Page Header Section Ending Here -->

    <!-- shop page Section Start Here -->
    <div class="shop-page padding-tb">
        <div class="container">
            <div class="section-wrapper">
                <div class="row justify-content-center">
                    <div class="col-lg-9 col-12">
                        <article>
                            <div class="shop-title d-flex flex-wrap justify-content-between">
                                <p>Product List</p>
                                <div class="product-view-mode">
                                    <a class="active" data-target="lists"><i class="fas fa-th-list"></i></a>
                                    <!-- <a class="active" data-target="grids"><i class="fas fa-th"></i></a> -->
                                    
                                </div>
                            </div>
<%

				//int amount=100;
				List<Product> list=ProductDAO.getProductByEventId(eid);
				request.setAttribute("list",list);
			%>
                            
                            <div class="shop-product-wrap lists row justify-content-center">
                                <%
											for(Product p:list)
											{
												String img=ProductDAO.getImg(p.getPro_id());
												System.out.println(img);		
                               			%>
                                <div class="col-lg-4 col-sm-6 col-12">
                                  
                                    <div class="product-list-item">
                                        <div class="product-thumb">
                                            <img src="Product_Img/<%=img %>" alt="shope">
                                            <div class="product-action-link">
                                                <a href="Product_Img/<%=img %>" data-rel="lightcase"><i
                                                        class="icofont-eye"></i></a>
                                  
                                            </div>
                                        </div>
                                        <div class="product-content">
                                            <h6><a href="#"><%=p.getPro_name() %></a></h6>
                                            <div class="rating mb-1">                                            
                                            
											<a href="FeedbackForm.jsp?id=<%=p.getPro_id()%>&eveid=<%= p.getEvent_id()%>"><button type="button" class="btn btn-warning">Give Feedback</button></a>	
											<a href="order_detail_form.jsp?id=<%=p.getPro_id()%>&eveid=<%= p.getEvent_id()%>"><button type="button" class="btn btn-success">Buy Now</button></a>													
                                            
                                            </div>
                                            <h6>
                                                Rs. <%=p.getPro_price() %>
                                            </h6>
                                            <p><%=p.getPro_desc() %></p>
                                        </div>
                                    </div>
                                </div>

                                <% } %>

                            </div>

                            
                        </article>
                    </div>
                    <div class="col-lg-3 col-md-7 col-12">
                        <!-- <aside>
                            <div class="widget widget-search primary-bg px-3">
                                <div class="widget-header">
                                    <h5>Search keywords</h5>
                                </div>
                            
                            </div>

                            <div class="widget widget-category primary-bg px-3">
                                <div class="widget-header">
                                    <h5>All Categories</h5>
                                </div>
                                <div class="widget-wrapper">
                                    <ul class="lab-ul shop-menu">
                                        <li>
                                            <a href="#0">Apple</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Apple 1</a></li>
                                                <li><a href="#">Apple 2</a></li>
                                                <li><a href="#">Apple 3</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#0">Orange</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Orange 1</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#0">Tomato</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Tomato 1</a></li>
                                                <li><a href="#">Tomato 2</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#0">Honey</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Honey 1</a></li>
                                                <li><a href="#">Honey 2</a></li>
                                                <li><a href="#">Honey 3</a></li>
                                                <li><a href="#">Honey 4</a></li>
                                                <li><a href="#">Honey 5</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#0">Banana</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Banana 1</a></li>
                                                <li><a href="#">Banana 2</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#0">Blueberry</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Blueberry 1</a></li>
                                                <li><a href="#">Blueberry 2</a></li>
                                                <li><a href="#">Blueberry 3</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#0">Lettuce</a>
                                            <ul class="lab-ul shop-submenu">
                                                <li><a href="#">Lettuce 1</a></li>
                                                <li><a href="#">Lettuce 2</a></li>
                                                <li><a href="#">Lettuce 3</a></li>
                                                <li><a href="#">Lettuce 4</a></li>
                                                <li><a href="#">Lettuce 5</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="widget widget-post primary-bg px-3">
                                <div class="widget-header">
                                    <h5>Latests Products</h5>
                                </div>
                                <ul class="lab-ul widget-wrapper">
                                    <li class="d-flex flex-wrap justify-content-between">
                                        <div class="post-thumb">
                                            <a href="blog-single.html"><img src="assets/images/shop/02.jpg"
                                                    alt="product"></a>
                                        </div>
                                        <div class="post-content ps-3">
                                            <a href="blog-single.html">
                                                <h6>Organic Orange</h6>
                                            </a>
                                            <div class="rating">
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                            </div>
                                            <h6>$59.9</h6>
                                        </div>
                                    </li>
                                    <li class="d-flex flex-wrap justify-content-between">
                                        <div class="post-thumb">
                                            <a href="blog-single.html"><img src="assets/images/shop/03.jpg"
                                                    alt="product"></a>
                                        </div>
                                        <div class="post-content ps-3">
                                            <a href="blog-single.html">
                                                <h6>Organic Orange</h6>
                                            </a>
                                            <div class="rating">
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                            </div>
                                            <h6>$59.9</h6>
                                        </div>
                                    </li>
                                    <li class="d-flex flex-wrap justify-content-between">
                                        <div class="post-thumb">
                                            <a href="blog-single.html"><img src="assets/images/shop/04.jpg"
                                                    alt="product"></a>
                                        </div>
                                        <div class="post-content ps-3">
                                            <a href="blog-single.html">
                                                <h6>Organic Orange</h6>
                                            </a>
                                            <div class="rating">
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                            </div>
                                            <h6>$59.9</h6>
                                        </div>
                                    </li>
                                    <li class="d-flex flex-wrap justify-content-between">
                                        <div class="post-thumb">
                                            <a href="blog-single.html"><img src="assets/images/shop/05.jpg"
                                                    alt="product"></a>
                                        </div>
                                        <div class="post-content ps-3">
                                            <a href="blog-single.html">
                                                <h6>Organic Orange</h6>
                                            </a>
                                            <div class="rating">
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                                <span><a href="#"><i class="far fa-star"></i></a></span>
                                            </div>
                                            <h6>$59.9</h6>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </aside> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- shop page Section ENding Here -->

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