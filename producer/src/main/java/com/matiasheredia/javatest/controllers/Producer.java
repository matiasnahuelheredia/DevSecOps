package com.matiasheredia.javatest.controllers;
import com.matiasheredia.javatest.model.entities.ImmutableMessage;
import com.matiasheredia.javatest.model.entities.MessageResponse;
import com.matiasheredia.javatest.model.entities.ImmutableMessageResponse;
import com.matiasheredia.javatest.model.usecases.MessageSender;
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
