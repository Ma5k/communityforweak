<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>活动</title>
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

		<!--标签选项-->
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<ul class="nav nav-pills">
					<li role="presentation">
						<a href="../activity/byPageAndClassify0"><strong>全部</strong></a>
					</li>
					<li role="presentation">
						<a href="../activity/byPageAndClassify1">积分兑换</a>
					</li>
					<li role="presentation">
						<a href="../activity/byPageAndClassify2">线下集会</a>
					</li>
					<li role="presentation">
						<a href="../activity/byPageAndClassify3">闲置互换</a>
					</li>
					<li role="presentation">
						<a href="../activity/byPageAndClassify4">郊游踏青</a>
					</li>
					<li role="presentation">
						<a href="../activity/byPageAndClassify5">其他</a>
					</li>
				</ul>
			</div>
		</div>
		<!--标签选项-->

		<!--显示内容-->
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<!--第一条-->
				<#if pageResult.content[0]??>
				<div class="panel panel-info" style="height: 200px;">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="text-left"><strong>${pageResult.content[0].activityname}</strong></span>|
							<span class="text-right">积分${pageResult.content[0].scoreadd}</span>|
							时间：<span>${pageResult.content[0].startime?date}</span>至
							<span>${pageResult.content[0].endtime?date}</span>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-5">
								<img src="/img/activity/${pageResult.content[0].classify}.jpg" class="img-rounded img-thumbnail">
							</div>
							<div class="col-md-7">
								<p>
									${pageResult.content[0].document}
								</p>
								<a href="../partakeActivity?userid=${Session.user.userid}&activityid=${pageResult.content[0].id}&tel=${Session.user.tel}" class="btn btn-info" role="button">报名</a>
							</div>
						</div>

					</div>
				</div>
				</#if>
				<!--第一条-->
			</div>
			<div class="col-md-5">
				<!--第二条-->
				<#if pageResult.content[1]??>
				<div class="panel panel-info" style="height: 200px;">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="text-left"><strong>${pageResult.content[1].activityname}</strong></span>|
							<span class="text-right">积分${pageResult.content[0].scoreadd}</span>|
							时间：<span>${pageResult.content[1].startime?date}</span>至
							<span>${pageResult.content[1].endtime?date}</span>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-5">
								<img src="/img/activity/${pageResult.content[1].classify}.jpg" class="img-rounded img-thumbnail">
							</div>
							<div class="col-md-7">
								<p>
									${pageResult.content[1].document}
								</p>
								<a href="../partakeActivity?userid=${Session.user.userid}&activityid=${pageResult.content[1].id}&tel=${Session.user.tel}" class="btn btn-info" role="button">报名</a>
							</div>
						</div>

					</div>
				</div>
				</#if>
				<!--第二条-->
			</div>
		</div>

		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<!--第三条-->
				<#if pageResult.content[2]??>
				<div class="panel panel-info" style="height: 200px;">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="text-left"><strong>${pageResult.content[2].activityname}</strong></span>|
							<span class="text-right">积分${pageResult.content[0].scoreadd}</span>|
							时间：<span>${pageResult.content[2].startime?date}</span>至
							<span>${pageResult.content[2].endtime?date}</span>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-5">
								<img src="/img/activity/${pageResult.content[2].classify}.jpg" class="img-rounded img-thumbnail">
							</div>
							<div class="col-md-7">
								<p>
									${pageResult.content[2].document}
								</p>
								<a href="../partakeActivity?userid=${Session.user.userid}&activityid=${pageResult.content[2].id}&tel=${Session.user.tel}" class="btn btn-info" role="button">报名</a>
							</div>
						</div>

					</div>
				</div>
				</#if>
				<!--第三条-->
			</div>
			<div class="col-md-5">
				<!--第四条-->
				<#if pageResult.content[3]??>
				<div class="panel panel-info" style="height: 200px;">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="text-left"><strong>${pageResult.content[3].activityname}</strong></span>|
							<span class="text-right">积分${pageResult.content[0].scoreadd}</span>|
							时间：<span>${pageResult.content[3].startime?date}</span>至
							<span>${pageResult.content[3].endtime?date}</span>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-5">
								<img src="/img/activity/${pageResult.content[3].classify}.jpg" class="img-rounded img-thumbnail">
							</div>
							<div class="col-md-7">
								<p>
									${pageResult.content[3].document}
								</p>
								<a href="../partakeActivity?userid=${Session.user.userid}&activityid=${pageResult.content[3].id}&tel=${Session.user.tel}" class="btn btn-info" role="button">报名</a>
							</div>
						</div>

					</div>
				</div>
				</#if>
				<!--第四条-->
			</div>
		</div>
		<!--显示内容-->

		<!--分页-->
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<#if classify??>
			<#import "pageShow.ftl" as page>
                <@page.pageShow pageResult.totalPages, pageResult.number, "../activity/byPageAndClassify" + classify, pageResult.size, "gray"/><br/>
		</#if>
		</div>
		<!--分页-->

		<!--底部版权信息-->
		
		<!--底部版权信息-->
	</body>

</html>