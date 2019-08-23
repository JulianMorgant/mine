package fr.jm.mine.services;

import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */


public interface MessageService {

    MessageFullResource getMessageById(Long messageId);

    Page<MessageFullResource> getAllMessagesByChannel(String channel, Pageable pageable);

    Page<MessageFullResource> getAllMessagesByAuthor(String author, Pageable pageable);

    MessageFullResource addNewMessage(MessageFullResource messageFullResource);

    MessageFullResource checkAndFormatNewMessageFullResource (MessageBodyResource messageBodyResource);


}
