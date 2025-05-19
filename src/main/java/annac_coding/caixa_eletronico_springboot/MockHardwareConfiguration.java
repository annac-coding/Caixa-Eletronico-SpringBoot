package annac_coding.caixa_eletronico_springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockHardwareConfiguration {
	Long numeroConta;
	@Bean
    MockHardware MockHardware() {
        return new MockHardware();
    }
 
}