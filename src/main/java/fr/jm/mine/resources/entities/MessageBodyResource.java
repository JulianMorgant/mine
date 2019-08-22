package fr.jm.mine.resources.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@Getter
@Setter
public class MessageBodyResource {

    @NotBlank
    private String channel;
    @NotBlank
    private String messageText;
    @NotBlank
    private String author;

}
