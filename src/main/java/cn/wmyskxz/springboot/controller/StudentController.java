package cn.wmyskxz.springboot.controller;

import cn.wmyskxz.springboot.mapper.StudentMapper;
import cn.wmyskxz.springboot.pojo.ResponseMessage;
import cn.wmyskxz.springboot.pojo.Result;
import cn.wmyskxz.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping(value = "/layui/table")
    @ResponseBody
    public Map<String, Object> listStudent2() {

        List<Student> students = studentMapper.findAll();
        int counts = studentMapper.count();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("code", 0);
        map1.put("count", counts);
        map1.put("data", students);
        map1.put("msg", "");
        return map1;
    }
    @RequestMapping(value = "/layui/table/del/{id}")
    @ResponseBody
    public ResponseMessage<Student> del(@PathVariable int id){
        studentMapper.del(id);
        return Result.success();
    }
}
