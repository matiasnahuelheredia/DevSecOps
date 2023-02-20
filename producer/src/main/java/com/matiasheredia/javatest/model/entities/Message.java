package com.matiasheredia.javatest.model.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface Message {
    @JsonProperty("actualDate")
    @Value.Default
    @Nullable
    default Date actualDate() {
        return new Date();
    }

    @JsonProperty("email")
    public String email();
    @JsonProperty("message")
    public String message();

}
