package net.javaguides.sms.service;


import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class OperationCommand {
    private final Double amount;
    private final Timestamp createdDate;

    public OperationCommand (Double amount, Timestamp createdDate){
        this.amount = amount;
        this.createdDate =createdDate;
    }
}
