package compofinalproject.demo.dao;

import com.google.common.collect.Lists;
import compofinalproject.demo.entity.Customer;
import compofinalproject.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

   CustomerRepository customerRepository;
    @Autowired
    public void setStudentRepository(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> getCustomers() {

        return Lists.newArrayList(customerRepository.findAll());

    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Customer deleteCustomer(Customer customer) {
        return null;
    }


}
