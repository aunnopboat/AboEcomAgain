package compofinalproject.demo.service;

import compofinalproject.demo.dao.ProductDao;
import compofinalproject.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    String imageBaseUrl;
    String baseUrl;
    String imageUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @PostConstruct
    protected void setImageBaseUrl(){
        this.imageBaseUrl = this.baseUrl + this.imageUrl;
    }

    @Autowired
    ProductDao productDao;
    public List<Product> getProducts(){
        return productDao.getProducts();
    }


    @Override
    @Transactional
    public Product findById(long id) {
        Product student = productDao.findById(id);
        return student;
    }



    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Transactional
    @Override
    public Product getProductForTransfer(String searchName) {
        Product product = productDao.findByName(searchName);
//        Hibernate.initialize(product.getAuthrities());
        return product;
    }

    @Override
    public List<Product> queryProduct(String query) {
        if (query == null || query.equals("")) {
            return productDao.getProducts();
        }
        return productDao.getProductsSearch(query);
    }



}
