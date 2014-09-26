/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.entities.Revisao;
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
@ManagedBean(name = "mbRevisao")
@ViewScoped
public class MbRevisao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Revisao revisao = new Revisao();
    private List<Revisao> revisoes;
    private List<Revisao> filteredRevisoes;
    private List<Revisao> consultaRevisoes;

    public MbRevisao() {
    }

    private InterfaceDAO<Revisao> revisaoDAO() {
        InterfaceDAO<Revisao> revisaoDAO = new HibernateDAO<Revisao>(Revisao.class, FacesContextUtil.getRequestSession());
        return revisaoDAO;
    }

    public String limpRevisao() {
        revisao = new Revisao();
        return editRevisao();
    }

    public String editRevisao() {
        return "/restrict/cadastros/cadastrarrevisao.faces";
    }

    public String addRevisao() {
        // verifica a id veio igual a null ou id igual a 0
        if (revisao.getRevisao_id() == null || revisao.getRevisao_id() == 0) {
            insertRevisao();
        } else {
            updateRevisao();
        }
        limpRevisao();
        return null;
    }

    private void insertRevisao() {
        try {
            revisaoDAO().save(revisao);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateRevisao() {
        try {
            revisaoDAO().update(revisao);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteRevisao() {
        try {
            revisaoDAO().remove(revisao);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Revisao> getRevisoes() {
        revisoes = revisaoDAO().getEntities();
        return revisoes;
    }

    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }

    public List<Revisao> getFilteredRevisoes() {
        return filteredRevisoes;
    }

    public void setFilteredRevisoes(List<Revisao> filteredRevisoes) {
        this.filteredRevisoes = filteredRevisoes;
    }

    public List<Revisao> getConsultaSetores() {
        return consultaRevisoes;
    }

    public void setConsultaRevisoes(List<Revisao> consultaRevisoes) {
        this.consultaRevisoes = consultaRevisoes;
    }

}
