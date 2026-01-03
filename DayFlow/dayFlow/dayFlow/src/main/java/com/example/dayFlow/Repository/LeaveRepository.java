package Repository;

import models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository  extends JpaRepository<Leave,Long> {
}
