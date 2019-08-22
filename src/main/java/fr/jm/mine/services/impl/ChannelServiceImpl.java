package fr.jm.mine.services.impl;

import fr.jm.mine.entities.MessageEntity;
import fr.jm.mine.exceptions.ResourceNotFoundException;
import fr.jm.mine.repositories.MessageRepository;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.services.ChannelService;
import fr.jm.mine.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<MessageFullResource> getAllMessagesByChannel(String channel, Pageable pageable) {
        Page<MessageEntity> messageEntities = messageRepository.findMessageEntitiesByChannel(channel,pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No channel " + channel + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannelAndAuthor(String channel, String author, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannelAndCreationDateBetween(String channel, String creationDateRangeIn, String creationDateRangeOut, Pageable pageable) {
        return null;
    }
}
