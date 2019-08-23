package fr.jm.mine.services.impl;

import fr.jm.mine.entities.MessageEntity;
import fr.jm.mine.exceptions.ResourceNotFoundException;
import fr.jm.mine.repositories.MessageRepository;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.services.ChannelService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@Service
public class ChannelServiceImpl implements ChannelService {

    private final MessageRepository messageRepository;
    private final MessageServiceImpl messageService;
    private final ModelMapper modelMapper;

    public ChannelServiceImpl(MessageRepository messageRepository, MessageServiceImpl messageService, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<String> getAllChannelsNames(Pageable pageable) {
        Page<String> ps = messageRepository.findAllChannels(pageable);
        return ps;
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannelAndDates(String channel, LocalDateTime dateFrom,
                                                                     LocalDateTime dateTo, Pageable pageable) {
        Page<MessageEntity> messageEntities =
                messageRepository.findMessageEntitiesByChannelAndDates(channel, dateFrom, dateTo, pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No channel " + channel + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannelAndDatesAndAuthor(String channel, LocalDateTime dateFrom,
                                                                              LocalDateTime dateTo, String author,
                                                                              Pageable pageable) {
        Page<MessageEntity> messageEntities =
                messageRepository.findMessageEntitiesByChannelAndDatesAndAuthor(channel, dateFrom, dateTo, author, pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No message from " + author + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannelAndDatesAndAuthorStartBy(String channel, LocalDateTime dateFrom,
                                                                                     LocalDateTime dateTo, String author,
                                                                                     Pageable pageable) {
        Page<MessageEntity> messageEntities =
                messageRepository.findMessageEntitiesByChannelAndDatesAndLAuthorStartBy(channel, dateFrom, dateTo, author, pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No message from " + author + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannelAndDatesAndAuthorContains(String channel, LocalDateTime dateFrom,
                                                                                      LocalDateTime dateTo, String author,
                                                                                      Pageable pageable) {
        Page<MessageEntity> messageEntities =
                messageRepository.findMessageEntitiesByChannelAndDatesAndAuthorContains(channel,dateFrom,dateTo,
                        author, pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No message from " + author + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }


}
