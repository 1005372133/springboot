package cn.wmyskxz.springboot.controller;

import cn.wmyskxz.springboot.pojo.Student;
import cn.wmyskxz.springboot.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@Controller
public class JumpController {
    /* @ApiOperation(value = "跳转layui")
     @RequestMapping(value = "/layui", method = RequestMethod.GET)
     public String layui() {
         return "layui";
     }*/
    @Autowired
    StudentService s1;

    @ApiOperation(value = "跳转layui1")
    @RequestMapping(value = "/layui", method = RequestMethod.GET)
    public String layui1() {
        return "layui1";
    }

    @ApiOperation(value = "跳转登陆")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @ApiOperation(value = "跳转登陆")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request,
                        @RequestParam @NotNull(message = "请输入账户") String username,
                        @RequestParam @NotNull(message = "请输入密码") String pwd,
                        @RequestParam(value = "isRememberMe", defaultValue = "false") Boolean isRememberMe,
                        String verifyCode) {


        Student student = s1.login(username,pwd);

        if (student != null) {

            if (student.getUsername().equals(username)){
                if (student.getPwd().equals(pwd)) {
                    return "layui1";
                }
        }
        }
        return "hello";

    }


}