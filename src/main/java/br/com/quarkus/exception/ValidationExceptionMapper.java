package br.com.quarkus.exception;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static javax.ws.rs.core.Response.status;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Map<String, String> errors = getExtractExceptions(exception);
        return status(Response.Status.BAD_REQUEST).entity(errors).build();
    }

    private Map<String, String> getExtractExceptions(ConstraintViolationException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getConstraintViolations().forEach(i -> errors.put(
                lastFieldName(i.getPropertyPath().iterator()), i.getMessage()
        ));
        return errors;
    }

    private String lastFieldName(Iterator<Path.Node> nodes) {
        Path.Node last = null;
        while (nodes.hasNext()) {
            last = nodes.next();
        }
        return last.getName();
    }
}