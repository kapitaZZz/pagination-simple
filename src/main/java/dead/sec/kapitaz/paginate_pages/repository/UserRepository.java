package dead.sec.kapitaz.paginate_pages.repository;

import dead.sec.kapitaz.paginate_pages.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
