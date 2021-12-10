package com.marcioccp.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.marcioccp.api.dominio.Value;


@Repository
public interface ValuesRepository extends JpaRepository<Value, Integer> {
	
	
	
	 //List<Value> findByNome(String nome);
}
