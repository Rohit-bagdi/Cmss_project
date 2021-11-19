package in.cmss.icici.uotm.core.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<ErrorMessage, Integer> {
}
