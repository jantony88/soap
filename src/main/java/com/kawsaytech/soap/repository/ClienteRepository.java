package com.kawsaytech.soap.repository;


import com.kawsaytech.soap.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByIdentificacion(String identificacion);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cliente c WHERE c.identificacion = :cedula")
    void deleteByIdentificacion(String cedula);
}
