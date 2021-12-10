package com.marcioccp.api;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.marcioccp.api.dominio.Value;
import com.marcioccp.api.repositories.ValuesRepository;
import com.marcioccp.api.resources.ValueResources;
import com.marcioccp.api.service.UpdateService;
import com.marcioccp.api.service.ValueService;



@SpringBootApplication
public class ApiMicrosoftSecurityUpdatesApplication implements CommandLineRunner {
	
	@Autowired
	private  ValuesRepository repo;
	
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiMicrosoftSecurityUpdatesApplication.class, args);
	
		
		
		
	}
	
	

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			System.out.print("Iniciando a importação de Dados: ");
	      
	        Value[] values = UpdateService.buscaNaApi();
	        
	        Value v = new Value();
	        
	        for(Value item : values){
	            System.out.print(item.toString() + "\n"); 
	            v = item;
	            repo.saveAll(Arrays.asList(v));
	        }
	    	System.out.println("Dados Salvos com Sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			e.getLocalizedMessage();
			System.out.println("Erro ao Salvar os dados" + e.getMessage());
		}
		
		
		Timer time = new Timer();
		
		final long SEGUNDOS = (1000 *60);		
		TimerTask tarefe = new TimerTask() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(new Date());
				try {
					  
					 Value[] value = UpdateService.buscaNaApi();
					  
				     List<Value> v =  repo.findAll();
				     ValueResources servive = new ValueResources();		 
					 for(Value item : value){
				           
				       
				        	repo.save(item);
				        	
				        
				        	
				        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		time.scheduleAtFixedRate(tarefe, 0, SEGUNDOS);
       
		
		
	
		
		
	}

}
