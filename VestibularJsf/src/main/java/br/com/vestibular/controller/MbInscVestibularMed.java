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
import br.com.vestibular.model.entities.Curso;
import br.com.vestibular.model.entities.Estado;
import br.com.vestibular.model.entities.Inscricao;
import br.com.vestibular.model.entities.Local_Prova;
import br.com.vestibular.model.entities.Vestibular;
import br.com.vestibular.util.FacesContextUtil;
import java.io.Serializable;
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
@ManagedBean(name = "mbInscVestibularMed")
@ViewScoped
public class MbInscVestibularMed implements Serializable {

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

    ///// Objetos para o Combo \\\\\
    //private final MeuDaoImpl mmdao = new MeuDaoImpl();
    //Vestibular
    private List<Vestibular> vestibulares;
    private Vestibular vestibular;
    //Curso
    private List<Curso> cursos;
    private Curso curso;
    private Curso curso2;
    //Local Prova
    private List<Local_Prova> local_provas;
    private Local_Prova local_prova;
    ////////////////////////////////////////////////////////

    public MbInscVestibularMed() {
    }

    @PostConstruct
    public void init() {
        vestibulares = dao.consultaTodosVestibulares();
        cursos = dao.consultaTodosCursos("vestibularmedicina");
        local_provas = dao.consultaTodosLocais_Provas();
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
        vestibular = new Vestibular();
        curso = new Curso();
        curso2 = new Curso();
        estado = new Estado();
        cidade = new Cidade();
        return editInscricao();
    }

    public String editInscricao() {
        return "/restrict/cadastros/vestibularmedicina.faces";
    }

    public String addInscricao() {

        String cpf = inscricao.getInscricao_cpf();
        String vestinfo = vestibular.getVestibular_info().toString();
        Object resultado = dao.consultaCpf(cpf, vestinfo);
        //System.out.println("Resultado >>>>" + resultado.toString());

//        Date date = new Date();
        // verifica a id veio igual a null ou id igual a 0
        if (inscricao.getInscricao_id() == null || inscricao.getInscricao_id() == 0) {
            //inscricao.setInscricao_datacad(date);

            if (resultado.toString().equals("[0]")) {
                insertInscricao();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Cadastrar], no Banco de Dados!!!", ""));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Cpf já se encontra cadastrado no Vestibular selecionado", "" + cpf));

            }

        } else {
            if (resultado.toString().equals("[1]")) {
                updateInscricao();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao [Atualizar], no Banco de Dados!!!", ""));
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Por Favor, não altere o cpf do Inscrito", "" + cpf));

            }
        }
        limpInscricao();
        return null;
    }

    private void insertInscricao() {

        try {
            inscricao.setVestibular(vestibular);
            inscricao.setCurso(curso);
            inscricao.setCurso2(curso2);
            inscricao.setLocal_prova(local_prova);
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

    private void updateInscricao() {
        try {
            inscricao.setVestibular(vestibular);
            inscricao.setCurso(curso);
            inscricao.setCurso2(curso2);
            inscricao.setLocal_prova(local_prova);
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
        // vest_info do vestibular da Medicina
        String vest_info = "20140103";
        inscricoes = dao.inscritosVestibularMedicina(vest_info);
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

    public List<Vestibular> getVestibulares() {
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

    public List<Curso> getCursos() {
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

    public List<Local_Prova> getLocal_provas() {
        return local_provas;
    }

    public void setLocal_provas(List<Local_Prova> local_provas) {
        this.local_provas = local_provas;
    }

    public Local_Prova getLocal_prova() {
        return local_prova;
    }

    public void setLocal_prova(Local_Prova local_prova) {
        this.local_prova = local_prova;
    }

    public Curso getCurso2() {
        return curso2;
    }

    public void setCurso2(Curso curso2) {
        this.curso2 = curso2;
    }

}
