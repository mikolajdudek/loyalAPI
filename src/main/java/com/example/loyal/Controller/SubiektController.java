package com.example.loyal.Controller;

import com.example.loyal.Client.SubiektApiClient;
import com.example.loyal.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subiekt")
public class SubiektController {
    private final SubiektApiClient subiektApiClient;

    public SubiektController(SubiektApiClient subiektApiClient) {
        this.subiektApiClient = subiektApiClient;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return subiektApiClient.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") String id) {
        return subiektApiClient.getCustomerById(id);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return subiektApiClient.createCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        return subiektApiClient.updateCustomer(id, customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable("id") String id) {
        subiektApiClient.deleteCustomer(id);
    }
}

