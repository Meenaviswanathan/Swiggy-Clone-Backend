package demowithswiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demowithswiggy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}