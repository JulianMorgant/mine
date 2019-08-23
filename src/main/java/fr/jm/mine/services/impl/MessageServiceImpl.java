package fr.jm.mine.services.impl;


import fr.jm.mine.entities.MessageEntity;
import fr.jm.mine.exceptions.ResourceNotFoundException;
import fr.jm.mine.repositories.MessageRepository;
import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageFullResource getMessageById(Long messageId) {
        Optional<MessageEntity> messageEntity = messageRepository.findOneById(messageId);
        if (!messageEntity.isPresent()) {
            throw new ResourceNotFoundException("No message wthis id : " + messageId + " found");
        }
        return modelMapper.map(messageEntity.get(), MessageFullResource.class);
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByChannel(String channel, Pageable pageable) {
        Page<MessageEntity> messageEntities = messageRepository.findMessageEntitiesByChannel(channel, pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No channel " + channel + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }

    @Override
    public Page<MessageFullResource> getAllMessagesByAuthor(String author, Pageable pageable) {
        Page<MessageEntity> messageEntities = messageRepository.findMessageEntitiesByAuthor(author, pageable);
        if (messageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No author " + author + " found");
        }
        return messageEntities.map(s -> modelMapper.map(s, MessageFullResource.class));
    }



    @Override
    public MessageFullResource addNewMessage(MessageFullResource messageFullResource) {
        //TODO Check errors
        MessageEntity messageEntity = modelMapper.map(messageFullResource, MessageEntity.class);
        return modelMapper.map(messageRepository.save(messageEntity), MessageFullResource.class);
    }

    @Override
    public MessageFullResource checkAndFormatNewMessageFullResource(MessageBodyResource messageBodyResource) {

        //TODO Check errors
        return modelMapper.map(messageBodyResource, MessageFullResource.class);
    }
}
