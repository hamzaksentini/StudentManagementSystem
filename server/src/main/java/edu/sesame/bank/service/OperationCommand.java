package edu.sesame.bank.service;


import lombok.Builder;
import lombok.Getter;
import edu.sesame.bank.entity.OperationType;

@Getter
@Builder
public class OperationCommand {

    private Integer accountId;
    private Double amount;
    private OperationType type;
    private String label;


}
