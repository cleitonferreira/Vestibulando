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
@Table(name = "CURSO")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "CURSO_ID", nullable = false)
    private Integer curso_id;
    @Column(name = "CURSO_CODIGO", nullable = false, length = 10)
    private String curso_codigo;
    @Column(name = "CURSO_NOME", nullable = false, length = 80)
    private String curso_nome;
    @Column(name = "CURSO_VAGAS", nullable = false, length = 11)
    private Integer curso_vagas;
    @Column(name = "CURSO_EXTENSAO", nullable = false, length = 1)
    private Boolean curso_extensao;
    @Column(name = "CURSO_FLAG", nullable = false, length = 1)
    private Boolean curso_flag;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    @ForeignKey(name = "CursoInscricao")
    private List<Inscricao> inscricoes;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    @ForeignKey(name = "CursoInscricao2")
    private List<Inscricao> inscricoes2;

    public Curso() {
    }

    public Integer getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Integer curso_id) {
        this.curso_id = curso_id;
    }

    public String getCurso_codigo() {
        return curso_codigo;
    }

    public void setCurso_codigo(String curso_codigo) {
        this.curso_codigo = curso_codigo;
    }

    public String getCurso_nome() {
        return curso_nome;
    }

    public void setCurso_nome(String curso_nome) {
        this.curso_nome = curso_nome;
    }

    public Integer getCurso_vagas() {
        return curso_vagas;
    }

    public void setCurso_vagas(Integer curso_vagas) {
        this.curso_vagas = curso_vagas;
    }

    public Boolean isCurso_extensao() {
        return curso_extensao;
    }

    public void setCurso_extensao(Boolean curso_extensao) {
        this.curso_extensao = curso_extensao;
    }
    
    public Boolean isCurso_flag() {
        return curso_flag;
    }

    public void setCurso_flag(Boolean curso_flag) {
        this.curso_flag = curso_flag;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public List<Inscricao> getInscricoes2() {
        return inscricoes2;
    }

    public void setInscricoes2(List<Inscricao> inscricoes2) {
        this.inscricoes2 = inscricoes2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.curso_id != null ? this.curso_id.hashCode() : 0);
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
        final Curso other = (Curso) obj;
        if (this.curso_id != other.curso_id && (this.curso_id == null || !this.curso_id.equals(other.curso_id))) {
            return false;
        }
        return true;
    }

}
