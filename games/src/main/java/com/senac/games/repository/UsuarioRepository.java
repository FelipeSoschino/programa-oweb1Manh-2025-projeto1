package com.senac.games.repository;



import com.senac.games.entity.Patrocinador;
import com.senac.games.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Usuario p SET p.status = -1 where p.id = :id")
    void apagarUsuario(Integer usuarioId);

    @Query("SELECT p FROM Usuario p where p.status >= 0")
    List<Usuario> listarUsuarios();
    @Query("SELECT p FROM Usuario p where p.status >= 0 AND p.id = :id")
    Usuario listarUsuarioPorId(@Param("id") Integer usuarioId);
}
