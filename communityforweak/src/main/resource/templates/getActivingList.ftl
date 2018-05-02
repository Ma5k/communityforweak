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
		<table border="1" width="500px">
			<tr>
				<th width="50px">活动名</th>
				<th width="150px">活动描述</th>
				<th width="50px">操作</th>
			</tr>
			<#list data as act>
			<tr>
				<td>${act.activityname}</td>
				<td>${act.document}</td>
				<td><a href="../manager/activityAllUser?id=${act.id}">参与人员</a></td>
			</tr>
			</#list>
		</div> 

	</body>  
	</html>