package net.javaguides.sms.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccountCommand {

    private Integer userId;
}
