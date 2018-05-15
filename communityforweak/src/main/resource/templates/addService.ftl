<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>申请服务</title>
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
		
<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>
		<!--提示消息-->
		
		<div class="row">
			<div class="col-md-3">

			</div>
			<div class="col-md-6">
				<form action="/appService" method="get">
					<h2 class="form-signin-heading">申请服务</h2>
					<h3>我的积分：${Session.user.score}</h3>
					<div class="form-group">
						<label for="userid">用户账号</label>
						<input readonly="readonly" class="form-control" name="userid" placeholder="账号" value="${Session.user.userid}">
					</div>
					<div class="form-group">
						<label for="servicename">服务名称</label>
						<input type="text" class="form-control" name="servicename" placeholder="服务名称">
					</div>
					<div class="form-group">
						<label for="ineed">服务需求</label>
						<textarea class="form-control" rows="3" placeholder="服务需求" name="ineed"></textarea>
					</div>
					<div class="form-group">
						<label for="startime">开始时间</label>
						<input type="date" class="form-control" name="startime" placeholder="开始时间">
					</div>
					<div class="form-group">
						<label for="endtime">结束时间</label>
						<input type="date" class="form-control" name="endtime" placeholder="结束时间">
					</div>
					<div class="form-group">
						<label for="classify">服务类型</label>
						<select class="form-control" name="classify">
							<option value="1">清洁</option>
							<option value="2">陪伴</option>
							<option value="3">医护</option>
							<option value="4">照看</option>
							<option value="5">其他</option>
						</select>
					</div>
					<div class="form-group">
						<label for="scoreadd">积分</label>
						<input type="number" class="form-control" name="scoreadd" min="0" value="5" placeholder="积分">
					</div>
					<div class="form-group">
						<label for="tel">联系方式</label>
						<input type="tel" class="form-control" name="tel" placeholder="联系方式" value="${Session.user.tel}">
					</div>
					<button type="submit" class="btn btn-info">申请</button>
				</form>
			</div>

		</div>

	</body>

</html>