package com.matiasheredia.JavaTest.model.Exceptions;

import com.matiasheredia.JavaTest.model.Entities.Message;

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
