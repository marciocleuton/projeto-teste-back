package com.marcioccp.api.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcioccp.api.dominio.Value;
import com.marcioccp.api.service.ValueService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "values")
public class ValueResources {
	
	@Autowired
	private ValueService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista() {
		 List<Value> obj = service.todas();
		 
		 return ResponseEntity.ok().body(obj);
		 
	}	
	
	@RequestMapping(value ="/{sequencial}", method = RequestMethod.GET)
	public ResponseEntity<?> getValues(@PathVariable Integer sequencial){ 	   
			Optional<Value> obj = service.busca(sequencial);
		 
	 return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(value ="/alias/{alias}", method = RequestMethod.GET)
	public ResponseEntity<?> getValuesAlias(@PathVariable String alias){ 	   
		Example<Value> obj = service.buscaPorNome(alias);
		 
	 return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value ="/nome/{alias}", method = RequestMethod.GET)
	public ResponseEntity<?> getValuesTotal(@PathVariable Value values){ 	   
		Value obj = service.pegarOnjsto(values);
		 
	 return ResponseEntity.ok().body(obj);
	}
	
	
}
