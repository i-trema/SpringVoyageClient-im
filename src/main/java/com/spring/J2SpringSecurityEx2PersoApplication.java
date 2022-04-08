package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.repositories.ClientRepository;
import com.spring.repositories.VoyageRepository;
import com.spring.services.AccountServiceImplement;

@SpringBootApplication
public class J2SpringSecurityEx2PersoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(J2SpringSecurityEx2PersoApplication.class, args);
	}
	
	@Autowired
	VoyageRepository voyageRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AccountServiceImplement accountServiceImplement;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		accountServiceImplement.saveAdmin(new Admin("admin", "1234", true, null));
//		accountServiceImplement.saveAdmin(new Admin("supervisor", "1234", true, null));
//		
//		accountServiceImplement.saveRole(new AppRole("ADMIN"));
//		accountServiceImplement.saveRole(new AppRole("SUPERVISOR"));		
//		
//		accountServiceImplement.addRoleToAdmin("admin", "ADMIN");
//		accountServiceImplement.addRoleToAdmin("supervisor", "SUPERVISOR");		
//		
//		
//		Client c1 = clientRepository.save(new Client("adresse1", 22, "1@1.1", "employé", "nomclient1", "prenomclient1", "01220112201"));
//		
//		Voyage v1 = voyageRepository.save(new Voyage("date v1", "fdjkfgjhkdkjgkjhdfjgdf", "superviseur1", "Barcelone", 300));
//		
//		
//		
		
		
	}

}
