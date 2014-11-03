/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.dao.MeuDaoImpl;
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

    private final MeuDaoImpl dao = new MeuDaoImpl();

    private Boleto boleto = new Boleto();
    private List<Boleto> boletos;
    private List viewTotalInscritos;
    private List<Boleto> filteredBoletos;
    private List<Boleto> consultaBoletos;

    public MbBoleto() {
    }

    private InterfaceDAO<Boleto> boletoDAO() {
        InterfaceDAO<Boleto> boletoDAO = new HibernateDAO<Boleto>(Boleto.class, FacesContextUtil.getRequestSession());
        return boletoDAO;
    }

    public List getViewTotalInscritos() {
        viewTotalInscritos = dao.viewTotalInscritosBD();
        return viewTotalInscritos;
    }

    public void setViewTotalInscritos(List viewTotalInscritos) {
        this.viewTotalInscritos = viewTotalInscritos;
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
