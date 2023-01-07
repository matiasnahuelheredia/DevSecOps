package com.matiasheredia.JavaTest.controllers;

import com.matiasheredia.JavaTest.model.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/")
public class Home {

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String index() {
        return "The Service Rest is Working";
    }

    @PostMapping(value = "/sendMessage")
    @ResponseBody
    public void postMessage(Message message) {
        //NOT IMPLEMENTED
    }

}
