package compofinalproject.demo.service;

import compofinalproject.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer addCustomer(Customer customer);
}
