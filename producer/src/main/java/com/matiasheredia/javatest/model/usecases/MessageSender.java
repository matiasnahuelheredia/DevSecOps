package com.matiasheredia.javatest.model.usecases;

import com.matiasheredia.javatest.model.entities.Message;

public interface MessageSender {
    public void sendAsyncMessage(Message message);
}
