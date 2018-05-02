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
				<th width="100px">用户账号</th>
				<th width="100px">用户名</th>
				<th width="60px">发放积分</th>
			</tr>
			<#list data as user>
			<tr>
				<td>${user.userid}</td>
				<td>${user.username}</td>
				<td><a href="../user/addScore?sessionUserid=${Session.user.userid}&serverid=${server.id}&userid=${user.userid}&score=${server.scoreadd}">参与人员</a></td>
			</tr>
			</#list>
		</div> 

	</body>  
	</html>