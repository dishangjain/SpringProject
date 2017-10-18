<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
	<head>
		<title>Travel-R bUddY</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Sidebar -->
			<section id="sidebar">
				<div class="inner">
					<nav>
						<ul>
							<li><a href="#intro">Welcome</a></li>
							<li><a href="#one">Login</a></li>
							<li><a href="#two">Sign Up</a></li>
							<li><a href="#three">Get in touch</a></li>
						</ul>
					</nav>
				</div>
			</section>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Intro -->
					<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>Travel-R bUddY</h1>
							<p>Global Luxurious Hotel experience at your Footstep <br />
							Regards to - <a href="http://www.talent.capgemini.com/in">Capgemini </a>.</p>
							<ul class="actions">
								<li><a href="#one" class="button scrolly">Explore</a></li>
							</ul>
						</div>
					</section>

				<!-- One -->
					<section id="one" class="wrapper style2 fullscreen spotlights">
						<section>
							<a href="#" class="image"><img src="images/hotel02.jpeg" alt="" data-position="10% 25%" /></a>
							<div class="content">
								<div class="inner">
									<h2>Login Here</h2>
									<p>Login with your credentials to explore the world of Travel-R bUddY</p>
									<ul class="actions">
										<li><a href="getLoginPage.obj" class="button">Login</a></li>
									</ul>
								</div>
							</div>
						</section>
						
					</section>

				<!-- Two -->
					<section id="two" class="wrapper style3 fade-up">
						<div class="inner">
							<h2>What we Provide ?</h2>
							<p>Travel-R bUddY is a group which provide you an access to world class Hotels around the Globe. Be a part to utilize-</p>
							<ul class="actions">
								<li><a href="getSignUpPage.obj" class="button">Sign Up</a></li>
							</ul>
							<div class="features">
								<section>
									<span class="icon major fa-diamond"></span>
									<h3>Seasonal Offers</h3>
									<p>We provide awesome offers in festive season as well as in other seasonal occations.</p>
								</section>
								<section>
									<span class="icon major fa-cog"></span>
									<h3>Quality at its Peak</h3>
									<p>We assure the quality of food, rooms, and other added features provided by Travel-R bUddY.</p>
								</section>
								<section>
									<span class="icon major fa-lock"></span>
									<h3>Security assured by us</h3>
									<p>We promise you a secure stay by our leading insurance agencies here at Travel-R bUddY.</p>
								</section>
								<section>
									<span class="icon major fa-chain"></span>
									<h3>Offers by our Partners</h3>
									<p>By getting in touch with us we provide you added benefits provided by our partners. Thats how Travel-R bUddY believes in serving.</p>
								</section>
								<section>
									<span class="icon major fa-code"></span>
									<h3>Hygiene and add ons</h3>
									<p>We assure you with nice Hygiene and hospitality provided separately by Travel-R bUddY apart from Hotel benefits.</p>
								</section>
								<section>
									<span class="icon major fa-desktop"></span>
									<h3>Partnership experience with Travel-R bUddY</h3>
									<p>Being our partner you get a lot of preveledges with your bonding period with Travel-R bUddY.</p>
								</section>
							</div>
							
						</div>
					</section>

				<!-- Three -->
					<section id="three" class="wrapper style1 fade-up">
						<div class="inner">
							<h2>Write to us</h2>
							<p>Opportunity to be a buddy of Travel-R bUddY.</p>
							<div class="split style1">
								<section>
									<form method="post" action="sendFeedback.obj">
										<div class="field half first">
											<label for="name">Name</label>
											<input type="text" name="name" id="name" pattern="[A-Za-z ]{3,30}" required="true" />
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input type="text" name="email" id="email"  pattern="[A-Za-z0-9._%+-]{1,18}@[a-z0-9.-]{1,7}\.[a-z]{2,3}$" required="true" />
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="5" max="50" required="true"></textarea>
										</div>
										<ul class="actions">
											<li><a href="" class="button submit">Send Message</a></li>
										</ul>
									</form>
								</section>
								<section>
									<ul class="contact">
										<li>
											<h3>Address</h3>
											<span>Travel-R bUddY <br />
											Twin Towers, Marine Lines, Mumbai 400059<br />
											INDIA</span>
										</li>
										<li>
											<h3>Email</h3>
											<a href="#">admin@travellerbuddy.com</a>
										</li>
										<li>
											<h3>Phone</h3>
											<span>(+91) 9898989898</span>
										</li>
										<li>
											<h3>Social</h3>
											<ul class="icons">
												<li><a href="#" class="fa-twitter"><span class="label">Twitter</span></a></li>
												<li><a href="#" class="fa-facebook"><span class="label">Facebook</span></a></li>
												<li><a href="#" class="fa-github"><span class="label">GitHub</span></a></li>
												<li><a href="#" class="fa-instagram"><span class="label">Instagram</span></a></li>
												<li><a href="#" class="fa-linkedin"><span class="label">LinkedIn</span></a></li>
											</ul>
										</li>
									</ul>
								</section>
							</div>
						</div>
					</section>

			</div>

		<!-- Footer -->
			<footer id="footer" class="wrapper style1-alt">
				<div class="inner">
					<ul class="menu">
						<li>&copy; Travel-R bUddY. All rights reserved.</li><li>Design: <a href="#">Travel-R bUddY</a></li>
					</ul>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>