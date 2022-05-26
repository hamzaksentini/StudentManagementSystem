package net.javaguides.sms.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "operation")
public class OperationEntity {
    public OperationEntity(Integer id, Double amount, OperationType type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.createdDate = new Timestamp(new Date().getTime());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    private Timestamp createdDate;

}
