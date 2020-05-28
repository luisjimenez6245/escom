/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import objects.User;


/**
 *
 * @author luis
 */
public interface repositoryAPI {

   public User saveUser(User object);

    public User setUser(User object);

    public User getUser(User object);

    public User verifyUser(User object);

    public User authUser(User object);

    public List<User> getUserList();

    public Long deleteUser(Long key);
}
