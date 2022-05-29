package edu.sesame.bank.repository;

import edu.sesame.bank.entity.Account;
import edu.sesame.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findByUser(User user);
}