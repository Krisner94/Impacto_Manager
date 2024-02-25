package app.impacto_manager.repository;

import app.impacto_manager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
