package compofinalproject.demo.service;
import compofinalproject.demo.dao.CustomerDao;
import compofinalproject.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import java.util.List;

@ConfigurationProperties(prefix = "server")
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    public List<Customer> getCustomers(){

        return customerDao.getCustomers();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }
}
