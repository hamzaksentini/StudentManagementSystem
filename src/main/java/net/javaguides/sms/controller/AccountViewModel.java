package net.javaguides.sms.controller;

import lombok.Data;
import net.javaguides.sms.entity.Account;


@Data
public class AccountViewModel {

    private Integer id;

    public AccountViewModel(Account account) {
        this.id = account.getId();
    }
}
