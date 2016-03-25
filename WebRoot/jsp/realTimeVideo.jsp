<%@ page language="java" import="java.io.*" contentType="text/html;charset=gb2312" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">   
<html xmlns="http://www.w3.org/1999/xhtml" >   
 <head>    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />   
    <script>   
    var itemId = 0;
    function getVLC(name)   
    {   
            if (window.document[name])      
            {   
                    return window.document[name];   
            }   
            if (navigator.appName.indexOf("Microsoft Internet")==-1)   
            {   
                    if (document.embeds && document.embeds[name])   
                            return document.embeds[name];      
            }   
            else   
            {   
                    return document.getElementById(name);   
            }   
    }   
      

    function doGoStream(){
        var vlc = getVLC("vlc");
        <% String dir = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/VIP.sdp"; %>

        var mrlS = "<%=dir%>";

    		itemId=vlc.playlist.add(mrlS);  
            vlc.playlist.playItem(itemId);   
            document.getElementById("btn_stop").disabled = false;  
    } 
      
    function updateVolume(deltaVol)   
    {   
            var vlc = getVLC("vlc");   
            vlc.audio.volume += deltaVol;   
    }   
      
    function doPlay()   
    {   
            vlc.playlist.playItem(itemId);   
               
            document.getElementById("btn_stop").disabled = false;   
            document.getElementById("btn_play").disabled = true;   
    }   
      
    function doStop()   
    {   
            getVLC("vlc").playlist.stop();   
            document.getElementById("btn_stop").disabled = true;   
            document.getElementById("btn_play").disabled = false;   
    }   
    </script>   
    </head>   
    <body>   
    <div style="margin: 50px">
            <a title="VIP.sdp" href="#" onclick="doGoStream();return false;">实时视频流</a>   
            <span style="margin: 20px;" />   
    </div>   
    <div>   
    <OBJECT classid="clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921" id="vlc"  
        codebase="http://download.videolan.org/pub/videolan/vlc/0.8.6c/win32/axvlc.cab"  
           width="600" height="480" id="vlc" events="True">  
     <param name="MRL" value="" />  
     <param name="Src" value="" />  
     <param name="ShowDisplay" value="True" />  
     <param name="AutoLoop" value="False" />  
     <param name="AutoPlay" value="False" />  
     <param name="Time" value="True"/>  
     <EMBED pluginspage="http://www.videolan.org"  
           type="application/x-vlc-plugin"  
           version="VideoLAN.VLCPlugin.2"  
           width="600"  
           height="480"      
           text="Waiting for video"  
           name="vlc"  
           ></EMBED>  
     </OBJECT>   
    </div>   
    <div>   
    <input type=button id="btn_play" value=" 播放 " onClick='doPlay();' disabled="true">   
    <input type=button id="btn_stop" value="停止" onClick='doStop();' disabled="true">   
    <input type=button value="静音切换" onclick='getVLC("vlc").audio.togglemute();'>   
    <input type=button value="减小音量" onclick='updateVolume(-10)'>   
    <input type=button value="增加音量" onclick='updateVolume(+10)'>   
    </div>   
    </body>   
    </html>  
