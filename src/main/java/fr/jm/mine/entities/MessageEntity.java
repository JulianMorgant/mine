package fr.jm.mine.entities;

import fr.jm.mine.entities.base.AbstractAuditingEntity;
import fr.jm.mine.entities.base.AbstractBaseEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@Entity
@Table(name = "messages")
@Data
public class MessageEntity extends AbstractAuditingEntity {

    private String channel;
    private String messageText;
    private String author;

}
