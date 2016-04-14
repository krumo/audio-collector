<%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/3/1
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>四川话语音数据采集平台</title>
    <link href="./Wopop_files/style_log.css" rel="stylesheet"
          type="text/css" />
    <link rel="stylesheet" type="text/css" href="./Wopop_files/style.css" />
    <link rel="stylesheet" type="text/css"
          href="./Wopop_files/userpanel.css" />
    <link rel="stylesheet" type="text/css"
          href="./Wopop_files/jquery.ui.all.css" />
    <script type="text/javascript">
      function register()
      {
        document.LoginForm.action="/page/register.jsp";
        document.LoginForm.submit();
      }
    </script>
  </head>
  <!--body>
  <form action="Login.do" name="LoginForm" method="post">
    账户:<input type="text" name="username" required/><br/>
    密码:<input type="password" name="password" required/><br/>
    <input type="submit" value="登录" />
    <input type="submit" value="注册" onclick="register();"/>
  </form>
  </body-->
  <body class="login">
  <div class="login_m">
    <div class="login_logo" style="margin-top: 150px">
      <h3>
        <font size=6>四川话语音数据采集平台</font>
      </h3>
    </div>
    <div class="login_padding" id="login_model">

      <form action="Login.do" name="LoginForm" method="post">

        <center>
          <!--<p style="font-size: 18px">用户登录</p>-->
          <p>
            <input pattern="([a-z]|[A-Z])+[0-9]*" type="text" name="username"
                   align="middle"
                   style="width: 250px; height: 25px; margin-bottom: 5px; margin-top: 10px;"
                   placeholder="用户名（字母开头）" title="只支持以英文字符开头加数字的形式" required />
          </p>
          <p>
            <input type="password" name="password" align="middle"
                   style="width: 250px; height: 25px; margin-top: 5px; margin-bottom: 5px;"
                   placeholder="密   码（最多六位）" required />
          </p>
        </center>
        <div align="left"
             style="padding-left: 26px; margin-top: 0px; margin-bottom: 5px">
          <table>
            <tr>
              <td>
                <input type="checkbox" name="checkbox1" value="value1"
                       style="vertical-align: middle;" />
                自动登录
              </td>
              <td>
                <span style="font-size: 30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
              </td>
              <td>
                <!--a id="iforget" href="javascript:void(0);"><font
                        color=#1b66c7>忘记密码?</font> </a-->
              </td>
            </tr>
          </table>
        </div>
        <div style="padding-left: 27px;">
          <p>
            <input type="submit" value="登录" onclick="login();"
                   style="font-family: microsoft yahei, Arial, Helvetica, sans-serif; font-size: 18px; font-weight: normal; color: white; width: 256px; height: 30px; background-color: #1b66c7; border: 0px;" />
          </p>
          <!--input type="submit" value="注册" style="font-family: microsoft yahei, Arial, Helvetica, sans-serif; font-size:18px; font-weight:normal;color: #797979;width:60px;" onclick="register();"/-->
          <div align="right" style="padding-right: 25px; margin-top: 5px;">
            <a id="iregister" href="/page/register.jsp"><font
                    color=#1b66c7>我要注册</font> </a>
          </div>
        </div>
      </form>
    </div>
  </div>
  <!--login_m end-->
  <br />
  <br />
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
