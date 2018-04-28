<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
</head>
<body>
id=${user.userid} <br />
<a href="/user/login">注销</a>
<#list a  as activity>  
  
      <tr>
        <td>${activity.id}</td>
        <td>${activity.activityname}</td>
        <td>${activity.document}</td>
    </tr>  
  
  </#list>   
</body>
</html>