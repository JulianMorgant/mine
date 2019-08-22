package fr.jm.mine.services;

import fr.jm.mine.resources.entities.MessageFullResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

public interface ChannelService {

    Page<String> getAllChannelsNames(Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannel(String channel, Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannelAndAuthor(String channel, String author, Pageable pageable);

    Page<MessageFullResource> getAllMessagesByChannelAndCreationDateBetween(String channel, String creationDateRangeIn,
                                                                            String creationDateRangeOut, Pageable pageable);


}
