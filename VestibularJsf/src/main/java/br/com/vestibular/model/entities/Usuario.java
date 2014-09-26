/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
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
 * @author XPredator
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "USU_ID", nullable = false)
    private Integer usu_id;
    @Column(name = "USU_NOME", nullable = true, length = 80)
    private String usu_nome;
    @Column(name = "USU_CPF", nullable = true, length = 14) //224.491.491-71
    private String usu_cpf;
    @Column(name = "USU_RG", nullable = true, length = 20)
    private String usu_rg;
    @Column(name = "USU_DATANASC", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date usu_datanasc;
    @Column(name = "USU_TEL", nullable = true, length = 14)//(34)-8888-8888
    private String usu_tel;
    @Column(name = "USU_CEL", nullable = true, length = 15)
    private String usu_cel;
    @Column(name = "USU_PERMISAO", nullable = true, length = 20)
    private String usu_permissao;
    @Column(name = "USU_EMAIL", unique = true, nullable = true, length = 50)
    private String usu_email;
    @Column(name = "USU_SENHA", nullable = true, length = 40)
    private String usu_senha;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_SETOR_USUARIO")
    @JoinColumn(name = "SET_ID", referencedColumnName = "set_id", nullable = true)
    private Setor setor;

    public Usuario() {
        this.setor = new Setor();
    }

    public Integer getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_cpf() {
        return usu_cpf;
    }

    public void setUsu_cpf(String usu_cpf) {
        this.usu_cpf = usu_cpf;
    }

    public String getUsu_rg() {
        return usu_rg;
    }

    public void setUsu_rg(String usu_rg) {
        this.usu_rg = usu_rg;
    }

    public Date getUsu_datanasc() {
        return usu_datanasc;
    }

    public void setUsu_datanasc(Date usu_datanasc) {
        this.usu_datanasc = usu_datanasc;
    }

    public String getUsu_tel() {
        return usu_tel;
    }

    public void setUsu_tel(String usu_tel) {
        this.usu_tel = usu_tel;
    }

    public String getUsu_cel() {
        return usu_cel;
    }

    public void setUsu_cel(String usu_cel) {
        this.usu_cel = usu_cel;
    }

    public String getUsu_permissao() {
        return usu_permissao;
    }

    public void setUsu_permissao(String usu_permissao) {
        this.usu_permissao = usu_permissao;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.usu_id != null ? this.usu_id.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.usu_id != other.usu_id && (this.usu_id == null || !this.usu_id.equals(other.usu_id))) {
            return false;
        }
        return true;
    }

    
    
}
