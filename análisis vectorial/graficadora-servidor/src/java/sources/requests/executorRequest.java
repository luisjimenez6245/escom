/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.requests;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author luis
 */
public class executorRequest {

    protected HttpServletRequest request;

    protected executorRequest(HttpServletRequest request) {
        this.request = request;
    }
}
