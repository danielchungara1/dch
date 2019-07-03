package com.model;
/*


 * 
 * 
 * 
 * 
 * 
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.data.RepoObjetosInterface;



@Controller
@SpringBootApplication(scanBasePackages={"com.data", "com.model"})
public class Main {
	
	

	@Autowired
	@Qualifier("RepoHDB") 
	RepoObjetosInterface repoObjetos;
	
	

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Main.class, args);
	}

	@RequestMapping("/")
	String index(Model model) throws Exception{

		model.addAttribute("publicaciones",repoObjetos.getPublicacionesByIdVendedor("1", 5));
	
		return "index";
	}

	@RequestMapping("/publicacion")
	String publicacion(Model model, @RequestParam("id_vendedor") String id_vendedor, @RequestParam("id_publicacion") String id_publicacion)throws Exception {
		
		Vendedor vend = repoObjetos.getVendedorById(id_vendedor);
		Publicacion pub = vend.getPublicacion(id_publicacion);
		model.addAttribute("publicacion",pub);
		return "publicacion";
	}
}
