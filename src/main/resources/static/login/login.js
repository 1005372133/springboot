function login() {
    clearCookie();
    $.cookie('mycookie', "", {path: '/',expires: -1});
    //用户名密码输入后台交互操作
    /*var verifyCode = $.cookie('verifyCode') || 0;*/
    $("#loginMessageTip").text("");
    var pw =$("#pwd").val();
    var userName = $("#username").val();
    if(userName == null || userName == ""){
        $("#loginMessageTip").text("账号不能为空");
        return;
    } else if (userName.length > 30){
        $("#loginMessageTip").text("账号应为1-30位");
        return;
    }
    if(pw == null || pw == ""){
        $("#loginMessageTip").text("密码不能为空");
        return;
    } else if(pw.length < 6 || pw.length > 20){
        $("#loginMessageTip").text("密码应为6-20位");
        return;
    }
    var loding = layer.load(1, {shade: false});
    var params={
        "username": userName,
        "pwd": pw,
        "isRememberMe": false
    };
    var user = JSON.stringify(params);

    $.ajax({
        url:"/login?username="+userName+"&pwd="+pw,
        type:'GET',
        dataType:'json',
        success:function(data){
            layer.close(loding);
            if(1){
               /* var date = new Date();
                date = date.setTime(date.getTime()+30*60*60*1000);
                params["userid"]= data.data.usid;
                user = JSON.stringify(params);
                $.cookie('mycookie', user, {path: '/',expires: 1});
                layer.close(loding);*/
                window.location.href = "layui";
            }else if(data.respCode =="0002"){

            }else{
                $("#loginMessageTip").text(data.message);
            }

        },
        error: function(e) {
            layer.close(loding);
            $("#loginMessageTip").text("登录失败请重试!");
            console.log(e);
        }
    });

};

// base64加密开始
function encode64(input) {
    var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
        + "wxyz0123456789+/" + "=";
    var output = "";
    var chr1, chr2, chr3 = "";
    var enc1, enc2, enc3, enc4 = "";
    var i = 0;
    do {
        chr1 = input.charCodeAt(i++);
        chr2 = input.charCodeAt(i++);
        chr3 = input.charCodeAt(i++);
        enc1 = chr1 >> 2;
        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
        enc4 = chr3 & 63;
        if (isNaN(chr2)) {
            enc3 = enc4 = 64;
        } else if (isNaN(chr3)) {
            enc4 = 64;
        }
        output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
            + keyStr.charAt(enc3) + keyStr.charAt(enc4);
        chr1 = chr2 = chr3 = "";
        enc1 = enc2 = enc3 = enc4 = "";
    } while (i < input.length);

    return output;
}
// base64加密结束

/*var getvCode = function () {
    var oReq = new XMLHttpRequest();
    oReq.open("GET", addr + "/api/verifyCode?_ts="+timestamp, true);
    oReq.responseType = "blob";
    oReq.onreadystatechange = function () {
        if (oReq.readyState == oReq.DONE) {
            var blob = oReq.response;
            console.log(blob);
            document.getElementById("verifyimg").src = URL.createObjectURL(blob);
        }
    };
    oReq.send();
};*/
function clearCookie()
{
    var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
    if (keys)
    {
        for (var i = keys.length; i--;)
        {
            document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString();
        }
    }
}

function resetLoginInput(){
    $("#username").val("");
    $("#pwd").val("");
    $("#loginMessageTip").text("");
}
