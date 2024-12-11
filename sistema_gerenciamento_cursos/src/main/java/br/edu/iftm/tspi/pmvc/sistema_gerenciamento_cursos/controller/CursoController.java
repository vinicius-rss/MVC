package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.controller;

import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model.*;
import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.listarTodos());
        return "curso/listar";
    }

    @GetMapping("/novo")
    public String formNovo(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Curso curso) {
        cursoService.salvar(curso);
        return "redirect:/curso";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        model.addAttribute("curso", cursoService.buscarPorId(id));
        return "curso/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        cursoService.excluir(id);
        return "redirect:/curso";
    }
}
