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
	
		<h3>进行中的活动</h3>
		<div style="width: 700px;">
			<table class="table table-hover">
				<tr class="text-center">
					<th style="width: 150px;">活动名称</th>
					<th style="width: 300px;">活动简介</th>
					<th style="width: 100px;">积分</th>
					<th style="width: 150px;">参与人员</th>
				</tr>
				<#list data as act>
				<tr>
					<td>${act.activityname}</td>
					<td>${act.document}</td>
					<td>${act.scoreadd}</td>
					<td>
						<a href="../manager/activityAllUser?id=${act.id}" class="btn btn-info" role="button">参与列表</a>
					</td>
				</tr>
				<#else>
				<tr>
					<td colspan="4">没有进行中的活动</td>
				</tr>
				</#list>
				
			</table>
		</div>

	</body>

</html>