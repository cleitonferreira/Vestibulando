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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "RETORNO")
public class Retorno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "RETORNO_NR_CONV", nullable = false, columnDefinition = "CHAR(6)")
    private String retorno_nr_conv;
    @Id
    @Column(name = "RETORNO_NR_RETORNO", nullable = false, length = 7)
    private String retorno_nr_retorno;
    @Id
    @Column(name = "RETORNO_LINHA", nullable = false, length = 6)
    private String retorno_linha;
    @Column(name = "RETORNO_NOSSONUMERO", nullable = false, length = 11)
    private Integer retorno_nossonumero;
    @Column(name = "RETORNO_VL_BOLETO", nullable = false, precision = 10, scale = 2)
    private BigDecimal retorno_vl_boleto;
    @Column(name = "RETORNO_DT_VENC", nullable = false, length = 10)
    private String retorno_dt_venc;
    @Column(name = "RETORNO_PAGO", nullable = false, precision = 10, scale = 2)
    private BigDecimal retorno_pago;
    @Column(name = "RETORNO_DT_PGTO", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date retorno_dt_pgto;
    @Column(name = "RETORNO_MULTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal retorno_multa;
    @Column(name = "RETORNO_DESCONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal retorno_desconto;
    @Column(name = "RETORNO_DT_ARQUIVO", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date retorno_dt_arquivo;
    @Column(name = "RETORNO_DT_CREDITO", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date retorno_dt_credito;
    @Column(name = "BOLETO_ID", nullable = false)
    private Integer boleto_id;

    public Retorno() {
    }

    public String getRetorno_nr_conv() {
        return retorno_nr_conv;
    }

    public void setRetorno_nr_conv(String retorno_nr_conv) {
        this.retorno_nr_conv = retorno_nr_conv;
    }

    public String getRetorno_nr_retorno() {
        return retorno_nr_retorno;
    }

    public void setRetorno_nr_retorno(String retorno_nr_retorno) {
        this.retorno_nr_retorno = retorno_nr_retorno;
    }

    public String getRetorno_linha() {
        return retorno_linha;
    }

    public void setRetorno_linha(String retorno_linha) {
        this.retorno_linha = retorno_linha;
    }

    public Integer getRetorno_nossonumero() {
        return retorno_nossonumero;
    }

    public void setRetorno_nossonumero(Integer retorno_nossonumero) {
        this.retorno_nossonumero = retorno_nossonumero;
    }

    public BigDecimal getRetorno_vl_boleto() {
        return retorno_vl_boleto;
    }

    public void setRetorno_vl_boleto(BigDecimal retorno_vl_boleto) {
        this.retorno_vl_boleto = retorno_vl_boleto;
    }

    public String getRetorno_dt_venc() {
        return retorno_dt_venc;
    }

    public void setRetorno_dt_venc(String retorno_dt_venc) {
        this.retorno_dt_venc = retorno_dt_venc;
    }

    public BigDecimal getRetorno_pago() {
        return retorno_pago;
    }

    public void setRetorno_pago(BigDecimal retorno_pago) {
        this.retorno_pago = retorno_pago;
    }

    public Date getRetorno_dt_pgto() {
        return retorno_dt_pgto;
    }

    public void setRetorno_dt_pgto(Date retorno_dt_pgto) {
        this.retorno_dt_pgto = retorno_dt_pgto;
    }

    public BigDecimal getRetorno_multa() {
        return retorno_multa;
    }

    public void setRetorno_multa(BigDecimal retorno_multa) {
        this.retorno_multa = retorno_multa;
    }

    public BigDecimal getRetorno_desconto() {
        return retorno_desconto;
    }

    public void setRetorno_desconto(BigDecimal retorno_desconto) {
        this.retorno_desconto = retorno_desconto;
    }

    public Date getRetorno_dt_arquivo() {
        return retorno_dt_arquivo;
    }

    public void setRetorno_dt_arquivo(Date retorno_dt_arquivo) {
        this.retorno_dt_arquivo = retorno_dt_arquivo;
    }

    public Date getRetorno_dt_credito() {
        return retorno_dt_credito;
    }

    public void setRetorno_dt_credito(Date retorno_dt_credito) {
        this.retorno_dt_credito = retorno_dt_credito;
    }

    public Integer getBoleto_id() {
        return boleto_id;
    }

    public void setBoleto_id(Integer boleto_id) {
        this.boleto_id = boleto_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.retorno_nr_conv != null ? this.retorno_nr_conv.hashCode() : 0);
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
        final Retorno other = (Retorno) obj;
        if ((this.retorno_nr_conv == null) ? (other.retorno_nr_conv != null) : !this.retorno_nr_conv.equals(other.retorno_nr_conv)) {
            return false;
        }
        return true;
    }

    

}
