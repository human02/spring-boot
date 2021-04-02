package com.aarav.one;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @RequestMapping("/test")
    @ResponseBody // This is required to return the string as an HTML.
    public String handleTest() {
        return "This is a successful test";
    }
}
