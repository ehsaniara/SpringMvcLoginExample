package com.exapot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ehsaniara
 * From https://www.ehsaniara.com
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hi from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value = "/hiAgain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hi Again, from Spring 4 MVC");
        return "welcome";
    }
}
