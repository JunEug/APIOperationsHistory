package ru.netology.yunevgeni.model;

import ru.netology.yunevgeni.model.CustomerDTO;

import java.util.List;

public class CustomersGetResponse {
    private List<CustomerDTO> customers;

    public CustomersGetResponse(List<CustomerDTO> customers) {
        this.customers = customers;
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTO> customers) {
        this.customers = customers;
    }
}