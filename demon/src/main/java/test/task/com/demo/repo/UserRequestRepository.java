package test.task.com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import test.task.com.demo.model.UserRequest;

public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
}
