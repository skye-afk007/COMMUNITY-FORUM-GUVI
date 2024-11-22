import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
    /**
     * @param postId
     * @return
     */
    List<Like> findByPostId(Long postId);
}
