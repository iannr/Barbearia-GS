package com.web.BarbeariaGS.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.BarbeariaGS.models.Agendamento;
import com.web.BarbeariaGS.models.Funcionario;

public interface AgendamentoRepo extends CrudRepository<Agendamento, Integer>{
      @Query(value= "select CASE WHEN count(1)>0 THEN 'true' ELSE 'false' END from agendamentos where id = :id", nativeQuery = true)
    public boolean exist(int id);

    @Query(value= "select CASE WHEN count(1)>0 THEN 'true' ELSE 'false' END from agendamentos where email = :email", nativeQuery = true)
    public boolean existsByEmail(String email);

    @Query(value= "select * from agendamentos where email = :email and senha = :senha", nativeQuery = true)
    public Funcionario login(String email, String senha);

    @Query(value = "select * from agendamentos where email = :email", nativeQuery = true)
    Funcionario findByEmail(String email);

    @Query(value = "select senha from agendamentos where email = :email", nativeQuery = true)
    String findSenhaByEmail(String email);

    @Query(value = "select * from agendamentos where email = :email and id <> :id", nativeQuery = true)
    Funcionario findByEmailAndIdNot(String email, int id);
}
