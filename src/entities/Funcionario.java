package entities;

import java.time.LocalDate;
import java.util.UUID;

/*
 * Modelo de entidade para funcionário
 */
public class Funcionario {

	private UUID id;
	private String nome;
	private String cpf;
	private LocalDate dataAdmissao;
	private Endereco endereco;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(UUID id, String nome, String cpf, LocalDate dataAdmissao, Endereco endereco) {
		super();
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
