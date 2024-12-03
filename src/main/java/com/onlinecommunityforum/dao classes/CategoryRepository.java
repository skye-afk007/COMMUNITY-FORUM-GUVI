import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * @param name
     * @return
     */
    Optional<Category> findByName(String name);
}