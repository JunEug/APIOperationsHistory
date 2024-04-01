package ru.netology.yunevgeni;
import ru.netology.yunevgeni.model.Operation;
import ru.netology.yunevgeni.properties.OperationProperties;
import ru.netology.yunevgeni.service.*;

import java.util.Scanner;

public class Main {
    private static final StorageService<Operation> operationStorageService = new StorageService<>();
    private static final StatementService statementService = new StatementService(operationStorageService);

    static final Scanner scanner = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerService();
    static final OperationService operationService = new OperationService();
    static final OperationProperties operationProperties = new OperationProperties();

    public static void main(String[] args) {
        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(operationService, operationProperties);
        asyncInputOperationService.startAsyncOperationProcessing();
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

        }
    }

    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Create Customer");
        System.out.println("2. Create Operation");
        System.out.println("3. Associate Operation with Customer");
        System.out.println("4. Retrieve Customer Operations");
        System.out.println("5. Exit");
    }
}
