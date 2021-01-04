<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <%--<base href="${pageContext.request.contextPath }/">--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
</head>
<body>
<p style="font-size: 24px;"><b></b></p>
<p>发表于：</p>
<div></div>
<p style="font-size: 20px;"><b></b></p>
<%--<c:forEach items="" var="">
    <div>发表于：<br/>
    </div>
</c:forEach>--%>
<p>快速回复(字数200字以内)：</p>
<form>
    <input type="hidden" name="infold" value=""/>
    <textarea name="content" cols="50" rows="6" type="text" placeholder="限200字以内"></textarea>
    <br/>
    <input type="submit" value="提交"/><a href="#">返回首页</a>
</form>
</body>
</html>
