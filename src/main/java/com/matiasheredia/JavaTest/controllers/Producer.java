package com.matiasheredia.JavaTest.controllers;

import com.matiasheredia.JavaTest.model.Entities.Message;
import com.matiasheredia.JavaTest.model.UseCases.MessageSender;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Producer {

    private final MessageSender messageSender;

    public Producer (MessageSender messageSender)
    {
        super();
        this.messageSender = messageSender;
    }
    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String index() {
        return "The Service Rest is Working";
    }

    @PostMapping(value = "/sendMessage")
    public void postMessage(@RequestBody Message message) {
        this.messageSender.sendAsyncMessage(message);
    }

}
