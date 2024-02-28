package ru.netology.yunevgeni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int transactionCount = 5;

        int[] transactionAmount = new int[transactionCount];
        String[] transactionType = new String[transactionCount];
        boolean[] transactionSuccess = new boolean[transactionCount];

        double[] transaction2Amount = new double[transactionCount];
        char[] transaction2Currency = new char[transactionCount];
        String[] transaction2Status = new String[transactionCount];

        String[] transaction3Description = new String[transactionCount];
        int[] transaction3Quantity = new int[transactionCount];
        double[] transaction3Price = new double[transactionCount];

        String[] transaction4Recipient = new String[transactionCount];
        boolean[] transaction4Verified = new boolean[transactionCount];

        int[] transaction5AccountNumber = new int[transactionCount];
        double[] transaction5Balance = new double[transactionCount];

        for (int i = 0; i < transactionCount; i++) {
            System.out.println("Введите информацию о транзакции " + (i + 1) + ":");

            System.out.print("Сумма транзакции: ");
            transactionAmount[i] = scanner.nextInt();
            System.out.print("Тип транзакции: ");
            transactionType[i] = scanner.next();
            System.out.print("Успешность транзакции (true/false): ");
            transactionSuccess[i] = scanner.nextBoolean();

            System.out.print("Сумма транзакции: ");
            transaction2Amount[i] = scanner.nextDouble();
            System.out.print("Валюта транзакции: ");
            transaction2Currency[i] = scanner.next().charAt(0);
            System.out.print("Статус транзакции: ");
            transaction2Status[i] = scanner.next();

            System.out.print("Описание транзакции: ");
            transaction3Description[i] = scanner.next();
            System.out.print("Количество товара: ");
            transaction3Quantity[i] = scanner.nextInt();
            System.out.print("Цена товара: ");
            transaction3Price[i] = scanner.nextDouble();

            System.out.print("Получатель транзакции: ");
            transaction4Recipient[i] = scanner.next();
            System.out.print("Подтверждение транзакции (true/false): ");
            transaction4Verified[i] = scanner.nextBoolean();

            System.out.print("Номер счета: ");
            transaction5AccountNumber[i] = scanner.nextInt();
            System.out.print("Баланс счета: ");
            transaction5Balance[i] = scanner.nextDouble();
        }

        scanner.close();

        for (int i = 0; i < transactionCount; i++) {
            System.out.println("Транзакция " + (i + 1) + ": " +
                    "Сумма=" + transactionAmount[i] + ", " +
                    "Тип=" + transactionType[i] + ", " +
                    "Успешность=" + transactionSuccess[i] + ", " +
                    "Сумма=" + transaction2Amount[i] + ", " +
                    "Валюта=" + transaction2Currency[i] + ", " +
                    "Статус=" + transaction2Status[i] + ", " +
                    "Описание=" + transaction3Description[i] + ", " +
                    "Количество=" + transaction3Quantity[i] + ", " +
                    "Цена=" + transaction3Price[i] + ", " +
                    "Получатель=" + transaction4Recipient[i] + ", " +
                    "Подтверждение=" + transaction4Verified[i] + ", " +
                    "Номер счета=" + transaction5AccountNumber[i] + ", " +
                    "Баланс счета=" + transaction5Balance[i]);
        }

        searchTransactionsByDate(transactionCount, transaction3Description);
    }

    private static void searchTransactionsByDate(int transactionCount, String[] transaction3Description) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите диапазон дат для поиска операций (например, '01.01.2024-31.01.2024'): ");
        String dateRange = scanner.nextLine();

        scanner.close();
    }
}