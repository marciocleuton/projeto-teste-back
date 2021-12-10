package com.marcioccp.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.marcioccp.api.dominio.Update;
import com.marcioccp.api.dominio.Value;
import com.marcioccp.api.util.Util;


public class UpdateService {


	
	static String webService = "https://api.msrc.microsoft.com/cvrf/v2.0/Updates";
	static int codigoSucesso = 200;

	public static Value[] buscaNaApi() throws Exception {
		String urlParaChamada = webService ;

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso) 
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

				BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
				String jsonEmString = Util.converteJsonEmString(resposta);

				Gson gson = new Gson();
				Update value = gson.fromJson(jsonEmString, Update.class);
				
				
				return value.getValue();
			

		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

	


}
