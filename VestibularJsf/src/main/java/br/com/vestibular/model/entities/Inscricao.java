/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "INSCRICAO")
public class Inscricao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "INSCRICAO_ID", nullable = false, length = 20)
    private Long inscricao_id;
    @Column(name = "INSCRICAO_NOME", nullable = false, length = 80)
    private String inscricao_nome;
    @Column(name = "INSCRICAO_NOME_MAE", nullable = false, length = 80)
    private String inscricao_nome_mae;
    @Column(name = "INSCRICAO_NOME_PAI", nullable = false, length = 80)
    private String inscricao_nome_pai;
    @Column(name = "INSCRICAO_CPF", nullable = false, length = 14) //224.491.491-71
    private String inscricao_cpf;
    @Column(name = "INSCRICAO_RG", nullable = false, length = 20)
    private String inscricao_rg;
    @Column(name = "INSCRICAO_OE", nullable = false, length = 30)
    private String inscricao_oe;
    @Column(name = "INSCRICAO_DATANASC", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inscricao_datanasc;
    @Column(name = "INSCRICAO_SEXO", nullable = false, columnDefinition = "CHAR(1)")
    private String inscricao_sexo;
    @Column(name = "INSCRICAO_NATURALIDADE", nullable = false, length = 80)
    private String inscricao_naturalidade;
    @Column(name = "INSCRICAO_ENDERECO", nullable = false, length = 80)
    private String inscricao_endereco;
    @Column(name = "INSCRICAO_BAIRRO", nullable = false, length = 80)
    private String inscricao_bairro;
    @Column(name = "INSCRICAO_CEP", nullable = false, length = 10) //27600-000
    private String inscricao_cep;
    @Column(name = "INSCRICAO_TEL", nullable = false, length = 14)//(34)-8888-8888
    private String inscricao_tel;
    @Column(name = "INSCRICAO_CEL", nullable = false, length = 15)//(34)-88888-8888
    private String inscricao_cel;
    @Column(name = "INSCRICAO_EMAIL", nullable = false, length = 80)
    private String inscricao_email;
    @Column(name = "INSCRICAO_ENEM", nullable = false)
    private boolean inscricao_enem;
    @Column(name = "INSCRICAO_NOTA_ENEM", nullable = false, precision = 8, scale = 2)
    private BigDecimal inscricao_nota_enem;
    @Column(name = "INSCRICAO_ESCREVE_MAO", nullable = false, columnDefinition = "CHAR(1)")
    private String inscricao_escreve_mao;
    @Column(name = "INSCRICAO_PORTADOR_ESPECIAL", nullable = false)
    private boolean inscricao_portador_especial;
    @Column(name = "INSCRICAO_PORTADOR_DESCRICAO", nullable = false, length = 80)
    private String inscricao_portador_descricao;
    @Column(name = "INSCRICAO_ESCOLA", nullable = false, length = 80)
    private String inscricao_escola;
    @Column(name = "INSCRICAO_INFO_ADICIONAL1", nullable = false, columnDefinition = "CHAR(10)")
    private String inscricao_info_adicional1;
    @Column(name = "INSCRICAO_INFO_ADICIONAL2", nullable = false, columnDefinition = "CHAR(10)")
    private String inscricao_info_adicional2;
    @Column(name = "INSCRICAO_INFO_ADICIONAL3", nullable = false, columnDefinition = "CHAR(10)")
    private String inscricao_info_adicional3;
    @Column(name = "INSCRICAO_INFO_ADICIONAL4", nullable = false, columnDefinition = "CHAR(10)")
    private String inscricao_info_adicional4;
    @Column(name = "INSCRICAO_PRESENCA", nullable = false)
    private boolean inscricao_presenca;
    @Column(name = "INSCRICAO_CLASSIFICACAO", nullable = false, length = 11)
    private Integer inscricao_classificacao;
    @Column(name = "INSCRICAO_CLASSIFICACAO2", nullable = false, length = 11)
    private Integer inscricao_classificacao2;
    @Column(name = "INSCRICAO_ESPECIALIDADE", nullable = false, columnDefinition = "CHAR(2)")
    private String inscricao_especialidade;
    @Basic(optional = false)
    //funcionando
//    @Column(name = "INSCRICAO_DATACAD", insertable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date inscricao_datacad;
    @Column(name = "INSCRICAO_DATACAD", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inscricao_datacad;

    //relacionamentos
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoInscricao")
    @JoinColumn(name = "EST_ID", referencedColumnName = "est_id")
    private Estado estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeInscricao")
    @JoinColumn(name = "CID_ID", referencedColumnName = "cid_id")
    private Cidade cidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CursoInscricao")
    @JoinColumn(name = "CURSO_ID", referencedColumnName = "curso_id")
    private Curso curso;

    ////////////////////////////////////////////////////////////
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CursoInscricao2")
    @JoinColumn(name = "CURSO_ID2", referencedColumnName = "curso_id")
    private Curso curso2;

    ////////////////////////////////////////////////////////////
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "Local_Prova_Inscricao")
    @JoinColumn(name = "PROVA_ID", referencedColumnName = "prova_id")
    private Local_Prova local_prova;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "VestibularInscricao")
    @JoinColumn(name = "VESTIBULAR_INFO", referencedColumnName = "vestibular_info")
    private Vestibular vestibular;

    @OneToMany(mappedBy = "inscricao", fetch = FetchType.LAZY)
    @ForeignKey(name = "InscricaoResposta")
    private List<Resposta_Vestibular> resposta_vestibulares;

    public Inscricao() {
        this.estado = new Estado();
        this.cidade = new Cidade();
        this.curso = new Curso();
        this.curso2 = new Curso();
        this.local_prova = new Local_Prova();
        this.vestibular = new Vestibular();
    }

    public Long getInscricao_id() {
        return inscricao_id;
    }

    public void setInscricao_id(Long inscricao_id) {
        this.inscricao_id = inscricao_id;
    }

    public String getInscricao_nome() {
        return inscricao_nome;
    }

    public void setInscricao_nome(String inscricao_nome) {
        this.inscricao_nome = inscricao_nome;
    }

    public String getInscricao_nome_mae() {
        return inscricao_nome_mae;
    }

    public void setInscricao_nome_mae(String inscricao_nome_mae) {
        this.inscricao_nome_mae = inscricao_nome_mae;
    }

    public String getInscricao_nome_pai() {
        return inscricao_nome_pai;
    }

    public void setInscricao_nome_pai(String inscricao_nome_pai) {
        this.inscricao_nome_pai = inscricao_nome_pai;
    }

    public String getInscricao_cpf() {
        return inscricao_cpf;
    }

    public void setInscricao_cpf(String inscricao_cpf) {
        this.inscricao_cpf = inscricao_cpf;
    }

    public String getInscricao_rg() {
        return inscricao_rg;
    }

    public void setInscricao_rg(String inscricao_rg) {
        this.inscricao_rg = inscricao_rg;
    }

    public String getInscricao_oe() {
        return inscricao_oe;
    }

    public void setInscricao_oe(String inscricao_oe) {
        this.inscricao_oe = inscricao_oe;
    }

    public Date getInscricao_datanasc() {
        return inscricao_datanasc;
    }

    public void setInscricao_datanasc(Date inscricao_datanasc) {
        this.inscricao_datanasc = inscricao_datanasc;
    }

    public String getInscricao_sexo() {
        return inscricao_sexo;
    }

    public void setInscricao_sexo(String inscricao_sexo) {
        this.inscricao_sexo = inscricao_sexo;
    }

    public String getInscricao_naturalidade() {
        return inscricao_naturalidade;
    }

    public void setInscricao_naturalidade(String inscricao_naturalidade) {
        this.inscricao_naturalidade = inscricao_naturalidade;
    }

    public String getInscricao_endereco() {
        return inscricao_endereco;
    }

    public void setInscricao_endereco(String inscricao_endereco) {
        this.inscricao_endereco = inscricao_endereco;
    }

    public String getInscricao_bairro() {
        return inscricao_bairro;
    }

    public void setInscricao_bairro(String inscricao_bairro) {
        this.inscricao_bairro = inscricao_bairro;
    }

    public String getInscricao_cep() {
        return inscricao_cep;
    }

    public void setInscricao_cep(String inscricao_cep) {
        this.inscricao_cep = inscricao_cep;
    }

    public String getInscricao_tel() {
        return inscricao_tel;
    }

    public void setInscricao_tel(String inscricao_tel) {
        this.inscricao_tel = inscricao_tel;
    }

    public String getInscricao_cel() {
        return inscricao_cel;
    }

    public void setInscricao_cel(String inscricao_cel) {
        this.inscricao_cel = inscricao_cel;
    }

    public String getInscricao_email() {
        return inscricao_email;
    }

    public void setInscricao_email(String inscricao_email) {
        this.inscricao_email = inscricao_email;
    }

    public boolean isInscricao_enem() {
        return inscricao_enem;
    }

    public void setInscricao_enem(boolean inscricao_enem) {
        this.inscricao_enem = inscricao_enem;
    }

    public BigDecimal getInscricao_nota_enem() {
        return inscricao_nota_enem;
    }

    public void setInscricao_nota_enem(BigDecimal inscricao_nota_enem) {
        this.inscricao_nota_enem = inscricao_nota_enem;
    }

    public String getInscricao_escreve_mao() {
        return inscricao_escreve_mao;
    }

    public void setInscricao_escreve_mao(String inscricao_escreve_mao) {
        this.inscricao_escreve_mao = inscricao_escreve_mao;
    }

    public boolean isInscricao_portador_especial() {
        return inscricao_portador_especial;
    }

    public void setInscricao_portador_especial(boolean inscricao_portador_especial) {
        this.inscricao_portador_especial = inscricao_portador_especial;
    }

    public String getInscricao_portador_descricao() {
        return inscricao_portador_descricao;
    }

    public void setInscricao_portador_descricao(String inscricao_portador_descricao) {
        this.inscricao_portador_descricao = inscricao_portador_descricao;
    }

    public String getInscricao_escola() {
        return inscricao_escola;
    }

    public void setInscricao_escola(String inscricao_escola) {
        this.inscricao_escola = inscricao_escola;
    }

    public String getInscricao_info_adicional1() {
        return inscricao_info_adicional1;
    }

    public void setInscricao_info_adicional1(String inscricao_info_adicional1) {
        this.inscricao_info_adicional1 = inscricao_info_adicional1;
    }

    public String getInscricao_info_adicional2() {
        return inscricao_info_adicional2;
    }

    public void setInscricao_info_adicional2(String inscricao_info_adicional2) {
        this.inscricao_info_adicional2 = inscricao_info_adicional2;
    }

    public String getInscricao_info_adicional3() {
        return inscricao_info_adicional3;
    }

    public void setInscricao_info_adicional3(String inscricao_info_adicional3) {
        this.inscricao_info_adicional3 = inscricao_info_adicional3;
    }

    public String getInscricao_info_adicional4() {
        return inscricao_info_adicional4;
    }

    public void setInscricao_info_adicional4(String inscricao_info_adicional4) {
        this.inscricao_info_adicional4 = inscricao_info_adicional4;
    }

    public boolean isInscricao_presenca() {
        return inscricao_presenca;
    }

    public void setInscricao_presenca(boolean inscricao_presenca) {
        this.inscricao_presenca = inscricao_presenca;
    }

    public Integer getInscricao_classificacao() {
        return inscricao_classificacao;
    }

    public void setInscricao_classificacao(Integer inscricao_classificacao) {
        this.inscricao_classificacao = inscricao_classificacao;
    }

    public Integer getInscricao_classificacao2() {
        return inscricao_classificacao2;
    }

    public void setInscricao_classificacao2(Integer inscricao_classificacao2) {
        this.inscricao_classificacao2 = inscricao_classificacao2;
    }

    public String getInscricao_especialidade() {
        return inscricao_especialidade;
    }

    public void setInscricao_especialidade(String inscricao_especialidade) {
        this.inscricao_especialidade = inscricao_especialidade;
    }

    public Date getInscricao_datacad() {
        return inscricao_datacad;
    }

    public void setInscricao_datacad(Date inscricao_datacad) {
        this.inscricao_datacad = inscricao_datacad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso2() {
        return curso2;
    }

    public void setCurso2(Curso curso2) {
        this.curso2 = curso2;
    }

    public Local_Prova getLocal_prova() {
        return local_prova;
    }

    public void setLocal_prova(Local_Prova local_prova) {
        this.local_prova = local_prova;
    }

    public Vestibular getVestibular() {
        return vestibular;
    }

    public void setVestibular(Vestibular vestibular) {
        this.vestibular = vestibular;
    }

    public List<Resposta_Vestibular> getResposta_vestibulares() {
        return resposta_vestibulares;
    }

    public void setResposta_vestibulares(List<Resposta_Vestibular> resposta_vestibulares) {
        this.resposta_vestibulares = resposta_vestibulares;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.inscricao_id != null ? this.inscricao_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscricao other = (Inscricao) obj;
        if (this.inscricao_id != other.inscricao_id && (this.inscricao_id == null || !this.inscricao_id.equals(other.inscricao_id))) {
            return false;
        }
        return true;
    }

    

}
