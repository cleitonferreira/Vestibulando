/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.vestibular.validators;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cleiton
 */
@FacesValidator("InteiroValidator")  
public class InteiroValidator implements Validator {  
  
         
   /** 
    * Método responsável por validar os campos com moeda. Caso ocorra algum erro lança uma ValidatorException. 
    */  
   public void validate(FacesContext ctx, UIComponent comp, Object val) throws ValidatorException {  
         
       Float valor = (Float) val;  
         
       if(val == null)  
            return;               
         
        if (valor.intValue() < 0) {  
           FacesMessage message = new FacesMessage("Preencha com o valor válido maior ou igual a zero!");  
           message.setSeverity(FacesMessage.SEVERITY_ERROR);  
           throw new ValidatorException(message);  
       }  
         
   }  
     
}  
