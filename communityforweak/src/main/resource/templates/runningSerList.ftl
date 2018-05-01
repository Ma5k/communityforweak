<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="stylesheet" href="/css/regist.css">
	<link rel="stylesheet" href="/css/common.css">
	<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
	<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="/js/mustache.js"></script>
	<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<!-- 主体部分 -->
<body> 
<!--提示消息-->
		<#if msg??>
			<h1>${msg}</h1>
		</#if>

	<div class="mid">
		<table border="1">
			<tr>
				<th>活动名</th>
				<th>活动描述</th>
				<th>操作</th>
			</tr>
			<#list data as ser>
			<tr>
				<td>${ser.servname}</td>
				<td>${ser.ineed}</td>
				<td><a href="../server/getServerUserList?serverid=${ser.id}">结算</a></td>
			</tr>
			</#list>
		</div> 

	</body>  
	</html>