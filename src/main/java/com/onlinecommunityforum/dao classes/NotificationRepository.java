import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    /**
     * @param userId
     * @return
     */
    List<Notification> findByUserId(Long userId);
}
