<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/user_acp.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" type="text/css" href="/js/pagination/mricode.pagination.css"/>
		<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="/js/history.js"></script>
		<script type="text/javascript" src="/js/pagination/mricode.pagination.js"></script>
</head>
<body>

<div class="user_acp">
	<form class="acp" action="/addActivity" method="post">
		<ul>
			<li><span>活动名称</span> <input name="activityname" placeholder="活动名称" type="text"/></li>
		<li><span>活动简介</span> <textarea name="document" class="xuqiu"></textarea>
		<li><span>活动图片</span> <input type="file" name="image" placeholder="活动图片" type="text"/></li>
		<li><span>起止时间</span> <input name="startime" type="date"> 至 <input name="endtime" type="date"></li>
		</ul>
		<li><span>服务分类</span> <select name="classify">
		  <option value="1">积分兑换</option>
		  <option value="2">线下集会</option>
		  <option value="3">闲置互换</option>
		  <option value="4">郊游踏青</option>
		  <option value="5">其他</option>
		</select></li>
		<li><span>积  分 </span><input name="scoreadd" type="number" min="0" value="0"></li>
		<input class="submit" type="submit" value="添加" />
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