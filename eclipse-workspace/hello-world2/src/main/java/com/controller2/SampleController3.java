package com.controller2;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController3 {

    @RequestMapping(value = "/ccc", method = GET)
    public String show() {
        // jsp‚Ìƒtƒ@ƒCƒ‹–¼
        return "sample";
    }
}
