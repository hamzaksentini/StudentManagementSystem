package net.javaguides.sms.service;

import net.javaguides.sms.entity.OperationEntity;
import net.javaguides.sms.entity.OperationType;
import net.javaguides.sms.repository.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final OperationRepository operationRepository;

    public AccountService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void withdraw (OperationCommand command){
        OperationEntity operation = toOperation(command, OperationType.WITHDRAW);
        operationRepository.save(operation);
    }

    public void deposit (OperationCommand command){
        OperationEntity operation = toOperation(command, OperationType.DEPOSIT);
        operationRepository.save(operation);
    }

    private OperationEntity toOperation(OperationCommand command, OperationType type){
        return new OperationEntity(null,command.getAmount(),type);
    }

}
