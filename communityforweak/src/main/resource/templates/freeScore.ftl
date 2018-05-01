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

<!--提示消息-->
		<#if msg??>
			<h1>${msg}</h1>
		</#if>

	<form class="acp" action="../manager/freescore" method="get">
			<li><span>积分</span> <input name="score" placeholder="积分" type="number"/></li>
		<input class="submit" type="submit" value="发放积分" />
	</form>
</div>

</body>
</html>