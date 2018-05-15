<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>参与的服务</title>
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
	
		<h3>我参与的服务</h3>
		<div style="width: 700px;">
			<table class="table table-hover">
				<tr class="text-center">
					<th style="width: 200px;">图片</th>
					<th style="width: 100px;">服务名称</th>
					<th style="width: 300px;">服务需求</th>
					<th style="width: 100px;">积分</th>
				</tr>
				<#list data as ser>
				<tr>
					<td><img src="/img/server/${ser.classify}.jpg" class="img-rounded img-thumbnail"></td>
					<td>${ser.servname}</td>
					<td>${ser.ineed}</td>
					<td>${ser.scoreadd}</td>
				</tr>
				<#else>
				<tr>
					<td colspan="4">暂未参与过服务</td>
				</tr>
				</#list>
			</table>
		</div>

	</body>

</html>