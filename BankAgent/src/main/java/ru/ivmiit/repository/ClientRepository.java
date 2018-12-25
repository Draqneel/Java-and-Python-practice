package ru.ivmiit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
