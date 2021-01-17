package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topico;

public class TopicoDTO {

	private Long id;
	private String titulo;
	private String menssagem;
	private LocalDateTime datacriacao;
	
	
	
	public TopicoDTO() {
		super();
	}
	
	public TopicoDTO(Long id, String titulo, String menssagem, LocalDateTime datacriacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.menssagem = menssagem;
		this.datacriacao = datacriacao;
	}
	public TopicoDTO(Topico topico) {
		super();
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.menssagem = topico.getMensagem();
		this.datacriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMenssagem() {
		return menssagem;
	}
	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}
	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}

	public static Page<TopicoDTO> converter(Page<Topico> topicos) {
		
		//return topicos.stream().map(TopicoDTO :: new).collect(Collectors.toList());
		return topicos.map(TopicoDTO ::new);
	}
	
}
