package com.example.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@CommonsLog
public class MainController {

    @RequestMapping("")
    @ResponseBody
    public  String main(){
        return "Hello, World";
    }

    @RequestMapping("/view")
    public String view(Model model){
        log.info("* view 메소드 실행 *");
        model.addAttribute("key", "하이");
        return "index";
    }
}