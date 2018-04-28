<!DOCTYPE html>
<html>
<head>
	<title>个人主页</title>
	<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/user_acp.css">
		<link rel="stylesheet" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="js/pagination/mricode.pagination.css"/>
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="js/history.js"></script>
		<script type="text/javascript" src="js/pagination/mricode.pagination.js"></script>
</head>
<body>
<div class="user_acp">
	<form class="acp">
		<ul>
			<li>服务名称 <input name="" type="text"/></li>
		<li>服务需求 <input class="xuqiu" name="" type="textarea"/></li>
		<li>起止时间 <input name="" type="datetime-local"> 至 <input name="" type="datetime-local"></li>
		</ul>
		<li>服务分类 <select>
		  <option value="volvo">Volvo</option>
		  <option value="saab">Saab</option>
		  <option value="opel">Opel</option>
		  <option value="audi">Audi</option>
		</select></li>
		<li>积  分  <input name="" type="number" min="0" value="5"></li>
		<li>联系电话 <input name="" type="tel"></li>
		<input class="submit" type="button" onclick="formSubmit()" value="申请" />
	</form>
</div>
<script type="text/javascript">
	function formSubmit()
{
document.getElementById("myForm").submit()
}
</script>
</body>
</html>