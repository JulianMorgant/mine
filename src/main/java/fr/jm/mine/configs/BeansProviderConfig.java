package fr.jm.mine.configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Julian MORGANT
 * @contact julian.morgant@gmail.com
 * <p>
 * Created 22/08/2019
 */

@Configuration
public class BeansProviderConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mm = new ModelMapper();
        mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return new ModelMapper();
    }

}
