
package routes;

import javax.servlet.annotation.WebServlet;
import routes.utils.iServlet;

/**
 *
 * @author luis
 */
@WebServlet(name = "index", urlPatterns = {"/index/*"})
public class index extends iServlet{

    
    @Override
    protected void get() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void post() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
