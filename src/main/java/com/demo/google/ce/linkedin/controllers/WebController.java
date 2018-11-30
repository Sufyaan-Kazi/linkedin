package com.demo.google.ce.linkedin.controllers;

import com.demo.google.ce.linkedin.domain.People;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    private OAuth2RestTemplate restTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name", required = false) final String name) {
        log("Saying hello: " + name);
        String url = null, resp = "No data returned";
        // url = "https://api.linkedin.com/v2/me";
        url = "https://api.linkedin.com/v1/people/~?format=json";
        log("TOKEN: " + restTemplate.getAccessToken());

        People obj = restTemplate.getForObject(url, People.class);
        if (obj != null) {
            log(obj.toString());
            resp = obj.toString();
        } else {
            log("got null object back");
        }

        return resp;
    }

    private void log(Object o) {
        if (o == null)
            return;

        System.out.println(o.toString());
    }
}
