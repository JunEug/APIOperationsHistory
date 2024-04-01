package ru.netology.yunevgeni.service;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.netology.yunevgeni.OperationService;
import ru.netology.yunevgeni.model.Operation;
import ru.netology.yunevgeni.properties.OperationProperties;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class AsyncInputOperationService {
    private final Queue<Operation> queue = new LinkedList<>();
    private final OperationService operationService;
    private final OperationProperties operationProperties;

    public AsyncInputOperationService(OperationService operationService, OperationProperties operationProperties) {
        this.operationService = operationService;
        this.operationProperties = operationProperties;
    }



    public boolean offerOperation(Operation operation) {
        return queue.offer(operation);
    }

    public void startAsyncOperationProcessing() {
        Thread t = new Thread(() -> {
            processQueue();
        });
        t.start();
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();
            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(operationProperties.getSleepMilliSeconds());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation: " + operation);
                operationService.addOperation(operation);
            }
        }
    }

    @PostConstruct
    public void init() {
        this.startAsyncOperationProcessing();
    }
}
