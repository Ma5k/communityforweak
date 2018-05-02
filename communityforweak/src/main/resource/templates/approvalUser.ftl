<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="stylesheet" href="/css/regist.css">
	<link rel="stylesheet" href="/css/common.css">
	<link rel="stylesheet" href="/css/table.css">
	<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<!-- 主体部分 -->
<body> 

<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>

	<div class="mid">
		<table border="1">
			<tr>
				<th>账号</th>
				<th>用户名</th>
				<th>地址</th>
				<th>身份证号</th>
				<th>联系方式</th>
				<th>审批</th>
			</tr>
			<#list data as user>
			<tr>
				<td>${user.userid}</td>
				<td>${user.username}</td>
				<td>${user.address}</td>
				<td><#if user.idcard??>${user.idcard}<#else>该用户暂未填写身份证号</#if></td>
				<td>${user.tel}</td>
				<td><a href="../manager/AppUser?userid=${user.userid}&select=yes">是</a><a href="../manager/AppUser?userid=${user.userid}&select=no">否</a></td>
			</tr>
			</#list>
		</div> 

	</body>  
	</html>