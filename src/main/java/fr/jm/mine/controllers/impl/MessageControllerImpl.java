package fr.jm.mine.controllers.impl;

import fr.jm.mine.controllers.MessageController;
import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.resources.entities.MessageResponseResource;
import fr.jm.mine.services.impl.MessageServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@RestController
public class MessageControllerImpl implements MessageController {

    private MessageServiceImpl messageService;

    public MessageControllerImpl(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @Override
    public MessageFullResource getMessageById(Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @Override
    public String getTestString(String requestText) {
        return "test " + requestText;
    }

    @Override
    public MessageFullResource postMessage(@Valid MessageBodyResource messageBodyResource) {

        MessageFullResource mfr = messageService.checkAndFormatNewMessageFullResource(messageBodyResource);
        return messageService.addNewMessage(mfr);

    }
}
