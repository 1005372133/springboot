package cn.wmyskxz.springboot.controller;

import cn.wmyskxz.springboot.common.BaseController;
import cn.wmyskxz.springboot.common.LayUiResult;
import cn.wmyskxz.springboot.common.PageInfo;
import cn.wmyskxz.springboot.common.StudentPage;
import cn.wmyskxz.springboot.service.StudentService;
import cn.wmyskxz.springboot.util.ResponseMessage;
import cn.wmyskxz.springboot.util.Result;
import cn.wmyskxz.springboot.pojo.Student;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/layui")
public class StudentController extends BaseController<Student> {

    @Autowired
    StudentService s1;

    @ApiOperation(value = "获取layui表格")///layui/table11
    @RequestMapping(value = "/table",method =RequestMethod.GET )
    @ResponseBody
    public Map<String, Object> listStudent2() {

        List<Student> students = s1.findAll1();
        int counts = s1.count1();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("code", 0);
        map1.put("count", counts);
        map1.put("data", students);
        map1.put("msg", "获取数据成功");
        return map1;
    }


    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/table/del/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage<Student> del(@PathVariable int id){
        s1.del(id);
        return Result.success();
    }


    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/table/insert",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<Student> insert(@RequestBody Student student){
        s1.insert(student);
        return Result.success(student);
    }
    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/table/update",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseMessage<Student> update(@RequestBody Student student) throws Exception {
        s1.updateByPrimaryKey(student);
        return Result.success(student);
    }



    @ApiOperation(value = "|SysCorpEO|分页查询")
    @GetMapping("/table1")
    public LayUiResult<Student> page(StudentPage page) throws Exception {
        List<Student> rows = s1.queryByPage(page);
        PageInfo<Student> mapPage = getPageInfo(page.getPager(), rows);
        return new LayUiResult<Student>(mapPage);
    }


}
