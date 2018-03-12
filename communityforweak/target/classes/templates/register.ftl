<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Title</title>
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>

</head>
<body>
	<form action="../user/registerVerify" method="post">
		<p>
			用户id: <input type="text" name="userid" id="userid" />
		</p>
		<p>
			密码: <input type="password" name="password" id="password" />
		</p>
		<p>
			确认密码: <input type="password" name="passwordRe" id="passwordRe" />
		</p>
		<p>
			姓名: <input type="text" name="username" id="username" />
		</p>
		<p>
			地址:<input type="text" name="address" id="address"/>
		</p>
		<p>
			电话:<input type="text" name="tel" id="tel"/>
		</p>
		<p>${msg}</p>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>