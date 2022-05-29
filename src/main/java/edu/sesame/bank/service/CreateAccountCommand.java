package edu.sesame.bank.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccountCommand {

    private Integer userId;
}
