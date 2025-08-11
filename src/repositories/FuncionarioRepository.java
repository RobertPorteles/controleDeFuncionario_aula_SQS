package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import entities.Funcionario;

public class FuncionarioRepository {

    
    public int inserir(Connection connection, Funcionario funcionario) throws SQLException {
        final String sql = """
            INSERT INTO funcionario (id, nome, cpf, dataadmissao, endereco_id)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (PreparedStatement persistence = connection.prepareStatement(sql)) {
            persistence.setString(1, funcionario.getId().toString());
            persistence.setString(2, funcionario.getNome());
            persistence.setString(3, funcionario.getCpf());
            persistence.setDate  (4, Date.valueOf(funcionario.getDataAdmissao()));   
            persistence.setString(5, funcionario.getEndereco().getId().toString());  
            return persistence.executeUpdate(); 
        }
        
    }
}
