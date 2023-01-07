package com.matiasheredia.JavaTest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

import static org.yaml.snakeyaml.tokens.Token.ID.Value;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Message {
    @JsonProperty("Fecha actual")
    public Date actualDate();

    @JsonProperty("Email")
    public String email();
    @JsonProperty("Mensaje")
    public String menssage();

}
