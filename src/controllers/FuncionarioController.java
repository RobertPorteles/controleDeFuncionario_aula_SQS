package controllers;

import dtos.FuncionarioRequest;
import dtos.FuncionarioResponse;
import interfaces.FuncionarioServer;

public class FuncionarioController {

    private final FuncionarioServer funcionarioService;

    // Injeção da interface
    public FuncionarioController(FuncionarioServer funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public FuncionarioResponse cadastrarFuncionario(FuncionarioRequest request) {
        return funcionarioService.salvar(request);
    }
}
