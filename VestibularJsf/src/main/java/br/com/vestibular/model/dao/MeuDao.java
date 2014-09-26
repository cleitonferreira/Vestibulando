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
import java.util.List;

/**
 *
 * @author altitdb
 */
public interface MeuDao {

    //Estado e Cidade
    public List<Estado> consultaTodosEstados();

    public List<Cidade> consultaCidades(Estado estado);

    public Cidade getByIdCidade(Integer id);

    public Estado getByIdEstado(Integer id);

    //Consultas na hora do cadastro e atualizacao
    public Object consultaCpf(String cpf, String vestinfo);

//    public Object consultaVestibular(String vest_info);
    /////////////////////////////////////////////
    //Pais  
    public Pais getByIdPais(Integer id);

    public List<Pais> consultaTodosPaises();

    //Setor  
    public Setor getByIdSetor(Integer id);

    public List<Setor> consultaTodosSetores();

    //Vestibular  
    public Vestibular getByIdVestibular(String id);

    public List<Vestibular> consultaTodosVestibulares();

    //Curso
    public Curso getByIdCurso(Integer id);

    public List<Curso> consultaTodosCursos(String cursoreferencia);

    // Curso 2
//    public Curso getByIdCurso2(Integer id);
//
//    public List<Curso> consultaTodosCursos2();

    //Local Prova
    public Local_Prova getByIdLocal_Prova(Integer id);

    public List<Local_Prova> consultaTodosLocais_Provas();

//  Vestibular Medicina
    public List<Inscricao> inscritosVestibularMedicina(String vest_info);

    //  Vestibular
    public List<Inscricao> inscritosVestibular(String vest_info);

}
