package com.haythem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haythem.entities.Etudiant;
import com.haythem.repository.EtudiantRepository;

@RestController
public class EtudiantRestService {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE"})
	@RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)
	public Etudiant saveEtudiant(@RequestBody Etudiant e) {
		return etudiantRepository.save(e);
	}
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE","ROLE_PROF","ROLE_ETUDIANT"})
	@RequestMapping(value="/etudiants")
	public Page<Etudiant>listEtudiant(int page, int size){
		return etudiantRepository.findAll(new PageRequest(page, size));
				
	}
	@RequestMapping(value="/getLogedUser")// recuperation de donne de personne connecte
	public Map<String, Object>getLogedUser(HttpServletRequest request){
		HttpSession session= request.getSession();// fiha les donne kol mete3 securite
		SecurityContext context=(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = context.getAuthentication().getName();
		List<String>roles=new ArrayList<>();
		for (GrantedAuthority ga :context.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		Map<String, Object>params= new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
		
	}
}
