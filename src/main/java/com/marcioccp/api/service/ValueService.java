package com.marcioccp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcioccp.api.dominio.Value;
import com.marcioccp.api.repositories.ValuesRepository;


@Service
public class ValueService {

	@Autowired
	private ValuesRepository repo;

	public List<Value> todas() {
		List<Value> obj = repo.findAll();

		return obj;
	}

	public Optional<Value> busca(Integer sequencial) {
		Optional<Value> obj = repo.findById(sequencial);

		return obj;
	}

	public Example<Value> buscaPorNome(String alias) {

		Value v = new Value();
	
		Example<Value> obj = Example.of(v);
		

		return obj;
	}
	
	public Value pegarOnjsto(Value value) {

		Value v = new Value();
	
		Value obj = (Value) Example.of(value);
		

		return obj;
	}

}
