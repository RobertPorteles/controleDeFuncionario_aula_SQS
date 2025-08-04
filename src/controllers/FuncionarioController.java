package controllers;

import dtos.FuncionarioRequest;
import dtos.FuncionarioResponse;
import interfaces.FuncionarioServer;
import server.FuncionarioImpl;

public class FuncionarioController {

	private final FuncionarioServer funcionarioService;

	public FuncionarioController() {
		this.funcionarioService = new FuncionarioImpl(); // agora injetando a interface
	}

	public FuncionarioResponse cadastrarFuncionario(FuncionarioRequest request) {
		return funcionarioService.salvar(request);
	}
}
