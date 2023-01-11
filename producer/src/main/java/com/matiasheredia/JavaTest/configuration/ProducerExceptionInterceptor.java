package com.matiasheredia.JavaTest.configuration;

import com.google.common.collect.ImmutableMap;
import com.matiasheredia.JavaTest.model.Exceptions.ExceptionsSupported;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@ControllerAdvice(annotations = RestController.class)
public class ProducerExceptionInterceptor {
    @ExceptionHandler
    public ResponseEntity<Map<Object, Object>> processSupportedExceptions(Throwable throwable) {
        Optional<ResponseEntity<Map<Object, Object>>> supportedException = Arrays.stream(ExceptionsSupported.values())
                .filter(supportedEx -> hasSameClass(supportedEx, throwable))
                .map(this::createResponseEntityFromException)
                .findFirst();
        return supportedException.orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private Boolean hasSameClass(ExceptionsSupported exception, Throwable throwable) {
        return throwable.getClass().equals(exception.getExceptionClass());
    }

    private ResponseEntity<Map<Object, Object>> createResponseEntityFromException(ExceptionsSupported exception){
        Objects.requireNonNull(exception);
        return new ResponseEntity<>(ImmutableMap.builder()
                .put("status", exception.getStatus().value())
                .put("error", exception.getStatus().getReasonPhrase())
                .build(),
                exception.getStatus());
    }

}
