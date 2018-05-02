<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/user_service.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
		<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script src="/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/history.js"></script>
		<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<body>
<div class="user_service">
<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>

<#list data as act>
	<div class="ract">
		<div class="img" id="">
			<img src="/img/a.png">
		</div>
		<div class="disc" id="">
			<a href="">${act.activityname}</a>
			<div class="disca">
			<a href="">${act.document}</a>
			<a href="">参与时间：2017年9月12日</a>
			</div>
		</div>
	</div>
</div>
<#else>
<h1>暂未参与过活动</#list>
</body>
</html>