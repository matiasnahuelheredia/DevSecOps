package com.matiasheredia.JavaTest.Infrastructure.Services;

import com.matiasheredia.JavaTest.model.Entities.Message;
import com.matiasheredia.JavaTest.model.UseCases.MessageSender;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderImpl implements MessageSender {
    @Override
    public void sendAsyncMessage(Message message) {

    }
}
