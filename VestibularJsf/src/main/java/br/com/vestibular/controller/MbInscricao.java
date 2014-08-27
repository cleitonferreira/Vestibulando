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
import br.com.vestibular.model.entities.Inscricao;
import br.com.vestibular.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbInscricao")
@ViewScoped
public class MbInscricao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Inscricao inscricao = new Inscricao();
    private List<Inscricao> inscricoes;
    private List<Inscricao> filteredInscricoes;
    private List<Inscricao> consultaInscricoes;

    ///// Objetos para os ComBos Estado Cidade \\\\\
    private final MeuDaoImpl dao = new MeuDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    //////////////////////////////////

    public MbInscricao() {
    }

    @PostConstruct
    public void init() {
        estados = dao.consultaTodosEstados();
    }

    public void listaCidades(AjaxBehaviorEvent event) {
//        System.out.println("Busca Cidade>>>>>>>>>>>>");
        cidades = dao.consultaCidades(estado);
    }

    private InterfaceDAO<Inscricao> inscricaoDAO() {
        InterfaceDAO<Inscricao> inscricaoDAO = new HibernateDAO<Inscricao>(Inscricao.class, FacesContextUtil.getRequestSession());
        return inscricaoDAO;
    }

    public String limpInscricao() {
        inscricao = new Inscricao();
        estado = new Estado();
        cidade = new Cidade();
        return editInscricao();
    }

    public String editInscricao() {
        return "/restrict/cadastros/cadastrarinscricao.faces";
    }

    public String addInscricao() {

        Date date = new Date();

        // verifica a id veio igual a null ou id igual a 0
        if (inscricao.getInscricao_id() == null || inscricao.getInscricao_id() == 0) {
            //inscricao.setInscricao_datacad(date);
            insertInscricao();
        } else {
            updateInscricao();
        }
        limpInscricao();
        return null;
    }

    private void insertInscricao() {

        String cpf = inscricao.getInscricao_cpf();
        String vestinfo = inscricao.getVestibular().getVestibular_info();
        ArrayList results = (ArrayList) dao.consultaCpf(cpf, vestinfo);
        System.out.println("Resultsss>>>>" + results.toString());

        if (results.toString().equals("[1]")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados!!!", ""));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Cpf já se encontra cadastrado no Vestibular selecionado", "" + cpf));
        } else {
            try {

                inscricao.setEstado(estado);
                inscricao.setCidade(cidade);
                inscricaoDAO().save(inscricao);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
                //Limpar os campos
                limpInscricao();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar],  no Banco de Dados", "" + ex));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
            }
        }

    }

    private void updateInscricao() {
        String cpf = inscricao.getInscricao_cpf();
        String vestinfo = inscricao.getVestibular().getVestibular_info();
        ArrayList results = (ArrayList) dao.consultaCpf(cpf, vestinfo);
        System.out.println("Resultsss>>>>" + results.toString());

        if (results.toString().equals("[1]")) {
            try {
                
                inscricao.setEstado(estado);
                inscricao.setCidade(cidade);
                inscricaoDAO().update(inscricao);
                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados", "" + ex));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados!!!", ""));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Por Favor, não altere o cpf do Inscrito", "" + cpf));

        }
    }

    public void deleteInscricao() {
        try {
            inscricaoDAO().remove(inscricao);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Excluir], no Banco de Dados", "" + ex));
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Entre em contato com o Administrador", "" + ex));
        }

    }

    //tomar cuidado com esses dois get aqui
    //realizar as modificações.
    public List<Inscricao> getInscricoes() {
        inscricoes = inscricaoDAO().getEntities();
        return inscricoes;
    }

    ////////////////////////////////////////////
    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Inscricao> getFilteredInscricoes() {
        return filteredInscricoes;
    }

    public void setFilteredInscricoes(List<Inscricao> filteredInscricoes) {
        this.filteredInscricoes = filteredInscricoes;
    }

    public List<Inscricao> getConsultaInscricoes() {
        return consultaInscricoes;
    }

    public void setConsultaInscricoes(List<Inscricao> consultaInscricoes) {
        this.consultaInscricoes = consultaInscricoes;
    }

}
