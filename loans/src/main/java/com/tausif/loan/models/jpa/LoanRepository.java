package com.tausif.loan.models.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
	List<LoanEntity> findByAccountId(Long accountId);
}
