package suuper.sett.superboard.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suuper.sett.superboard.data.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User getByUid(String uid);
}
