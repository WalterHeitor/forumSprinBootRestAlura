package br.com.alura.forum.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.forum.modelo.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);

	@Query(" SELECT u FROM Usuario u WHERE u.id = :idUsuario ")
	Usuario findOne(@Param("idUsuario") Long idUsuario);

}
