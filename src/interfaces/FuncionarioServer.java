package interfaces;

import java.util.List;
import java.util.UUID;

import dtos.FuncionarioRequest;
import dtos.FuncionarioResponse;

public interface FuncionarioServer {
	FuncionarioResponse salvar(FuncionarioRequest produtoRequest);
	
	List<FuncionarioResponse> listarProdutos();
	
	FuncionarioResponse buscarProdutoPorId(UUID id);
	
	FuncionarioResponse atualizarProduto(UUID id, FuncionarioRequest produto);
	
	FuncionarioResponse deletarProduto(UUID id);

	

}
