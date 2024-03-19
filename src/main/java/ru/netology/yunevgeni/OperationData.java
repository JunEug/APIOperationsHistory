package ru.netology.yunevgeni;

import java.io.Serializable;

public class OperationData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Customer[] customers;
    private Operation[] operations;
    private int[][] statement;

}