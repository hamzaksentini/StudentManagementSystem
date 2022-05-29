package edu.sesame.bank.service;

import edu.sesame.bank.entity.Account;
import edu.sesame.bank.repository.AccountRepository;
import edu.sesame.bank.repository.OperationRepository;
import edu.sesame.bank.entity.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Account create(CreateAccountCommand command) {
        return accountRepository.save(new Account());
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
