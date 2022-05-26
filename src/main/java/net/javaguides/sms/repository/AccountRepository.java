package net.javaguides.sms.repository;

import net.javaguides.sms.entity.Account;
import net.javaguides.sms.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}