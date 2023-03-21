package com.matiasheredia.javatest.infrastructure.services;
import com.matiasheredia.javatest.model.entities.Message;
import com.matiasheredia.javatest.model.usecases.MessageSender;
import com.matiasheredia.javatest.model.validations.MessageValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.stereotype.Component;

@Component
public class MessageKafkaSenderImpl implements MessageSender {

    private MessageValidation validation;

    private KafkaOperations<String,String> template;
    public MessageKafkaSenderImpl(MessageValidation validation,KafkaOperations<String,String> template){
        this.validation = validation;
        this.template = template;
    }

    @Override
    public void sendAsyncMessage(Message message) {
        this.validation.validateMessage(message);
        final String topic = "topico";
        this.template.send(topic,message.message());
    }
}
