package com.ejemplo.demo.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ejemplo.demo.entities.Alumno;
import com.ejemplo.demo.entities.Materia;
import com.ejemplo.demo.repository.AlumnoRepository;
import com.ejemplo.demo.repository.DocenteRepository;
import com.ejemplo.demo.repository.MateriaRepository;

@Controller
public class ViewControl {
	
	
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	DocenteRepository docenteRepository;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Materia> materiasOpt= materiaRepository.findAll();
		if (materiasOpt==null) {
			return "No existen materias";
			
		}
	    
		model.addAttribute("materias", materiasOpt);
		
		model.addAttribute("nombre", "Javier Moncada");
		
		
		return "index";
	}
	
	@GetMapping("/index/{codigo:.+}")
	public String indexver(Model model, @PathVariable String codigo) {
		
		Optional<Alumno> alumnoOpt= alumnoRepository.findById(codigo);
		if (!alumnoOpt.isPresent()) {
			return "El codigo no se encuentra registrado";
			
		}
		Alumno alumno = alumnoOpt.get();
		model.addAttribute("alumnos", alumno);
		return "index";
	}
	
	@GetMapping("/index/materia")
	public String materias(Model model) {
		
		List<Materia> materiasOpt= materiaRepository.findAll();
		if (materiasOpt==null) {
			return "No existen materias";
			
		}
	    
		model.addAttribute("materias", materiasOpt);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	
	@GetMapping("/materia/nueva")
	public String materiasnuevo(Model model) {
		
	    model.addAttribute("materia", new Materia());
	    model.addAttribute("enlace", "/materia/registro");
	    model.addAttribute("docentes", docenteRepository.findAll());

		return "/materia";
	}
	
	
	@PostMapping("/materia/registro")
public String materiasRegistro(@ModelAttribute(value="materia") Materia materia, RedirectAttributes r) {
		
		materiaRepository.save(materia);
		return "redirect:/index/materia";
	}
	
	
	@GetMapping("/materia/{id:.+}")
	public String materiaInfo(Model model, @PathVariable Integer id) {
		
		Optional<Materia> materiaOpt = materiaRepository.findById(id);
		if (!materiaOpt.isPresent()) 
			return "index";
		
		Materia materia = materiaOpt.get();
		
		
	    model.addAttribute("materia", materia);
	    model.addAttribute("enlace", "/materia/actualizar");
	    model.addAttribute("docentes", docenteRepository.findAll());

		return "/materia";
	}
	
	
	@PostMapping("/materia/actualizar")
public String materiasActualizar(@ModelAttribute(value="materia") Materia materia, RedirectAttributes r) {
		
		materiaRepository.save(materia);
		return "redirect:/index/materias";
	}

	}


	
