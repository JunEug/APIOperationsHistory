package ru.netology.yunevgeni.model;

import lombok.Data;

@Data
public class Customer implements Identifiable {
    private int customerId;
    private String name;
    private String email;
    private int id;

    public Customer() {
    }

    public Customer(int id, int customerId, String name, String email) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }
}
