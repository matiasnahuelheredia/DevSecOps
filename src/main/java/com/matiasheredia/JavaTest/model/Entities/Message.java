package com.matiasheredia.JavaTest.model.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import org.immutables.value.Value;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@Value.Immutable
public interface Message {
    @JsonProperty("Fecha actual")
    public Date actualDate();

    @JsonProperty("Email")
    public String email();
    @JsonProperty("Mensaje")
    public String message();

}
