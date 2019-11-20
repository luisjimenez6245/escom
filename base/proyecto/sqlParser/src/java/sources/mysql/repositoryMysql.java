/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package sources.mysql;

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
public interface repositoryMysql {

    public Email saveEmail(Email object);

    public Email setEmail(Email object);

    public Email getEmail(Email object);

    public Email[] getEmailList(Email object);

    public int deleteEmail(int key);

    public Phone savePhone(Phone object);

    public Phone setPhone(Phone object);

    public Phone getPhone(Phone object);

    public Phone[] getPhoneList(Phone object);

    public int deletePhone(int key);

    public User saveUser(User object);

    public User setUser(User object);

    public User getUser(User object);

    public User[] getUserList(User object);

    public int deleteUser(int key);

    public Level saveLevel(Level object);

    public Level setLevel(Level object);

    public Level getLevel(Level object);

    public Level[] getLevelList(Level object);

    public int deleteLevel(int key);

    public Query saveQuery(Query object);

    public Query setQuery(Query object);

    public Query getQuery(Query object);

    public Query[] getQueryList(Query object);

    public int deleteQuery(int key);

    public AttributeKind saveAttributeKind(AttributeKind object);

    public AttributeKind setAttributeKind(AttributeKind object);

    public AttributeKind getAttributeKind(AttributeKind object);

    public AttributeKind[] getAttributeKindList(AttributeKind object);

    public int deleteAttributeKind(int key);

    public Attribute saveAttribute(Attribute object);

    public Attribute setAttribute(Attribute object);

    public Attribute getAttribute(Attribute object);

    public Attribute[] getAttributeList(Attribute object);

    public int deleteAttribute(int key);

    public Table saveTable(Table object);

    public Table setTable(Table object);

    public Table getTable(Table object);

    public Table[] getTableList(Table object);

    public int deleteTable(int key);

    public Database saveDatabase(Database object);

    public Database setDatabase(Database object);

    public Database getDatabase(Database object);

    public Database[] getDatabaseList(Database object);

    public int deleteDatabase(int key);

}
