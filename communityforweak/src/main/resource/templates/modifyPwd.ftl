<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
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
			<form method="post" action="/user/modifyPwd">
				<h2 class="form-signin-heading">修改密码</h2>
				<div class="form-group">
					<label for="userid">账号</label>
					<input readonly="readonly" type="text" class="form-control" name="userid" placeholder="账号" value="${Session.user.userid}">
				</div>
				<div class="form-group">
					<label for="oldPwd">旧密码</label>
					<input type="password" class="form-control" name="oldPwd" placeholder="旧密码">
				</div>
				<div class="form-group">
					<label for="newPwd">新密码</label>
					<input type="password" class="form-control" name="newPwd" placeholder="新密码">
				</div>
				<div class="form-group">
					<label for="tel">确认密码</label>
					<input type="password" class="form-control" name="rePwd" placeholder="确认密码">
				</div>
				<button type="submit" class="btn btn-info">修改</button>
			</form>
		</div>
	</body>

</html>