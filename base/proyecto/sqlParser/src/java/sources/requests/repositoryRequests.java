/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package sources.requests;

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
public interface repositoryRequests {

    public Email getEmail();

    public Email[] getEmailList();

    public Phone getPhone();

    public Phone[] getPhoneList();

    public User getUser();

    public User[] getUserList();

    public Level getLevel();

    public Level[] getLevelList();

    public Query getQuery();

    public Query[] getQueryList();

    public AttributeKind getAttributeKind();

    public AttributeKind[] getAttributeKindList();

    public Attribute getAttribute();

    public Attribute[] getAttributeList();

    public Table getTable();

    public Table[] getTableList();

    public Database getDatabase();

    public Database[] getDatabaseList();

}
