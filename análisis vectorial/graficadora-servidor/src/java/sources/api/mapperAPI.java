/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

import objects.User;

/**
 *
 * @author luis
 */
public class mapperAPI {

    public final Gson json = new Gson();

    public List<User> listUser(String json) {
        return this.json.fromJson(json, new TypeToken<List<User>>() {
        }.getType());
    }

    public User user(String json) {
        UserAux aux = this.json.fromJson(json, UserAux.class);
        aux.is_active = aux.is_active == null ? "" : aux.is_active;
        return new User(aux.id).build(aux.email == null ? "" : aux.email, aux.password == null ? "" : aux.password, aux.name == null ? "" : aux.name, aux.token == null ? "" : aux.token, !aux.is_active.equals("0"), aux.type);
    }

}

class UserAux {

    public Long id;

    public String email;
    public String password;
    public String name;
    public String token;
    public String is_active;
    public String type;
}
