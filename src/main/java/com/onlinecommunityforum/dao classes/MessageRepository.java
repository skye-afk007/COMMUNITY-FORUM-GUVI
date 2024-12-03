import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecommunityforum.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * @param senderId
     * @return
     */
    List<Message> findBySenderId(Long senderId);
    List<Message> findByReceiverId(Long receiverId);
}