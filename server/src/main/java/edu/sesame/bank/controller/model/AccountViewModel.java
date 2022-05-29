package edu.sesame.bank.controller.model;

import edu.sesame.bank.entity.Account;
import lombok.Data;


@Data
public class AccountViewModel {

    private Integer id;

    public AccountViewModel(Account account) {
        this.id = account.getId();
    }
}
