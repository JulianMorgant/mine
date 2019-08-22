package fr.jm.mine.entities.base;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;


/**
 * @author Hamza HABCHI
 * @contact hamza.habchi@acensi.fr or hamzahabchi.pro@gmail.com
 * <p>
 * Created 04 Mar 2019
 */

@Data
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
