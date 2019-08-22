package fr.jm.mine.repositories;

import fr.jm.mine.entities.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    Optional<MessageEntity> findOneById(Long messageId);


    @Query (value = "select me.channel from MessageEntity me group by me.channel")
    Page<String> findAllChannels(Pageable pageable);

    Page<MessageEntity> findMessageEntitiesByChannel(String channel, Pageable pageable);

    Page<MessageEntity> findMessageEntitiesByAuthor(String author, Pageable pageable);

    Page<MessageEntity> findMessageEntitiesByChannelAndAuthor(String channel,String author, Pageable pageable);



    Page<MessageEntity> findMessageEntitiesByChannelAndCreatedDate_DateBetween(String channel,
                                                                           String creationDateRangeIn,
                                                                           String creationDateRangeOut,
                                                                           Pageable pageable);


}
