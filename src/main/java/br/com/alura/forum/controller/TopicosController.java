package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositories.TopicoRepository;

//@Controller
@RestController
public class TopicosController {

	
	//@ResponseBody //com @RestController nao prescisa declara @responsebody.
	@Autowired
	private TopicoRepository topicoRepository;
	@GetMapping("/topicos")
	public List<TopicoDTO> lista(){
		/*
		 * Topico t = new Topico("Dúvida", "Dúvida Spring", new Curso("Spring",
		 * "Progamação"));
		 * return TopicoDTO.converter(Arrays.asList(t,t,t,t));
		 */
		List<Topico>topicos = topicoRepository.findAll();
		return TopicoDTO.converter(topicos);
	}
}
