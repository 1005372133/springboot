package cn.wmyskxz.springboot.controller;

import cn.wmyskxz.springboot.service.StudentService;
import cn.wmyskxz.springboot.serviceImpl.StudentServiceImpl;
import cn.wmyskxz.springboot.util.ResponseMessage;
import cn.wmyskxz.springboot.util.Result;
import cn.wmyskxz.springboot.pojo.Student;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Resource
    StudentServiceImpl s1;

    @ApiOperation(value = "获取layui表格")
    @RequestMapping(value = "/layui/table",method =RequestMethod.GET )
    @ResponseBody
    public Map<String, Object> listStudent2() {

        List<Student> students = s1.findAll();
        int counts = s1.count();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("code", 0);
        map1.put("count", counts);
        map1.put("data", students);
        map1.put("msg", "获取数据成功");
        return map1;
    }
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/layui/table/del/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage<Student> del(@PathVariable int id){
        s1.del(id);
        return Result.success();
    }


/*    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/layui/table/insert",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<Student> insert(@RequestBody Student student){
        studentMapper.insert(student);
        return Result.success(student);
    }*/

}
