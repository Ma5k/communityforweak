<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/user_acp.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
		<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script src="/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/history.js"></script>
		<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<body>

<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>

<div class="user_acp">
	<form class="acp" action="/addActivity" method="post">
		<ul>
			<li><span>活动名称</span> <input name="activityname" placeholder="活动名称" type="text"/></li>
		<li><span>活动简介</span> <textarea name="document" class="xuqiu"></textarea>
		<li><span>起止时间</span> <input name="startime" type="date"> 至 <input name="endtime" type="date"></li>
		</ul>
		<li><span>服务分类</span> <select name="classify">
		  <option value="1">积分兑换</option>
		  <option value="2">线下集会</option>
		  <option value="3">闲置互换</option>
		  <option value="4">郊游踏青</option>
		  <option value="5">其他</option>
		</select></li>
		<li><span>积  分 </span><input name="scoreadd" type="number"  value="0"></li>
		<input class="submit" type="submit" value="添加" />
	</form>
</div>


</body>
</html>