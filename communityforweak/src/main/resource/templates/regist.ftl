<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>注册</title>
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
	
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form method="post" action="/user/registVerify">
				<h2 class="form-signin-heading text-center">用户注册</h2>
				<div class="form-group">
					<label for="userid">账号</label>
					<input type="text" class="form-control" name="userid" placeholder="账号">
				</div>
				<div class="form-group">
					<label for="password">密码</label>
					<input type="password" class="form-control" name="password" placeholder="密码">
				</div>
				<div class="form-group">
					<label for="passwordRe">确认密码</label>
					<input type="password" class="form-control" name="passwordRe" placeholder="确认密码">
				</div>
				<div class="form-group">
					<label for="username">用户名</label>
					<input type="text" class="form-control" name="username" placeholder="用户名">
				</div>
				<div class="form-group">
					<label for="address">住址</label>
					<input type="text" class="form-control" name="address" placeholder="住址">
				</div>
				<div class="form-group">
					<label for="tel">联系方式</label>
					<input type="text" class="form-control" name="tel" placeholder="联系方式">
				</div>
				<center>
					<button type="submit" class="btn btn-info">注册</button>
					<a href="../user/login" class="btn btn-info" role="button">已有账号，去登录</a>
				</center>
				
			</form>
		</div>
	</body>

</html>