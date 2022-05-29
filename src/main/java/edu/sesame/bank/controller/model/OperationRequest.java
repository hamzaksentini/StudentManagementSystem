package edu.sesame.bank.controller.model;

import lombok.Data;

@Data
public class OperationRequest {

    private Integer accountId;
    private Double amount;

}
