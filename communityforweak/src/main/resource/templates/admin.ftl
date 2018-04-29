<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/inter.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="js/history.js"></script>
		<script type="text/javascript" src="js/pagination/mricode.pagination.js"></script>
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
			<span id="">管理员${Session.user.id}</span>
		</div>
		<div class="time">
			<div class="time-title">个人积分</div>
			<div class="time-num" id="">${Session.user.score}</div>
		</div>
	</div>	
</div>

<!-- 主体部分 -->
<div class="userWrap">
	<div class="userWrap-left">
		<ul>
			<li><button type="button" class="btnn" id="btn" onClick="javascript:approvalUser();" >审批用户</button></li>
			<li><button type="button" class="btnn" id="btn" onClick="javascript:addActivity();" >添加活动</button></li>
			<li><button type="button" class="btnn" id="btn" onClick="javascript:actSign();" >活动签到</button></li>
			<li><button type="button" class="btnn" id="btn" onClick="javascript:giveScore();" >发放积分</button></li>
		</ul>
		
	</div>
	<div class="userWrap-right" id="viewDiv">
		
	</div>
</div>
<!-- 底部 -->
		<div class="footer">
			<div class="footer-text">
		湖北省武汉市亿维达信息科技 版权所有 鄂ICP备05000742号<br>
		地址：武汉市湖北经济学院大学创业园 邮编：430205 电话：1010111<br>
		Copyright&nbsp;&copy;&nbsp;2017-2027,CS.NET,All Rights Reserved<br>

	</div>
		</div>
<script type="text/javascript">
	function approvalUser() {
 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../manager/findAppUser" width="100%" height="100%"></object>';
   }
   function addActivity() {
 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../activity/addActivity" width="100%" height="100%"></object>';
   }
   function actSign() {
 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../activity/getActivingList" width="100%" height="100%"></object>';
   }
   function giveScore() {
 document.getElementById("viewDiv").innerHTML = '<object type="text/html" data="../manager/freeScorePage" width="100%" height="100%"></object>';
   }
</script>
</body>
</html>