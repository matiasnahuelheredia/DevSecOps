package com.matiasheredia.javatest.model.exceptions;

import com.matiasheredia.javatest.model.entities.Message;

public class MessageValueFormatException extends RuntimeException {
    public static MessageValueFormatException of(Message message) {
        return new MessageValueFormatException(message);
    }

    public MessageValueFormatException(String customMessage) {
        super(customMessage);
    }

    private MessageValueFormatException(Message message) {
        super(String.format("Message %s Can't Contains illegal characters.",
                message.message()));
    }
}
