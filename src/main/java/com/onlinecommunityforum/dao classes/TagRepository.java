import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    /**
     * @param name
     * @return
     */
    Optional<Tag> findByName(String name);
}