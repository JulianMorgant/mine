package fr.jm.mine.controllers.impl;

import fr.jm.mine.controllers.ChannelController;
import fr.jm.mine.enums.SearchModeEnum;
import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.services.ChannelService;
import fr.jm.mine.services.impl.ChannelServiceImpl;
import fr.jm.mine.services.impl.MessageServiceImpl;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

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
                                                          String strDateFrom, String strDateTo,
                                                          String channel, Pageable pageable) {

        LocalDateTime dateFrom = LocalDateTime.of(1980,02,07,0,0,0);
        LocalDateTime dateTo = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        if (!strDateFrom.equals("")) {
            dateFrom = LocalDateTime.parse(strDateFrom,formatter);
        }

        if (!strDateTo.equals("")) {
            dateTo = LocalDateTime.parse(strDateTo,formatter);
        }

        if (author.isEmpty()) {
            return channelService.getAllMessagesByChannelAndDates(channel,dateFrom,dateTo, pageable);
        } else {
            if (searchMode == SearchModeEnum.STARTBY) {
                return channelService.getAllMessagesByChannelAndDatesAndAuthorStartBy(channel,dateFrom,dateTo,author,pageable);
            }
            if (searchMode == SearchModeEnum.CONTAINS) {
                return channelService.getAllMessagesByChannelAndDatesAndAuthorContains(channel,dateFrom,dateTo,author,pageable);
            }
            // else SearchModeEnum.STRICT
            return channelService.getAllMessagesByChannelAndDatesAndAuthor(channel,dateFrom,dateTo, author, pageable);
        }
    }

    @Override
    public MessageFullResource postMessage(@Valid MessageBodyResource messageBodyResource, String channel) {
        return null;
    }
}
