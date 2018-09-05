var tableUse, table;
layui.use('table', function () {
    table = layui.table;

    tableUser = table.render({
        elem: '#demo'
        , url: '/layui/table1'
        , cellMinWidth: 80
         ,request:{
            limitName:'pageSize',
            pageName:'page',
        }
        , cols: [[
            {type: 'checkbox'}
            , {field: 'id', width: 80, title: 'ID', sort: true}
            , {field: 'pwd', width: 80, title: '密码'}
            , {field: 'username', width: 80, title: '用户名', sort: true}
            , {field: 'age', width: 80, title: '年龄'}
            , {field: 'sex', title: '性别'}
            , {fixed: 'right', width: 150, align: 'center', toolbar: '#barDemo'}
        ]]
        , page: true
    });

    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            edit(data);
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                del(data.id);
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            updateRole(data);
        }
    });
});

function del(id) {
    $.ajax({
        type: "DELETE",
        url: "/layui/table/del/" + id,
        /*data:delIds,*/
        dataType: "json",
        success: function (data) {
            if (data.ok) {
                layer.alert("删除成功!");
                tableUser.reload({});
            }
        },
    });
}

layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
    //监听提交
    form.on('submit(userSubmit)', function (data) {
        submitUserAddData();
        return false;
    });
});

function submitUserAddData() {
    var type;
    var urlstr;
    var fmsg = $("#userForm").serializeArray();
    var params = "{";
    for (var i in fmsg) {
        params += "\"" + fmsg[i].name + "\":\"" + fmsg[i].value + "\"";
        if (i < fmsg.length - 1) {
            params += ',';
        }
    }
    params += "}";
    if ($("#type").val() == "ADD") {
        type = "POST";
        urlstr = "/layui/table/insert";
    } else {
        type = "PUT";
        urlstr = "/layui/table/update";
    }
    $.ajax({
        url: urlstr,
        type: type,
        data: params,
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            if (data.ok) {
                layer.alert('成功！');
                $("#userForm")[0].reset();
                $('#createUserModal').modal('hide');
                tableUser.reload({page: {curr: 1}});
            } else {
                layer.alert(data.message);
            }
        },
        error: function (data) {
            layer.alert('失败！');
        }

    })
}
function cleanSelectInfo(){
    $("#selectid").val("");
    $("#selectusername").val("");
    $("#selectage").val("");
    $("#selectsex").val("");
}//重置
function selectCorpPage(){
    var id=$.trim($("#selectid").val());
    var username=$.trim($("#selectusername").val());
    var age=$.trim($("#selectage").val());
    var sex=$.trim($("#selectsex").val());
    tableUser.reload(
        {where:{id:id,username:username,age:age,sex:sex},page:{curr:1}}
    );
}//查询


/*function exportExcel(){
    var checkStstus=table.checkStatus('corpTable'),data=checkStstus.data;
    var delIds = "";
    if(data.length > 0){
        for(var i=0;i<data.length;i++){
            delIds += data[i].id + ",";
        }
        delIds = delIds.substring(0, delIds.length-1);
            window.location.href=addr + '/api/sys/sysCorp/exportCorpExcelBusiness?ids=' + delIds;
    }else{
        layer.alert("请选择要导出的数据！");
        // $("#alertTips").modal('show');
    }

}
*/
/*
function deleteCorp() {
    layer.confirm('是否删除选中的', {
        btn: ['确认','取消'] //按钮
    }, function(){
        var checkStstus=table.checkStatus('corpTable'),data=checkStstus.data;
        var delIds = "";
        for(var i=0;i<data.length;i++){
            delIds+=data[i].id;
            if(i<data.length-1){delIds +=',';}
        }
        if(delIds.length>0){
            $.ajax({
                type: "DELETE",
                url: addr+"/api/sys/sysCorp/"+delIds,
                /!*data:delIds,*!/
                dataType: "json",
                success:function (result) {
                    if(result.ok){
                        layer.alert("删除"+pageText+"成功!");
                        corpTable.reload({});
                    }else{
                        if(result.respCode == "4869"){
                            var delMessage = "";
                            var errorIds = result.message.split(",");
                            for (var i = 0; i < data.length; i++) {
                                var delData = data[i];
                                for (var j = 0; j < errorIds.length; j++) {
                                    var errorId = errorIds[j];
                                    if(delData.id == errorId){
                                        delMessage += delData.corpName;
                                        delMessage += ",";
                                        break;
                                    }
                                }
                            }

                            if($("#corpType").val() == 0)
                                layer.alert(delMessage+"企业下有子部门，无法删除！");
                            else
                                layer.alert(delMessage+"使用方下有子部门，无法删除！");
                            corpTable.reload({});
                        }else
                            layer.alert(result.message);
                    }
                },error:function (result) {
                    layer.alert("删除"+pageText+"失败!");
                }
            });
        }else{
            layer.alert("请选择"+pageText+"!");
        }
    });
}*/

