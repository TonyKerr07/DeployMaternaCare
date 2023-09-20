package com.generation.MaternaCare.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nomeUsuario é Obrigatorio")
	@Size(min = 3, max = 255, message = "O atributo nomeUsuario deve conter no mínimo 03 e no máximo 255 caracteres")
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O atributo Email é Obrigatorio")
	@Size(min = 5, max = 100, message = "O atributo Email deve conter no mínimo 05 e no máximo 100 caracteres")
	private String usuario;
	
	@NotNull(message = "O atributo senha é Obrigatorio")
	private String senha;
	
	@NotBlank(message = "O atributo foto é Obrigatorio")
	private String foto;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
	    private List<Produto> produto;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
