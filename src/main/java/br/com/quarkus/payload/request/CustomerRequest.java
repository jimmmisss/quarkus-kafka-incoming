package br.com.quarkus.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;
    @NotBlank(message = "Document is mandatory")
    private String document;
}
