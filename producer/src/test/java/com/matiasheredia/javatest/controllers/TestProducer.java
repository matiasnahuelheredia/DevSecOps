package com.matiasheredia.javatest.controllers;
import com.matiasheredia.javatest.model.entities.ImmutableMessage;
import com.matiasheredia.javatest.model.entities.Message;
import com.matiasheredia.javatest.model.entities.MessageResponse;
import com.matiasheredia.javatest.model.exceptions.MessageEmailFormatException;
import com.matiasheredia.javatest.model.exceptions.MessageValueFormatException;
import com.matiasheredia.javatest.model.usecases.MessageSender;
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
            .message("OhAdAn6565kGBec7Tsu3lKQNmOdKHMp77gguh1u8WVq2afKGFmhAFW2NIfMaVcqTSFbbZdfeYZDANkneezzC6gaz1DxcdyKvpHlRzYh1QLPiwZkFe0aitzyPdlQvVY7sAtwvHBMAraphphI7rgMmWTUAtLT7UXtMRFOnP25Hf3UVQoiLMJz6joCqd7eTcodj1M4FWTG3jOMbkt7yQaudmtX3R5UB07iCHlS7dVfKgbNuEpbZ1btKH9xyDwGcxQM")
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
