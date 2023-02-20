package com.matiasheredia.JavaTest.Infrastructure.Services;
import com.matiasheredia.JavaTest.model.Entities.Message;
import com.matiasheredia.JavaTest.model.Exceptions.MessageEmailFormatException;
import com.matiasheredia.JavaTest.model.Exceptions.MessageValueFormatException;
import com.matiasheredia.JavaTest.model.UseCases.MessageSender;
import com.matiasheredia.JavaTest.model.Validations.MessageValidation;
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
