package com.mycompany.alyssonaldrin1.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Estagio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date inicioEstagio;
    
    @Temporal(TemporalType.DATE)
    private Date fimEstagio;
    
    private int cargaHoraria;
    
    private String status; 

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Orientador orientador;

    public Estagio() {
    }

    public Estagio(Date inicioEstagio, Date fimEstagio, int cargaHoraria, String status, Aluno aluno, Empresa empresa, Orientador orientador) {
        this.inicioEstagio = inicioEstagio;
        this.fimEstagio = fimEstagio;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.aluno = aluno;
        this.empresa = empresa;
        this.orientador = orientador;
        empresa.addAluno(aluno);
        orientador.addAluno(aluno);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicioEstagio() {
        return inicioEstagio;
    }

    public void setInicioEstagio(Date inicioEstagio) {
        this.inicioEstagio = inicioEstagio;
    }

    public Date getFimEstagio() {
        return fimEstagio;
    }

    public void setFimEstagio(Date fimEstagio) {
        this.fimEstagio = fimEstagio;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }
}