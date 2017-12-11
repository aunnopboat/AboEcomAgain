package compofinalproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@RequiredArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NonNull
    int CustomerId;
    @NonNull
    String CustomerName;
    @NonNull
    String CustomerSurname;
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String moreInformation;


    @OneToOne
    Cart cart;


}
