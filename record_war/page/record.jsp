<%--
  Created by IntelliJ IDEA.
  User: krumo
  Date: 2016/3/1
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>录音</title>
    <link href="../Wopop_files/style_log.css" rel="stylesheet"
          type="text/css" />
    <link rel="stylesheet" type="text/css" href="../Wopop_files/style.css" />
    <link rel="stylesheet" type="text/css"
          href="../Wopop_files/userpanel.css" />
    <link rel="stylesheet" type="text/css"
          href="../Wopop_files/jquery.ui.all.css" />

    <style type="text/css">
        fieldset { /*display:table-cell;*/ /*padding:10px;*/
            margin-right: 5px;
            margin: 0px auto;
            height: 50px;
            width: 300px;
        }

        p {
            margin: 0px auto;
        }

        legend {
            color: #303030;
            font-size: 20px;
            font-weight: 800;
            /*background:#fff;*/
        }
    </style>
</head>
<body class="login">
<div class="login_m">
    <center>
        <div class="login_logo" style="margin-top: 150px">
            <h3>
                <font size=6>四川话语音数据采集平台</font>
            </h3>
        </div>
        <a href="/page/personalSetting.jsp">个人设置</a>
        <div class="login_padding" id="login_model">
            <div>
                <fieldset>
                    <legend>
                        录音文本
                    </legend>
                    <div id="text2read">
                        <p>
                            文本显示区
                        </p>
                    </div>
                </fieldset>
            </div>
            <div style="margin-top: 10px; margin-bottom: 10px" align="middle" />
            <button id="previouss" style="width: 100px; height: 40px; font-weight: 800"
                    onclick="loadprevXMLDoc(this);">上一条</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button id="skip" style="width: 100px; height: 40px; font-weight: 800"
                    onclick="loadnextXMLDoc(this);">显示文本</button>
        </div>
        <div style="margin-top: 10px; margin-bottom: 10px" align="middle">
            <button id="nexts" style="width: 100px; height: 40px; font-weight: 800"
                    onclick="uploadandnext(this)">下一条</button>
        </div>
        <div style="margin-top: 10px; margin-bottom: 10px" align="middle">
            <button id="beginrec" style="width: 100px; height: 40px; font-weight: 800"
                    onclick="recordaudio(this);">开始录音</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <!--button id="stoprec" style="width: 100px; height: 40px; font-weight: 800"
                    onclick="stopRecording(this);">停止录音</button-->
        </div>
        <div style="margin-top: 10px; margin-bottom: 10px" align="middle">
            <ul id="recordingslist"></ul>
        </div>
    </center>

</div>
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

<script>
    function uploadandnext(button)
    {
        upload(button);
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("text2read").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","<%=path%>/Record.do?status=next&t="+Math.random(),true);
        xmlhttp.send(null);
    }
    function loadnextXMLDoc(button)
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("text2read").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","<%=path%>/Record.do?status=next&t="+Math.random(),true);
        xmlhttp.send(null);
        var skip=document.getElementById('skip');
        skip.innerHTML="跳过";
        beginrec.disabled=false;
        var previouss=document.getElementById('previouss');
        previouss.disabled=false;
        var nexts=document.getElementById('nexts');
        nexts.disabled=false;
    }
    function loadprevXMLDoc(button)
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("text2read").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","<%=path%>/Record.do?status=previous&t="+Math.random(),true);
        xmlhttp.send(null);
    }

    function __log(e, data) {
        //log.innerHTML += "\n" + e + " " + (data || '');
    }

    var audio_context;
    var recorder;
    var audioblob;
    var beginrec;
    var stoprec;
    var begin;

    function startUserMedia(stream) {
        var input = audio_context.createMediaStreamSource(stream);
        __log('Media stream created.');

        // Uncomment if you want the audio to feedback directly
        //input.connect(audio_context.destination);
        __log('Input connected to audio context destination.');

        recorder = new Recorder(input);
        __log('Recorder initialised.');
    }
    function recordaudio(button)
    {
        if(begin==1)
        {
            recorder.clear();
            recorder && recorder.record();
            beginrec.innerHTML="结束录音";
            begin=0;
        }
        else if(begin==0)
        {
            recorder && recorder.stop();
            createDownloadLink();
            beginrec.innerHTML="开始录音";
            begin=1;
        }
    }
    function startRecording(button) {
        recorder.clear();
        recorder && recorder.record();
        beginrec.disabled=true;
        stoprec.disabled=false;
        //button.disabled = true;
        //button.nextElementSibling.disabled = false;
        __log('Recording...');
    }

    function stopRecording(button) {
        recorder && recorder.stop();
        stoprec.disabled=true;
        beginrec.disabled=false;
        //button.disabled = true;
        //button.previousElementSibling.disabled = false;
        __log('Stopped recording.');
        // create WAV download link using audio data blob
        createDownloadLink();


    }
    function upload(button)
    {
        var formData = new FormData();
        var request = new XMLHttpRequest();
        formData.append("filee",audioblob);
        formData.append("status","upload");
        //request.open("POST", url, true);
        request.open("POST", "http://localhost:8080/Record.do");
        //request.responseType = audioblob;

        request.send(formData);

        recorder.clear();
        var reclist=document.getElementById('recordingslist');
        reclist.innerHTML="";
    }

    function createDownloadLink() {
        recorder && recorder.exportWAV(function(blob) {
            audioblob=blob;
         var url = URL.createObjectURL(blob);
         var li = document.createElement('li');
         var au = document.createElement('audio');
         //var hf = document.createElement('a');

         au.controls = true;
         au.src = url;
         //hf.href = url;
         //hf.download = new Date().toISOString() + '.wav';
         //hf.innerHTML = hf.download;
         li.appendChild(au);
         //li.appendChild(hf);
            var reclist=document.getElementById('recordingslist');
            reclist.appendChild(li);

        });
    }

    window.onload = function init() {
        try {
            // webkit shim
            window.AudioContext = window.AudioContext || window.webkitAudioContext;
            navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia;
            window.URL = window.URL || window.webkitURL;

            audio_context = new AudioContext;
            beginrec=document.getElementById('beginrec');
            stoprec=document.getElementById('stoprec');
            begin=1;
            beginrec.disabled=true;
            var previouss=document.getElementById('previouss');
            var nexts=document.getElementById('nexts');
            previouss.disabled=true;
            nexts.disabled=true;
            __log('Audio context set up.');
            __log('navigator.getUserMedia ' + (navigator.getUserMedia ? 'available.' : 'not present!'));
        } catch (e) {
            alert('No web audio support in this browser!');
        }

        navigator.getUserMedia({audio: true}, startUserMedia, function(e) {
            __log('No live audio input: ' + e);
        });
    };
</script>
<script src="../dist/recorder.js"></script>
</body>
</html>
