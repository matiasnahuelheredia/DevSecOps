package com.matiasheredia.JavaTest.controllers;
import com.matiasheredia.JavaTest.model.Entities.ImmutableMessage;
import com.matiasheredia.JavaTest.model.Entities.Message;
import com.matiasheredia.JavaTest.model.Entities.MessageResponse;
import com.matiasheredia.JavaTest.model.Exceptions.MessageEmailFormatException;
import com.matiasheredia.JavaTest.model.Exceptions.MessageValueFormatException;
import com.matiasheredia.JavaTest.model.UseCases.MessageSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doThrow;
@RunWith(MockitoJUnitRunner.class)
public class TestProducer {

    private Producer producerController;
    @Mock
    private MessageSender messageSender;

    private static Message regularMessage = ImmutableMessage.builder()
            .message("Hola, tu código de acceso es 1234.")
            .email("xxx@test.com")
            .build();
    private static Message badMailMessage = ImmutableMessage.builder()
            .message("Hola, tu código de acceso es 1234.")
            .email("xxxtest.com")
            .build();
    private static Message badLongMessage = ImmutableMessage.builder()
            .message("Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.Hola, tu código de acceso es 1234.")
            .email("xxx@test.com")
            .build();
    @Before
    public  void setup() {
        this.producerController = new Producer(messageSender);

    }

    @Test
    public void testThatMessageCanBeSend() {
        MessageResponse producerResponse = producerController.sendMessage((ImmutableMessage)regularMessage);
        assertNotNull(producerResponse);
        assertEquals(HttpStatus.OK.getReasonPhrase(), producerResponse.status());
    }

    @Test(expected = MessageEmailFormatException.class)
    public void testThatBadFormatEmailCannotBeSend() {
        doThrow(MessageEmailFormatException.of(badMailMessage))
                .when(messageSender)
                .sendAsyncMessage((ImmutableMessage)badMailMessage);
        producerController.sendMessage((ImmutableMessage)badMailMessage);
    }

    @Test(expected = MessageValueFormatException.class)
    public void testThatLongMessageCannotBeSend() {
        doThrow(MessageValueFormatException.of(badLongMessage))
                .when(messageSender)
                .sendAsyncMessage((ImmutableMessage)badLongMessage);
        producerController.sendMessage((ImmutableMessage)badLongMessage);
    }


}
