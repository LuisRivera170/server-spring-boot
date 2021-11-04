package com.lara.server;

import com.lara.server.model.Server;
import com.lara.server.service.ServerServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.lara.server.enumeration.Status.SERVER_DOWN;
import static com.lara.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerServiceImpl serverService) {
		return args -> {
			serverService.create(new Server(null, "192.168.1.85", "MacBook Pro 16\"", "16 GB", "Personal PC", "", SERVER_UP));
			serverService.create(new Server(null, "192.168.1.160", "Fedora Linux", "16 GB", "Dell Tower", "", SERVER_DOWN));
			serverService.create(new Server(null, "192.168.1.21", "MS 2008", "32 GB", "Web Server PC", "", SERVER_UP));
			serverService.create(new Server(null, "192.168.1.14", "Red Hat Linux", "16 GB", "Mail Server", "", SERVER_DOWN));
		};
	}

}
