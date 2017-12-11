package compofinalproject.demo.controller;
import compofinalproject.demo.entity.Customer;
import compofinalproject.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    CustomerService customerService;
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getCustomers() {

        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/customer")
    public ResponseEntity<?> uploadOnlyCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok(customer);
    }
}
