package ru.ivmiit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.entity.BankAccount;

public interface BankAccountRepositroy extends JpaRepository<BankAccount, Long>{
}
