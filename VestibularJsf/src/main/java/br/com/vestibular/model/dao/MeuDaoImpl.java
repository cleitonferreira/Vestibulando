/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.dao;

import br.com.vestibular.model.entities.Cidade;
import br.com.vestibular.model.entities.Curso;
import br.com.vestibular.model.entities.Estado;
import br.com.vestibular.model.entities.Inscricao;
import br.com.vestibular.model.entities.Local_Prova;
import br.com.vestibular.model.entities.Pais;
import br.com.vestibular.model.entities.Setor;
import br.com.vestibular.model.entities.Vestibular;
import br.com.vestibular.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author altitdb
 */
public class MeuDaoImpl implements MeuDao, Serializable {

    @Override
    public Cidade getByIdCidade(Integer id) {
        return (Cidade) FacesContextUtil.getRequestSession().get(Cidade.class, id);
    }

    @Override
    public Estado getByIdEstado(Integer id) {
        return (Estado) FacesContextUtil.getRequestSession().get(Estado.class, id);
    }

    @Override
    public List<Estado> consultaTodosEstados() {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Estado.class);
        return crit.list();
    }

    @Override
    public List<Cidade> consultaCidades(Estado estado) {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Cidade.class);
        crit.add(Restrictions.eq("estado", estado));
        return crit.list();
    }

    //http://www.devmedia.com.br/hibernate-api-criteria-realizando-consultas/29627
    //http://www.developerhelpway.com/framework/hibernate/criteria/criteria-unique-result.php
    @Override
    public Object consultaCpf(String cpf, String vestinfo) {
//        System.out.println("Variavel>>>>>>" + cpf);
        SQLQuery sql = FacesContextUtil.getRequestSession().createSQLQuery("SELECT COUNT(*) FROM INSCRICAO WHERE VESTIBULAR_INFO = '" + vestinfo + "' AND INSCRICAO_CPF = " + "'" + cpf + "'");
//        projList.add(Projections.count("pes_cpf"), cpf);
//        crit.setProjection(projList);
//        List results = crit.list();

        Object results = sql.list();
        //System.out.println("Ojeto >>>>" + results);

        return results;
    }

//    @Override
//    public Object consultaVestibular(String vest_info) {
//        System.out.println("Variavel>>>>>>" + vest_info);
//        SQLQuery sql = HibernateCombos.getSession().createSQLQuery("SELECT COUNT(*) FROM `VESTIBULAR` WHERE `VESTIBULAR_INFO` = '" + vest_info + "'");
//
//        Object resultado;
//        resultado = sql.list();
////        System.out.println("List >>>>" + resultado);
//
//        return resultado;
//    }
    @Override
    public Pais getByIdPais(Integer id) {
        return (Pais) FacesContextUtil.getRequestSession().get(Pais.class, id);
    }

    @Override
    public List<Pais> consultaTodosPaises() {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Pais.class);
        return crit.list();
    }

    //Setor
    @Override
    public Setor getByIdSetor(Integer id) {
        return (Setor) FacesContextUtil.getRequestSession().get(Setor.class, id);
    }

    @Override
    public List<Setor> consultaTodosSetores() {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Setor.class);
        return crit.list();
    }

    @Override
    public Vestibular getByIdVestibular(String id) {
        return (Vestibular) FacesContextUtil.getRequestSession().get(Vestibular.class, id);
    }

    @Override
    public List<Vestibular> consultaTodosVestibulares() {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Vestibular.class);
        return crit.list();
    }

    @Override
    public Curso getByIdCurso(Integer id) {
        return (Curso) FacesContextUtil.getRequestSession().get(Curso.class, id);
    }

    @Override
    public List<Curso> consultaTodosCursos(String cursoreferencia) {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Curso.class);
//        String varflag = "%" + true + "%";
        String varcurso = "%" + cursoreferencia + "%";
        crit.add(Restrictions.eq("curso_flag", "1"));
        crit.add(Restrictions.ilike("curso_referencia", varcurso));

        return crit.list();
    }

//    @Override
//    public Curso getByIdCurso2(Integer id) {
//        return (Curso) FacesContextUtil.getRequestSession().get(Curso.class, id);
//    }
//
//    @Override
//    public List<Curso> consultaTodosCursos2() {
//        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Curso.class);
//        // where curso_flag = 1
//        crit.add(Restrictions.eq("curso_flag", 1));
//        return crit.list();
//    }
    @Override
    public Local_Prova getByIdLocal_Prova(Integer id) {
        return (Local_Prova) FacesContextUtil.getRequestSession().get(Local_Prova.class, id);
    }

    @Override
    public List<Local_Prova> consultaTodosLocais_Provas() {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Local_Prova.class);
        return crit.list();
    }

//    @Override
//    public List<Inscricao> consultaVestibularInscricao() {
//        Criteria crit = HibernateCombos.getSession().createCriteria(Inscricao.class);
//        // where curso_flag = 1
//        crit.add(Restrictions.eq("curso_id", 9));
//        return crit.list();
//    }
    @Override
    public List<Inscricao> inscritosVestibularMedicina(String vest_info) {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Inscricao.class).createCriteria("vestibular");
        String var = "%" + vest_info + "%";
        crit.add(Restrictions.ilike("vestibular_info", var));

//        chave estrangeira criteria
//        http://www.mballem.com/post/consultas-com-hibernate-e-a-api-criteria-parte-ii
        return crit.list();
    }

    @Override
    public List<Inscricao> inscritosVestibular(String vest_info) {
        Criteria crit = FacesContextUtil.getRequestSession().createCriteria(Inscricao.class).createCriteria("vestibular");
        String var = "%" + vest_info + "%";
        crit.add(Restrictions.ilike("vestibular_info", var));
        return crit.list();
    }

    @Override
    public List quantInscritosVestibular(String vest_info) {
        SQLQuery sql = FacesContextUtil.getRequestSession().createSQLQuery("SELECT CURSO,\n"
                + "CONCAT('Total: ',VW_INSCRITOS) AS VW_INSCRITOS\n"
                + "FROM VW_TOTAL_INSCRITOS_VEST_20150101 WHERE VESTIBULAR_INFO = "+vest_info);

        sql.setResultTransformer(Transformers.TO_LIST);

//        List results = sql.list();
//        System.out.println("Qaunt.>>>>>>>>>>>>>>>>>>>>>>>" + results.toString());
        return sql.list();
    }

    @Override
    public List viewTotalInscritosBD() {
        SQLQuery sql = FacesContextUtil.getRequestSession().createSQLQuery("SELECT CURSO, VW_PAGO, VW_ABERTO, VW_INSCRITOS FROM VW_TOTAL_INSCRITOS_VEST_20150101");

//        System.out.println("Sql"+sql);
        sql.setResultTransformer(Transformers.TO_LIST);
        return sql.list();
    }

}
