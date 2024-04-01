package ru.netology.yunevgeni.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOService {
    private final Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public void consumeNewLine() {
        scanner.nextLine();
    }
}
