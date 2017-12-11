package compofinalproject.demo.dao;

import com.google.common.collect.Lists;
import compofinalproject.demo.entity.Product;
import compofinalproject.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

@Profile("ProductDataSource")
public class ProductDaoImpl implements ProductDao {


    ProductRepository productRepository;
    @Autowired
    public void setCourseRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    @Transactional
    public List<Product> getProductsSearch(String searchText) {
        return productRepository.findByProductNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(searchText,searchText);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByName(String searchName) {
        return null;
    }

}
