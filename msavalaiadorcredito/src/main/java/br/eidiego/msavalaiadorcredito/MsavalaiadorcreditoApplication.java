package br.eidiego.msavalaiadorcredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsavalaiadorcreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsavalaiadorcreditoApplication.class, args);
	}

}
