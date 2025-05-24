package com.charles.sevenbankapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SevenBankApiApplication {

	public static void main(String[] args) throws UnknownHostException {

		// Sobe o Spring e obtém o contexto
		ConfigurableApplicationContext ctx = SpringApplication.run(SevenBankApiApplication.class, args);

		// Recupera host e porta
		Environment env = ctx.getEnvironment();
		String port = env.getProperty("local.server.port");
		String host = InetAddress.getLocalHost().getHostAddress();

		// Imprime no console
		System.out.println("Running on → http://" + host + ":" + port);

	}

}
