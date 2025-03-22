package _22T1020362.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class TextConfig {
	
	@Value("${app.datasource.textfile.path}")
	private String txtFileUrl;

	@Bean
    public String txtPath() {
        return txtFileUrl;
    }
}
