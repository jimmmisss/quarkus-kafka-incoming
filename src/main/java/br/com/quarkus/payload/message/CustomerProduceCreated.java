package br.com.quarkus.payload.message;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.LocalDateTime.ofInstant;

@Data
public class CustomerProduceCreated {

    private Long id;
    private String name;
    private String lastname;
    private String document;

    private String sourceOrigin;
    private String action;
    private LocalDateTime instant = ofInstant(Instant.now(), ZoneId.systemDefault());
}
