/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.converter;


import br.com.vestibular.model.dao.MeuDao;
import br.com.vestibular.model.dao.MeuDaoImpl;
import br.com.vestibular.model.entities.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author altitdb
 */
@FacesConverter(value = "converterEstado")
public class ConverterEstado implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            MeuDao dao = new MeuDaoImpl();
            return dao.getByIdEstado(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Estado) {
            Estado estado = (Estado) value;
            return String.valueOf(estado.getEst_id());
        }
        return "";
    }
}
