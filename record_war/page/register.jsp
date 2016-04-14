<%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/3/1
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>用户注册</title>
    <link href="../Wopop_files/style_log.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../Wopop_files/style.css" />
    <link rel="stylesheet" type="text/css" href="../Wopop_files/userpanel.css" />
    <link rel="stylesheet" type="text/css" href="../Wopop_files/jquery.ui.all.css" />
</head>
<!--body>
<form action="/Register.do" method="post">
    用户名:<input type="text" name="username" required/><br/>
    密码:<input type="password" name="password" required/><br/>
    性别:<input type="text" name="gender" required/><br>
    年龄:<input type="text" name="age" required/><br>
    出生所在地:<input type="text" name="birthPlace" required/><br>
    注册口令:<input type="text" name="userType" required/><br>
    <input type="submit" value="注册" />
</form>
</body-->
<body class="login">
<div class="login_m">
    <div class="login_logo" style="margin-top: 150px">
        <h3><font size = 6>四川话语音数据采集平台</font></h3>
    </div>
    <!--<div class="login_logo" style="margin-top: 10px">
        <h3><font size = 5>注册</font></h3>
    </div-->
    <div class="login_padding" id="login_model">
        <form action="/Register.do" method="post">
            <p><font size=3>用户名</font><input type="text" name="username" style="width:250px;height: 20px;margin-top: 5px;margin-bottom: 5px;" required/></p>
            <p><font size=3>密&nbsp;&nbsp;&nbsp;码</font>&nbsp;<input type="password" name="password" style="width:250px;height: 20px;margin-top: 5px;margin-bottom: 5px;" required/></p>
            <p><font size=3>性&nbsp;&nbsp;&nbsp;别</font>&nbsp;<!--input type="text" name="gender" style="width:250px;height: 20px;margin-top: 5px;margin-bottom: 5px;" required/-->
                <select name="gender">
                    <option value="male">男性</option>
                    <option value="female">女性</option>
                </select>
            </p>

            <p><font size=3>年&nbsp;&nbsp;&nbsp;龄</font>&nbsp;<input type="text" name="age" style="width:250px;height: 20px;margin-top: 5px;margin-bottom: 5px;" required/></p>
            <p><font size=3>籍&nbsp;&nbsp;&nbsp;贯</font>&nbsp;<!--input type="text" name="birthplace" style="width:250px;height: 20px;margin-top: 5px;margin-bottom: 5px;" required/-->
                <select name="birthplace">
                    <option value="成都">成都</option>
                    <option value="重庆">重庆</option>
                    <option value="乐山">乐山</option>
                    <option value="内江">内江</option>
                </select>
            </p>

            <!--p><font size=3>类&nbsp;&nbsp;&nbsp;型</font>&nbsp;<input type="text" name="usertype" style="width:250px;height: 20px;margin-top: 5px;margin-bottom: 5px;" required/></p-->
            <p style="padding-left: 48px;"><input type="submit" value="注册" style="font-family: microsoft yahei, Arial, Helvetica, sans-serif; font-size:20px; font-weight:normal;color: white;width:256px;height: 30px;margin-top: 5px;background-color: #1b66c7;border:0px;" /></p>
        </form>
    </div>


</div><!--login_m end-->
<br /> <br />
<p align="center">
    Copyright © 2016 Machine Intelligence Lab
</p>
<p align="center">
    All Rights Reserved
</p>
<p align="center">
    <a href="http://www.machineilab.org/" target="_blank" title="机器智能实验室">机器智能实验室</a>
</p>


</body>
</html>
