package compofinalproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String productId;
    String productName;
    String image;
    int price;
    int amount;
    String description;

}
