package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.service;


import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final List<Curso> cursos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Curso> listarTodos() {
        return cursos;
    }

    public Curso salvar(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(nextId++);
        }
        cursos.add(curso);
        return curso;
    }

    public void excluir(Long id) {
        cursos.removeIf(curso -> curso.getId().equals(id));
    }

    public Curso buscarPorId(Long id) {
        return cursos.stream().filter(curso -> curso.getId().equals(id)).findFirst().orElse(null);
    }
}