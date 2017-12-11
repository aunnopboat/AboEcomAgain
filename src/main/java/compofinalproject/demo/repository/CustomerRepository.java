package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long>  {
    Customer findById(Long id);
}
