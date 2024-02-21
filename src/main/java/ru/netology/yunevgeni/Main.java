package ru.netology.yunevgeni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, my name is Yun Evgeni");

        String transactionType;
        double amount;
        int transactionId;
        String transactionDate;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите тип транзакции (перевод, оплата и т.д.): ");
        transactionType = scanner.nextLine();

        System.out.print("Введите сумму транзакции: ");
        amount = scanner.nextDouble();

        System.out.print("Введите идентификатор транзакции (целое число): ");
        transactionId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Введите дату транзакции (в формате ДД.ММ.ГГГГ): ");
        transactionDate = scanner.nextLine();

        System.out.println("Тип транзакции: " + transactionType +
                ", Сумма: " + amount +
                ", Идентификатор:" + transactionId +
                ", Дата: " + transactionDate);

        scanner.close();
    }
}