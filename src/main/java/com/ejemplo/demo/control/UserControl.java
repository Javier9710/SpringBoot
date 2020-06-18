package com.ejemplo.demo.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.entities.Alumno;
import com.ejemplo.demo.repository.AlumnoRepository;

@RestController
//@RequestMapping("/user")
public class UserControl {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	
	@GetMapping("/user/hola")
	public String index() {
		/*Optional<Alumno> alumnoOpt= alumnoRepository.findById("1234");
		Alumno alumno = alumnoOpt.get();*/
		return "Hola Mundo con Spring BOOT ";
	}
	
	
	
	@GetMapping("/user/get/{codigo}")
	public String ver(@PathVariable String codigo) {
		Optional<Alumno> alumnoOpt= alumnoRepository.findById(codigo);
		if (!alumnoOpt.isPresent()) {
			return "El codigo no se encuentra registrado";
			
		}else {
			
		
			
			Alumno alumno = alumnoOpt.get();
			return "Hola Mundo con Spring BOOT (Metodo GET): "+ alumno.getNombre();
		}
		
	}
	
	
	@PostMapping("/user/hola")
	public String post() {
		return "Hola Mundo con Spring BOOT (Metodo POST)";
	}
}
