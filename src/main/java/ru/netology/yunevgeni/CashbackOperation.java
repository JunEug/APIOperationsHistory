package ru.netology.yunevgeni;

import lombok.Data;

@Data
public class CashbackOperation extends Operation {
    private int cashbackAmount;

    @Override
    public void print() {
        super.print();
        System.out.println("Cashback Amount: " + cashbackAmount);
    }

    public int getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(int cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }
}
