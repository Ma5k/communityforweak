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
<div class="mid">

<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>
	<div id="login" class="mid">  
        <form method="post" action="/user/modifyPwd">  
            <input class="input" type="password" required="required" placeholder="旧密码" name="oldPwd"/>
           <input class="input" type="password" required="required" placeholder="新密码" name="newPwd"/>
           <input class="input" type="password" required="required" placeholder="确认密码" name="rePwd"/>
            <button class="btn" type="submit">修改</button>  
        </form>
    </div>
</div> 
      
</body>  
</html>