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
    <link rel="stylesheet" href="../Wopop_files/css/bootstrap.min.css">
    <link rel="stylesheet" href="../Wopop_files/css/main.css">
    <link rel="stylesheet" href="../Wopop_files/css/record.css">
</head>

<body class="login">
<!--导航条-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <p><span>四川话 </span>语音数据采集平台</p>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <button class="iregister btn btn-info" onClick="personalset(this);" title="个人设置"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></button>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="login_m container">

    <img src="../Wopop_files/img_record.png" alt="img_record">

    <div class="login_padding" id="login_model">
        <div class="record_text">
            <div class="alert alert-info" role="alert" id="text2read">
                <p>文本显示区</p>
            </div>
        </div><!--record_text-->

        <div class="btn_group">
            <button id="previouss" onclick="loadprevXMLDoc(this);" class="btn btn-info" title="上一条"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;上一条</button>

            <button id="skip"onclick="loadskipXMLDoc(this);" class="btn btn-info" title="显示文本"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;显示文本</button>

            <button id="nexts" onclick="uploadandnext(this);" class="btn btn-info" title="下一条"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>&nbsp;下一条</button>

            <button id="beginrec" onclick="recordaudio(this);" class="btn btn-info" title="开始录音"><span class="glyphicon glyphicon-play" aria-hidden="true"></span>&nbsp;开始</button>

            <!--button id="beginrec" onclick="startRecording(this);" class="btn btn-info" title="开始录音"><span class="glyphicon glyphicon-play" aria-hidden="true"></span>&nbsp;开始</button>
            <button id="stoprec" onclick="stopRecording(this);" class="btn btn-info"  title="停止录音"><span class="glyphicon glyphicon-stop" aria-hidden="true"></span>&nbsp;停止</button-->
        </div>

        <div class="record_list">
            <ul id="recordingslist"></ul>
        </div><!--record_list-->

    </div><!--login_model-->
</div><!--login_m-->

<footer>
    <div class="container">
        <p>Copyright © 2016 Machine Intelligence Lab | All Rights Reserved
            <span><a href="http://www.machineilab.org/" target="_blank" title="机器智能实验室" class="link_lab">机器智能实验室</a></span>
        </p>
    </div>
</footer>

<script>
    function personalset(button)
    {
        loadprevXMLDoc(button);
        window.location.href='./personalSetting.jsp';
    }
    function uploadandnext(button)
    {
        var formData = new FormData();
        var request;
        if (window.XMLHttpRequest)
        {
            request=new XMLHttpRequest();
        }
        else
        {
            request=new ActiveXObject("Microsoft.XMLHTTP");
        }
        formData.append("filee",audioblob);
        formData.append("status","upload");
        request.onreadystatechange=function()
        {
            if (request.readyState==4 && request.status==200)
            {
                loadnextXMLDoc(button);
            }

        }
        request.open("POST", "<%=path%>/Record.do");
        request.send(formData);
        recorder.clear();
        var reclist=document.getElementById('recordingslist');
        reclist.innerHTML="";
    }
    function loadnextXMLDoc(button)
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
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
    function loadskipXMLDoc(button)
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("text2read").innerHTML=xmlhttp.responseText;
            }
        }
        if(display==0)
        {
            xmlhttp.open("GET","<%=path%>/Record.do?status=next&t="+Math.random(),true);
            display=1;
        }
        else
        {
            xmlhttp.open("GET","<%=path%>/Record.do?status=skip&t="+Math.random(),true);
        }
        xmlhttp.send(null);
        var skip=document.getElementById('skip');
        skip.innerHTML="跳过";
        beginrec.disabled=false;
        var previouss=document.getElementById('previouss');
        previouss.disabled=false;
        var nexts=document.getElementById('nexts');
        nexts.disabled=false;
        recorder.clear();
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
        recorder.clear();
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
    var display

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
            var skip=document.getElementById('skip');
            skip.disabled=true;
            var previouss=document.getElementById('previouss');
            previouss.disabled=true;
            var nexts=document.getElementById('nexts');
            nexts.disabled=true;
        }
        else if(begin==0)
        {
            recorder && recorder.stop();
            createDownloadLink();
            beginrec.innerHTML="开始录音";
            begin=1;
            var skip=document.getElementById('skip');
            skip.disabled=false;
            var previouss=document.getElementById('previouss');
            previouss.disabled=false;
            var nexts=document.getElementById('nexts');
            nexts.disabled=false;
        }
    }
    function startRecording(button) {

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
        request.open("POST", "<%=path%>/Record.do");
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
            display=0;
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
<script type="text/javascript" src="../Wopop_files/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../Wopop_files/bootstrap.min.js"></script>
</body>
</html>
