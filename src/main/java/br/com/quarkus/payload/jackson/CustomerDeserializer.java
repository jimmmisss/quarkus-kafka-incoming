package br.com.quarkus.payload.jackson;

import br.com.quarkus.payload.request.CustomerRequest;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class CustomerDeserializer extends ObjectMapperDeserializer<CustomerRequest> {
    public CustomerDeserializer() {
        super(CustomerRequest.class);
    }
}