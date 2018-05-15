<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>首页</title>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
		<script src="/bootstrap/js/bootstrap.min.js"></script>
	</head>

	<body>

		<!--导航栏-->
		<nav class="navbar navbar-default navbar-static-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="../index"><h4>社区服务中心</h4></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li>
							<a href="../activity/byPageAndClassify0"><h5>活动</h5></a>
						</li>
						<li>
							<a href="../server/byPageAndClassify0"><h5>服务</h5></a>
						</li>
						<li>
							<a href="../server/addService"><h5>申请服务</h5></a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="../user/personInfo"><h5>个人中心</h5></a>
						</li>
						<#if 0 == Session.user.permission>
						<li>
							<a href="../user/admin"><h5>管理员</h5></a>
						</li>
						</#if>
						<li>
							<a href="../user/logout"><h5>注销</h5></a>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
		<!--导航栏-->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner" style="height: 450px;">
				<div class="item active" style="color: #FDFDFD; height: 100%;background: url(/img/roll0.jpg);background-size: 100% 100%;">
					<br /><br /><br />
					<p class="text-center" style="font-size: 50px;">系统介绍 </p>
					<p class="text-center" style="font-size: 30px;">系统名：社区服务系统 </p>
					<p class="text-center" style="font-size: 30px;">用途：社区邻里之间相互提供帮助 </p>
					<p class="text-center" style="font-size: 30px;">发布社区活动信息</p>
					<p class="text-center" style="font-size: 30px;">让弱势群体有一个发布需求的平台</p>
				</div>
				<div class="item" style="height: 100%;background: url(/img/roll1.jpg);background-size: 100% 100%;">
					<br /><br /><br />
					<p class="text-center" style="font-size: 50px;">项目开发者</p>
					<p class="text-center" style="font-size: 30px;">姓名：王希文 </p>
					<p class="text-center" style="font-size: 30px;">学号：14150292 </p>
					<p class="text-center" style="font-size: 30px;">班级：软件Q1441</p>
					<p class="text-center" style="font-size: 30px;">指导老师：关培超</p>
				</div>
				<div class="item" style="color: #F5E79E; height: 100%;background: url(/img/roll2.jpg);background-size: 100% 100%;">
					<br /><br /><br />
					<p class="text-center" style="font-size: 50px;">系统技术 </p>
					<p class="text-center" style="font-size: 30px;">后台：Spring-Boot+Spring-Data</p>
					<p class="text-center" style="font-size: 30px;">前端：Freemarker+Bootstrap </p>
					<p class="text-center" style="font-size: 30px;">数据库：MySQL</p>
					<p class="text-center" style="font-size: 30px;">开发工具：Eclipse</p>
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
			</div>
		</div>
		

	</body>

</html>