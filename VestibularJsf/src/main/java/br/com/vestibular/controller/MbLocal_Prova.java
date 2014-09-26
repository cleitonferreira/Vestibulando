/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.entities.Local_Prova;
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
@ManagedBean(name = "mbLocal_Prova")
@ViewScoped
public class MbLocal_Prova implements Serializable {

    private static final long serialVersionUID = 1L;

    private Local_Prova local_prova = new Local_Prova();
    private List<Local_Prova> local_provas;
    private List<Local_Prova> filteredLocal_Provas;
    private List<Local_Prova> consultaLocal_Provas;

    public MbLocal_Prova() {
    }

    private InterfaceDAO<Local_Prova> local_provaDAO() {
        InterfaceDAO<Local_Prova> local_provaDAO = new HibernateDAO<Local_Prova>(Local_Prova.class, FacesContextUtil.getRequestSession());
        return local_provaDAO;
    }

    public String limpLocal_Prova() {
        local_prova = new Local_Prova();
        return editLocal_Prova();
    }

    public String editLocal_Prova() {
        return "/restrict/cadastros/cadastrarlocalprova.faces";
    }

    public String addLocal_Prova() {
        // verifica a id veio igual a null ou id igual a 0
        if (local_prova.getProva_id() == null || local_prova.getProva_id() == 0) {
            insertLocal_Prova();
        } else {
            updateLocal_Prova();
        }
        limpLocal_Prova();
        return null;
    }

    private void insertLocal_Prova() {
        try {
            local_provaDAO().save(local_prova);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateLocal_Prova() {
        try {
            local_provaDAO().update(local_prova);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteLocal_Prova() {
        try {
            local_provaDAO().remove(local_prova);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Local_Prova> getLocal_provas() {
        local_provas = local_provaDAO().getEntities();
        return local_provas;
    }

    public Local_Prova getLocal_prova() {
        return local_prova;
    }

    public void setLocal_prova(Local_Prova local_prova) {
        this.local_prova = local_prova;
    }

    public void setLocal_provas(List<Local_Prova> local_provas) {
        this.local_provas = local_provas;
    }

    public List<Local_Prova> getFilteredLocal_Provas() {
        return filteredLocal_Provas;
    }

    public void setFilteredLocal_Provas(List<Local_Prova> filteredLocal_Provas) {
        this.filteredLocal_Provas = filteredLocal_Provas;
    }

    public List<Local_Prova> getConsultaLocal_Provas() {
        return consultaLocal_Provas;
    }

    public void setConsultaLocal_Provas(List<Local_Prova> consultaLocal_Provas) {
        this.consultaLocal_Provas = consultaLocal_Provas;
    }

}
