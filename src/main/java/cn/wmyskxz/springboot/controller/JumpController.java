package cn.wmyskxz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/layui")
    public String layui() {
        return "layui";
    }
    @RequestMapping("/layui1")
    public String layui1() {
        return "layui1";
    }
}