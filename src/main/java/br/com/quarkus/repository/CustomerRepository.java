package br.com.quarkus.repository;

import br.com.quarkus.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> findPage(int page) {
        return find("FROM Customer")
                .page(page, 12)
                .list();
    }
}
