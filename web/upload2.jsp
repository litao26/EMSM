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
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        function  sendAJAX(){
            var  fdata = new FormData();
            fdata.append("acc_no",$("#acc_no").val());
            fdata.append("mf",$("#mf")[0].files[0]);
            $.ajax({
                url:"upload.do",
                type:"post",
                success:function(fname){
                    //alert(fname);
                    $("#mm").attr("src","datas/"+fname);
                },
                data:fdata,
                contentType:false,
                processData:false
            });
        }
    </script>
</head>
<body>

账号:<input  type="text"  name="acc_no" id="acc_no"> <br>
头像:<input  type="file"  name="mf"  id="mf"> <br>
<img   id="mm"  style="width: 400px"> <br>
<input  type="button"  value="上传"  onclick="sendAJAX()">
</form>
</body>
</html>
