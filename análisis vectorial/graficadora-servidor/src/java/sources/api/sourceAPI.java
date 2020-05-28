/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.api;

import controllers.security.logger;
import java.util.HashMap;
import java.util.List;

import objects.User;
import repositories.repositoryAPI;

/**
 *
 * @author luis
 */
public class sourceAPI extends sources.api.executorAPI implements repositoryAPI {

    private final mapperAPI MAPPER = new mapperAPI();
    public final logger ERROR = new logger();

    @Override
    public User saveUser(User object) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "" + object.id);
        map.put("email", "" + object.email);
        map.put("password", "" + object.password);
        map.put("name", "" + object.name);
        map.put("type", "" + object.type);
        try {
            return this.MAPPER.user(this.formRequest("/users", "POST", map, null));
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public User setUser(User object) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "" + object.id);
        if (object.email != null && !object.email.equals("")) {
            map.put("email", "" + object.email);
        }
        if (object.password != null && !object.password.equals("")) {
            map.put("password", "" + object.password);
        }
        if (object.name != null && !object.name.equals("")) {
            map.put("name", "" + object.name);
        }
        if (object.type != null && !object.type.equals("")) {
            map.put("type", "" + object.type);
        }
        try {
            return this.MAPPER.user(this.formRequest("/users/" + object.id, "PUT", map, null));
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public User getUser(User object) {
        try {
            return this.MAPPER.user(this.queryRequest("/users" + "/" + object.id, "GET", null));
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        try {
            return this.MAPPER.listUser(this.queryRequest("/users", "GET", null));
        } catch (Exception ex) {
            ERROR.error(ex);
        }

        return null;
    }

    @Override
    public Long deleteUser(Long key) {
        try {
            this.queryRequest("/users" + "/" + key, "DELETE", null);
            return 0L;
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public User verifyUser(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User authUser(User object) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("email", "" + object.email);
            map.put("password", "" + object.password);
            object = this.MAPPER.user(this.queryRequest("/users/auth", "GET", map));
            if (object.id != null) {
                return object;
            }
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

}
