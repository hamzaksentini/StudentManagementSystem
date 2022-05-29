package edu.sesame.bank.controller;


import edu.sesame.bank.controller.model.AccountCreationRequest;
import edu.sesame.bank.controller.model.AccountViewModel;
import edu.sesame.bank.controller.model.OperationRequest;
import edu.sesame.bank.entity.Account;
import edu.sesame.bank.entity.OperationType;
import edu.sesame.bank.service.AccountService;
import edu.sesame.bank.service.CreateAccountCommand;
import edu.sesame.bank.service.OperationCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/withdraw")
    public void withdraw(@RequestBody OperationRequest request) {
        OperationCommand command = OperationCommand.builder()
                .accountId(request.getAccountId())
                .amount(request.getAmount())
                .type(OperationType.WITHDRAW)
                .build();
        accountService.applyOperation(command);
    }

    @PutMapping("/deposit")
    public void deposit(@RequestBody OperationRequest request) {
        OperationCommand command = OperationCommand.builder()
                .accountId(request.getAccountId())
                .amount(request.getAmount())
                .type(OperationType.DEPOSIT)
                .build();
        accountService.applyOperation(command);
    }

    @PostMapping
    public ResponseEntity<AccountViewModel> create(@RequestBody AccountCreationRequest request) {
        CreateAccountCommand command = CreateAccountCommand.builder()
                .userId(request.getUserId())
                .build();
        Account account = accountService.create(command);
        AccountViewModel accountViewModel = new AccountViewModel(account);
        return ResponseEntity.ok(accountViewModel);
    }

    @GetMapping
    public ResponseEntity<List<AccountViewModel>> findAll() {
        List<AccountViewModel> accounts = accountService.findAll().stream()
                .map(AccountViewModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

}
