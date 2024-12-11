package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.controller;

import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model.*;
import br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudante")
public class EstudanteController {
    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudantes", estudanteService.listarTodos());
        return "estudante/listar";
    }

    @GetMapping("/novo")
    public String formNovo(Model model) {
        model.addAttribute("estudante", new Estudante());
        return "estudante/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Estudante estudante) {
        estudanteService.salvar(estudante);
        return "redirect:/estudante";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        model.addAttribute("estudante", estudanteService.buscarPorId(id));
        return "estudante/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        estudanteService.excluir(id);
        return "redirect:/estudante";
    }
}