package com.example.jpa_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateApplication {

    static DataService dataService;

	public JpaHibernateApplication(DataService injectedDataService) {
		dataService = injectedDataService;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JpaHibernateApplication.class, args);
		dataService.test();
    }

}
