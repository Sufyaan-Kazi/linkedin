package com.demo.google.ce.linkedin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    private OAuth2RestOperations restTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        log("Saying hello");
        String url = "https://api.linkedin.com/v2/me";

        Object obj = restTemplate.getForObject(url, Object.class);
        if (obj != null) {
            log(obj.toString());
        } else {
            log("got null object back");
        }

        try {

            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
            log(e);
        }

        return "hello";
    }

    private void log(Object o) {
        if (o == null)
            return;

        System.out.println(o.toString());
    }
}
