package net.javaguides.sms.controller;


import net.javaguides.sms.entity.Account;
import net.javaguides.sms.service.AccountService;
import net.javaguides.sms.service.CreateAccountCommand;
import net.javaguides.sms.service.OperationCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static net.javaguides.sms.entity.OperationType.DEPOSIT;
import static net.javaguides.sms.entity.OperationType.WITHDRAW;

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
                .type(WITHDRAW)
                .build();
        accountService.applyOperation(command);
    }

    @PutMapping("/deposit")
    public void deposit(@RequestBody OperationRequest request) {
        OperationCommand command = OperationCommand.builder()
                .accountId(request.getAccountId())
                .amount(request.getAmount())
                .type(DEPOSIT)
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
