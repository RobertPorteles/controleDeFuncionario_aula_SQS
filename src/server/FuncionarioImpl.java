package server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import dtos.FuncionarioRequest;
import dtos.FuncionarioResponse;
import infra.ConnectionFactory;
import interfaces.FuncionarioServer;
import mapper.MapperFuncionario;
import repositories.EnderecoRepository;
import repositories.FuncionarioRepository;

public class FuncionarioImpl implements FuncionarioServer {

	private final MapperFuncionario mapper;
	private final FuncionarioRepository funcionarioRepository;
	private final EnderecoRepository enderecoRepository;

	// Injetando dependências
	public FuncionarioImpl(MapperFuncionario mapper, FuncionarioRepository funcionarioRepository,
			EnderecoRepository enderecoRepository) {
		this.mapper = mapper;
		this.funcionarioRepository = funcionarioRepository;
		this.enderecoRepository = enderecoRepository;
	}
	Connection con = null;
	
	@Override
	public FuncionarioResponse salvar(FuncionarioRequest request) {
		var funcionario = mapper.toEntity(request);

		try {
			Connection con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);

			enderecoRepository.inserir(con, funcionario.getEndereco());
			funcionarioRepository.inserir(con, funcionario);
			
			 con.commit();

		}catch (SQLException e) {
			  if (con != null) try { con.rollback(); } catch (SQLException ignore) {}
			  throw new RuntimeException("Falha ao salvar funcionário", e);
			} finally {
			  if (con != null) try { con.close(); } catch (SQLException ignore) {}
			}

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
