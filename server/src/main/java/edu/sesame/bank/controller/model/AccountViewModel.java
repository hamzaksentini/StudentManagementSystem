package edu.sesame.bank.controller.model;

import edu.sesame.bank.entity.Account;
import edu.sesame.bank.entity.Operation;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class AccountViewModel {

    private Integer id;
    private Double balance;
    private String label;

    private List<OperationViewModel> operations;


    public AccountViewModel(Account account, List<Operation> operations) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.label = account.getLabel();
        this.operations = operations.stream().map(OperationViewModel::new).collect(Collectors.toList());
    }

    public AccountViewModel(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.label = account.getLabel();
    }
}
