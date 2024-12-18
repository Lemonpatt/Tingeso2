package com.tingeso.ms_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Ms5Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms5Application.class, args);
	}

}
