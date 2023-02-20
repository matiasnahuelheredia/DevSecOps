package com.matiasheredia.javatest.model.validations;
import com.matiasheredia.javatest.model.entities.ImmutableMessage;
import com.matiasheredia.javatest.model.entities.Message;
import com.matiasheredia.javatest.model.exceptions.MessageEmailFormatException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class TestKafkaMessageValidation {

    private MessageValidation messageValidation;
    @Before
    public  void setup() {
        this.messageValidation = new KafkaMessageValidation();
    }
    private static final Message badMailMessage = ImmutableMessage.builder().message("").email("test test.com").build();
    @Test(expected = MessageEmailFormatException.class)
    public void testThatBadFormatEmailIsValidate() {
        this.messageValidation.validateMessage(badMailMessage);
    }
}
