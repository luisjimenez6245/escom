/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.AttributesKind;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "attributesKind", urlPatterns = {"/attributesKind/*"})
public class attributesKind extends iServlet {

    private AttributesKind control;

    @Override
    protected void get() throws Exception {
        control = Factory.createAttributesKind();
        control.get(repository.getAttributeKind());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createAttributesKind();
        control.save(repository.getAttributeKind());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createAttributesKind();
        control.update(repository.getAttributeKind());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createAttributesKind();
        control.delete(repository.getAttributeKind());
        result = control.getContent();
    }

}
