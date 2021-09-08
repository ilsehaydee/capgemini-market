package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

    @Query(value = "UPDATE cliente c SET nombre = ?1 WHERE c.id = ?2 ; ", nativeQuery = true)
    Optional<Cliente> actualizarNombreCliente(String nombre, String id);

    List<Cliente> findByIdOrderByNombreAsc(String id);

    //Optional<List<Cliente>> findByComprasOrderByFechaAsc(String id);

    Optional<List<Cliente>> findByNombreAndApellidos(String nombre, String apellidos);




}
