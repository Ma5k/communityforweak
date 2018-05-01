<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="stylesheet" href="/css/regist.css">
	<link rel="stylesheet" href="/css/common.css">
	<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
	<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="/js/mustache.js"></script>
	<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<!-- 主体部分 -->
<body> 
<div class="mid">

<!--提示消息-->
		<#if msg??>
			<h1>${msg}</h1>
		</#if>
	<div id="login" class="mid">  
        <form method="get" action="/user/updateUserInfo">  
            <input readonly="readonly" class="input" type="text" required="required" placeholder="请输入账号" name="userid" value="${Session.user.userid}"/>  
            <input class="input" type="text" required="required" placeholder="请输入姓名" name="username" value="${Session.user.username}"/> 
            <input class="input" type="text" required="required" placeholder="请输入家庭地址" name="address" value="${Session.user.address}"/>
            <input class="input" type="text" required="required" placeholder="请输入联系方式" name="tel" value="${Session.user.tel}"/>
            <button class="btn" type="submit">修改</button>  
        </form>
    </div>
</div> 
      
</body>  
</html>