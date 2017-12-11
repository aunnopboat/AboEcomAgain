package compofinalproject.demo.dao;

import compofinalproject.demo.entity.Customer;
import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();
    Customer addCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
}
