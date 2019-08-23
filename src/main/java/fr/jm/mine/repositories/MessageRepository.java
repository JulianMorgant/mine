package fr.jm.mine.repositories;

import fr.jm.mine.entities.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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


    @Query(value = "select me.channel from MessageEntity me group by me.channel")
    Page<String> findAllChannels(Pageable pageable);

    Page<MessageEntity> findMessageEntitiesByChannel(String channel, Pageable pageable);

    Page<MessageEntity> findMessageEntitiesByAuthor(String author, Pageable pageable);

    Page<MessageEntity> findMessageEntitiesByChannelAndAuthor(String channel, String author, Pageable pageable);

    @Query(value = "select me from MessageEntity me where " +
            "(me.channel = :channel)" +
            " and ( lower(me.author) like lower(concat(:author,'%') ) )" +
            " order by me.createdDate desc")
    Page<MessageEntity> findMessageEntitiesByChannelAndLAuthorStartBy(String channel, String author, Pageable pageable);

    @Query(value = "select me from MessageEntity me where (me.channel = :channel) and ( lower(me.author) like lower(concat('%',:author,'%') ) )")
    Page<MessageEntity> findMessageEntitiesByChannelAndLAuthorContains(String channel, String author, Pageable pageable);

    @Query(value = "select me from MessageEntity me where (" +
            "(me.channel = :channel) and" +
            "(me.createdDate between :dateFrom and :dateTo) and" +
            "(me.author = :author)" +
            ") order by me.createdDate desc ")
    Page<MessageEntity> findMessageEntitiesByChannelAndDatesAndAuthor(String channel, LocalDateTime dateFrom,
                                                                      LocalDateTime dateTo,String author,
                                                                      Pageable pageable);

    @Query(value = "select me from MessageEntity me where " +
            "(me.createdDate between :dateFrom and :dateTo)" +
            " and (me.channel = :channel)" +
            " and ( lower(me.author) like lower(concat(:author,'%') ) )" +
            " order by me.createdDate desc ")
    Page<MessageEntity> findMessageEntitiesByChannelAndDatesAndLAuthorStartBy(String channel, LocalDateTime dateFrom,
                                                                              LocalDateTime dateTo, String author,
                                                                              Pageable pageable);

    @Query(value = "select me from MessageEntity me where " +
            "(me.createdDate between :dateFrom and :dateTo)" +
            " and (me.channel = :channel)" +
            " and ( lower(me.author) like lower(concat('%',:author,'%') ) )" +
            " order by me.createdDate desc ")
    Page<MessageEntity> findMessageEntitiesByChannelAndDatesAndAuthorContains(String channel, LocalDateTime dateFrom,
                                                                               LocalDateTime dateTo, String author,
                                                                               Pageable pageable);



    @Query(value = "select me from MessageEntity me where " +
            "(me.createdDate between :dateFrom and :dateTo)" +
            " and (me.channel = :channel)" +
            " order by me.createdDate desc ")
    Page<MessageEntity> findMessageEntitiesByChannelAndDates(String channel, LocalDateTime dateFrom,
                                                             LocalDateTime dateTo,  Pageable pageable);


}
