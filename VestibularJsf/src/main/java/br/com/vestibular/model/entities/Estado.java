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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "EST_ID", nullable = false)
    private Integer est_id;
    @Column(name = "EST_NOME", nullable = false, length = 80)
    private String est_nome;
    @Column(name = "EST_UF", nullable = false, columnDefinition = "CHAR(3)")
    private String est_uf;

    //relacionamentos
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_PAIS_ESTADO")
    @JoinColumn(name = "PA_ID", referencedColumnName = "pa_id")
    private Pais pais;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_ESTADO_CIDADE")
    private List<Cidade> cidades;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_ESTADO_INSCRICAO")
    private List<Inscricao> inscricoes;

    public Estado() {
        this.pais = new Pais();
    }

    public Integer getEst_id() {
        return est_id;
    }

    public void setEst_id(Integer est_id) {
        this.est_id = est_id;
    }

    public String getEst_nome() {
        return est_nome;
    }

    public void setEst_nome(String est_nome) {
        this.est_nome = est_nome;
    }

    public String getEst_uf() {
        return est_uf;
    }

    public void setEst_uf(String est_uf) {
        this.est_uf = est_uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.est_id != null ? this.est_id.hashCode() : 0);
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
        final Estado other = (Estado) obj;
        if (this.est_id != other.est_id && (this.est_id == null || !this.est_id.equals(other.est_id))) {
            return false;
        }
        return true;
    }

    
    

    
    
}
