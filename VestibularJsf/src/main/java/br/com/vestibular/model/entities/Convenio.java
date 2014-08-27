/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "CONVENIO")
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONVENIO_NR_CONV", nullable = false, columnDefinition = "CHAR(6)")
    private String convenio_nr_conv;
    @Column(name = "CONVENIO_NR_CART", nullable = false, columnDefinition = "CHAR(2)")
    private String convenio_nr_cart;
    @Column(name = "CONVENIO_NR_VAR", nullable = false, columnDefinition = "CHAR(3)")
    private String convenio_nr_var;
    @Column(name = "CONVENIO_NR_AGE", nullable = false, columnDefinition = "CHAR(4)")
    private String convenio_nr_age;
    @Column(name = "CONVENIO_DV_AGE", nullable = false, columnDefinition = "CHAR(1)")
    private String convenio_dv_age;
    @Column(name = "CONVENIO_NR_CC", nullable = false, columnDefinition = "CHAR(4)")
    private String convenio_nr_cc;
    @Column(name = "CONVENIO_DV_CC", nullable = false, columnDefinition = "CHAR(1)")
    private String convenio_dv_cc;
    @Column(name = "CONVENIO_EDOC", nullable = false, columnDefinition = "CHAR(2)")
    private String convenio_edoc;
    @Column(name = "CONVENIO_ULT_BOL", nullable = false, length = 11)
    private Integer convenio_ult_bol;

    public Convenio() {
    }

    public String getConvenio_nr_conv() {
        return convenio_nr_conv;
    }

    public void setConvenio_nr_conv(String convenio_nr_conv) {
        this.convenio_nr_conv = convenio_nr_conv;
    }

    public String getConvenio_nr_cart() {
        return convenio_nr_cart;
    }

    public void setConvenio_nr_cart(String convenio_nr_cart) {
        this.convenio_nr_cart = convenio_nr_cart;
    }

    public String getConvenio_nr_var() {
        return convenio_nr_var;
    }

    public void setConvenio_nr_var(String convenio_nr_var) {
        this.convenio_nr_var = convenio_nr_var;
    }

    public String getConvenio_nr_age() {
        return convenio_nr_age;
    }

    public void setConvenio_nr_age(String convenio_nr_age) {
        this.convenio_nr_age = convenio_nr_age;
    }

    public String getConvenio_dv_age() {
        return convenio_dv_age;
    }

    public void setConvenio_dv_age(String convenio_dv_age) {
        this.convenio_dv_age = convenio_dv_age;
    }

    public String getConvenio_nr_cc() {
        return convenio_nr_cc;
    }

    public void setConvenio_nr_cc(String convenio_nr_cc) {
        this.convenio_nr_cc = convenio_nr_cc;
    }

    public String getConvenio_dv_cc() {
        return convenio_dv_cc;
    }

    public void setConvenio_dv_cc(String convenio_dv_cc) {
        this.convenio_dv_cc = convenio_dv_cc;
    }

    public String getConvenio_edoc() {
        return convenio_edoc;
    }

    public void setConvenio_edoc(String convenio_edoc) {
        this.convenio_edoc = convenio_edoc;
    }

    public Integer getConvenio_ult_bol() {
        return convenio_ult_bol;
    }

    public void setConvenio_ult_bol(Integer convenio_ult_bol) {
        this.convenio_ult_bol = convenio_ult_bol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.convenio_nr_conv != null ? this.convenio_nr_conv.hashCode() : 0);
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
        final Convenio other = (Convenio) obj;
        if ((this.convenio_nr_conv == null) ? (other.convenio_nr_conv != null) : !this.convenio_nr_conv.equals(other.convenio_nr_conv)) {
            return false;
        }
        return true;
    }
    
    
}
