package fr.jm.mine.controllers;

import fr.jm.mine.enums.SearchModeEnum;
import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@RequestMapping("/chan")
public interface ChannelController {

    @GetMapping
    Page<String> getChannelsNames(Pageable pageable);

    @GetMapping("/{channel}")
    Page<MessageFullResource> getMessagesByChannel(
            @RequestParam(value = "author", defaultValue = "", required = false) String author,
            @RequestParam(value = "mode", defaultValue = "STRICT", required = false) SearchModeEnum searchMode,
            @PathVariable String channel, Pageable pageable);

    @PostMapping("/{channel}")
    MessageFullResource postMessage(
            @Valid
            @RequestBody MessageBodyResource messageBodyResource,
            @PathVariable String channel
    );


}
