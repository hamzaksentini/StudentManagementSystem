package edu.sesame.bank.controller.model;

import edu.sesame.bank.entity.Account;
import lombok.Data;


@Data
public class AccountViewModel {

    private Integer id;
    private Double balance;
    private String label;

    public AccountViewModel(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.label = account.getLabel();
    }
}
