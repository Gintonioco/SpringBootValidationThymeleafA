package com.inti.SpringBootValidationThymeleafA.repository;

import com.inti.SpringBootValidationThymeleafA.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>
{

}
