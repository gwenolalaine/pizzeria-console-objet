package config;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("fr.pizzeria.dao, fr.pizzeria.ihm, config")
@EnableJpaRepositories("fr.pizzeria.repository")
public class AppConfig {
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	/** LOG Logger */
	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger(AppConfig.class);
	}	
}
