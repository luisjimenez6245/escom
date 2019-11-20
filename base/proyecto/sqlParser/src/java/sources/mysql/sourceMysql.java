/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package sources.mysql;

import java.util.HashMap;

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
public class sourceMysql extends executorMysql implements sources.mysql.repositoryMysql {

    private final mapperMysql MAPPER = new mapperMysql();

    public sourceMysql(String user, String password, String dbName, String url, String port) {
        super(user, password, dbName, url, port);
    }

    @Override
    public Email saveEmail(Email object) {
        String query = "email";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.email(this.save(query, lista));
        object = this.getEmail(object);
        return object;
    }

    @Override
    public Email setEmail(Email object) {
        String query = "updatw email set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.email(this.set(query, params, conditions));
        return this.getEmail(object);
    }

    @Override
    public Email getEmail(Email object) {
        Email[] res = getEmailList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Email(0);
    }

    @Override
    public Email[] getEmailList(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.emailList(this.get(query, lista));
    }

    @Override
    public int deleteEmail(int key) {
        String query = "email";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("email_id", key);
        }
        this.delete(query, lista);
        Email helper = getEmail(new Email(key));
        if (helper == null || helper.emailId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public Phone savePhone(Phone object) {
        String query = "phone";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.phone(this.save(query, lista));
        object = this.getPhone(object);
        return object;
    }

    @Override
    public Phone setPhone(Phone object) {
        String query = "updatw phone set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.phone(this.set(query, params, conditions));
        return this.getPhone(object);
    }

    @Override
    public Phone getPhone(Phone object) {
        Phone[] res = getPhoneList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Phone(0);
    }

    @Override
    public Phone[] getPhoneList(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.phoneList(this.get(query, lista));
    }

    @Override
    public int deletePhone(int key) {
        String query = "phone";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("phone_id", key);
        }
        this.delete(query, lista);
        Phone helper = getPhone(new Phone(key));
        if (helper == null || helper.phoneId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public User saveUser(User object) {
        String query = "user";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.user(this.save(query, lista));
        object = this.getUser(object);
        return object;
    }

    @Override
    public User setUser(User object) {
        String query = "updatw user set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.user(this.set(query, params, conditions));
        return this.getUser(object);
    }

    @Override
    public User getUser(User object) {
        User[] res = getUserList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new User(0);
    }

    @Override
    public User[] getUserList(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.userList(this.get(query, lista));
    }

    @Override
    public int deleteUser(int key) {
        String query = "user";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("user_id", key);
        }
        this.delete(query, lista);
        User helper = getUser(new User(key));
        if (helper == null || helper.userId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public Level saveLevel(Level object) {
        String query = "level";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.level(this.save(query, lista));
        object = this.getLevel(object);
        return object;
    }

    @Override
    public Level setLevel(Level object) {
        String query = "updatw level set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.level(this.set(query, params, conditions));
        return this.getLevel(object);
    }

    @Override
    public Level getLevel(Level object) {
        Level[] res = getLevelList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Level(0);
    }

    @Override
    public Level[] getLevelList(Level object) {
        String query = "select l.* from level l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.levelList(this.get(query, lista));
    }

    @Override
    public int deleteLevel(int key) {
        String query = "level";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("level_id", key);
        }
        this.delete(query, lista);
        Level helper = getLevel(new Level(key));
        if (helper == null || helper.levelId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public Query saveQuery(Query object) {
        String query = "query";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.query(this.save(query, lista));
        object = this.getQuery(object);
        return object;
    }

    @Override
    public Query setQuery(Query object) {
        String query = "updatw query set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.query(this.set(query, params, conditions));
        return this.getQuery(object);
    }

    @Override
    public Query getQuery(Query object) {
        Query[] res = getQueryList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Query(0);
    }

    @Override
    public Query[] getQueryList(Query object) {
        String query = "select q.* from query q";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.queryList(this.get(query, lista));
    }

    @Override
    public int deleteQuery(int key) {
        String query = "query";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("query_id", key);
        }
        this.delete(query, lista);
        Query helper = getQuery(new Query(key));
        if (helper == null || helper.queryId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public AttributeKind saveAttributeKind(AttributeKind object) {
        String query = "attribute_kind";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.attributeKind(this.save(query, lista));
        object = this.getAttributeKind(object);
        return object;
    }

    @Override
    public AttributeKind setAttributeKind(AttributeKind object) {
        String query = "updatw attribute_kind set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.attributeKind(this.set(query, params, conditions));
        return this.getAttributeKind(object);
    }

    @Override
    public AttributeKind getAttributeKind(AttributeKind object) {
        AttributeKind[] res = getAttributeKindList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new AttributeKind(0);
    }

    @Override
    public AttributeKind[] getAttributeKindList(AttributeKind object) {
        String query = "select a.* from attribute_kind a";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.attributeKindList(this.get(query, lista));
    }

    @Override
    public int deleteAttributeKind(int key) {
        String query = "attribute_kind";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("attribute_kind_id", key);
        }
        this.delete(query, lista);
        AttributeKind helper = getAttributeKind(newAttributeKind(key));
        if (helper == null || helper.attributeKindId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public Attribute saveAttribute(Attribute object) {
        String query = "attribute";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.attribute(this.save(query, lista));
        object = this.getAttribute(object);
        return object;
    }

    @Override
    public Attribute setAttribute(Attribute object) {
        String query = "updatw attribute set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.attribute(this.set(query, params, conditions));
        return this.getAttribute(object);
    }

    @Override
    public Attribute getAttribute(Attribute object) {
        Attribute[] res = getAttributeList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Attribute(0);
    }

    @Override
    public Attribute[] getAttributeList(Attribute object) {
        String query = "select a.* from attribute a";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.attributeList(this.get(query, lista));
    }

    @Override
    public int deleteAttribute(int key) {
        String query = "attribute";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("attribute_id", key);
        }
        this.delete(query, lista);
        Attribute helper = getAttribute(new Attribute(key));
        if (helper == null || helper.attributeId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public Table saveTable(Table object) {
        String query = "table";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.table(this.save(query, lista));
        object = this.getTable(object);
        return object;
    }

    @Override
    public Table setTable(Table object) {
        String query = "updatw table set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.table(this.set(query, params, conditions));
        return this.getTable(object);
    }

    @Override
    public Table getTable(Table object) {
        Table[] res = getTableList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Table(0);
    }

    @Override
    public Table[] getTableList(Table object) {
        String query = "select t.* from table t";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.tableList(this.get(query, lista));
    }

    @Override
    public int deleteTable(int key) {
        String query = "table";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("table_id", key);
        }
        this.delete(query, lista);
        Table helper = getTable(new Table(key));
        if (helper == null || helper.tableId == 0) {
            return key;
        }
        return key;
    }

    @Override
    public Database saveDatabase(Database object) {
        String query = "database";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.database(this.save(query, lista));
        object = this.getDatabase(object);
        return object;
    }

    @Override
    public Database setDatabase(Database object) {
        String query = "updatw database set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        object = MAPPER.database(this.set(query, params, conditions));
        return this.getDatabase(object);
    }

    @Override
    public Database getDatabase(Database object) {
        Database[] res = getDatabaseList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Database(0);
    }

    @Override
    public Database[] getDatabaseList(Database object) {
        String query = "select d.* from database d";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
        }
        return MAPPER.databaseList(this.get(query, lista));
    }

    @Override
    public int deleteDatabase(int key) {
        String query = "database";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("database_id", key);
        }
        this.delete(query, lista);
        Database helper = getDatabase(new Database(key));
        if (helper == null || helper.databaseId == 0) {
            return key;
        }
        return key;
    }

}
