<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>个人信息</title>
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
			<form method="get" action="/user/updateUserInfo">
				<h2 class="form-signin-heading">个人信息</h2>
				<div class="form-group">
					<label for="userid">账号</label>
					<input readonly="readonly" type="text" class="form-control" name="userid" placeholder="账号" value="${Session.user.userid}">
				</div>
				<div class="form-group">
					<label for="username">用户名</label>
					<input type="text" class="form-control" name="username" placeholder="用户名" value="${Session.user.username}">
				</div>
				<div class="form-group">
					<label for="address">地址</label>
					<input type="text" class="form-control" name="address" placeholder="地址" value="${Session.user.address}">
				</div>
				<div class="form-group">
					<label for="tel">联系方式</label>
					<input type="text" class="form-control" name="tel" placeholder="联系方式" value="${Session.user.tel}">
				</div>
				<button type="submit" class="btn btn-info">修改</button>
			</form>
		</div>
	</body>

</html>