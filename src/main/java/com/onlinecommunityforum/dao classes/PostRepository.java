import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * @param userId
     * @return
     */
    List<Post> findByUserId(Long userId);
}