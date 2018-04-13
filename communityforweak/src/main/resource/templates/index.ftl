<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="/css/index.css">
		<link rel="stylesheet" href="/css/common.css">
		<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
		<!--顶部部分-->
		<div class="top">
			<div class="top-text">
				<img src="/img/serv.png" class="l logo1"/>
			  <ul class="top-title l">
				<li class="l"><a href="index">首 页</a></li>
				<li class="l"><a href="">活 动</a></li>
				<li class="l"><a href="">服 务</a></li>
				<li class="l"><a href="">申请服务</a></li>
				<li class="l"><a href="">我的参与</a></li>
			  </ul> 
			  
			  <div class="head-portrai r">
			  <button type="button" class="btn">
   				<img src="/img/icon-person.png" class="logo2"></button>
			  	<div class="people-name">
			  		<a id="login" href="">欢迎您！${Session.user.username}</a> <a href="/user/logout">注销</a>
			  	</div>

			  </div>

			</div>
		</div>
		<!--当前位置部分-->
		
		<div class="position">
			<ul class="position-text"> 
				<li class="l"><img src="/img/location.png" class="po-logo"/></li>
				<li class="l posi">当前位置 :</li>
				<li class="l ftp">首页</li>
				<li class="l ftp">/</li>
				<li class="l api">活动</li>
			</ul>
		</div>
		<!--服务分类--> 
		<div class="serve">
			<div class="serve-name l">
				<span>
					服务
				</span>
				<span>
					分类
				</span>
				
			</div>
			<div class="fon l">
				<a href="">全部</a>
			</div>
			<ul id="classify" class="clay">
				<li id="">服务分类一</li>
				<li id="">服务分类二</li>
				<li id="">服务分类三</li>
				<li id="">服务分类四</li>
				<li id="">服务分类五</li>
			</ul>
		</div>
		<div class="serve">
			<div class="serve-name l">
				<span>
					活动
				</span>
				<span>
					分类
				</span>
				
			</div>
			<div class="fon l">
				<a href="">全部</a>
			</div>
			<ul id="classify" class="clay">
				<li id="">活动分类一</li>
				<li id="">活动分类二</li>
				<li id="">活动分类三</li>
				<li id="">活动分类四</li>
				<li id="">活动分类五</li>
			</ul>
		</div>
		
		<!-- 分页 -->
		<!-- <div class="page">
			<span class="disabled_page">首页</span>
			<span class="disabled_page">上一页</span>
			<a href="#" class="text-page-tag">1</a>
			<a class="text-page-tag" href="#">2</a>
			<a class="text-page-tag" href="#">3</a>
			<a class="text-page-tag" href="#">4</a>
			<a class="text-page-tag" href="#">5</a>
			<a class="text-page-tag" href="#">6</a>
			<a class="text-page-tag" href="#">7</a>
			<a href="#">下一页</a>
			<a href="#">尾页</a>
		</div> -->
		
		<div class="act">
			<div class="lact" id="act1">
				<div class="img" id="">
					<img id="act1_img" src="/img/a.png">
				</div>
				<div class="disc" id="">
					<a id="act1_actname" href="">免费体检</a>
					<div class="disca">
					<a id="act1_actdoc" href="">详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述</a>
					<button type="button" class="btn-v" id="act1_actid" actid="">报名</button>
				</div>
				
				</div>
				
			</div>
			<div class="ract">
				<div class="img" id="">
					<img id="act2_img" src="/img/a.png">
				</div>
				<div class="disc" id="">
					<a id="act2_actname" href="">拔河比赛</a>
					<div class="disca">
					<a id="act2_actdoc" href="">详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述</a>
					<button type="button" class="btn-v" id="act2_actid" actid="">报名</button>
				</div>
				
				</div>
				
			</div>
			<div class="lact">
				<div class="img" id="">
					<img id="act3_img" src="/img/a.png">
				</div>
				<div class="disc" id="">
					<a id="act3_actname" href="">免费体检</a>
					<div class="disca">
					<a id="act3_actdoc" href="">详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述</a>
					<button type="button" class="btn-v" id="act3_actid" actid="">报名</button>
					</div>
				</div>
				
			</div>
			<div class="ract">
				<div class="img" id="">
					<img id="act4_img" src="/img/a.png">
				</div>
				<div class="disc" id="">
					<a id="act4_actname" href="">拔河比赛</a>
					<div class="disca">
					<a id="act4_actdoc" href="">详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述详细描述</a>
					<button type="button" class="btn-v" id="act4_actid" actid="">报名</button>
				</div>
				</div>
				
			</div>
		</div>

		<div id="setpage">
			<a href="#">首页</a>
			<a href="#">上一页</a>
			<a href="#">1</a>
			<a href="#">2</a>
			<a class="current" href="#">3</a>
			<a class="info" href="#">4</a>
			<a class="text-page-tag" href="#">5</a>
			<a class="text-page-tag" href="#">6</a>
			<a class="text-page-tag" href="#">7</a>
			<a href="#">下一页</a>
			<a href="#">尾页</a>

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
	
		<script type="text/javascript" src="/js/index.js"></script>
</html>
