/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import br.com.vestibular.model.dao.HibernateDAO;
import br.com.vestibular.model.dao.InterfaceDAO;
import br.com.vestibular.model.dao.MeuDaoImpl;
import br.com.vestibular.model.entities.Cidade;
import br.com.vestibular.model.entities.Estado;
import br.com.vestibular.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XPredator
 */
@ManagedBean(name = "mbCidade")
@ViewScoped
public class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Cidade cidade = new Cidade();
    public List<Cidade> cidades;
    private List<Cidade> filteredCidades;
    private List<Cidade> consultaCidades;

    ///// Objetos para o Combo Estado \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Estado> estados;
    private Estado estado;
    ////////////////////////////////////////////////////////

    public MbCidade() {
    }

    @PostConstruct
    public void init() {
        estados = dao.consultaTodosEstados();
    }

    private InterfaceDAO<Cidade> cidadeDAO() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }

    public String limpCidade() {
        cidade = new Cidade();
        estado = new Estado();
        return editCidade();
    }

    public String editCidade() {
        return "/restrict/cadastros/cadastrarcidade.faces";
    }

    public String addCidade() {
        // verifica a id veio igual a null ou id igual a 0
        if (cidade.getCid_id() == null || cidade.getCid_id() == 0) {
            insertCidade();
        } else {
            updateCidade();
        }
        limpCidade();
        return null;
    }

    private void insertCidade() {

        try {
            cidade.setEstado(estado);
            cidadeDAO().save(cidade);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    private void updateCidade() {
        try {
            cidade.setEstado(estado);
            cidadeDAO().update(cidade);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    public void deleteCidade() {
        try {
            cidadeDAO().remove(cidade);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getFilteredCidades() {
        return filteredCidades;
    }

    public void setFilteredCidades(List<Cidade> filteredCidades) {
        this.filteredCidades = filteredCidades;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Cidade> getConsultaCidades() {
        return consultaCidades;
    }

    public void setConsultaCidades(List<Cidade> consultaCidades) {
        this.consultaCidades = consultaCidades;
    }

}
