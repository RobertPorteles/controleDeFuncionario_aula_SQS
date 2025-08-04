package dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioResponse implements Serializable {

	private UUID id;
	private String nome;
	private String cpf;
	private LocalDate dataAdmissao;
	private EnderecoResponse endereco;

	public FuncionarioResponse() {
	}

	public FuncionarioResponse(UUID id, String nome, String cpf, LocalDate dataAdmissao, EnderecoResponse endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataAdmissao = dataAdmissao;
		this.endereco = endereco;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public EnderecoResponse getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResponse endereco) {
		this.endereco = endereco;
	}
}
