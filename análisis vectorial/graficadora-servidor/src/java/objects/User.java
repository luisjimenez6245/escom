/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author luis
 */
public class User extends object<User> {

    public Long id;

    public String email;
    public String password;
    public String name;
    public String token;
    public boolean isActive;
    public String type;

    public User(Long id) {
        this.id = id;
    }

    public User build(String email, String password, String name, String token, boolean isActive, String type) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.token = token;
        this.isActive = isActive;
        this.type = type;
        return this;
    }

    @Override
    public String toJSON() {
        return "{id:" + this.id
                + ",email:" + this.email
                + ",password:" + this.password
                + ",name:" + this.name
                + ",token:" + this.token
                + ",is_active:" + this.isActive
                + ",type:" + this.type
                + "}";
    }

}
