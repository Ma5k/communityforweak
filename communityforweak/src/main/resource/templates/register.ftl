<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="stylesheet" href="/css/regist.css">
	<link rel="stylesheet" href="/css/common.css">
</head>
<!-- 主体部分 -->
<body> 
<div class="mid">
	<div id="login" class="mid">  
        <span class="login">注  册</span>
        <form method="post" action="/user/registerVerify">  
            <input class="input" type="text" required="required" placeholder="请输入用户ID" name="userid"/>  
            <input class="input" type="password" required="required" placeholder="请输入密码" name="password"/> 
            <input class="input" type="password" required="required" placeholder="请核对密码" name="passwordRe"/> 
            <input class="input" type="text" required="required" placeholder="请输入姓名" name="username"/> 
            <input class="input" type="text" required="required" placeholder="请输入家庭地址" name="address"/>
            <input class="input" type="text" required="required" placeholder="请输入联系方式" name="tel"/>
            <button class="btn" type="submit">注册</button>  
        </form>
        <a href="/user/login">已有账号？去登陆</a>
    </div>
</div> 
      
</body>  
</html>