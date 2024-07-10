package com.davinci.recuperatorio_dos.repository;

import com.davinci.recuperatorio_dos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email =:email and u.password = :password")
    Optional<Usuario> autenticar(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM Usuario u WHERE u.email =:email")
    Optional<Usuario> getByEmail(@Param("email") String email);

}
