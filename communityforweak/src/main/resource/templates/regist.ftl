<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="stylesheet" href="/css/regist.css">
	<link rel="stylesheet" href="/css/common.css">
	<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
	<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/mustache.js"></script>
	<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<!-- 主体部分 -->
<body> 
<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>
<div class="mid">
	<div id="login" class="mid">  
        <span class="login">注  册</span>
        <form method="post" action="/user/registVerify">  
            <input class="input" type="text" required="required" placeholder="请输入账号" name="userid"/>  
            <input class="input" type="password" required="required" placeholder="请输入密码" name="password"/> 
            <input class="input" type="password" required="required" placeholder="请核对密码" name="passwordRe"/> 
            <input class="input" type="text" required="required" placeholder="请输入姓名" name="username"/> 
            <input class="input" type="text" required="required" placeholder="请输入家庭地址" name="address"/>
            <input class="input" type="text" required="required" placeholder="请输入联系方式" name="tel"/>
            <button class="btn" type="submit">注册</button>  
        </form>
        <a href="login">已有账号？去登陆</a>
    </div>
</div> 
      
</body>  
</html>