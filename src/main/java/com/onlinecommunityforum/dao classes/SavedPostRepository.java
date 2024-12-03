import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.SavedPost;

public interface SavedPostRepository extends JpaRepository<SavedPost, Long> {
    /**
     * @param userId
     * @return
     */
    List<SavedPost> findByUserId(Long userId);
}