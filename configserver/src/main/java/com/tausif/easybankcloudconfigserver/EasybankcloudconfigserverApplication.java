package com.tausif.easybankcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EasybankcloudconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasybankcloudconfigserverApplication.class, args);
	}

}
