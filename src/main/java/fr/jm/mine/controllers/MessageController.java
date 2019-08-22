package fr.jm.mine.controllers;

import fr.jm.mine.resources.entities.MessageBodyResource;
import fr.jm.mine.resources.entities.MessageFullResource;
import fr.jm.mine.resources.entities.MessageResponseResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@RequestMapping("/messages")
public interface MessageController {



    @GetMapping("/{messageId}")
    MessageFullResource getMessageById(@PathVariable Long messageId);

    @GetMapping("/test")
    String getTestString(
            @RequestParam(value = "text", defaultValue = "", required = false)
                    String requestText);




    @PostMapping
    MessageFullResource postMessage(
            @Valid
            @RequestBody MessageBodyResource messageBodyResource
    );


}
