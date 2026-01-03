package Repository;

import models.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendence,Long> {
}
