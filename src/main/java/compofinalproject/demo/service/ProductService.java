package compofinalproject.demo.service;

import compofinalproject.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product findById(long id);
    Product addProduct(Product product);
    Product getProductForTransfer(String searchName);
    List<Product> queryProduct(String query);


}
