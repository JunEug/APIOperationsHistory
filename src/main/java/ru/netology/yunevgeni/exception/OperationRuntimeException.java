package ru.netology.yunevgeni.exception;

public class OperationRuntimeException extends RuntimeException {
    public OperationRuntimeException(String message) {
        super(message);
    }
}