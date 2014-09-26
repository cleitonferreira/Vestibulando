/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "BOLETO")
public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "BOLETO_ID", nullable = false)
    private Integer boleto_id;
    
    //Na classe Boleto o atributo inscricao_id nao 
    //pode haver relacionamentos por causa da trigger
    @Column(name = "INSCRICAO_ID", nullable = true, length = 20)
    private Long inscricao_id;
    
    @Column(name = "BOLETO_DT_VENC", nullable = true, length = 10)
    private String boleto_dt_venc;
    @Column(name = "BOLETO_VL_BOLETO", nullable = true, precision = 10, scale = 2)
    private BigDecimal boleto_vl_boleto;
    @Column(name = "BOLETO_NR_DOC", nullable = true, length = 11)
    private Integer boleto_nr_doc;
    @Column(name = "BOLETO_NR_CONV", nullable = true, columnDefinition = "CHAR(6)")
    private String boleto_nr_conv;
    @Column(name = "BOLETO_NOSSONUMERO", nullable = true, length = 11)
    private Integer boleto_nossonumero;
    @Column(name = "BOLETO_DT_DOC", nullable = true, length = 10)
    private String boleto_dt_doc;
    @Column(name = "BOLETO_DT_VAL", nullable = true, length = 10)
    private String boleto_dt_val;
    @Column(name = "BOLETO_DATA_PGTO", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date boleto_data_pgto;
    @Column(name = "BOLETO_INSTRUCAO", nullable = true, columnDefinition="Text")
    private String boleto_instrucao;
    @Column(name = "BOLETO_PAGO", nullable = true, precision = 10, scale = 2)
    private BigDecimal boleto_pago;
    @Column(name = "BOLETO_DT_CREDITO", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date boleto_dt_credito;
    @Column(name = "BOLETO_DT_ARQUIVO", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date boleto_dt_arquivo;
    @Column(name = "BOLETO_NR_RETORNO", nullable = true, length = 7)
    private String boleto_nr_retorno;
    @Column(name = "BOLETO_LINHA_RETORNO", nullable = true, length = 6)
    private String boleto_linha_retorno;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_BOLETO_VESTIBULAR")
    @JoinColumn(name = "VESTIBULAR_INFO", referencedColumnName = "vestibular_info")
    private Vestibular vestibular;

    public Boleto() {
        this.vestibular = new Vestibular();
    }

    public Integer getBoleto_id() {
        return boleto_id;
    }

    public void setBoleto_id(Integer boleto_id) {
        this.boleto_id = boleto_id;
    }

    public Long getInscricao_id() {
        return inscricao_id;
    }

    public void setInscricao_id(Long inscricao_id) {
        this.inscricao_id = inscricao_id;
    }

    public String getBoleto_dt_venc() {
        return boleto_dt_venc;
    }

    public void setBoleto_dt_venc(String boleto_dt_venc) {
        this.boleto_dt_venc = boleto_dt_venc;
    }

    public BigDecimal getBoleto_vl_boleto() {
        return boleto_vl_boleto;
    }

    public void setBoleto_vl_boleto(BigDecimal boleto_vl_boleto) {
        this.boleto_vl_boleto = boleto_vl_boleto;
    }

    public Integer getBoleto_nr_doc() {
        return boleto_nr_doc;
    }

    public void setBoleto_nr_doc(Integer boleto_nr_doc) {
        this.boleto_nr_doc = boleto_nr_doc;
    }

    public String getBoleto_nr_conv() {
        return boleto_nr_conv;
    }

    public void setBoleto_nr_conv(String boleto_nr_conv) {
        this.boleto_nr_conv = boleto_nr_conv;
    }

    public Integer getBoleto_nossonumero() {
        return boleto_nossonumero;
    }

    public void setBoleto_nossonumero(Integer boleto_nossonumero) {
        this.boleto_nossonumero = boleto_nossonumero;
    }

    public String getBoleto_dt_doc() {
        return boleto_dt_doc;
    }

    public void setBoleto_dt_doc(String boleto_dt_doc) {
        this.boleto_dt_doc = boleto_dt_doc;
    }

    public String getBoleto_dt_val() {
        return boleto_dt_val;
    }

    public void setBoleto_dt_val(String boleto_dt_val) {
        this.boleto_dt_val = boleto_dt_val;
    }

    public Date getBoleto_data_pgto() {
        return boleto_data_pgto;
    }

    public void setBoleto_data_pgto(Date boleto_data_pgto) {
        this.boleto_data_pgto = boleto_data_pgto;
    }

    public String getBoleto_instrucao() {
        return boleto_instrucao;
    }

    public void setBoleto_instrucao(String boleto_instrucao) {
        this.boleto_instrucao = boleto_instrucao;
    }

    public BigDecimal getBoleto_pago() {
        return boleto_pago;
    }

    public void setBoleto_pago(BigDecimal boleto_pago) {
        this.boleto_pago = boleto_pago;
    }

    public Date getBoleto_dt_credito() {
        return boleto_dt_credito;
    }

    public void setBoleto_dt_credito(Date boleto_dt_credito) {
        this.boleto_dt_credito = boleto_dt_credito;
    }

    public Date getBoleto_dt_arquivo() {
        return boleto_dt_arquivo;
    }

    public void setBoleto_dt_arquivo(Date boleto_dt_arquivo) {
        this.boleto_dt_arquivo = boleto_dt_arquivo;
    }

    public String getBoleto_nr_retorno() {
        return boleto_nr_retorno;
    }

    public void setBoleto_nr_retorno(String boleto_nr_retorno) {
        this.boleto_nr_retorno = boleto_nr_retorno;
    }

    public String getBoleto_linha_retorno() {
        return boleto_linha_retorno;
    }

    public void setBoleto_linha_retorno(String boleto_linha_retorno) {
        this.boleto_linha_retorno = boleto_linha_retorno;
    }

    public Vestibular getVestibular() {
        return vestibular;
    }

    public void setVestibular(Vestibular vestibular) {
        this.vestibular = vestibular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.boleto_id != null ? this.boleto_id.hashCode() : 0);
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
        final Boleto other = (Boleto) obj;
        if (this.boleto_id != other.boleto_id && (this.boleto_id == null || !this.boleto_id.equals(other.boleto_id))) {
            return false;
        }
        return true;
    }

    
    
    
}
