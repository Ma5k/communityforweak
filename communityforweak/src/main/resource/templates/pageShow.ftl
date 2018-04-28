<#-- 分页控件-->
<#-- 分页组件的使用 -->
<#--
pageShow 总页数, 当前页, 请求服务地址, 页面大小默认15, 显示最多分页个数, 请求服务地址参数默认为p, 分页样式（可选：gray（默认）、orange、blue）
<#import "pub/pageShow.ftl" as page>
<@page.pageShow pageCount, curPage, "pagePluginTest.do", pageSize, "blue"/>
-->
 
<#macro pageShow _totalPageNum _currentPageNo _pageName _pageSize=4 _styleClassName="gray" _maxShowNums=2 _defaultPageParameter="page" >
    <#-- 本段默认起始页 -->
    <#local _pageStartNo = 0/>
    <#-- 本段默认结束页 -->
    <#local _pageEndNo = _maxShowNums />
    <#-- 分页的第一页 -->
    <#local _firstPageNo = 0 />
    <#-- 分页的最后一页 -->
    <#local _lastPageNo = _totalPageNum-1>
    <#-- 前一页号码 -->
    <#local _prePageNo = _currentPageNo-1 />
    <#-- 后一页号码 -->
    <#local _nextPageNo = _currentPageNo+1 />
    
    <#if _currentPageNo == _pageStartNo>
        <#local _prePageNo = _pageStartNo />
    </#if>
    
    <#if _currentPageNo == _lastPageNo>
        <#local _nextPageNo = _lastPageNo />
    </#if>
    
    <#if _currentPageNo+1 gt _maxShowNums>
        <#local _thisPageSegment = ((_currentPageNo-1) / _maxShowNums)?int + 1/>
        <#assign _thisPageStartNo = _pageStartNo + (_thisPageSegment-1) * _maxShowNums/>
        <#assign _thisPageEndNo = _pageEndNo + (_thisPageSegment-1) * _maxShowNums/>
        <#if _thisPageEndNo gt _totalPageNum>
            <#assign _thisPageEndNo = _totalPageNum>
        </#if>
    <#else>
        <#assign _thisPageStartNo = _pageStartNo />
        <#assign _thisPageEndNo = _pageEndNo />
    </#if>
    
    <#-- 构造当前分页栏上面的分页按钮 -->
    <#local _pages=[] />
    <#if _totalPageNum != 0>
        <#list _thisPageStartNo .. _thisPageEndNo as _index>
            <#if _currentPageNo == _index >
                <#local _pages = _pages + [{"pageNum" : _index+1 ,"url" : _pageName+"?"+_defaultPageParameter+"="+_index , "current" : true}] />
            <#else>
                <#local _pages = _pages + [{"pageNum" : _index+1 ,"url" : _pageName+"?"+_defaultPageParameter+"="+_index , "current" : false}] />
            </#if>   
        </#list>
    </#if>
    
    <#-- 构造分页栏HTML代码 -->
    <#local _htmlNoLinkLine>
        <a href = "${_pageName}?${_defaultPageParameter}=${_firstPageNo}" target = "_self">首页</a>
        <#if _currentPageNo != _pageStartNo>
            <a href = "${_pageName}?${_defaultPageParameter}=${_prePageNo}" target = "_self">上一页</a>
        </#if>
        
        <#list _pages as page>
            <#if page.current?default(false)>
                <span class="current" >${page.pageNum}</span>
            <#else>
                <a href="${page.url}" mce_href="${page.url}" target="_self">${page.pageNum}</a>
            </#if>
        </#list>
        
        <#if _currentPageNo != _lastPageNo>
            <a href = "${_pageName}?${_defaultPageParameter}=${_nextPageNo}" target = "_self">下一页</a>
        </#if>
        <a href = "${_pageName}?${_defaultPageParameter}=${_lastPageNo}" target = "_self">末页</a>
        <span>共${_totalPageNum?default(0)}页</span>
    </#local>
    
    <!-- 将分页HTML代码放置到页面 -->
    <div class="${_styleClassName}">
        ${_htmlNoLinkLine}
    </div>
    
    <!-- 分页插件CSS -->
    <style type="text/css" mce_bogus="1">
        <#if _styleClassName == "gray">
        <#-- CSS gray style pagination -->
        div.gray {
            font-size: 12px;
            font-family: verdana, arial, helvetica, sans-serif;
            padding: 3px;
            margin: 3px;
            text-align: center;
            color:#999999;
        }
        div.gray a {
            border: #E1E2E3 1px solid;
            padding: 7px 14px;
            margin: 2px;
            color: #0000CC;
            text-decoration: none;
        }
        div.gray a:hover {
            border: #3388FF 1px solid;
            background: #F2F8FF;
        }
        div.gray a:active {
            color: #FF0000;
        }
        div.gray span.current {
            border: transparent 1px solid;
            font-weight: bold;
            margin: 2px;
            padding: 7px 14px;
            color: #333333;
        }
        </#if>
        <#if _styleClassName == "orange">
        <#-- CSS orange style pagination -->
        div.orange {
            font-size: 12px;
            font-family: verdana, arial, helvetica, sans-serif;
            padding: 3px;
            margin: 3px;
            text-align: center;
            color:#999999;
        }
        div.orange a {
            border: #DFDFDF 1px solid;
            padding: 7px 14px;
            margin: 2px;
            color: #3D3D3D;
            text-decoration: none;
        }
        div.orange a:hover {
            border: #FE4500 1px solid;
            background: transparent;
            color:#FE4500;
        }
        div.orange a:active {
            color: #FE4500;
        }
        div.orange span.current {
            border: #FF4400 1px solid;
            background: #FF4400;
            font-weight: bold;
            margin: 2px;
            padding: 7px 14px;
            color: #FFFFFF;
        }
        </#if>
        <#if _styleClassName == "blue">
        <#-- CSS blue style pagination -->
        div.blue {
            font-size: 12px;
            font-family: verdana, arial, helvetica, sans-serif;
            padding: 3px;
            margin: 3px;
            text-align: center;
            color:#999999;
        }
        div.blue a {
            border: #E1E2E3 1px solid;
            padding: 7px 14px;
            margin: 2px;
            color: #808080;
            text-decoration: none;
        }
        div.blue a:hover {
            border: #389CFF 1px solid;
            background: transparent;
            color:#389CFF;
        }
        div.blue a:active {
            color: #389CFF;
        }
        div.blue span.current {
            border: #389CFF 1px solid;
            background: #389CFF;
            font-weight: bold;
            margin: 2px;
            padding: 7px 14px;
            color: #FFFFFF;
        }
        </#if>
    </style>
</#macro>
