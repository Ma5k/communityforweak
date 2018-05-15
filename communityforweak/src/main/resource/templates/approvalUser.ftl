<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>审批用户</title>
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
	
		<h3>已申请用户列表</h3>
		<div style="width: 700px;">
			<table class="table table-hover">
				<tr class="text-center">
					<th style="width: 200px;">账号</th>
					<th style="width: 150px;">用户名</th>
					<th style="width: 300px;">地址</th>
					<th style="width: 100px;">身份证号</th>
					<th style="width: 100px;">联系方式</th>
					<th style="width: 300px;">操作</th>
				</tr>
				<#list data as user>
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.address}</td>
					<td><#if user.idcard??>${user.idcard}<#else>该用户暂未填写身份证号</#if></td>
					<td>${user.tel}</td>
					<td>
						<a href="../manager/AppUser?userid=${user.userid}&select=yes" class="btn btn-info" role="button">是</a>
						<a href="../manager/AppUser?userid=${user.userid}&select=no" class="btn btn-info" role="button">否</a>
					</td>
				</tr>
				<#else>
				<tr>
					<td colspan="6">暂时无人申请</td>
				</tr>
				</#list>
			</table>
		</div>

	</body>

</html>