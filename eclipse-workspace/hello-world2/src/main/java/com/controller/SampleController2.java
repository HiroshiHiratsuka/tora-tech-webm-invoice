package com.controller;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

    @RequestMapping(value = "/aaa", method = GET)
    public String show() {
        // jsp�̃t�@�C����
        return "test2";
    }

}
