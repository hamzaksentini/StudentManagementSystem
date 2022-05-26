package net.javaguides.sms.repository;

import net.javaguides.sms.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationEntity, Integer> {
}