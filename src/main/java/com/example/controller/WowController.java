package com.example.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Seryang on 2016-08-12.
 */
@Controller
@CommonsLog
public class WowController {

    @RequestMapping("/hahaha")
    public String ha(Model model){
        log.info("* ha 메소드 실행 *");
        model.addAttribute("key", "하하하");
        return "index";
    }
}
