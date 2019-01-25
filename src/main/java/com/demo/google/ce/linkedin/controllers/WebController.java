/* 
  “Copyright 2018 Google LLC. This software is provided as-is, without warranty or representation for any use or purpose. Your use of it is subject to your agreements with Google.”

  Licensed to the Apache Software Foundation (ASF) under one
  or more contributor license agreements.  See the NOTICE file
  distributed with this work for additional information
  regarding copyright ownership.  The ASF licenses this file
  to you under the Apache License, Version 2.0 (the
  "License"); you may not use this file except in compliance
  with the License.  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

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
