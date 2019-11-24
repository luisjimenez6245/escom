/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package sources.requests;

import javax.servlet.http.HttpServletRequest;

import models.Email;
import models.Phone;
import models.User;
import models.Level;
import models.Query;
import models.AttributeKind;
import models.Attribute;
import models.Table;
import models.Database;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class sourceRequests extends executorRequests implements sources.requests.repositoryRequests {

    private final mapperRequests MAPPER = new mapperRequests();

    public sourceRequests(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Email getEmail() {
        return new Email(Integer.parseInt(request.getParameter("email_id") == null ? "0" : request.getParameter("email_id")));
    }

    @Override
    public Email[] getEmailList() {
        return null;
    }

    @Override
    public Phone getPhone() {
        return new Phone(Integer.parseInt(request.getParameter("phone_id") == null ? "0" : request.getParameter("phone_id")));
    }

    @Override
    public Phone[] getPhoneList() {
        return null;
    }

    @Override
    public User getUser() {
        return new User(Integer.parseInt(request.getParameter("user_id") == null ? "0" : request.getParameter("user_id")));
    }

    @Override
    public User[] getUserList() {
        return null;
    }

    @Override
    public Level getLevel() {
        return new Level(Integer.parseInt(request.getParameter("level_id") == null ? "0" : request.getParameter("level_id")));
    }

    @Override
    public Level[] getLevelList() {
        return null;
    }

    @Override
    public Query getQuery() {
        return new Query(Integer.parseInt(request.getParameter("query_id") == null ? "0" : request.getParameter("query_id")));
    }

    @Override
    public Query[] getQueryList() {
        return null;
    }

    @Override
    public AttributeKind getAttributeKind() {
        return new AttributeKind(Integer.parseInt(request.getParameter("attribute_kind_id") == null ? "0" : request.getParameter("attribute_kind_id")));
    }

    @Override
    public AttributeKind[] getAttributeKindList() {
        return null;
    }

    @Override
    public Attribute getAttribute() {
        return new Attribute(Integer.parseInt(request.getParameter("attribute_id") == null ? "0" : request.getParameter("attribute_id")));
    }

    @Override
    public Attribute[] getAttributeList() {
        return null;
    }

    @Override
    public Table getTable() {
        return new Table(Integer.parseInt(request.getParameter("table_id") == null ? "0" : request.getParameter("table_id")));
    }

    @Override
    public Table[] getTableList() {
        return null;
    }

    @Override
    public Database getDatabase() {
        return new Database(Integer.parseInt(request.getParameter("database_id") == null ? "0" : request.getParameter("database_id")));
    }

    @Override
    public Database[] getDatabaseList() {
        return null;
    }

}