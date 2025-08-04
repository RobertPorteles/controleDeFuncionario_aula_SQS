package server;

import java.util.List;
import java.util.UUID;

import dtos.FuncionarioRequest;
import dtos.FuncionarioResponse;
import interfaces.FuncionarioServer;
import mapper.MapperFuncionario;
import repositories.FuncionarioRepository;

public class FuncionarioImpl implements FuncionarioServer {

	private final MapperFuncionario mapper = new MapperFuncionario();
	private final FuncionarioRepository repository = new FuncionarioRepository();

	@Override
	public FuncionarioResponse salvar(FuncionarioRequest request) {
		var funcionario = mapper.toEntity(request);
		repository.inserir(funcionario);
		return mapper.toResponse(funcionario);
	}

	@Override
	public List<FuncionarioResponse> listarProdutos() {
		// Ainda não implementado
		return null;
	}

	@Override
	public FuncionarioResponse buscarProdutoPorId(UUID id) {
		// Ainda não implementado
		return null;
	}

	@Override
	public FuncionarioResponse atualizarProduto(UUID id, FuncionarioRequest produto) {
		// Ainda não implementado
		return null;
	}

	@Override
	public FuncionarioResponse deletarProduto(UUID id) {
		// Ainda não implementado
		return null;
	}
}
