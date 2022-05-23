package com.inti.SpringBootValidationThymeleaf.service;

import java.util.ArrayList;
import java.util.List;

import com.inti.SpringBootValidationThymeleaf.model.Role;
import com.inti.SpringBootValidationThymeleaf.model.Utilisateur;
import com.inti.SpringBootValidationThymeleaf.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		//va vérifier en bdd de retrouver l'user saisi par le client
		Utilisateur utilisateur = utilisateurRepository.findByUsernameOrEmail(username, username);
		
		if(utilisateur == null)
		{
			throw new UsernameNotFoundException("Le username " + username + " n'existe pas en BDD");
		}
		
		return new User(utilisateur.getUsername(), utilisateur.getMdp(), getListeGrantedAuthority(Utilisateur u));
		
	}

	
	private List<GrantedAuthority> getListeGrantedAuthority(Utilisateur u)
	{
		List<GrantedAuthority> listeGrantedAthorities = new ArrayList<GrantedAuthority>();
		Role r = u.getRole();
		
		listeGrantedAthorities.add(new SimpleGrantedAuthority(r.getNomRole()));
		
		return listeGrantedAthorities;
	}
	
	
}
