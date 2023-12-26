package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("")
public class TestController {


    @GetMapping(value = "/key-word")
    @ResponseBody
    public String test() {
        return "Salom Aslbek";
    }

    @GetMapping("/time")
    @ResponseBody
    public String time() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

}
