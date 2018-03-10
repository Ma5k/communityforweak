<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Title</title>
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>

</head>
<body>
	<form action="../user/loginVerify" method="post">
		<p>
			ID: <input type="text" name="userid" id="uid" />
		</p>
		<p>
			password: <input type="password" name="password" id="pwd" />
		</p>
		<p>${msg}</p>
		<input type="submit" value="登录"/>
	</form>
</body>
<script>
/* $("#login").click(function(){
	var uid = $("#uid").val();
	var pwd = $("#pwd").val();
	
	$.ajax({
        type: "post",
        url: "../user/login",
        data: {
            id: uid,
            password: pwd
        },
        dataType: "TEXT",
        success: function(msg) {
        	if(msg=="登录成功"){
        		window.location.href="/spring/t"
        	}
        }
    });
}); */
</script>
</html>