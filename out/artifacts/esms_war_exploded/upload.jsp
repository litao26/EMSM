<%--
  Created by IntelliJ IDEA.
  User: 20782
  Date: 2018/9/3
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="upload.do"   method="post"  enctype="multipart/form-data">
    账号:<input  type="text"  name="acc_no"> <br>
    头像:<input  type="file"  name="mf"> <br>
    <input  type="submit"  value="上传">
</form>
</body>
</html>
