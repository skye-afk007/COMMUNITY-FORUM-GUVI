import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.ReportedPost;

public interface ReportedPostRepository extends JpaRepository<ReportedPost, Long> {
    /**
     * @param postId
     * @return
     */
    List<ReportedPost> findByPostId(Long postId);
}