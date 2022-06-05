package edu.sesame.bank.service;

import edu.sesame.bank.entity.Account;
import edu.sesame.bank.entity.Operation;
import edu.sesame.bank.entity.User;
import edu.sesame.bank.repository.AccountRepository;
import edu.sesame.bank.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final OperationRepository operationRepository;
    private final UserService userService;
    private final AccountRepository accountRepository;

    public AccountService(OperationRepository operationRepository, UserService userService, AccountRepository accountRepository) {
        this.operationRepository = operationRepository;
        this.userService = userService;
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
        User currentUser = userService.findCurrentUser();
        return accountRepository.findByUser(currentUser);
    }

    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    public List<Operation> getOperations(Integer id) {
        return operationRepository.findByAccountIdOrderByCreatedDateDesc(id);
    }
}
