<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/common.css">
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<table class="table table-hover">
		<thead>

		</thead>
		<tbody>
			<#list pageResult.content as act>
			<tr>
				<div class="ract">
					<div class="img" id="">
						<img id="act2_img" src="/img/a.png">
					</div>
					<div class="disc" id="">
						<a id="act2_actname" href="">${act.activityname}</a>
						<div class="disca">
							<a id="act2_actdoc" href="">${act.document}</a>
							<button type="button" class="btn-v" id="act2_actid" actid=""><a href="http://www.baidu.com">报名</a></button>
						</div>

					</div>

				</div>
			</tr>
			<#else>
			<h1>暂无活动</h1></#list>
			<tr height="160px">  
            <td colspan="4" align="center">
                <!--
                pageShow 总页数, 当前页, 请求服务地址, 页面大小默认15, 显示最多分页个数, 请求服务地址参数默认为p, 分页样式（可选：gray（默认）、orange、blue）
                -->
				<!-- <p>总页数：${pageResult.totalPages},当前页：${pageResult.number}</p>-->                
				<#import "pageShow.ftl" as page>
                <@page.pageShow pageResult.totalPages, pageResult.number, "page", pageResult.size, "gray"/><br/>
                <@page.pageShow pageResult.totalPages, pageResult.number, "page", pageResult.size, "blue"/><br/>
                <@page.pageShow pageResult.totalPages, pageResult.number, "page", pageResult.size, "orange"/><br/>
            </td>  
        </tr>  
		</tbody>
	</table>

</body>
</html>
