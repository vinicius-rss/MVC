package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.controller;

import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model.*;
import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.repository.*;
import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.controller.*;
import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inscricao")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("inscricoes", inscricaoService.listarTodos());
        return "inscricao/listar";
    }

    @GetMapping("/novo")
    public String formNovo(Model model) {
        model.addAttribute("inscricao", new Inscricao());
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("estudantes", estudanteService.listarTodos());
        return "inscricao/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Inscricao inscricao) {
        inscricaoService.salvar(inscricao);
        return "redirect:/inscricao";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        model.addAttribute("inscricao", inscricaoService.buscarPorId(id));
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("estudantes", estudanteService.listarTodos());
        return "inscricao/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        inscricaoService.excluir(id);
        return "redirect:/inscricao";
    }
}