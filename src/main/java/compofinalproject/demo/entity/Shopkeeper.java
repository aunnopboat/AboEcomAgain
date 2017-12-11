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
@RequiredArgsConstructor
@Builder
public class Shopkeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NonNull
    int ShopkeeperId;
    @NonNull
    String ShopkeeperName;
    @NonNull
    String ShopkeeperSurname;
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String moreInformation;
}
