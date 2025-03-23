package _22T1020362.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class TextConfig {
	
	@Value("${app.datasource.textfile.pathSV}")
	private String urlSV;
	@Value("${app.datasource.textfile.pathNDT}")
	private String urlNDT;

	@Bean
    public String txtPathSV() {
        return urlSV;
    }
	
	@Bean
    public String txtPathNDT() {
        return urlNDT;
    }
}
