<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="stylesheet" href="/css/login.css">
	<link rel="stylesheet" href="/css/common.css">
	<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
	<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="/js/mustache.js"></script>
	<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>

<!-- 主体部分 -->
<body> 
<div class="mid">
	<div id="login" class="mid">  
        <span class="login">登  录</span>
        <form method="post" action="/user/loginVerify">  
            <input class="input" type="text" required="required" placeholder="用户名" name="userid"/>  
            <input class="input" type="password" required="required" placeholder="密码" name="password"/> 
            <button class="btn" type="submit">登录</button>  
        </form>
        <a href="/user/regist">没有账号？注册一个</a>
    </div>
</div> 

<script type="text/javascript">
error : function(error){
}
</script>

</body>  
</html>