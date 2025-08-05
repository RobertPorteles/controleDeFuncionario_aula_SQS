package repositories;

import entities.Funcionario;
import java.sql.DriverManager;

public class FuncionarioRepository {

    public void inserir(Funcionario funcionario) {
        try {
            var host = "jdbc:mysql://localhost:3306/banco?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            var user = "usuario";
            var pass = "senha";

            var connection = DriverManager.getConnection(host, user, pass);

            // Usar os IDs da entidade (já setados pelo mapper)
            String enderecoId = funcionario.getEndereco().getId().toString();
            String funcionarioId = funcionario.getId().toString();

            // Inserir o endereço primeiro
            var statementEnd = connection.prepareStatement(
                "INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, cep) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statementEnd.setString(1, enderecoId);
            statementEnd.setString(2, funcionario.getEndereco().getLogradouro());
            statementEnd.setString(3, funcionario.getEndereco().getNumero());
            statementEnd.setString(4, funcionario.getEndereco().getComplemento());
            statementEnd.setString(5, funcionario.getEndereco().getBairro());
            statementEnd.setString(6, funcionario.getEndereco().getCidade());
            statementEnd.setString(7, funcionario.getEndereco().getEstado());
            statementEnd.setString(8, funcionario.getEndereco().getCep());
            statementEnd.executeUpdate();

            // Inserir o funcionário
            var statementFun = connection.prepareStatement(
                "INSERT INTO funcionario (id, nome, cpf, dataadmissao, endereco_id) VALUES (?, ?, ?, ?, ?)");
            statementFun.setString(1, funcionarioId);
            statementFun.setString(2, funcionario.getNome());
            statementFun.setString(3, funcionario.getCpf());
            statementFun.setDate(4, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
            statementFun.setString(5, enderecoId);
            statementFun.executeUpdate();

            System.out.println("Funcionário cadastrado com sucesso!");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
