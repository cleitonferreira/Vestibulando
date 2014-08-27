/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "LOCAL_PROVA")
public class Local_Prova implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "PROVA_ID", nullable = false)
    private Integer prova_id;
    @Column(name = "PROVA_CIDADE", nullable = false, length = 80)
    private String prova_cidade;
    @Column(name = "PROVA_OBS", nullable = false, length = 80)
    private String prova_obs;
    @Column(name = "PROVA_FLAG", nullable = false, length = 1)
    private Boolean prova_flag;

    @OneToMany(mappedBy = "local_prova", fetch = FetchType.LAZY)
    @ForeignKey(name = "Local_Prova_Inscricao")
    private List<Inscricao> inscricoes;

    public Local_Prova() {
    }

    public Integer getProva_id() {
        return prova_id;
    }

    public void setProva_id(Integer prova_id) {
        this.prova_id = prova_id;
    }

    public String getProva_cidade() {
        return prova_cidade;
    }

    public void setProva_cidade(String prova_cidade) {
        this.prova_cidade = prova_cidade;
    }

    public String getProva_obs() {
        return prova_obs;
    }

    public void setProva_obs(String prova_obs) {
        this.prova_obs = prova_obs;
    }

    public Boolean isProva_flag() {
        return prova_flag;
    }

    public void setProva_flag(Boolean prova_flag) {
        this.prova_flag = prova_flag;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.prova_id != null ? this.prova_id.hashCode() : 0);
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
        final Local_Prova other = (Local_Prova) obj;
        if (this.prova_id != other.prova_id && (this.prova_id == null || !this.prova_id.equals(other.prova_id))) {
            return false;
        }
        return true;
    }

    

    
    
}
