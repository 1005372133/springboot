package cn.wmyskxz.springboot.controller;

import cn.wmyskxz.springboot.common.BaseController;
import cn.wmyskxz.springboot.common.LayUiResult;
import cn.wmyskxz.springboot.common.PageInfo;
import cn.wmyskxz.springboot.common.StudentPage;
import cn.wmyskxz.springboot.service.StudentService;
import cn.wmyskxz.springboot.util.ResponseMessage;
import cn.wmyskxz.springboot.util.Result;
import cn.wmyskxz.springboot.pojo.Student;
import cn.wmyskxz.springboot.util.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/layui")
public class StudentController extends BaseController<Student> {

    @Autowired
    StudentService s1;

   /* @ApiOperation(value = "获取layui表格")//    /layui/table11
    @RequestMapping(value = "/table", method = RequestMethod.GET)
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
    }*/


    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/table/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage<Student> del(@PathVariable String id) {
        s1.del(id);
        return Result.success();
    }

    @ApiOperation(value = "批量删除")
    @RequestMapping(value = "/table/deleteList/{idList}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage<Student> delList(@NotNull @PathVariable("idList") String ids) {
        String resultIds = "";
        String[] idList = ids.split(",");
        if (idList != null && idList.length > 0) {
            for (String id : idList) {
                s1.del(id);
            }
        }
        return Result.success();
    }

    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/table/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<Student> insert(@RequestBody Student student) {
        s1.insert(student);
        return Result.success(student);
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/table/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseMessage<Student> update(@RequestBody Student student) throws Exception {
        s1.updateByPrimaryKey(student);
        return Result.success(student);
    }

    @ApiOperation(value = "|SysCorpEO|分页查询")
    @GetMapping("/table1")
    public LayUiResult<Student> page(StudentPage page) throws Exception {

        if (StringUtil.isNotEmpty(page.getId()) && !page.getId().trim().equals("")) {
            page.setIdOperator("LIKE");
            String id = page.getId();
            page.setId("%" + id + "%");
        } else {
            page.setId(null);
        }
        if (StringUtil.isNotEmpty(page.getUsername()) && !page.getUsername().trim().equals("")) {
            page.setUsernameOperator("LIKE");
            String Username = page.getUsername();
            page.setUsername("%" + Username + "%");
        } else {
            page.setUsername(null);
        }
        if (StringUtil.isNotEmpty(page.getAge()) && !page.getAge().trim().equals("")) {
            page.setAgeOperator("LIKE");
            String Age = page.getAge();
            page.setAge("%" + Age + "%");
        } else {
            page.setAge(null);
        }
        if (StringUtil.isNotEmpty(page.getSex()) && !page.getSex().trim().equals("")) {
            page.setSexOperator("LIKE");
            String Sex = page.getSex();
            page.setSex("%" + Sex + "%");
        } else {
            page.setSex(null);
        }
        List<Student> rows = s1.queryByPage(page);
        PageInfo<Student> mapPage = getPageInfo(page.getPager(), rows);
        return new LayUiResult<Student>(mapPage);
    }
}
