package net.javaguides.sms.service;

import net.javaguides.sms.entity.Account;
import net.javaguides.sms.entity.Operation;
import net.javaguides.sms.repository.AccountRepository;
import net.javaguides.sms.repository.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final OperationRepository operationRepository;
    private final AccountRepository accountRepository;

    public AccountService(OperationRepository operationRepository, AccountRepository accountRepository) {
        this.operationRepository = operationRepository;
        this.accountRepository = accountRepository;
    }

    public void applyOperation(OperationCommand command) {
        Account account = accountRepository.getById(command.getAccountId());
        Operation operation = Operation.builder()
                .account(account)
                .amount(command.getAmount())
                .type(command.getType())
                .build();
        operationRepository.save(operation);

    }

}
