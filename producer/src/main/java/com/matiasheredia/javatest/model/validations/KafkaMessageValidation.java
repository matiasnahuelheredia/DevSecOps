package com.matiasheredia.javatest.model.validations;

import com.matiasheredia.javatest.model.entities.Message;
import com.matiasheredia.javatest.model.exceptions.MessageEmailFormatException;
import com.matiasheredia.javatest.model.exceptions.MessageValueFormatException;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class KafkaMessageValidation implements MessageValidation{
    final static int MAX_EMAIL_LENGTH=50;
    final static int MAX_MSG_CHARACTERS_LENGTH=255;
    @Override
    public void validateMessage(Message message) {
        if(!this.isEmailFormatValid(message))       throw MessageEmailFormatException.of(message);
        if(this.isEmailLengthTooLarge(message))     throw MessageEmailFormatException.of(message);
        if (this.isMsgLengthTooLarge(message))      throw MessageValueFormatException.of(message);
    }

    private boolean isEmailFormatValid(Message message)
    {
        final String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern).matcher(message.email()).matches();
    }
    private boolean isEmailLengthTooLarge(Message message)
    {
        return message.email().length() > MAX_EMAIL_LENGTH;
    }

    private boolean isMsgLengthTooLarge(Message message)
    {
        return message.message().length() > MAX_MSG_CHARACTERS_LENGTH;
    }
}
