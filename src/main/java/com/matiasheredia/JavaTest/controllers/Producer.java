package com.matiasheredia.JavaTest.controllers;

import com.matiasheredia.JavaTest.model.Entities.ImmutableMessageResponse;
import com.matiasheredia.JavaTest.model.Entities.Message;
import com.matiasheredia.JavaTest.model.Entities.ImmutableMessage;
import com.matiasheredia.JavaTest.model.Entities.MessageResponse;
import com.matiasheredia.JavaTest.model.UseCases.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Producer {

    private final MessageSender messageSender;
    @Autowired
    public Producer (MessageSender messageSender)
    {
        super();
        this.messageSender = messageSender;
    }
    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String index() {
        return "The Service RestFul Producer is Working";
    }

    @PostMapping(path = "/sendMessage")
    public MessageResponse sendMessage(@RequestBody ImmutableMessage message) {
        this.messageSender.sendAsyncMessage(message);
        return ImmutableMessageResponse.builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .build();
    }

}
