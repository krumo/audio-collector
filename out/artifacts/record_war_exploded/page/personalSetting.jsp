<%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/3/1
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>个人设置</title>
    <link rel="stylesheet" href="../Wopop_files/css/bootstrap.min.css">
    <link rel="stylesheet" href="../Wopop_files/css/main.css">
    <link rel="stylesheet" href="../Wopop_files/css/register.css">
</head>
<!--body>
<a href="/page/record.jsp">返回录音</a>
<form action="/Person.do" method="post">
    用户名:<input type="text" name="username" required/><br/>
    密码:<input type="password" name="password" required/><br/>
    性别:<input type="text" name="gender" required/><br>
    年龄:<input type="text" name="age" required/><br>
    出生所在地:<input type="text" name="birthPlace" required/><br>
    <input type="submit" value="更新" />
</form>
</body-->
<body class="login">
<div class="myContainer">
    <!--导航条-->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <p><span>四川话 </span>语音数据采集平台</p>
                </a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <button class="iregister btn btn-info" onClick="javascript:window.location.href='./record.jsp'" title="返回录音"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span></button>
                </li>
            </ul>
        </div><!-- /.container-fluid -->
    </nav>

    <div class="login_m">
        <div class="login_logo">
            <h1>个人设置</h1>
        </div>
        <div class="login_padding" id="login_model">

            <!--<a href="/page/record.jsp">返回录音</a>-->

            <form action="../Person.do" method="post">
                <!--div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="用户名"required />
                </div>
                <div class="form-group">
                    <input type="password" name="username" class="form-control" placeholder="密码"required />
                </div>
                <div class="form-group">
                    <input type="text" name="gender" class="form-control" placeholder="性别"required />
                </div>
                <div class="form-group">
                    <input type="text" name="age" class="form-control" placeholder="年龄"required />
                </div>
                <div class="form-group">
                    <input type="text" name="birthplace" class="form-control" placeholder="籍贯"required />
                </div-->
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="请输入用户名（必须以字母开头）"required />
                </div>

                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="请输入密码（不超过六位）" />
                </div>

                <div class="form-group select_list">
                    <!--input type="text" name="age" class="form-control" placeholder="请输入年龄" required /-->
                    <span>年龄区间</span>
                    <select name="age">
                        <option value="0-5">0-5岁</option>
                        <option value="6-10">6-10岁</option>
                        <option value="11-15">11-15岁</option>
                        <option value="16-25">16-25岁</option>
                        <option value="21-25">21-25岁</option>
                        <option value="26-30">26-30岁</option>
                        <option value="31-35">31-35岁</option>
                        <option value="26-30">26-30岁</option>
                        <option value="31-35">31-35岁</option>
                        <option value="36-40">36-40岁</option>
                        <option value="41-45">41-45岁</option>
                        <option value="46-50">46-50岁</option>
                        <option value="51-55">51-55岁</option>
                        <option value="56-60">56-60岁</option>
                        <option value="61-65">61-65岁</option>
                        <option value="66-70">66-70岁</option>
                        <option value="71-75">71-75岁</option>
                        <option value="76-80">76-80岁</option>
                        <option value="81-85">81-85岁</option>
                        <option value="86-90">86-90岁</option>
                        <option value="91-95">91-95岁</option>

                    </select>
                </div>

                <div class="form-group select_list">
                    <span>性别</span>
                    <select name="gender">
                        <option value="male">男性</option>
                        <option value="female">女性</option>
                    </select>
                </div>

                <div class="form-group select_list">
                    <span>籍贯</span>
                    <select name="birthplace">
                        <option value="成都">成都</option>
                        <option value="重庆">重庆</option>
                        <option value="乐山">乐山</option>
                        <option value="内江">内江</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" value="更新" class="btn btn-info btn-signup" />
                </div>
            </form>
        </div>

    </div><!--login_m end-->

    <footer>
        <div class="container">
            <p>Copyright © 2016 Machine Intelligence Lab | All Rights Reserved
                <span><a href="http://www.machineilab.org/" target="_blank" title="机器智能实验室" class="link_lab">机器智能实验室</a></span>
            </p>
        </div>
    </footer>
</div>

<script type="text/javascript" src="../Wopop_files/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../Wopop_files/bootstrap.min.js"></script>
</body>
</html>
