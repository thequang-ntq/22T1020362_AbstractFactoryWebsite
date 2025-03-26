package _22T1020362.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class TextConfig {
	
	@Value("${app.gittoken}")
	private String gittoken;
	@Value("${app.gistid.sv}")
	private String gistidsv;
	@Value("${app.gistid.ndt}")
	private String gistidndt;
	@Value("${app.filename.sv}")
	private String filenamesv;
	@Value("${app.filename.ndt}")
	private String filenamendt;

	@Bean
    public String getGittoken() {
        return gittoken;
    }
	
	@Bean
    public String getGistidsv() {
        return gistidsv;
    }
	
	@Bean
	public String getGistidndt() {
		return gistidndt;
	}
	
	@Bean
	public String getFilenamesv() {
		return filenamesv;
	}
	
	@Bean
	public String getFilenamendt() {
		return filenamendt;
	}
	
}
