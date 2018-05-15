<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>登录</title>
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
		<!-- 提示消息 -->
		<div class="col-md-12" style="height: 100px;"></div>
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form method="post" action="../user/loginVerify">
				<h2 class="form-signin-heading text-center">用户登录</h2>
				<div class="form-group">
					<label for="userid">账号</label>
					<input type="text" class="form-control" name="userid" placeholder="账号">
				</div>
				<div class="form-group">
					<label for="password">密码</label>
					<input type="password" class="form-control" name="password" placeholder="密码">
				</div>
				<center>
					<button type="submit" class="btn btn-info">登录</button>
					<a href="../user/regist" class="btn btn-info" role="button">没有账号，去注册</a>
				</center>
				
			</form>
		</div>
	</body>

</html>