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
		
		<!--提示消息-->
		<#if msg??>
			<h1>${msg}</h1>
		</#if>
		
		
		<!--服务分类--> 
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
				<a href="../activity/byPageAndClassify0">全部</a>
			</div>
			<ul id="classify" class="clay">
				<li id=""><a href="../activity/byPageAndClassify1">积分兑换</a></li>
				<li id=""><a href="../activity/byPageAndClassify2">线下集会</a></li>
				<li id=""><a href="../activity/byPageAndClassify3">闲置互换</a></li>
				<li id=""><a href="../activity/byPageAndClassify4">郊游踏青</a></li>
				<li id=""><a href="../activity/byPageAndClassify5">其他</a></li>
			</ul>
		</div>
		

		
		<div class="act">
			<#list pageResult.content as act>
				<div class="ract">
					<div class="img" id="">
						<img id="act2_img" src="/img/a.png">
					</div>
					<div class="disc" id="">
						<a id="act2_actname" href="">${act.activityname}</a>
						<div class="disca">
							<a id="act2_actdoc" href="">${act.document}</a>
							<button type="button" class="btn-v" id="act2_actid" actid=""><a href="../partakeActivity?userid=${Session.user.userid}&activityid=${act.id}&tel=${Session.user.tel}">报名</a></button>
						</div>

					</div>

				</div>
			<#else>
			<h1>暂无活动</h1></#list>
		</div>

		<div id="setpage">
		<#if classify??>
			<#import "pageShow.ftl" as page>
                <@page.pageShow pageResult.totalPages, pageResult.number, "../activity/byPageAndClassify" + classify, pageResult.size, "gray"/><br/>
		</#if>
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
