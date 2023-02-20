package com.matiasheredia.javatest.model.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;
@JsonSerialize
@Value.Immutable
public interface MessageResponse {
    public String status();
    public Optional<String> error();
}