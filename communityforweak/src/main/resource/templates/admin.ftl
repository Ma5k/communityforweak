<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>管理员</title>
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

		<!--左侧导航-->
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<div style="width: 200px;" class="btn-group-vertical" role="group" aria-label="Vertical button group">
					<h3 class="text-center">积分：${Session.user.score}</h3>
					<button type="button" class="btn btn-info" onclick="javascript:approvalUser()"><h4>审批用户</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:addActivity()"><h4>添加活动</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:actSign()"><h4>活动签到</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:giveScore()"><h4>发放积分</h4></button>
				</div>
			</div>
			<div class="col-md-7" style="height: 600px" id="viewDiv"></div>
		</div>
	</body>
	<script type="text/javascript">
		function approvalUser() {
			document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../manager/findAppUser" width="100%" height="100%"></object>';
		}
		function addActivity() {
			document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../activity/addActivity" width="100%" height="100%"></object>';
		}
		function actSign(){
			document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../activity/getActivingList" width="100%" height="100%"></object>';
		}
		function giveScore(){
			document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../manager/freeScorePage" width="100%" height="100%"></object>';
		}
	</script>

</html>