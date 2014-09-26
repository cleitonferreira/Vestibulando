/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.entities.Curso;
import br.com.vestibular.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbCurso")
@ViewScoped
public class MbCurso implements Serializable {

    private static final long serialVersionUID = 1L;

    private Curso curso = new Curso();
    private List<Curso> cursos;
    private List<Curso> filteredCursos;
    private List<Curso> consultaCursos;

    public MbCurso() {
        
    }

    private InterfaceDAO<Curso> cursoDAO() {
        InterfaceDAO<Curso> cursoDAO = new HibernateDAO<Curso>(Curso.class, FacesContextUtil.getRequestSession());
        return cursoDAO;
    }

    public String limpCurso() {
        curso = new Curso();
        return editCurso();
    }

    public String editCurso() {
        return "/restrict/cadastros/cadastrarcurso.faces";
    }

    public String addCurso() {
        // verifica a id veio igual a null ou id igual a 0
        if (curso.getCurso_id() == null || curso.getCurso_id() == 0) {
            insertCurso();
        } else {
            updateCurso();
        }
        limpCurso();
        return null;
    }

    private void insertCurso() {
        try {
            cursoDAO().save(curso);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    private void updateCurso() {
        try {
            cursoDAO().update(curso);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteCurso() {
        try {
            cursoDAO().remove(curso);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Curso> getCursos() {
        cursos = cursoDAO().getEntities();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getFilteredCursos() {
        return filteredCursos;
    }

    public void setFilteredCursos(List<Curso> filteredCursos) {
        this.filteredCursos = filteredCursos;
    }

    public List<Curso> getConsultaCursos() {
        return consultaCursos;
    }

    public void setConsultaCursos(List<Curso> consultaCursos) {
        this.consultaCursos = consultaCursos;
    }

}
