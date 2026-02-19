package id.ac.ui.cs.advprog.backend.repository;

import id.ac.ui.cs.advprog.backend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
