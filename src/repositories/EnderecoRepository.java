package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Endereco;

public class EnderecoRepository {
	public void inserir(Connection connection, Endereco endereco) throws SQLException {
		// Implementar lógica para inserir o endereço no banco de dados
		var sql = "INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, cep) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement persistence = connection.prepareStatement(sql)) {
			persistence.setString(1, endereco.getId().toString());
			persistence.setString(2, endereco.getLogradouro());
			persistence.setString(3, endereco.getNumero());
			persistence.setString(4, endereco.getComplemento());
			persistence.setString(5, endereco.getBairro());
			persistence.setString(6, endereco.getCidade());
			persistence.setString(7, endereco.getEstado());
			persistence.setString(8, endereco.getCep());
			persistence.executeUpdate();
			
		}
		
	}
}
