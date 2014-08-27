/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.entities.Vestibular;
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
@ManagedBean(name = "mbVestibular")
@ViewScoped
public class MbVestibular implements Serializable {

    private static final long serialVersionUID = 1L;

    private Vestibular vestibular = new Vestibular();
    private List<Vestibular> vestibulares;
    private List<Vestibular> filteredVestibulares;
    private List<Vestibular> consultaVestibulares;

    public MbVestibular() {
    }
    
    private InterfaceDAO<Vestibular> vestibularDAO() {
        InterfaceDAO<Vestibular> vestibularDAO = new HibernateDAO<Vestibular>(Vestibular.class, FacesContextUtil.getRequestSession());
        return vestibularDAO;
    }

    public String limpVestibular() {
        vestibular = new Vestibular();
        return editVestibular();
    }

    public String editVestibular() {
        return "/restrict/cadastros/cadastrarvestibular.faces";
    }

    public String addVestibular() {
        // verifica a id veio igual a null ou id igual a 0
        if (vestibular.getVestibular_info() == null || vestibular.getVestibular_info().equals(0)) {
            insertVestibular();
        } else {
            updateVestibular();
        }
        limpVestibular();
        return null;
    }

    private void insertVestibular() {
        try {
            vestibularDAO().save(vestibular);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    private void updateVestibular() {
        try {
            vestibularDAO().update(vestibular);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public void deleteVestibular() {
        try {
            vestibularDAO().remove(vestibular);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
            limpVestibular();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public List<Vestibular> getVestibulares() {
        vestibulares = vestibularDAO().getEntities();
        return vestibulares;
    }

    public void setVestibulares(List<Vestibular> vestibulares) {
        this.vestibulares = vestibulares;
    }

    public Vestibular getVestibular() {
        return vestibular;
    }

    public void setVestibular(Vestibular vestibular) {
        this.vestibular = vestibular;
    }

    public List<Vestibular> getFilteredVestibulares() {
        return filteredVestibulares;
    }

    public void setFilteredVestibulares(List<Vestibular> filteredVestibulares) {
        this.filteredVestibulares = filteredVestibulares;
    }

    public List<Vestibular> getConsultaVestibulares() {
        return consultaVestibulares;
    }

    public void setConsultaVestibulares(List<Vestibular> consultaVestibulares) {
        this.consultaVestibulares = consultaVestibulares;
    }

    

}
