package com.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/")
    public String index() {
    	return "index";
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String get() {
    	return "get";
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String post() {
    	return "post";
    }

    @RequestMapping("/hello")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
