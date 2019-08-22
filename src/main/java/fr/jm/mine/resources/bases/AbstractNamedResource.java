package fr.jm.mine.resources.bases;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Hamza HABCHI
 * @contact hamza.habchi@acensi.fr or hamzahabchi.pro@gmail.com
 * <p>
 * Created 04 Mar 2019
 */
@Getter
@Setter
public abstract class AbstractNamedResource extends AbstractAuditingResource {

  @NotBlank
  private String name;

}
