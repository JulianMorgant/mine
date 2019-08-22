package fr.jm.mine.resources.entities;

import fr.jm.mine.resources.bases.AbstractAuditingResource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@Getter
@Setter
@Validated
public class MessageFullResource extends AbstractAuditingResource {

    private String channel;
    private String messageText;
    private String author;

}
