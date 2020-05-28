/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.requests;

import javax.servlet.http.HttpServletRequest;
import objects.Parametrics;

import objects.User;
import repositories.repositoryRequest;

/**
 *
 * @author luis
 */
public class sourceRequest extends executorRequest implements repositoryRequest {

    public sourceRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public User getUser() {
        return new User(Long.parseLong(request.getParameter("id_user") == null ? "0" : request.getParameter("id_user")))
                .build(
                        request.getParameter("email") == null ? "" : request.getParameter("email"),
                        request.getParameter("password") == null ? "" : request.getParameter("password"),
                        request.getParameter("name") == null ? "" : request.getParameter("name"),
                        request.getParameter("token") == null ? "" : request.getParameter("url"),
                        Boolean.parseBoolean(request.getParameter("is_active") == null ? "0" : request.getParameter("is_active")),
                        request.getParameter("type") == null ? "" : request.getParameter("type"));
    }

    @Override
    public String getAction() {
        return request.getParameter("c_action") == null ? "" : request.getParameter("c_action");
    }

    @Override
    public Parametrics getParametrics() {
        return new Parametrics(request.getParameter("g_type") == null ? "" : request.getParameter("g_type"))
                .build(
                        request.getParameter("x_parameter") == null ? "" : request.getParameter("x_parameter"),
                        request.getParameter("y_parameter") == null ? "" : request.getParameter("y_parameter"),
                        request.getParameter("z_parameter") == null ? "" : request.getParameter("z_parameter"),
                        request.getParameter("t_parameter") == null ? "" : request.getParameter("t_parameter"),
                        request.getParameter("s_parameter") == null ? "" : request.getParameter("s_parameter"),
                        request.getParameter("g_point") == null ? -1 : Integer.parseInt(request.getParameter("g_point"))
                );
    }

    @Override
    public String getOption() {
        return request.getParameter("option") == null ? "" : request.getParameter("option");
    }
}
