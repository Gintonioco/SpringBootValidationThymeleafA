package com.inti.SpringBootValidationThymeleafA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.SpringBootValidationThymeleaf.model.Utilisateur;
import com.inti.SpringBootValidationThymeleaf.service.User;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>
{
	
	Utilisateur findByUsernameOrEmail(String username, String email);

}
