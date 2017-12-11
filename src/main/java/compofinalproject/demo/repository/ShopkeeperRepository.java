package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Customer;
import compofinalproject.demo.entity.Shopkeeper;
import org.springframework.data.repository.CrudRepository;

public interface ShopkeeperRepository extends CrudRepository<Shopkeeper,Long> {
        Customer findById(Long id);
        }

