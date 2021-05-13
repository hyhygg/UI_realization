<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Multi Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Multi - v2.2.1
  * Template URL: https://bootstrapmade.com/multi-responsive-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

<%@ include file="Header.jsp" %>


    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact section-bg">
      <div class="container" >

        <div class="section-title">
          <h2>Contact</h2>
          <p></p>
          <p>리뷰 쓰기</p>
        </div>

        <div class="row">
          <div class="col-lg-6" style="height: 100%">
            <div class="row">
              <div class="col-md-12">
                <div class="info-box" ">
                    <div>
                      <img src="assets/img/portfolio/movie_image-1.jpg" 
                      class="img-thumbnail ri-image-2-fill" alt="">
                    </div>
                  <div style="margin-top: 10px;">
                    <input type="file">
                  </div>
                </div>
              </div>
              <!-- <div class="col-md-6">
                <div class="info-box mt-4">
                  <i class="bx bx-envelope"></i>
                  <h3>Email Us</h3>
                  <p>info@example.com<br>contact@example.com</p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="info-box mt-4">
                  <i class="bx bx-phone-call"></i>
                  <h3>Call Us</h3>
                  <p>+1 5589 55488 55<br>+1 6678 254445 41</p>
                </div>
              </div> -->
            </div>
          </div>


	<!-- 1번 문제 -->
          <div class="col-lg-6" style="height: 100%">
            <form action="write" method="post" role="form" class="php-email-form">
              <div class="form-row">
                <div class="col form-group">
                  <select class="form-control" name="genre">
                    <option value="한국영화">한국영화</option>
                    <option value="외국영화">외국영화</option>
                    <option value="잡담">잡담</option>
                    <div class="validate"></div>
                  </select>
                </div>
                <div class="col form-group">
                  <input type="text" class="form-control" value="writer" name="writer" id="title" placeholder="영화 이름" data-msg="Please enter a valid email" />
                  <div class="validate"></div>
                </div>
                <div class="col form-group">
                  <input type="text" class="form-control" value="title" name="title" id="genre" placeholder="영화 감독" data-msg="Please enter a valid email" />
                  <div class="validate"></div>
                </div>
              </div>
              <div class="form-group">
                <div>
                  <input type="text" class="form-control" value="userId" name="userId" id="userId" placeholder="제목" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                </div>
                <div class="validate"></div>
              </div>
              <div class="form-group">
                <textarea class="form-control" name="content" rows="10" data-rule="required" data-msg="Please write something for us" placeholder="글을 작성해주세요"></textarea>
                <div class="validate"></div>
              </div>
              <div class="mb-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit">글쓰기</button></div>
            </form>
          </div>

			<form method="post" action="write" id="topcontactform">
					<div class="form">
						<input type="text" name="genre" placeholder="아이디 *">
						<input type="text" name="title" placeholder="비밀번호 *">	
						<input type="text" name="content" placeholder="닉네임 *">
					    <input type="text" name="writer" placeholder="닉네임 *">	
					    <input type="text" name="userId" placeholder="닉네임 *">																																		
          				<input type="submit" class="clearfix btn" value="회원 등록">	
					</div>
		    </form>

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>

  <div id="preloader"></div>
  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>