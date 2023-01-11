package com.matiasheredia.JavaTest.model.UseCases;

import com.matiasheredia.JavaTest.model.Entities.Message;

public interface MessageSender {
    public void sendAsyncMessage(Message message);
}
