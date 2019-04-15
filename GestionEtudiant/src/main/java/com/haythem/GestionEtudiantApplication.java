package com.haythem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.haythem.entities.Etudiant;
import com.haythem.repository.EtudiantRepository;

@SpringBootApplication
public class GestionEtudiantApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRepository etudiantRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionEtudiantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		 * etudiantRepository.save(new
		 * Etudiant("nour","sallemi",df.parse("2000-11-02")));
		 */
		/*
		 * etudiantRepository.save(new Etudiant("haythem","jebel",new Date()));
		 * etudiantRepository.save(new Etudiant("hadil","jebel",new Date()));
		 * etudiantRepository.save(new Etudiant("dorsaf","sallemi",new Date()));
		 */
//		List<Etudiant> listEtud = etudiantRepository.findAll();
//		listEtud.forEach(e -> System.out.println(e.getNom()));
//		
//		for (Etudiant e : listEtud) {
//			System.out.println(e.getPrenom());
//		}
	}

}
