package com.matiasheredia.javatest.Infrastructure.services;
import com.matiasheredia.javatest.model.entities.Message;
import com.matiasheredia.javatest.model.usecases.MessageSender;
import com.matiasheredia.javatest.model.validations.MessageValidation;
import org.springframework.stereotype.Component;

@Component
public class MessageKafkaSenderImpl implements MessageSender {

    private MessageValidation validation;
    public MessageKafkaSenderImpl(MessageValidation validation){
        this.validation = validation;
    }

    @Override
    public void sendAsyncMessage(Message message) {
        this.validation.validateMessage(message);
        //code Implementation code here
    }
}
