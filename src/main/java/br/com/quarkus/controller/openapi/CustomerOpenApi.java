package br.com.quarkus.controller.openapi;

import br.com.quarkus.entity.Customer;
import br.com.quarkus.payload.request.CustomerRequest;
import br.com.quarkus.payload.response.CustomerResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public interface CustomerOpenApi {

    @Operation(summary = "Returns all")
    @APIResponse(responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = Customer.class, type = SchemaType.ARRAY)))
    List<CustomerResponse> findPage(int page);

    @Operation(summary = "Update object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = CustomerRequest.class, type = SchemaType.OBJECT)))
    Response update(@PathParam("customerId") Long customerId,
                    @Valid CustomerRequest request);

    @Operation(summary = "Delete object")
    @APIResponse(responseCode = "204", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(type = SchemaType.INTEGER)))
    Response delete(@PathParam("id") Long id);
}
