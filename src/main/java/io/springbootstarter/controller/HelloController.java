package io.springbootstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // We use these annotation anytime we want to tell Springboot to treat these class a RestApi Controller
public class HelloController {

    /*These allows these class to map to url requests from our clients such as a mobile app
     * or a web client like a browser*/

    /**
     * The @RequestMapping annotation is only applicable for making GET requests by default
     * to map to other HTTP methods, you'll have to specify it directly in the annotation
     */

    @RequestMapping("/hello")
    public String sayHi() {
        return "Hi Kingsley, make some time out to sleep";
    }
}
