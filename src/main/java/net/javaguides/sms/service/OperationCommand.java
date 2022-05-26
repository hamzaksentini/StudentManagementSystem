package net.javaguides.sms.service;


import lombok.Builder;
import lombok.Getter;
import net.javaguides.sms.entity.OperationType;

@Getter
@Builder
public class OperationCommand {

    private Integer accountId;
    private Double amount;
    private OperationType type;


}
