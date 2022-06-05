package edu.sesame.bank.controller.model;

import edu.sesame.bank.entity.Operation;
import edu.sesame.bank.entity.OperationType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Data
public class OperationViewModel {

    private Integer id;
    private String label;
    private Double amount;
    private String date;
    private OperationType type;


    public OperationViewModel(Operation operation) {
        this.id = operation.getId();
        this.label = operation.getLabel();
        this.amount = operation.getAmount();
        this.date = operation.getCreatedDate() != null ? DateTimeFormatter.ISO_DATE.format(LocalDateTime.ofInstant(operation.getCreatedDate(), ZoneOffset.UTC)) : "2022-05-21";
        this.type = operation.getType();
    }


}
