package principal;

import java.util.Scanner;

import controllers.FuncionarioController;
import dtos.EnderecoRequest;
import dtos.FuncionarioRequest;
import mapper.MapperFuncionario;
import repositories.EnderecoRepository;
import repositories.FuncionarioRepository;
import server.FuncionarioImpl;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do funcionário:");
		String nome = scanner.nextLine();

		System.out.println("Digite o CPF do funcionário:");
		String cpf = scanner.nextLine();

		System.out.println("Digite o logradouro:");
		String logradouro = scanner.nextLine();

		System.out.println("Digite o número:");
		String numero = scanner.nextLine();

		System.out.println("Digite o complemento:");
		String complemento = scanner.nextLine();

		System.out.println("Digite o bairro:");
		String bairro = scanner.nextLine();

		System.out.println("Digite a cidade:");
		String cidade = scanner.nextLine();

		System.out.println("Digite o estado:");
		String estado = scanner.nextLine();

		System.out.println("Digite o CEP:");
		String cep = scanner.nextLine();

		// Criar DTOs
        var enderecoRequest = new EnderecoRequest(logradouro, numero, complemento, bairro, cidade, estado, cep);
        var funcionarioRequest = new FuncionarioRequest(nome, cpf, enderecoRequest);

        // Injetando dependências
        var mapper = new MapperFuncionario();
        var funcionario = new FuncionarioRepository();
        var endereco = new EnderecoRepository();
        var service = new FuncionarioImpl(mapper, funcionario, endereco);
        var controller = new FuncionarioController(service);

        // Chamar o controller
        var response = controller.cadastrarFuncionario(funcionarioRequest);

		System.out.println("\nFuncionário cadastrado com sucesso:");
		System.out.println("ID: " + response.getId());
		System.out.println("Nome: " + response.getNome());
		System.out.println("CPF: " + response.getCpf());
		System.out.println("Data de admissão: " + response.getDataAdmissao());

		scanner.close();
	}
}
