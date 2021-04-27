package com.unifolio.medsys.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unifolio.medsys.services.DBService;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private DBService dbservice;

	@Override
	public void run(String... args) throws Exception {
		dbservice.instantiateTestDatabase();
	}

}
