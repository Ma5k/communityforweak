<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/user_acp.css">
		<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script src="/bootstrap/js/bootstrap.min.js"></script>
		
		
		<link rel="stylesheet" href="/css/index.css">
		<link rel="stylesheet" href="/css/common.css">
</head>
<body>
<!--顶部部分-->
		<div class="top">
			<div class="top-text">
				<img src="/img/serv.png" class="l logo1"/>
			  <ul class="top-title l">
				<li class="l"><a href="../activity/byPageAndClassify0">首 页</a></li>
				<li class="l"><a href="../activity/byPageAndClassify0">活 动</a></li>
				<li class="l"><a href="../server/byPageAndClassify0">服 务</a></li>
				<li class="l"><a href="../server/addService">申请服务</a></li>
				<#if 0 == Session.user.permission>
				<li class="l"><a href="../user/admin">管理员</a></li>
				</#if>
			  </ul> 
			  
			  <div class="head-portrai r">
			  <button type="button" class="btn">
   				<img src="/img/icon-person.png" class="logo2"></button>
			  	<div class="people-name">
			  		<a id="login" href="../user/personInfo">欢迎您！${Session.user.username}</a>
			  		 <a href="/user/logout">注销</a>
			  	</div>

			  </div>

			</div>
		</div>
<!-- 中间部分 -->
<div class="mid">
	<div class="midall">
		<div class="person">
			<button type="button" class="tx">
   				<img src="/img/a.png" class="logo2"></button>
			<span id="">${Session.user.userid}</span>
		</div>
		<div class="time">
			<div class="time-title">个人积分</div>
			<div class="time-num" id="">${Session.user.score}</div>
		</div>
	</div>	
</div>

<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>


<div class="user_acp">
	<form class="acp" action="/appService" method="get">
	 	<input readonly="readonly" type="hidden" name="userid" value="${Session.user.userid}"/>
		<ul>
			<li><span>服务名称</span> <input name="servicename" placeholder="服务名称" type="text"/></li>
		<li><span>服务需求</span> <textarea name="ineed" class="xuqiu"></textarea>
		<li><span>起止时间</span> <input name="startime" type="date"> 至 <input name="endtime" type="date"></li>
		</ul>
		<li><span>服务分类</span> <select name="classify">
		  <option value="1">清洁</option>
		  <option value="2">陪伴</option>
		  <option value="3">医护</option>
		  <option value="4">照看</option>
		  <option value="5">其他</option>
		</select></li>
		<li><span>积  分 </span><input name="scoreadd" type="number" min="0" value="5"></li>
		<li><span>联系电话</span> <input name="tel" type="tel" value="${Session.user.tel}"></li>
		<input class="submit" type="submit" value="申请" />
	</form>
</div>
<!-- 底部 -->
		<div class="footer">
			<div class="footer-text">
		湖北省武汉市亿维达信息科技 版权所有 鄂ICP备05000742号<br>
		地址：武汉市湖北经济学院大学创业园 邮编：430205 电话：1010111<br>
		Copyright&nbsp;&copy;&nbsp;2017-2027,CS.NET,All Rights Reserved<br>

	</div>
		</div>

</body>
</html>