/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.dao;

import br.com.vestibular.model.entities.Cidade;
import br.com.vestibular.model.entities.Estado;
import br.com.vestibular.model.entities.Pais;
import br.com.vestibular.model.entities.Setor;
import br.com.vestibular.util.HibernateCombos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author altitdb
 */
public class MeuDaoImpl implements MeuDao, Serializable {

    @Override
    public Cidade getByIdCidade(Integer id) {
        return (Cidade) HibernateCombos.getSession().get(Cidade.class, id);
    }

    @Override
    public Estado getByIdEstado(Integer id) {
        return (Estado) HibernateCombos.getSession().get(Estado.class, id);
    }

    @Override
    public List<Estado> consultaTodosEstados() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Estado.class);
        return crit.list();
    }

    @Override
    public List<Cidade> consultaCidades(Estado estado) {
        Criteria crit = HibernateCombos.getSession().createCriteria(Cidade.class);
        crit.add(Restrictions.eq("estado", estado));
        return crit.list();
    }

    //http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
    //http://www.developerhelpway.com/framework/hibernate/criteria/criteria-unique-result.php
    @Override
    public Object consultaCpf(String cpf, String vestinfo) {
        System.out.println("Variavel>>>>>>" + cpf);
        SQLQuery sql = HibernateCombos.getSession().createSQLQuery("SELECT COUNT(*) FROM `inscricao` WHERE `vestibular_info` = " + vestinfo + " AND `inscricao_cpf` = " + cpf);
//        projList.add(Projections.count("pes_cpf"), cpf);
//        crit.setProjection(projList);
//        List results = crit.list();

        List results = new ArrayList();
        results = sql.list();
        System.out.println("List >>>>" + results);

        return results;
    }

    @Override
    public Pais getByIdPais(Integer id) {
        return (Pais) HibernateCombos.getSession().get(Pais.class, id);
    }

    @Override
    public List<Pais> consultaTodosPaises() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Pais.class);
        return crit.list();
    }

    //Setor
    @Override
    public Setor getByIdSetor(Integer id) {
        return (Setor) HibernateCombos.getSession().get(Setor.class, id);
    }

    @Override
    public List<Setor> consultaTodosSetores() {
        Criteria crit = HibernateCombos.getSession().createCriteria(Setor.class);
        return crit.list();
    }

}
