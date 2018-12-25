package ru.ivmiit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}