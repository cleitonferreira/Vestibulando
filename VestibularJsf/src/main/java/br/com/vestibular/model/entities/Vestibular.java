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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "VESTIBULAR")
public class Vestibular implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VESTIBULAR_INFO", nullable = false, length = 8)
    private String vestibular_info;
    @Column(name = "VESTIBULAR_DESCRICAO", nullable = false, length = 80)
    private String vestibular_descricao;
    @Column(name = "VESTIBULAR_SEQ_ID", nullable = false, length = 20)
    private Long vestibular_seq_id;
    @Column(name = "VESTIBULAR_INICIO", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vestibular_inicio;
    @Column(name = "VESTIBULAR_FIM", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vestibular_fim;
    @Column(name = "VESTIBULAR_VALOR", nullable = true, precision = 10, scale = 2)
    private BigDecimal vestibular_valor;
    @Column(name = "VESTIBULAR_DIA", nullable = false, length = 11)
    private Integer vestibular_dia;

    @OneToMany(mappedBy = "vestibular", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_VESTIBULAR_INSCRICAO")
    private List<Inscricao> inscricoes;

    @OneToMany(mappedBy = "vestibular", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_BOLETO_VESTIBULAR")
    private List<Boleto> boletos;

    @OneToMany(mappedBy = "vestibular", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_VESTIBULAR_GABARITO")
    private List<Gabarito_Vestibular> gabarito_vestibulares;

    @OneToMany(mappedBy = "vestibular", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_VESTIBULAR_RESPOSTA")
    private List<Resposta_Vestibular> resposta_vestibulares;

    public String getVestibular_info() {
        return vestibular_info;
    }

    public void setVestibular_info(String vestibular_info) {
        this.vestibular_info = vestibular_info;
    }

    public String getVestibular_descricao() {
        return vestibular_descricao;
    }

    public void setVestibular_descricao(String vestibular_descricao) {
        this.vestibular_descricao = vestibular_descricao;
    }

    public Long getVestibular_seq_id() {
        return vestibular_seq_id;
    }

    public void setVestibular_seq_id(Long vestibular_seq_id) {
        this.vestibular_seq_id = vestibular_seq_id;
    }

    public Date getVestibular_inicio() {
        return vestibular_inicio;
    }

    public void setVestibular_inicio(Date vestibular_inicio) {
        this.vestibular_inicio = vestibular_inicio;
    }

    public Date getVestibular_fim() {
        return vestibular_fim;
    }

    public void setVestibular_fim(Date vestibular_fim) {
        this.vestibular_fim = vestibular_fim;
    }

    public BigDecimal getVestibular_valor() {
        return vestibular_valor;
    }

    public void setVestibular_valor(BigDecimal vestibular_valor) {
        this.vestibular_valor = vestibular_valor;
    }

    public Integer getVestibular_dia() {
        return vestibular_dia;
    }

    public void setVestibular_dia(Integer vestibular_dia) {
        this.vestibular_dia = vestibular_dia;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<Gabarito_Vestibular> getGabarito_vestibulares() {
        return gabarito_vestibulares;
    }

    public void setGabarito_vestibulares(List<Gabarito_Vestibular> gabarito_vestibulares) {
        this.gabarito_vestibulares = gabarito_vestibulares;
    }

    public List<Resposta_Vestibular> getResposta_vestibulares() {
        return resposta_vestibulares;
    }

    public void setResposta_vestibulares(List<Resposta_Vestibular> resposta_vestibulares) {
        this.resposta_vestibulares = resposta_vestibulares;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.vestibular_info != null ? this.vestibular_info.hashCode() : 0);
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
        final Vestibular other = (Vestibular) obj;
        if ((this.vestibular_info == null) ? (other.vestibular_info != null) : !this.vestibular_info.equals(other.vestibular_info)) {
            return false;
        }
        return true;
    }

    

}
