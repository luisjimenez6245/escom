/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.files;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

import objects.User;

/**
 *
 * @author luis
 */
public class mapperFiles {

    public final Gson json = new Gson();

    public List<User> listUser(String json) {
        return this.json.fromJson(json, new TypeToken<List<User>>() {
        }.getType());
    }

    public User user(String json) {
        return null;
    }

}