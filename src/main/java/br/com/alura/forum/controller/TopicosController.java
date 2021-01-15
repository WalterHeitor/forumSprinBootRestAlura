package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositories.TopicoRepository;

//@Controller
@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso){
		if(nomeCurso == null) {
			List<Topico>topicos = topicoRepository.findAll();
			return TopicoDTO.converter(topicos);			
		}else {
			List<Topico>topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDTO.converter(topicos);
		}
	}
	
	@PostMapping
	public void cadastrar( @RequestBody TopicoForm form) { //anotaçao para indicar ao Spring que vai passar os parametros no corpo da requisiçao.
		Topico topico = form.converter();
		topicoRepository.save(topico);
	}
	
}
