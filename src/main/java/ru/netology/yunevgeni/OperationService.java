package ru.netology.yunevgeni;

import org.springframework.stereotype.Service;
import ru.netology.yunevgeni.model.Operation;
import ru.netology.yunevgeni.service.StorageService;

import java.util.Queue;
import java.util.Scanner;

import static ru.netology.yunevgeni.Main.operationService;

@Service
public class OperationService {
    Queue<Operation> queue;
    private final Scanner scanner = new Scanner(System.in);
    private final StorageService<Operation> operationStorageService = new StorageService<>();

    public void createOperation() {
        System.out.println("Enter operation details:");
        int operationId = readInt("Operation ID: ");
        String description = readString("Description: ");
        double amount = readDouble("Amount: ");
        int id = readInt("Id:");

        Operation operation = new Operation(id, operationId, description, amount);
        operationStorageService.save(operation);

        System.out.println("Operation created successfully.");
    }

    public void addOperation(Operation operation) {

    }

    public void associateOperationWithCustomer() {
        System.out.println("Enter customer ID to associate with the operation: ");
        int customerToAssociateId = scanner.nextInt();
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();
            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation:” + operation");
                operationService.addOperation(operation);
            }
        }
    }
    public void startAsyncOperationProcessing() {
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();
            }
        };
        t.start();
    }

}
