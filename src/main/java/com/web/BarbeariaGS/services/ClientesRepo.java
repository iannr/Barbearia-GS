package com.web.BarbeariaGS.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.BarbeariaGS.models.Cliente;

public interface ClientesRepo extends CrudRepository<Cliente, Integer>{
    
    @Query(value= "select CASE WHEN count(1)>0 THEN 'true' ELSE 'false' END from clientes where id = :id", nativeQuery = true)
    public boolean exist(int id);

}