package ru.netology.yunevgeni.exception;

import ru.netology.yunevgeni.exception.OperationRuntimeException;

public class CustomerOperationOutOfBoundException extends OperationRuntimeException {
    public static final String MESSAGE = "Exception while trying to save operation %s for customer %s";
    private int customerId;
    private int operationId;

    public CustomerOperationOutOfBoundException(int customerId, int operationId) {
        super(MESSAGE.formatted(operationId, customerId));
        this.customerId = customerId;
        this.operationId = operationId;
    }
}