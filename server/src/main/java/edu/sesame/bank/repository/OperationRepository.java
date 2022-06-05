package edu.sesame.bank.repository;

import edu.sesame.bank.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Integer> {


    List<Operation> findByAccountIdOrderByCreatedDateDesc(Integer accountId);
}