<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <%--<base href="${pageContext.request.contextPath }/">--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
</head>
<body>
<c:forEach items="${pageInfo.list}" var="standard">
    ${standard.zhname}<br/>
</c:forEach>
<p>
    <a href="list?currentPage=${pageInfo.navigateFirstPage}">首页</a>
    <c:if test="${pageInfo.hasPreviousPage}">
        <a href="list?currentPage=${pageInfo.prePage}">上一页</a>
    </c:if>
    <c:if test="${!pageInfo.hasPreviousPage}">
        上一页
    </c:if>
    <c:if test="${pageInfo.hasNextPage}">
        <a href="list?currentPage=${pageInfo.nextPage}">下一页</a>
    </c:if>
    <c:if test="${!pageInfo.hasNextPage}">
        下一页
    </c:if>
    <a href="list?currentPage=${pageInfo.navigateLastPage}">尾页</a>
</p>
</body>
</html>
