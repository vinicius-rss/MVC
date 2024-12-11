package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.service;

import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscricaoService {
    private final List<Inscricao> inscricoes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Inscricao> listarTodos() {
        return inscricoes;
    }

    public Inscricao salvar(Inscricao inscricao) {
        if (inscricao.getId() == null) {
            inscricao.setId(nextId++);
        }
        inscricoes.add(inscricao);
        return inscricao;
    }

    public void excluir(Long id) {
        inscricoes.removeIf(inscricao -> inscricao.getId().equals(id));
    }

    public Inscricao buscarPorId(Long id) {
        return inscricoes.stream().filter(inscricao -> inscricao.getId().equals(id)).findFirst().orElse(null);
    }
}