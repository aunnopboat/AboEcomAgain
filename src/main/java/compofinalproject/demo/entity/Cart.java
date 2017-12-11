package compofinalproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    @NonNull
    String CartId;


    @ManyToMany
    List<Product> addedProduct;

    public List<Product> addProduct(Product product) {
        addedProduct = Optional.ofNullable(addedProduct).orElse(new ArrayList<>());
        addedProduct.add(product);
        return addedProduct;
    }

}
