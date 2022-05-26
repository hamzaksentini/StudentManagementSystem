package net.javaguides.sms.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_OPERATION")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
