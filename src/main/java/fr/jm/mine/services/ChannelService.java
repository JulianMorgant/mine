package fr.jm.mine.services;

import fr.jm.mine.resources.entities.MessageFullResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

public interface ChannelService {

    Page<String> getAllChannelsNames(Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannelAndDates(String channel,LocalDateTime dateFrom,
                                                              LocalDateTime dateTo, Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannelAndDatesAndAuthor(String channel, LocalDateTime dateFrom,
                                                                       LocalDateTime dateTo,String author,
                                                                       Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannelAndDatesAndAuthorStartBy(String channel, LocalDateTime dateFrom,
                                                                              LocalDateTime dateTo,String author,
                                                                              Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannelAndDatesAndAuthorContains(String channel,LocalDateTime dateFrom,
                                                                               LocalDateTime dateTo, String author,
                                                                               Pageable pageable);


}
