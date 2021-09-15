package br.com.quarkus.service.mapper;

import br.com.quarkus.entity.Customer;
import br.com.quarkus.payload.request.CustomerRequest;
import br.com.quarkus.payload.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerResponse toResponse(Customer entity);

    Customer toEntity(CustomerRequest request);

    Customer toUpdate(CustomerRequest request, @MappingTarget Customer entity);
}
