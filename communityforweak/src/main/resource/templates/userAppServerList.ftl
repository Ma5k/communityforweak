<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/user_service.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
		<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="/js/history.js"></script>
		<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<body>
<div class="user_service">
<#list data as ser>
	<div class="ract">
		<div class="img" id="">
			<img src="/img/a.png">
		</div>
		<div class="disc" id="">
			<a href="">${ser.servname}</a>
			<div class="disca">
			<a href="">${ser.ineed}</a>
			<a href="">参与时间：2017年9月12日</a>
			</div>
		</div>
	</div>
</div>
<#else>
<h1>暂未发起过服务请求</#list>
</body>
</html>