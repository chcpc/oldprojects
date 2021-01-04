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
<table>
<thead style="text-align: center;">
    <tr>
        <td>序号</td>
        <td>标题</td>
        <td>回复/查看</td>
        <td>发表时间</td>
        <td>最新回复</td>
    </tr>
</thead>
<tbody>
<c:forEach items="${pageInfo.list}" var="info">
    <tr>
    <td>${info.id}</td>
    <td><a href="<c:url value='/details?id=${info.id}'/>">${info.title}</a></td>
    <td>${info.replycount}/${info.viewcount}</td>
    <td><fmt:formatDate value="${info.reporttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td><fmt:formatDate value="${info.lastposttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    </tr>
</c:forEach>
</tbody>
</table>
<p>
    <a href="navi?currentPage=${pageInfo.navigateFirstPage}">首页</a>
    <c:if test="${pageInfo.hasPreviousPage}">
        <a href="navi?currentPage=${pageInfo.prePage}">上一页</a>
    </c:if>
    <c:if test="${!pageInfo.hasPreviousPage}">
        上一页
    </c:if>
    <c:if test="${pageInfo.hasNextPage}">
        <a href="navi?currentPage=${pageInfo.nextPage}">下一页</a>
    </c:if>
    <c:if test="${!pageInfo.hasNextPage}">
        下一页
    </c:if>
    <a href="navi?currentPage=${pageInfo.navigateLastPage}">尾页</a>
</p>
</body>
</html>
