import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
    List<PostTag> findByPostId(Long postId);
    List<PostTag> findByTagId(Long tagId);
 }