/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vestibular.converter;

import br.com.vestibular.model.dao.MeuDao;
import br.com.vestibular.model.dao.MeuDaoImpl;
import br.com.vestibular.model.entities.Local_Prova;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cleiton
 */
@FacesConverter(value="converterLocal_Prova")
public class ConverterLocal_Prova implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            MeuDao dao = new MeuDaoImpl();
            return dao.getByIdLocal_Prova(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Local_Prova) {
            Local_Prova local_prova = (Local_Prova) value;
            return String.valueOf(local_prova.getProva_id());
        }
        return "";
    }
}