<%--
  Created by IntelliJ IDEA.
  User: bigStone
  Date: 2019/5/6
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>poi主页</title>
    <script type="text/javascript">

       function exportt() {
           window.location.href = "${pageContext.request.contextPath}/stu/export.action";
       }

        function upload() {
            window.location.href = "${pageContext.request.contextPath}/import.jsp";
        }

    </script>
</head>
<body>

<h1>hello world</h1>

<button id="export" type="button" onclick="exportt()" >导出Excel</button>
<p>
    <button id="upload" type="button" onclick="upload()" >导入文件</button>
</p>

</body>
</html>
