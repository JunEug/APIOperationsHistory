package ru.netology.yunevgeni;
import java.util.Scanner;
import ru.netology.yunevgeni.Customer;


public class Main {
    private static Operation[] operations = new Operation[100];
    private static Customer[] customers = new Customer[50];
    private static int[][] statement = new int[50][100];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Operation");
            System.out.println("3. Associate Operation with Customer");
            System.out.println("4. Retrieve Customer Operations");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    createOperation();
                    break;
                case 3:
                    associateOperationWithCustomer();
                    break;
                case 4:
                    retrieveCustomerOperations();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createCustomer() {
        System.out.println("Enter customer details:");
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        Customer customer = new Customer(customerId, name, email);
        customers[customerId] = customer;

        System.out.println("Customer created successfully.");
    }

    private static void createOperation() {
        System.out.println("Enter operation details:");
        System.out.print("Operation ID: ");
        int operationId = scanner.nextInt();
        System.out.print("Description: ");
        String description = scanner.next();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        Operation operation = new Operation(operationId, description, amount);
        operations[operationId] = operation;

        System.out.println("Operation created successfully.");
    }

    private static void associateOperationWithCustomer() {
        System.out.println("Enter customer ID to associate with the operation: ");
        int customerToAssociateId = scanner.nextInt();

        if (customers[customerToAssociateId] != null) {
            System.out.println("Enter operation ID to associate with the customer: ");
            int operationId = scanner.nextInt();

            if (operations[operationId] != null) {
                statement[customerToAssociateId][operationId] = operationId;
                System.out.println("Operation associated with the customer successfully.");
            } else {
                System.out.println("Operation not found.");
            }
        } else {
            System.out.println("Customer not found. Do you want to create a new customer? (yes/no)");
            String createCustomerChoice = scanner.next();

            if (createCustomerChoice.equalsIgnoreCase("yes")) {
                createCustomer();
                associateOperationWithCustomer(); // Recursively retry association after creating a new customer
            } else {
                System.out.println("Operation not associated with any customer.");
            }
        }
    }

    private static void retrieveCustomerOperations() {
        System.out.println("Enter customer ID to retrieve operations: ");
        int customerIdToRetrieve = scanner.nextInt();
        Operation[] customerOperations = getOperations(customerIdToRetrieve);

        System.out.println("Customer Operations:");
        for (Operation customerOperation : customerOperations) {
            if (customerOperation != null) {
                customerOperation.print();
            }
        }
    }

    public static Operation[] getOperations(int clientId) {
        int[] operationIds = statement[clientId];
        Operation[] customerOperations = new Operation[operationIds.length];

        for (int i = 0; i < operationIds.length; i++) {
            int operationId = operationIds[i];
            customerOperations[i] = operations[operationId];
        }

        return customerOperations;
    }
}