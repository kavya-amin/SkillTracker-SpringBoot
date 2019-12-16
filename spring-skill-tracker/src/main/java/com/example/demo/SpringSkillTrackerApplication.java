package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.AssociateInfo;
import com.example.demo.repository.AssociateInfoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableEurekaClient
public class SpringSkillTrackerApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringSkillTrackerApplication.class);
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner setup(AssociateInfoRepository associateInfoRepository) {
		return (args) -> {
			associateInfoRepository.save(new AssociateInfo(1,"Divya", "Amin", "divyaamin@gmail.com", "1234", 9887677898L,
					"29-01-2002", "female", "bangalore", "india"));
			logger.info("The sample data has been generated");
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringSkillTrackerApplication.class, args);
	}

}
