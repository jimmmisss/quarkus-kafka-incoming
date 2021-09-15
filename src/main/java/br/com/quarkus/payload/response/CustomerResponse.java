package br.com.quarkus.payload.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long id;
    private String name;
    private String lastname;
    private String document;
}
