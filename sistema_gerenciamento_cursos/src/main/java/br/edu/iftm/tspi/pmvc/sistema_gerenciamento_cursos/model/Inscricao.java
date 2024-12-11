package br.edu.iftm.tspi.pmvc.sistema_gerenciamento_cursos.model;

import java.time.LocalDate;

public class Inscricao {
    private Long id;
    private Curso curso;
    private Estudante estudante;
    private LocalDate dataInscricao;
    private String status;

     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}