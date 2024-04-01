package ru.netology.yunevgeni.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.netology.yunevgeni.model.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerService {

    private final Scanner scanner = new Scanner(System.in);
    private final StorageService<Customer> customerStorageService = new StorageService<>();



    public void createCustomer(Customer customer) {
        customerStorageService.save(customer);
        System.out.println("Customer created successfully.");
    }

    public Customer getCustomer(int id) {
        return customerStorageService.findById(id, Customer.class)
                .orElse(null);
    }

    public List<Customer> getCustomers() {
        return customerStorageService.getAll();
    }

    @PostConstruct
    public void initStorage() {
        List<Customer> initialCustomers = Arrays.asList(
                new Customer(1, 2, "Spring", "s@s.ru"),
                new Customer(2, 3, "Boot", "s@s.ru")
        );
        for (Customer customer : initialCustomers) {
            customerStorageService.save(customer);
        }
    }

    public Customer findById(int id) {
        return customerStorageService.findById(id, Customer.class)
                .orElse(null);
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOptional = customerStorageService.findById(id, Customer.class);
        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            customerStorageService.save(existingCustomer);
            return existingCustomer;
        } else {
            return null;
        }
    }

    public boolean deleteCustomer(int id) {
        Optional<Customer> customerOptional = customerStorageService.findById(id, Customer.class);
        if (customerOptional.isPresent()) {
            customerStorageService.delete(customerOptional.get());
            return true;
        } else {
            return false;
        }
    }

}
