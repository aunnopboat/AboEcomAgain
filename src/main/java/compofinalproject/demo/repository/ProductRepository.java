package compofinalproject.demo.repository;

import compofinalproject.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findById(Long id);
    List<Product> findByProductNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String searchProduct,String searchDes);
//    Product findByProductProductName(String productName);
}
