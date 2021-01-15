package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

//@Controller
@RestController
public class TopicosController {

	@GetMapping("/topicos")
	//@ResponseBody //com @RestController nao prescisa declara @responsebody.
	public List<TopicoDTO> lista(){
		Topico t = new Topico("Dúvida", "Dúvida Spring", 
				new Curso("Spring", "Progamação"));
		return TopicoDTO.converter(Arrays.asList(t,t,t,t));
	}
}
