package cn.wmyskxz.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JumpController {
    @ApiOperation(value = "跳转layui")
    @RequestMapping(value = "/layui", method = RequestMethod.GET)
    public String layui() {
        return "layui";
    }

    @ApiOperation(value = "跳转layui1")
    @RequestMapping(value = "/layui1", method = RequestMethod.GET)
    public String layui1() {
        return "layui1";
    }
}