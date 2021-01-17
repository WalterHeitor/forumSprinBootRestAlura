package br.com.alura.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repositories.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Dados invalidos");
	}
	
	public static void main(String[] args) {
		//@Autowired
		UsuarioRepository usuarioRepository = null;
		Usuario u = usuarioRepository.findById(1L).get();
		System.out.println(u);
		System.out.println("Imprimir usuario "+u);
	}

}
