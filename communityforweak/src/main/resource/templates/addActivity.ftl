<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>申请服务</title>
		<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
		<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
		<script src="/bootstrap/js/bootstrap.min.js"></script>
	</head>

	<body>
	<!--提示消息-->
		<#if msg??>
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
      <strong>${msg}</strong>
    </div>
		</#if>
		<!--提示消息-->
			<div style="width: 500px;">
				<form action="/addActivity" method="post">
					<h2 class="form-signin-heading">添加活动</h2>
					<div class="form-group">
						<label for="activityname">活动名称</label>
						<input type="text" class="form-control" name="activityname" placeholder="活动名称">
					</div>
					<div class="form-group">
						<label for="document">活动简介</label>
						<textarea class="form-control" rows="3" placeholder="活动简介" name="document"></textarea>
					</div>
					<div class="form-group">
						<label for="startime">开始时间</label>
						<input type="date" class="form-control" name="startime" placeholder="开始时间">
					</div>
					<div class="form-group">
						<label for="endtime">结束时间</label>
						<input type="date" class="form-control" name="endtime" placeholder="结束时间">
					</div>
					<div class="form-group">
						<label for="classify">活动类型</label>
						<select class="form-control" name="classify">
							<option value="1">积分兑换</option>
							<option value="2">线下集会</option>
							<option value="3">闲置互换</option>
							<option value="4">郊游踏青</option>
							<option value="5">其他</option>
						</select>
					</div>
					<div class="form-group">
						<label for="scoreadd">积分</label>
						<input type="number" class="form-control" name="scoreadd" value="5" placeholder="积分">
					</div>
					<button type="submit" class="btn btn-info">添加</button>
				</form>
			</div>
	</body>

</html>