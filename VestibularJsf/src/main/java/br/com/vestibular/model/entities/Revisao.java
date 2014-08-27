/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "REVISAO")
public class Revisao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "REVISAO_ID", nullable = false)
    private Integer revisao_id;
    @Column(name = "INSCRICAO_ID", nullable = false, length = 20)
    private Long inscricao_id;
    @Column(name = "REVISAO_NOME", nullable = false, length = 80)
    private String revisao_nome;
    @Column(name = "REVISAO_CPF", nullable = false, length = 14)
    private String revisao_cpf;
    @Column(name = "REVISAO_QUESTAO", nullable = false, length = 80)
    private String revisao_questao;
    @Column(name = "REVISAO_DESCRICAO", nullable = false, length = 255)
    private String revisao_descricao;


    public Revisao() {

    }

    public Integer getRevisao_id() {
        return revisao_id;
    }

    public void setRevisao_id(Integer revisao_id) {
        this.revisao_id = revisao_id;
    }

    public Long getInscricao_id() {
        return inscricao_id;
    }

    public void setInscricao_id(Long inscricao_id) {
        this.inscricao_id = inscricao_id;
    }

    public String getRevisao_nome() {
        return revisao_nome;
    }

    public void setRevisao_nome(String revisao_nome) {
        this.revisao_nome = revisao_nome;
    }

    public String getRevisao_cpf() {
        return revisao_cpf;
    }

    public void setRevisao_cpf(String revisao_cpf) {
        this.revisao_cpf = revisao_cpf;
    }

    public String getRevisao_questao() {
        return revisao_questao;
    }

    public void setRevisao_questao(String revisao_questao) {
        this.revisao_questao = revisao_questao;
    }

    public String getRevisao_descricao() {
        return revisao_descricao;
    }

    public void setRevisao_descricao(String revisao_descricao) {
        this.revisao_descricao = revisao_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.revisao_id != null ? this.revisao_id.hashCode() : 0);
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
        final Revisao other = (Revisao) obj;
        if (this.revisao_id != other.revisao_id && (this.revisao_id == null || !this.revisao_id.equals(other.revisao_id))) {
            return false;
        }
        return true;
    }

    

    
}
