package dtos;

public class FuncionarioRequest {

	private String nome;
	private String cpf;
	private EnderecoRequest endereco;

	public FuncionarioRequest() {
	}

	public FuncionarioRequest(String nome, String cpf, EnderecoRequest endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
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

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequest endereco) {
		this.endereco = endereco;
	}
}
