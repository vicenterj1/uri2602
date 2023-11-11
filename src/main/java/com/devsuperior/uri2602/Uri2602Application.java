package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
//			System.out.println("ola");
//		
//			String url;
//			
//			Connection o = null;
//			try {
//				url = "jdbc:postgresql://localhost:5432/uri2602";
//				o = DriverManager.getConnection(url,"postgres", "1234567");
//				System.out.println("Conectado.");
//			} catch (Exception e)
//			{
//				System.out.println("Erro de conexão." + e.toString());
//			} finally {
//				o.close();
//			}
		
		try {
			List<CustomerMinProjection> list = repository.search1("RS");
		
			for (CustomerMinProjection obj : list) {
				System.out.println(obj.getName());
			}
			
			List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
			
			for (CustomerMinDTO obj: result1) {
				// chama o getstring direto
				System.out.println(obj);
			}
			
		} catch (Exception e)
		{
			System.out.println("Erro de leitura:" + e.toString());
		}
	
		
	}
}
