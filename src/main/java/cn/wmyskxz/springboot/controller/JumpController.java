package cn.wmyskxz.springboot.controller;

import cn.wmyskxz.springboot.pojo.Student;
import cn.wmyskxz.springboot.service.StudentService;
import cn.wmyskxz.springboot.util.Encodes;
import cn.wmyskxz.springboot.util.ResponseMessage;
import cn.wmyskxz.springboot.util.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;


@Controller
public class JumpController {

    @Autowired
    StudentService s1;


    @ApiOperation(value = "跳转layui")
    @RequestMapping(value = "/layui1", method = RequestMethod.GET)
    public String layui() {
        return "layui";
    }

    @ApiOperation(value = "跳转错误页面")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String error() {
        return "hello";
    }

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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage login(HttpServletRequest request,
                                 @RequestParam @NotNull(message = "请输入账户") String username,
                                 @RequestParam @NotNull(message = "请输入密码") String pwd) {

      /*  Subject subject = SecurityUtils.getSubject();
        SecurityUtils.getSubject().getSession().setTimeout(10000000);
        // 前台如果base64传输密文，则需要解码
//        password = new String(Encodes.decodeBase64(password));
        username = username.trim();
        pwd = pwd.trim();


        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, pwd.toCharArray());
        subject.login(usernamePasswordToken);


        return Result.success();*/



        username = username.trim();
        pwd = pwd.trim();
        Student student = s1.login(username, pwd);


        if (student != null) {

            if (student.getUsername().equals(username)) {
                if (student.getPwd().equals(pwd)) {
                    return Result.success(student);
                }
            }
        }
        return Result.error("登陆失败");

    }


            }