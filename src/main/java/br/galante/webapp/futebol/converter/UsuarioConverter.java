package br.galante.webapp.futebol.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.galante.webapp.futebol.model.Usuario;

public class UsuarioConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
//        if (submittedValue.trim().equals("")) {
//            return null;
//        } else {
//            try {
//                int number = Integer.parseInt(submittedValue);
//
//                for (Usuario p : UsuarioDB) {
//                    if (p.getNumber() == number) {
//                        return p;
//                    }
//                }
//                
//            } catch(NumberFormatException exception) {
//                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Usuario"));
//            }
//        }

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else {
            return String.valueOf(((Usuario) value).getNome());
        }
    }
}