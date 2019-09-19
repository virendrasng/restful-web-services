package com.in28minutes.rest.webservices.restfulwebservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner{
	private static Logger LOGGER = LoggerFactory.getLogger(CommandLineRunnerDemo.class);
	
	/**
	 * Run method is called after - Started RestfulWebServicesApplication in 23.839 seconds (JVM running for 26.533)
	 * message is displayed on the console.
	 */
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("*********************** From CommandLineRunnerDemo **************");
	}

}
