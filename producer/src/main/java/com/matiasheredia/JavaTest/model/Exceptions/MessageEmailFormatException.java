package com.matiasheredia.JavaTest.model.Exceptions;

import com.matiasheredia.JavaTest.model.Entities.Message;

public class MessageEmailFormatException extends RuntimeException {
    public static MessageEmailFormatException of(Message message) {
        return new MessageEmailFormatException(message);
    }

    public MessageEmailFormatException(String customMessage) {
        super(customMessage);
    }

    private MessageEmailFormatException(Message message) {
        super(String.format("Message %s with email %s is considered Unformated or excesive Length.",
                message.message(),
                message.email()));
    }
}
