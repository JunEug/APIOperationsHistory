package ru.netology.yunevgeni.model;

import lombok.Data;
import ru.netology.yunevgeni.model.Operation;

@Data
public class LoanOperation extends Operation {
    private int loanId;

    @Override
    public void print() {
        super.print();
        System.out.println("Loan ID: " + loanId);
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }
}
