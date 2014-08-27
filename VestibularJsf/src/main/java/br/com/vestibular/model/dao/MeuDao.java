/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.dao;

import br.com.vestibular.model.entities.Cidade;
import br.com.vestibular.model.entities.Estado;
import br.com.vestibular.model.entities.Pais;
import br.com.vestibular.model.entities.Setor;
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

    //Pais  
    public Pais getByIdPais(Integer id);

    public List<Pais> consultaTodosPaises();

    //Setor  
    public Setor getByIdSetor(Integer id);

    public List<Setor> consultaTodosSetores();

}
