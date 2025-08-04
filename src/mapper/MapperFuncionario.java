package mapper;

import java.time.LocalDate;
import java.util.UUID;

import dtos.EnderecoResponse;
import dtos.FuncionarioRequest;
import dtos.FuncionarioResponse;
import entities.Endereco;
import entities.Funcionario;

public class MapperFuncionario {

    public Funcionario toEntity(FuncionarioRequest funcionarioRequest) {
        var funcionario = new Funcionario();
        funcionario.setId(UUID.randomUUID());
        funcionario.setNome(funcionarioRequest.getNome());
        funcionario.setCpf(funcionarioRequest.getCpf());
        funcionario.setDataAdmissao(LocalDate.now());

        var endereco = new Endereco();
        endereco.setId(UUID.randomUUID());
        endereco.setLogradouro(funcionarioRequest.getEndereco().getLogradouro());
        endereco.setNumero(funcionarioRequest.getEndereco().getNumero());
        endereco.setComplemento(funcionarioRequest.getEndereco().getComplemento());
        endereco.setBairro(funcionarioRequest.getEndereco().getBairro());
        endereco.setCidade(funcionarioRequest.getEndereco().getCidade());
        endereco.setEstado(funcionarioRequest.getEndereco().getEstado());
        endereco.setCep(funcionarioRequest.getEndereco().getCep());

        funcionario.setEndereco(endereco);

        return funcionario;
    }

    public FuncionarioResponse toResponse(Funcionario funcionario) {
        var funcionarioResponse = new FuncionarioResponse();
        funcionarioResponse.setId(funcionario.getId());
        funcionarioResponse.setNome(funcionario.getNome());
        funcionarioResponse.setCpf(funcionario.getCpf());
        funcionarioResponse.setDataAdmissao(funcionario.getDataAdmissao());

        var endereco = funcionario.getEndereco();
        var enderecoResponse = new EnderecoResponse();
        enderecoResponse.setId(endereco.getId());
        enderecoResponse.setLogradouro(endereco.getLogradouro());
        enderecoResponse.setNumero(endereco.getNumero());
        enderecoResponse.setComplemento(endereco.getComplemento());
        enderecoResponse.setBairro(endereco.getBairro());
        enderecoResponse.setCidade(endereco.getCidade());
        enderecoResponse.setEstado(endereco.getEstado());
        enderecoResponse.setCep(endereco.getCep());
        funcionarioResponse.setEndereco(enderecoResponse);

        return funcionarioResponse;
    }
}
