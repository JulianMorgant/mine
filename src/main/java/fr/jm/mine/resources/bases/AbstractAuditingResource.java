package fr.jm.mine.resources.bases;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Hamza HABCHI
 * @contact hamza.habchi@acensi.fr or hamzahabchi.pro@gmail.com
 * <p>
 * Created 11 Apr 2019
 */
@Getter
@Setter
public abstract class AbstractAuditingResource extends AbstractBaseResource {

  private LocalDateTime createdDate;
  private String createdBy;
  private LocalDateTime modifiedDate;
  private String modifiedBy;

}
