<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath }/">
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <script type="text/javascript">

        function Format(datetime,fmt) {
            if (parseInt(datetime)==datetime) {
                if (datetime.length==10) {
                    datetime=parseInt(datetime)*1000;
                } else if(datetime.length==13) {
                    datetime=parseInt(datetime);
                }
            }
            datetime=new Date(datetime);
            var o = {
                "M+" : datetime.getMonth()+1,                 //月份
                "d+" : datetime.getDate(),                    //日
                "h+" : datetime.getHours(),                   //小时
                "m+" : datetime.getMinutes(),                 //分
                "s+" : datetime.getSeconds(),                 //秒
                "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
                "S"  : datetime.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            return fmt;
}
    </script>
</head>
<body>
<p style="font-size: 24px;"><b>${info.title}</b></p>
<p>发表于：<fmt:formatDate value="${info.reporttime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
<div>${info.content}</div>
<p style="font-size: 20px;"><b>读者回应：</b></p>
<c:forEach items="${lists}" var="replies">
    <div style="margin-bottom: 10px;">发表于：<fmt:formatDate value="${replies.replytime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
        ${replies.content}
    </div>
</c:forEach>
<p>快速回复(字数200字以内)：</p>
<form action="<c:url value='replies'/>" method="post">
    <input type="hidden" name="infold" value="${info.id}"/>
    <textarea name="content" cols="50" rows="6" type="text" placeholder="限200字以内"></textarea>
    <br/>
    <input type="submit" value="提交"/><a href="<c:url value='navi'/>">返回首页</a>
</form>
</body>
</html>
