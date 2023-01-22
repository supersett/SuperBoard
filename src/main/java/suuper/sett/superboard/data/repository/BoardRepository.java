package suuper.sett.superboard.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import suuper.sett.superboard.data.entity.Board;

public interface BoardRepository extends JpaRepository<Board,Long> {


}
