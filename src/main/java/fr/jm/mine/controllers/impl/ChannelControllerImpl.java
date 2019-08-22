package fr.jm.mine.controllers.impl;

import fr.jm.mine.controllers.ChannelController;
import fr.jm.mine.enums.SearchModeEnum;
import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.services.ChannelService;
import fr.jm.mine.services.impl.ChannelServiceImpl;
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
public class ChannelControllerImpl implements ChannelController {

    private MessageServiceImpl messageService;  //TODO Delete if possible
    private ChannelServiceImpl channelService;

    public ChannelControllerImpl(MessageServiceImpl messageService, ChannelServiceImpl channelService) {
        this.messageService = messageService;
        this.channelService = channelService;
    }

    @Override
    public Page<String> getChannelsNames(Pageable pageable) {
        return channelService.getAllChannelsNames(pageable);
    }

    @Override
    public Page<MessageFullResource> getMessagesByChannel(String author, SearchModeEnum searchMode,
                                                          String channel, Pageable pageable) {
        if (author.isEmpty()) {
            return channelService.getAllMessagesByChannel(channel, pageable);
        } else {
            if (searchMode == SearchModeEnum.STARTBY) {
                return channelService.getAllMessagesByChannelAndAuthorStartBy(channel,author,pageable);
            }
            if (searchMode == SearchModeEnum.CONTAINS) {
                return channelService.getAllMessagesByChannelAndAuthorContains(channel,author,pageable);
            }
            // else SearchModeEnum.STRICT
            return channelService.getAllMessagesByChannelAndAuthor(channel, author, pageable);
        }
    }

    @Override
    public MessageFullResource postMessage(@Valid MessageBodyResource messageBodyResource, String channel) {
        return null;
    }
}
