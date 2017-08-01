package br.com.snackbar.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableCaching
@SpringBootApplication
public class SnackBarServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnackBarServerApplication.class, args);
	}
}
