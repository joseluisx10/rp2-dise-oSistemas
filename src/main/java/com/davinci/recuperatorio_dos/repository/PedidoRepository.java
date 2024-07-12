package com.davinci.recuperatorio_dos.repository;

import com.davinci.recuperatorio_dos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT DISTINCT p FROM Pedido p LEFT JOIN FETCH p.productos")
    List<Pedido> findAllConProductos();
}
