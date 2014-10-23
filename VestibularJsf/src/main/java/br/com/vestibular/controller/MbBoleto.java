/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.entities.Boleto;
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
@ManagedBean(name = "mbBoleto")
@ViewScoped
public class MbBoleto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boleto boleto = new Boleto();
    private List<Boleto> boletos;
    private List<Boleto> filteredBoletos;
    private List<Boleto> consultaBoletos;

    public MbBoleto() {
    }

    private InterfaceDAO<Boleto> boletoDAO() {
        InterfaceDAO<Boleto> boletoDAO = new HibernateDAO<Boleto>(Boleto.class, FacesContextUtil.getRequestSession());
        return boletoDAO;
    }

    public String limpBoleto() {
        boleto = new Boleto();
        return editBoleto();
    }

    public String editBoleto() {
        return "/restrict/cadastros/cadastrarboleto.faces";
    }

    public String addBoleto() {
        // verifica a id veio igual a null ou id igual a 0
        if (boleto.getBoleto_id() == null || boleto.getBoleto_id() == 0) {
            insertBoleto();
        } else {
            updateBoleto();
        }
        limpBoleto();
        return null;
    }

    private void insertBoleto() {
        try {
            boletoDAO().save(boleto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateBoleto() {
        try {
            boletoDAO().update(boleto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteBoleto() {
        try {
            boletoDAO().remove(boleto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Boleto> getBoletos() {
        boletos = boletoDAO().getEntities();
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public List<Boleto> getFilteredBoletos() {
        return filteredBoletos;
    }

    public void setFilteredBoletos(List<Boleto> filteredBoletos) {
        this.filteredBoletos = filteredBoletos;
    }

    public List<Boleto> getConsultaBoletos() {
        return consultaBoletos;
    }

    public void setConsultaBoletos(List<Boleto> consultaBoletos) {
        this.consultaBoletos = consultaBoletos;
    }

}

