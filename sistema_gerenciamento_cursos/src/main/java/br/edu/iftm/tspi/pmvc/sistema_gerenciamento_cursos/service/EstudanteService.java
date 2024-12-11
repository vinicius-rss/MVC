package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.service;

import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudanteService {
    private List<Estudante> estudantes = new ArrayList<>();

    public List<Estudante> listarTodos() {
        return estudantes;
    }

    public Estudante salvar(Estudante estudante) {
        estudantes.add(estudante);
        return estudante;
    }

    public void excluir(Long id) {
        estudantes.removeIf(estudante -> estudante.getId().equals(id));
    }

    public Estudante buscarPorId(Long id) {
        return estudantes.stream()
                         .filter(estudante -> estudante.getId().equals(id))
                         .findFirst()
                         .orElse(null);
    }
}