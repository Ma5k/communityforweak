<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>个人中心</title>
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
					<button type="button" class="btn btn-info" onclick="javascript:load_usercenter()"><h4>个人信息</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:modifyPwd()"><h4>修改密码</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:userActivityList()"><h4>参与的活动</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:userServerList()"><h4>参与的服务</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:userAppServerList()"><h4>发起的服务</h4></button>
					<button type="button" class="btn btn-info" onclick="javascript:giveScore()"><h4>结算积分</h4></button>
					<#if Session.user.permission == 1>
					<button type="button" class="btn btn-info" onclick="javascript:appUserInfo();"><h4>申请优待</h4></button>
					</#if>
				</div>
			</div>
			<div class="col-md-7" style="height: 600px" id="viewDiv"></div>
		</div>
	</body>
	<script type="text/javascript">
		function load_usercenter() {
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../user/user_center" width="100%" height="100%"></object>';
	   }
	   function userAppServerList() {
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../server/userAppServerList?userid=${Session.user.userid}" width="100%" height="100%"></object>';
	   }
	   function userServerList() {
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../server/userServerList?userid=${Session.user.userid}" width="100%" height="100%"></object>';
	   }
	   function userActivityList() {
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../activity/userActivityList?userid=${Session.user.userid}" width="100%" height="100%"></object>';
	   }
	   function appUserInfo(){
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../user/user_pre" width="100%" height="100%"></object>';
	   }
	   function giveScore(){
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../server/runningSerList?userid=${Session.user.userid}" width="100%" height="100%"></object>';
	   }
	   function modifyPwd(){
		 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../user/modifyPwdPage" width="100%" height="100%"></object>';
	   }
	</script>

</html>