<%--
  Created by IntelliJ IDEA.
  User: bigStone
  Date: 2019/5/7
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/stu/import.action" method="post" enctype="multipart/form-data" >
    <p >指定文件名： <input type="text" name="filename" value= ""/></p >
    <p >上传文件： <input type="file" name="file"/></p>
    <input type="submit" value="上传/" />


</form>


</body>
</html>
