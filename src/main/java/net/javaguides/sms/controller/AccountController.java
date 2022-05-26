package net.javaguides.sms.controller;


import net.javaguides.sms.entity.OperationType;
import net.javaguides.sms.service.AccountService;
import net.javaguides.sms.service.OperationCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static net.javaguides.sms.entity.OperationType.WITHDRAW;

@RestController("accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody OperationRequest request){
        OperationCommand command = OperationCommand.builder()
                .accountId(request.getAccountId())
                .amount(request.getAmount())
                .type(WITHDRAW)
                .build();
        accountService.applyOperation(command);
    }

}
