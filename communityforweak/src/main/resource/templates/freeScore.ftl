<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>发放积分</title>
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
	
		<form action="../manager/freescore" method="get">
					<h2 class="form-signin-heading">发放积分</h2>
					<div class="form-group">
						<label for="score">积分</label>
						<input type="number" class="form-control" name="score" min="0" placeholder="积分">
					</div>
					
					<button type="submit" class="btn btn-info">发放</button>
				</form>

	</body>

</html>