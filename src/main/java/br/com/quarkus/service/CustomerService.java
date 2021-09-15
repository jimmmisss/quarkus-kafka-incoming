package br.com.quarkus.service;

import br.com.quarkus.entity.Customer;
import br.com.quarkus.payload.request.CustomerRequest;
import br.com.quarkus.payload.response.CustomerResponse;
import br.com.quarkus.repository.CustomerRepository;
import br.com.quarkus.service.mapper.CustomerMapper;
import io.smallrye.common.annotation.NonBlocking;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.quarkus.service.constants.Constants.CUSTOMER;
import static br.com.quarkus.service.constants.Constants.ENTITY_NOT_FOUND;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public List<CustomerResponse> findPage(int page) {
        var entities = repository.findPage(page);
        return entities.stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public CustomerResponse findCustomerById(Long customerId) {
        var optional = repository.findByIdOptional(customerId);
        return mapper.toResponse(optional.orElseThrow(() ->
                new NotFoundException(format(ENTITY_NOT_FOUND, CUSTOMER, customerId))));
    }

    @Incoming("customer-in")
    @NonBlocking
    @Transactional
    public void create(CustomerRequest request) {
        repository.persist(mapper.toEntity(request));
    }

    @Transactional
    public void update(Long personId, CustomerRequest request) {
        repository.persist(mapper.toUpdate(request, findCustomer(personId)));
    }

    @Transactional
    public void delete(Long id) {
        var optional = repository.findByIdOptional(id);
        optional.ifPresentOrElse(repository::delete, () -> {
            throw new NotFoundException(format(ENTITY_NOT_FOUND, CUSTOMER, id));
        });
    }

    private Customer findCustomer(Long customerId) {
        var optional = repository.findByIdOptional(customerId);
        return optional.orElseThrow(() -> new NotFoundException(format(ENTITY_NOT_FOUND, CUSTOMER, customerId)));
    }
}
