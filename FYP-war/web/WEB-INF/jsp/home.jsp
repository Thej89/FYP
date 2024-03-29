<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
    <script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/cufon-replace.js" type="text/javascript"></script> 
    <script src="js/superfish.js" type="text/javascript"></script>
    <script src="js/jquery.hoverIntent.js" type="text/javascript"></script>
    <script src="js/FF-cash.js" type="text/javascript"></script> 
    <script src="js/script.js" type="text/javascript"></script>   
    <script src="js/tms-0.3.js" type="text/javascript"></script>
    <script src="js/tms_presets.js" type="text/javascript"></script>
    <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
    <script src="js/jquery.color.js" type="text/javascript"></script>    
	<!--[if lt IE 7]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
        	<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
    </div>
	<![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
        <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
	<![endif]-->
</head>
<body id="page1">
	<!--==============================header=================================-->
    <header>
    	<div class="row-top">
        	<div class="main index">
            	<div class="container_24">
                	<div class="grid_24">
                    	<h1><a href="index.html">EasyContact</a></h1>
                        <nav class="fright">
                            <ul class="menu">
                                <li class="active"><a href="index.html"><strong>home</strong><span></span></a></li>
                                <li><a href="index-1.html"><strong>About us</strong><span></span></a></li>
                                <li><a href="index-2.html"><strong>partners</strong><span></span></a></li>
                                <li><a href="index-3.html"><strong>Services</strong><span></span></a>
                                	<ul>
                                    	<li><a href="#">support</a></li>
                                        <li><a href="#">tips</a></li>
                                        <li class="last-item"><a href="#">consulting</a>
                                        	<ul>
                                            	<li><a href="#">on-line</a></li>
                                                <li class="last-item"><a href="#">publications</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="index-4.html"><strong>Contacts</strong><span></span></a></li>
                                <li><a href="" onclick="logout();"><strong>Log out</strong><span></span></a></li>
                            </ul>
                        </nav>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="wrapper margin-top">
            <div class="slider-wrapper">
                <div class="slider">
                    <ul class="items">
                        <li>
                            <img src="images/1.jpg" alt="" />
                        </li>
                        <li>
                            <img src="images/2.jpg" alt="" />
                        </li>
                        <li>
                            <img src="images/picture3.jpg" alt="" />
                        </li>
                        <li>
                            <img src="images/picture2.jpg" alt="" />
                        </li>
                    </ul>
                </div>
                <ul class="main-list">
                	<li><a class="item-1" href="#">Backup <span>Contacts</span></a></li>
                    <li><a class="item-2" href="#">View <span>Contacts</span></a></li>
                    <li><a class="item-3" href="#"><strong>24/7</strong> <span>live support</span></a></li>
                </ul>
            </div>
        </div>
    </header>
    
	<!--==============================content================================-->
    <section id="content">
        <div class="main">
            <div class="container_24">
                <div class="wrapper p6">
                    <article class="grid_8">
                    	<h2>welcome!</h2>
                        <h5>Combining many years of real estate and financial experience, we offer a new model of property finance.</h5>
                        <span class="text-1">ummy hendrerit mauris lacusenean jaseras elportasce suscvarius cinaya natoqibe uertyas<br> kertya faesrta ertas. Magnis disient monteidi<br> culus musulla duiuscgiat malesuada odio.</span>
                    </article>
                    <article class="grid_8 spacer-1">
                    	<div class="indent">
                        	<h3>our news</h3>
                            <time class="tdate-1" datetime="2012-01-26"><a class="link" href="#">26.Jan.2012 Kertyas Miaserta</a></time>
                            <p class="text-2 img-indent-bot">adipiscing eliasraent veuole dasertyase ummy hendrerit mauris lacusenean jaseras elportasce suscvarius cinaya natoqibe uertyas kertya faesrta ertas.</p>
                            <a class="link-1" href="#">Read More<span></span></a>
                        </div>
                    </article>
                    <article class="grid_8 spacer-1">
                    	<div class="indent">
                        	<h3 class="prev-indent-bot">newsletter sign up</h3>
                            <p class="p2">Nulla duiuscat maluada odior nucora vidase nase magnonec accumsauada:</p>
                            <form id="newsletter-form">
                                <fieldset>
                                    <label>
                                        <input type="text" value="Enter Your e-mail" onFocus="if(this.value=='Enter Your e-mail'){this.value=''}" onBlur="if(this.value==''){this.value='Enter Your e-mail'}" />
                                    </label>
                                    <div class="buttons-wrap">
                                        <a href="#" class="button" onClick="document.getElementById('newsletter-form').submit()">Subscribe</a>
                                    </div>
                                    <a class="link-1" href="#">Unsubscribe<span></span></a>                                    
                                </fieldset>
                            </form>
                        </div>
                    </article>
                </div>
<!--                <div class="wrapper img-indent-bot">
                	<article class="grid_24">
                    	<div class="bg">
                        	<div class="indent-left">
                            	<h3 class="p0">popular articles</h3>
                            </div>
                        </div>
                    </article>
                </div>-->
<!--                <div class="wrapper">
                	<div class="grid_24">
                    	<div class="wrapper border-bot">
                        	<article class="grid_11 suffix_1 alpha">
                                <div class="wrapper">
                                    <figure class="img-indent"><img src="images/page1-img1.jpg" alt="" /></figure>
                                    <div class="extra-wrap">
                                        <div class="indent-top">
                                            <ul class="list-1">
                                                <li><a href="#">Praesent tibulumkertyade</a></li>
                                                <li><a href="#">Molestie lanorafertas lertyades</a></li>
                                                <li><a href="#">Ndrerit mauris ketdeisera</a></li>
                                                <li><a href="#">Phasellus porta</a></li>
                                                <li><a href="#">Fusce suscipit vari</a></li> 
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </article>
                            <article class="grid_11 suffix_1 omega">
                                <div class="wrapper">
                                    <figure class="img-indent"><img src="images/page1-img2.jpg" alt="" /></figure>
                                    <div class="extra-wrap">
                                        <div class="indent-top">
                                            <ul class="list-1">
                                                <li><a href="#">Fusce suscipit varias</a></li>
                                                <li><a href="#">Usiasera uocisa isera basertas</a></li>
                                                <li><a href="#">Natoque nertyades</a></li>
                                                <li><a href="#">Benatibus kertyaderas</a></li>
                                                <li><a href="#">Parturient montes</a></li> 
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </div>
                </div>-->
                <div class="wrapper p3">
                	<article class="grid_24">
                    	<div class="alignright">
                            <a class="link-2" href="#">View More Articles<span></span></a>
                        </div>
                    </article>
                </div>
                <div class="wrapper">
                	<article class="grid_24">
                    	<div class="wrapper border-bot2">
                        	<article class="grid_16 alpha">
                                <div class="box-1">
                                    <div class="padding">
                                        <h3>our Tips</h3>
                                        <div class="wrapper">
                                            <div class="col-1">
                                                <div class="wrapper">
                                                    <span class="numb ground-1 img-indent2">1</span>
                                                    <div class="extra-wrap">
                                                        <p class="text-3 prev-indent-bot">Bertase deleoisg stibulum cude enoserta kertyad sdenit maportade tase necsaes asrialorem. </p>
                                                        <a class="link-3" href="#">Read More<span></span></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-2">
                                                <div class="wrapper">
                                                    <span class="numb ground-2 img-indent2">2</span>
                                                    <div class="extra-wrap">
                                                        <p class="text-3 prev-indent-bot">Miasera eoapisg stibu bertya<br> dendrit menoserta kertyad saportade asrialore mtase necsaes. </p>
                                                        <a class="link-3" href="#">Read More<span></span></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </article>
                            <article class="grid_8 omega">
                                <div class="box-2">
                                    <div class="padding">
                                        <h3 class="p0">follow us</h3>
                                        <ul class="list-services">
                                            <li><a class="item-1" href="#">Masetyad berts</a></li>
                                            <li><a class="item-2" href="#">Kertya berrtyade rtaseras hertys</a></li>
                                            <li class="last-item"><a class="item-3" href="#">Nasera leroasera</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </article>
                </div>
            </div>
        </div>
    </section>
    
	<!--==============================footer=================================-->
    <footer>
        <div class="main">
        	<div class="wrapper">
            	<div class="container_24">
                	<div class="wrapper">
                    	<div class="grid_24">
                        	<div class="wrapper">
                            	<span class="footer-text">real estate &copy; 2012  |  <a href="index-5.html">Privacy policy<span></span></a></span>
                                <nav class="fright">
                                	<ul class="footer-menu">
                                    	<li><a class="active" href="index.html">Home<span></span></a></li>
                                        <li><a href="index-1.html">About us<span></span></a></li>
                                        <li><a href="index-2.html">Partners<span></span></a></li>
                                        <li><a href="index-3.html">Services<span></span></a></li>
                                        <li><a href="index-4.html">Contacts<span></span></a></li>
                                    </ul>
                                </nav>
                            </div>
                            <!-- {%FOOTER_LINK} -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <script type="text/javascript">
		$(window).load(function() {
			$('.slider')._TMS({
				duration:800,
				easing:'easeOutQuad',
				preset:'simpleFade',
				slideshow:7000,
				banners:false,
				pauseOnHover:true,
				pagination:true
			});
		});
    </script>
</body>
</html>
