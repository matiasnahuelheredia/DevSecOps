package com.matiasheredia.JavaTest.controllers;

import com.matiasheredia.JavaTest.model.Entities.ImmutableMessage;
import com.matiasheredia.JavaTest.model.Entities.Message;
import com.matiasheredia.JavaTest.model.Entities.MessageResponse;
import com.matiasheredia.JavaTest.model.UseCases.MessageSender;
import com.matiasheredia.JavaTest.controllers.Producer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.concurrent.ExecutorService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TestProducer {

    private Producer producerController;
    @Mock
    private MessageSender messageSender;

    private static Message regularMessage = ImmutableMessage.builder()
            .message("Hola, tu código de acceso es 1234.")
            .email("xxx@test.com")
            .actualDate(new Date())
            .build();
    @Before
    public  void setup() {
        this.producerController = new Producer(messageSender);
    }

    @Test
    public void testThatMessageCanBeSend() {
        MessageResponse producerResponse = producerController.sendMessage((ImmutableMessage)regularMessage);
        assertNotNull(producerResponse);
        assertEquals("OK", producerResponse.status());
    }


}
