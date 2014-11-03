/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vestibular.converter;

import br.com.vestibular.model.dao.MeuDao;
import br.com.vestibular.model.dao.MeuDaoImpl;
import br.com.vestibular.model.entities.Pais;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cleiton
 */
@FacesConverter(value="converterPais")
public class ConverterPais implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            MeuDao dao = new MeuDaoImpl();
            return dao.getByIdPais(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Pais) {
            Pais pais = (Pais) value;
            return String.valueOf(pais.getPa_id());
        }
        return "";
    }
}
