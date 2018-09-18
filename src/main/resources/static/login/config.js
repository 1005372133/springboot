
/**
 * from 反序列化
 * @param form
 */
var formSerialize = {};
formSerialize.serializeForm = function(obj) {
    for(var p in obj){
        // 方法
        if(typeof(obj[p])=="function"){
            // obj[p]();
        }else{
            $("[name='"+p+"']").val(obj[p]);
            // p 为属性名称，obj[p]为对应属性的值

        }
    }
};

//反序列化 ：可指定某个form
$.fn.extend({
    //表单加载json对象数据
    setForm: function (jsonValue) {
        var obj = this;
        $.each(jsonValue, function (name, ival) {
            var $oinput = obj.find("input[name=" + name + "]");
            if ($oinput.attr("type") == "checkbox") {
                if (ival !== null) {
                    var checkboxObj = $("[name=" + name + "]");
                    var checkArray = ival.split(";");
                    for (var i = 0; i < checkboxObj.length; i++) {
                        for (var j = 0; j < checkArray.length; j++) {
                            if (checkboxObj[i].value == checkArray[j]) {
                                checkboxObj[i].click();
                            }
                        }
                    }
                }
            }
            else if ($oinput.attr("type") == "radio") {
                $oinput.each(function () {
                    var radioObj = $("[name=" + name + "]");
                    for (var i = 0; i < radioObj.length; i++) {
                        if (radioObj[i].value == ival) {
                            radioObj[i].click();
                        }
                    }
                });
            }
            else if ($oinput.attr("type") == "textarea") {
                obj.find("[name=" + name + "]").html(ival);
            }
            else {
                obj.find("[name=" + name + "]").val(ival);
            }
        })

    }
});

//表单序列化
formSerialize.serializeObject = function (form) {
    var o = {};
    $.each(form.serializeArray(), function (index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
};


/**
 * input 清空
 * @param input
 */
var inputEmptying = {};
inputEmptying.emptyingInput = function(formId) {
    $(formId + " :input").each(function() {
        var type = this.type;
        var tag = this.tagName.toLowerCase(); // normalize case
        if(type == 'text' || tag == 'textarea')
            this.value = "";
        // select 下拉框清空
        else if(tag == 'select')
            this.selectedIndex = -1;
    });
}





//var addr = $.trim(window.location.protocol + "//" + window.location.host+"/adc-da-main-1.0.0"), pageNo = 1, pageSize = 10,
var addr = $.trim(window.location.protocol + "//" + window.location.host), pageNo = 1, pageSize = 10,
    timestamp = (new Date).getTime();
var urltstamp = "_ts=" + timestamp;
var urladdr = "http://localhost";
/*var lanpath="../config/",language=$.cookie("lan");*/

/*
*  国际化
* */
/*
$('#language li').on('click',function () {
    language =$(this).attr('lan');
    $.cookie('lan',language);
    $("#language-button span").html(language);
});
function languages(path,fn) {
    $.i18n.properties({
        name : 'translate', //资源文件名称
        path : path+language, //'../languageprop/', //资源文件路径
        mode : 'map', //用Map的方式使用资源文件中的值
        language : language, //'en',
        callback : fn
    });
}
/!* layer成功提示 *!/
function sign(mes) {
    languages(lanpath,function(){
        layer.msg($.i18n.prop(mes), {time: 1100, icon:6 });
    })
};

languages(lanpath,function(){
    console.log(1)
   console.log($.i18n.prop("此项不能为空")) ;
   console.log(2)
    console.log($.i18n.prop("\u6b64\u9879\u4e0d\u80fd\u4e3a\u7a7a")) ;
})*/
