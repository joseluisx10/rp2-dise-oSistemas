package com.davinci.recuperatorio_dos.repository;

import com.davinci.recuperatorio_dos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
