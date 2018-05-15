<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>申请优待</title>
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
		<div class="col-md-4" style="width: 400px!important; margin: auto!important;">
			<form method="get" action="/user/appUserInfo">
				<h2 class="form-signin-heading">申请优待</h2>
				<div class="form-group">
					<label for="userid">账号</label>
					<input readonly="readonly" type="text" class="form-control" name="userid" placeholder="账号" value="${Session.user.userid}">
				</div>
				<div class="form-group">
					<label for="oldPwd">身份证号</label>
					<input type="text" class="form-control" name="idcard" placeholder="身份证号">
				</div>
				<button type="submit" class="btn btn-info">提交申请</button>
			</form>
		</div>
	</body>

</html>