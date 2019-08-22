package fr.jm.mine.configs;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/*import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
*/
/**
 * @author Hamza HABCHI
 * @contact hamza.habchi@acensi.fr or hamzahabchi.pro@gmail.com
 * <p>
 * Created 11 Mar 2019
 */
@EnableJpaAuditing
@Configuration
public class AuditingConfig {

  private class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
      return Optional.of("Auditor"); //TODO https://www.baeldung.com/database-auditing-jpa
    }
  }


  @Bean
  AuditorAware<String> auditorProvider() {
    return new AuditorAwareImpl();
  }
}



