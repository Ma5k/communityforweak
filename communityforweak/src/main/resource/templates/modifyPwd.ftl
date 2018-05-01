<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title></title>
	
</head>

<!-- 主体部分 -->
<body> 

        <form method="post" action="/user/modifyPwd">  
        <table>
            <tr><td><input class="input" type="password" required="required" placeholder="旧密码" name="oldPwd"/></td></tr>  
            <tr><td><input class="input" type="password" required="required" placeholder="新密码" name="newPwd"/></td></tr> 
            <tr><td><input class="input" type="password" required="required" placeholder="确认密码" name="rePwd"/></td></tr> 
            <tr><td><button class="btn" type="submit">修改</button></td></tr>  
            
            </table>
        </form>
        <!--提示消息-->
		<#if msg??>
			<h1>${msg}</h1>
		</#if>

</body>  
</html>