package ru.netology.yunevgeni.service;

import org.springframework.stereotype.Service;
import ru.netology.yunevgeni.model.Operation;

import java.util.List;

@Service
public class StatementService {
    private final StorageService<Operation> operationStorageService;
    private final IOService ioService = new IOService();

    public StatementService(StorageService<Operation> operationStorageService) {
        this.operationStorageService = operationStorageService;
    }

    public void retrieveCustomerOperations() {
        int customerIdToRetrieve = ioService.readInt("Enter customer ID to retrieve operations: ");
        List<Operation> customerOperations = operationStorageService.getAll();

        System.out.println("Customer Operations:");
        for (Operation operation : customerOperations) {
            if (operation != null && operation.getCustomerId() == customerIdToRetrieve) {
                operation.print();
            }
        }
    }
}
