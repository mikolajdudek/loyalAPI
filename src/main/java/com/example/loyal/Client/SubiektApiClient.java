package com.example.loyal.Client;

import com.example.loyal.Customer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SubiektApiClient {
    public SubiektApiClient(RestTemplate restTemplate, String apiUrl) {

    }

    public List<Customer> getCustomers() {
        return null;
    }

    public Customer getCustomerById(String id) {
        return null;
    }

    public Customer createCustomer(Customer customer) {
        return customer;
    }

    public void deleteCustomer(String id) {
    }

    public Customer updateCustomer(String id, Customer customer) {
        return customer;
    }
}
