import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Follower;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    /**
     * @param userId
     * @return
     */
    List<Follower> findByFollowedId(Long userId);
}