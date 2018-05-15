<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>进行中的服务列表</title>
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
		
		<h3>进行中的服务</h3>
		<table class="table table-hover">
				<tr class="text-center">
					<th style="width: 100px;">服务名称</th>
					<th style="width: 300px;">服务需求</th>
					<th style="width: 100px;">参于人员</th>
				</tr>
				<#list data as ser>
				<tr>
					<td>${ser.servname}</td>
					<td>${ser.ineed}</td>
					<td><a href="../server/getServerUserList?serverid=${ser.id}" class="btn btn-info" role="button">人员列表</a></td>
				</tr>
				<#else>
				<tr>
					<td colspan="4">没有进行中的服务</td>
				</tr>
				</#list>
			</table>
	</body>
</html>
