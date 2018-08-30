var tableUse,table;
layui.use('table', function () {
   table = layui.table;

    tableUser=table.render({
        elem: '#demo'
        , url: '/layui/table'
        , cellMinWidth: 80
        , cols: [[
            {type: 'checkbox'}
            , {field: 'id', width: 80, title: 'ID', sort: true}
            , {field: 'pwd', width: 80, title: '密码'}
            , {field: 'username', width: 80, title: '用户名', sort: true}
            , {field: 'age', width: 80, title: '年龄'}
            , {field: 'sex', title: '性别'}
            , {fixed: 'right', width: 150, align: 'center', toolbar: '#barDemo'}
        ]]
    });

    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            layer.msg('ID：' + data.id + ' 的查看操作');


        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                del(data.id);
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.alert('编辑行：<br>' + JSON.stringify(data))
        }
    });
});
function del(id){
    $.ajax({
        type: "DELETE",
        url: "/layui/table/del/"+id,
        /*data:delIds,*/
        dataType: "json",
        success:function (data) {
            if(data.ok){
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
    var fmsg=$("#userForm").serializeArray();
    var params ="{";
    for(var i in fmsg){
        params+="\""+ fmsg[i].name+"\":\""+fmsg[i].value+"\"" ;
        if(i<fmsg.length-1){params +=',';}
    }
    params += "}";
    $.ajax({
        url:"/layui/table/insert",
        type:"POST",
        data:params,
        contentType:"application/json; charset=UTF-8",
        success:function (data) {
            if(data.ok){
                layer.alert('成功！');
                $("#userForm")[0].reset();
                $('#createUserModal').modal('hide');
                tableUser.reload({page:{curr:1}});
            }else{
                layer.alert(data.message);
            }
        },
        error:function (data) {
            layer.alert('失败！');
        }

    })
}


