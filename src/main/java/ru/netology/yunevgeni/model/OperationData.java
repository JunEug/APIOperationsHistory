package ru.netology.yunevgeni.model;

import ru.netology.yunevgeni.model.Customer;
import ru.netology.yunevgeni.model.Operation;

import java.io.Serializable;

public class OperationData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Customer[] customers;
    private Operation[] operations;
    private int[][] statement;

}