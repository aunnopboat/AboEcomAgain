package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    List<Product> getProductsSearch(String searchText);
    Product findById(long id);
    Product addProduct(Product product);
    Product findByName(String searchName);
}
