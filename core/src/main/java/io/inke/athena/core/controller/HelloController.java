package io.inke.athena.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, Athena!!!";
    }

    /**
     * random generate exception
     *
     * @throws Exception exception info
     */
    private void randomException() throws Exception {
        Exception[] exceptions = {
                new NullPointerException(),
                new ArrayIndexOutOfBoundsException(),
                new NumberFormatException(),
                new SQLException(),
                new RuntimeException()
        };
        double probability = 0.75;
        if (Math.random() < probability) {
            // generate exception
            throw exceptions[(int) (Math.random() * exceptions.length)];
        } else {
            // do next
        }
    }

    @GetMapping("/exception")
    public String exception() throws Exception {
        randomException();
        return "SUCCESS";
    }

    @GetMapping("/param")
    public String param(@RequestParam String value) throws Exception {
        return value;
    }

}
