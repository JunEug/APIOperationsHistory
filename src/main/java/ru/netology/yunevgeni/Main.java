package ru.netology.yunevgeni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int transaction1Amount;
        String transaction1Type;
        boolean transaction1Success;

        double transaction2Amount;
        char transaction2Currency;
        String transaction2Status;

        String transaction3Description;
        int transaction3Quantity;
        double transaction3Price;

        String transaction4Recipient;
        boolean transaction4Verified;

        int transaction5AccountNumber;
        double transaction5Balance;

        int transactionCount = 1;
        while (true) {
            System.out.println("Введите информацию о транзакции " + transactionCount + ":");

            System.out.print("Сумма транзакции: ");
            transaction1Amount = scanner.nextInt();
            System.out.print("Тип транзакции: ");
            transaction1Type = scanner.next();
            System.out.print("Успешность транзакции (true/false): ");
            transaction1Success = scanner.nextBoolean();

            System.out.print("Сумма транзакции: ");
            transaction2Amount = scanner.nextDouble();
            System.out.print("Валюта транзакции: ");
            transaction2Currency = scanner.next().charAt(0);
            System.out.print("Статус транзакции: ");
            transaction2Status = scanner.next();

            System.out.print("Описание транзакции: ");
            transaction3Description = scanner.next();
            System.out.print("Количество товара: ");
            transaction3Quantity = scanner.nextInt();
            System.out.print("Цена товара: ");
            transaction3Price = scanner.nextDouble();

            System.out.print("Получатель транзакции: ");
            transaction4Recipient = scanner.next();
            System.out.print("Подтверждение транзакции (true/false): ");
            transaction4Verified = scanner.nextBoolean();

            System.out.print("Номер счета: ");
            transaction5AccountNumber = scanner.nextInt();
            System.out.print("Баланс счета: ");
            transaction5Balance = scanner.nextDouble();

            transactionCount++;

            if (transactionCount > 5) {
                break;
            }
        }

        System.out.println("Information:");
        System.out.println("Транзакция 1: Сумма=" + transaction1Amount + ", Тип=" + transaction1Type + ", Успешность=" + transaction1Success);
        System.out.println("Транзакция 2: Сумма=" + transaction2Amount + ", Валюта=" + transaction2Currency + ", Статус=" + transaction2Status);
        System.out.println("Транзакция 3: Описание=" + transaction3Description + ", Количество=" + transaction3Quantity + ", Цена=" + transaction3Price);
        System.out.println("Транзакция 4: Получатель=" + transaction4Recipient + ", Подтверждение=" + transaction4Verified);
        System.out.println("Транзакция 5: Номер счета=" + transaction5AccountNumber + ", Баланс счета=" + transaction5Balance);

        scanner.close();
    }
}