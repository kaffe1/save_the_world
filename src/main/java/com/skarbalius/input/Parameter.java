package com.skarbalius.input;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FloatParameter.class, name = "parameters"),
        @JsonSubTypes.Type(value = IntegerParameter.class, name = "parameters")
})
public interface Parameter extends Serializable {
}
