package com.demo.google.ce.linkedin.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        log("Saying hello");
        return "hello";
    }

    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLogin(@RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "state", required = false) String state) {
        log("Doing login: " + code + "," + state);
        return "login";
    }
    */

    private void log(Object o) {
        if (o == null)
            return;

        System.out.println(o.toString());
    }
}
