/*
* Contenido generado de pruebax
*/

package sources.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.User;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class mapperMysql {

    public User user (ResultSet res){
        try {
            if(res.next()){
                return new User(
                        res.getInt("user_id")
                ).build(
                        res.getString("email"), 
                        res.getString("password"), 
                        res.getString("name"), 
                        res.getString("token"),
                        res.getBoolean("is_active"),
                        res.getString("type") 
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
