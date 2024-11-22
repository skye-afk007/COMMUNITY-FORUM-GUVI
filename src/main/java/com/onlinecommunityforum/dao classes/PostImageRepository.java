import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
    /**
     * @param postId
     * @return
     */
    List<PostImage> findByPostId(Long postId);
}