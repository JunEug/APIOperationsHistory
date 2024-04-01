package ru.netology.yunevgeni.model;

import lombok.Data;

@Data
public class Operation {
    private int operationId;
    private String description;
    private double amount;
    private int customerId;
    private int id;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public Operation() {
    }

    public Operation(int id, int operationId, String description, double amount) {
        this.id = id;
        this.operationId = operationId;
        this.description = description;
        this.amount = amount;
    }

    public void print() {
        System.out.println("Operation ID: " + operationId);
        System.out.println("Description: " + description);
        System.out.println("Amount: " + amount);
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
