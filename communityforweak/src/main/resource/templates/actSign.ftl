<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>活动签到</title>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
		<script src="/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>
		<!--提示消息-->
		<h3>参与人员</h3>
		<table class="table table-hover">
				<tr class="text-center">
					<th style="width: 100px;">用户账号</th>
					<th style="width: 300px;">用户名</th>
					<th style="width: 100px;">签到</th>
				</tr>
				<#list data as user>
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td><a href="../manager/attendance?userid=${user.userid}&activityid=${actId}" class="btn btn-info" role="button">已到</a></td>
				</tr>
				<#else>
				<tr>
					<td colspan="3">该活动无人报名</td>
				</tr>
				</#list>
			</table>
	</body>
</html>
