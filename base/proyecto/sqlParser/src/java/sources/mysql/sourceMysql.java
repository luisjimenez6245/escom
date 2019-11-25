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
    public int deleteEmail(int key) {
        String query = "email";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("emailId", key);
        }

        this.delete(query, lista);
        Email helper = getEmail(new Email(key));
        if (helper == null || helper.emailId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deletePhone(int key) {
        String query = "phone";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("phoneId", key);
        }

        this.delete(query, lista);
        Phone helper = getPhone(new Phone(key));
        if (helper == null || helper.phoneId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteUser(int key) {
        String query = "user";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("userId", key);
        }
        this.delete(query, lista);
        User helper = getUser(new User(key));
        if (helper == null || helper.userId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteLevel(int key) {
        String query = "level";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("levelId", key);
        }

        this.delete(query, lista);
        Level helper = getLevel(new Level(key));
        if (helper == null || helper.levelId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteQuery(int key) {
        String query = "query";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("queryId", key);
        }
        this.delete(query, lista);
        Query helper = getQuery(new Query(key));
        if (helper == null || helper.queryId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteAttributeKind(int key) {
        String query = "attribute_kind";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("attribute_kindId", key);
        }
        this.delete(query, lista);
        AttributeKind helper = getAttributeKind(new AttributeKind(key));
        if (helper == null || helper.attributeKindId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteAttribute(int key) {
        String query = "attribute";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("attributeId", key);
        }
        this.delete(query, lista);
        Attribute helper = getAttribute(new Attribute(key));
        if (helper == null || helper.attributeId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteTable(int key) {
        String query = "_table";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("tableId", key);
        }
        this.delete(query, lista);
        Table helper = getTable(new Table(key));
        if (helper == null || helper.tableId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteDatabase(int key) {
        String query = "_database";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("databaseId", key);
        }
        this.delete(query, lista);
        Database helper = getDatabase(new Database(key));
        if (helper == null || helper.databaseId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public Email[] getEmailList(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.email != null) {
                lista.put("email", object.email);
            }
            if (object.emailId != 0) {
                lista.put("email_id", object.emailId);
            }
            lista.put("is_principal", object.isPrincipal);

            lista.put("is_active", object.isActive);

            if (object.emailId != 0) {
                lista.put("email_id", object.emailId);
            }
        }
        return MAPPER.emailList(this.get(query, lista));
    }

    @Override
    public Phone[] getPhoneList(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.phoneId != 0) {
                lista.put("phone_id", object.phoneId);
            }
            lista.put("phone", object.phone);
            lista.put("is_principal", object.isPrincipal);
            lista.put("is_active", object.isActive);
            if (object.phoneId != 0) {
                lista.put("phone_id", object.phoneId);
            }
        }
        return MAPPER.phoneList(this.get(query, lista));
    }

    @Override
    public User[] getUserList(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.password != null) {
                lista.put("password", object.password);
            }
            if (object.userId != 0) {
                lista.put("user_id", object.userId);
            }
            if (object.emails != null) {
                lista.put("emails", object.emails);
            }
            if (object.surname != null) {
                lista.put("surname", object.surname);
            }
            lista.put("is_active", object.isActive);
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }

            if (object.phones != null) {
                lista.put("phones", object.phones);
            }
            if (object.userType != null) {
                lista.put("user_type", object.userType);
            }
        }
        return MAPPER.userList(this.get(query, lista));
    }

    @Override
    public Level[] getLevelList(Level object) {
        String query = "select l.* from level l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.number != 0) {
                lista.put("number", object.number);
            }
            if (object.levelId != 0) {
                lista.put("level_id", object.levelId);
            }
            lista.put("is_principal", object.isPrincipal);
            lista.put("is_active", object.isActive);
            if (object.levelId != 0) {
                lista.put("level_id", object.levelId);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
        }
        return MAPPER.levelList(this.get(query, lista));
    }

    @Override
    public Query[] getQueryList(Query object) {
        String query = "select q.* from query q";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.queryId != 0) {
                lista.put("query_id", object.queryId);
            }
            if (object.queryType != null) {
                lista.put("query_type", object.queryType);
            }
        }
        return MAPPER.queryList(this.get(query, lista));
    }

    @Override
    public AttributeKind[] getAttributeKindList(AttributeKind object) {
        String query = "select a.* from attribute_kind a";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.minValue != 0) {
                lista.put("min_value", object.minValue);
            }
            if (object.attributeKindId != 0) {
                lista.put("attribute_kind_id", object.attributeKindId);
            }
            if (object.name != null) {
                lista.put("name ", object.name);
            }
            if (object.description != null) {
                lista.put("description", object.description);
            }
            if (object.maxValue != 0) {
                lista.put("max_value", object.maxValue);
            }
            if (object.sqlSyntax != null) {
                lista.put("sql_syntax", object.sqlSyntax);
            }
        }
        return MAPPER.attributeKindList(this.get(query, lista));
    }

    @Override
    public Attribute[] getAttributeList(Attribute object) {
        String query = "select a.* from attribute a";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.tableId != 0) {
                lista.put("_table_id", object.tableId);
            }
            if (object.attributeKind != null) {
                lista.put("attribute_kind", object.attributeKind);
            }
            if (object.attributeId != 0) {
                lista.put("attribute_id", object.attributeId);
            }
            if (object.name != null) {
                lista.put("name ", object.name);
            }
        }
        return MAPPER.attributeList(this.get(query, lista));
    }

    @Override
    public Table[] getTableList(Table object) {
        String query = "select t.* from _table t";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.databaseId != 0) {
                lista.put("_database_id", object.databaseId);
            }
            if (object.tableId != 0) {
                lista.put("_table_id", object.tableId);
            }
            if (object.attributes != null) {
                lista.put("attributes", object.attributes);
            }
        }
        return MAPPER.tableList(this.get(query, lista));
    }

    @Override
    public Database[] getDatabaseList(Database object) {
        String query = "select d.* from _database d";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.table != null) {
                lista.put("tables", object.table);
            }
            if (object.url != null) {
                lista.put("url", object.url);
            }
            if (object.databaseId != 0) {
                lista.put("_database_id", object.databaseId);
            }
        }
        return MAPPER.databaseList(this.get(query, lista));
    }

    @Override
    public Email saveEmail(Email object) {
        String query = " email ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            lista.put("is_valid", object.isValid);
            lista.put("is_active", object.isActive);
            lista.put("is_principal", object.isPrincipal);
            if (object.emailId != 0) {
                lista.put("email_id", object.emailId);
            }
            if (object.userId != 0) {
                lista.put("userId", object.userId);
            }
            if (object.email != null) {
                lista.put("email", object.email);
            }
        }
        object = MAPPER.email(this.save(query, lista));
        object = getEmail(object);
        return object;
    }

    @Override
    public Phone savePhone(Phone object) {
        String query = " phone ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            lista.put("is_active", object.isActive);
            if (object.phoneId != 0) {
                lista.put("phone_id", object.phoneId);
            }
            if (object.phoneId != 0) {
                lista.put("phone_id", object.phoneId);
            }
            if (object.phone != null) {
                lista.put("phone", object.phone);
            }
            if (object.userId != 0) {
                lista.put("userId", object.userId);
            }
            lista.put("is_valid", object.isValid);
            lista.put("is_principal", object.isPrincipal);

        }
        object = MAPPER.phone(this.save(query, lista));
        object = getPhone(object);
        return object;
    }

    @Override
    public User saveUser(User object) {
        String query = " user ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.password != null) {
                lista.put("password", object.password);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.emails != null) {
                lista.put("emails", object.emails);
            }
            if (object.userId != 0) {
                lista.put("user_id", object.userId);
            }
            lista.put("is_active", object.isActive);

            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.phones != null) {
                lista.put("phones", object.phones);
            }
            if (object.userType != null) {
                lista.put("user_type", object.userType);
            }
            if (object.surname != null) {
                lista.put("surname", object.surname);
            }
        }
        object = MAPPER.user(this.save(query, lista));
        object = getUser(object);
        return object;
    }

    @Override
    public Level saveLevel(Level object) {
        String query = " level ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            lista.put("is_active", object.isActive);

            if (object.levelId != 0) {
                lista.put("level_id", object.levelId);
            }
            if (object.levelId != 0) {
                lista.put("level_id", object.levelId);
            }
            lista.put("is_principal", object.isPrincipal);

            if (object.number != 0) {
                lista.put("number", object.number);
            }
        }
        object = MAPPER.level(this.save(query, lista));
        object = getLevel(object);
        return object;
    }

    @Override
    public Query saveQuery(Query object) {
        String query = " query ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.queryId != 0) {
                lista.put("query_id", object.queryId);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.queryType != null) {
                lista.put("query_type", object.queryType);
            }
        }
        object = MAPPER.query(this.save(query, lista));
        object = getQuery(object);
        return object;
    }

    @Override
    public AttributeKind saveAttributeKind(AttributeKind object) {
        String query = " attribute_kind ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.sqlSyntax != null) {
                lista.put("sql_syntax", object.sqlSyntax);
            }
            if (object.attributeKindId != 0) {
                lista.put("attribute_kind_id", object.attributeKindId);
            }
            if (object.description != null) {
                lista.put("description", object.description);
            }
            if (object.name != null) {
                lista.put("name ", object.name);
            }
            if (object.minValue != 0) {
                lista.put("min_value", object.minValue);
            }
            if (object.maxValue != 0) {
                lista.put("max_value", object.maxValue);
            }
        }
        object = MAPPER.attributeKind(this.save(query, lista));
        object = getAttributeKind(object);
        return object;
    }

    @Override
    public Attribute saveAttribute(Attribute object) {
        String query = " attribute ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.attributeId != 0) {
                lista.put("attribute_id", object.attributeId);
            }
            if (object.attributeKind != null) {
                lista.put("attribute_kind", object.attributeKind);
            }
            if (object.tableId != 0) {
                lista.put("_table_id", object.tableId);
            }
            if (object.name != null) {
                lista.put("name ", object.name);
            }
        }
        object = MAPPER.attribute(this.save(query, lista));
        object = getAttribute(object);
        return object;
    }

    @Override
    public Table saveTable(Table object) {
        String query = " _table ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.databaseId != 0) {
                lista.put("_database_id", object.databaseId);
            }
            if (object.tableId != 0) {
                lista.put("_table_id", object.tableId);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.attributes != null) {
                lista.put("attributes", object.attributes);
            }
        }
        object = MAPPER.table(this.save(query, lista));
        object = getTable(object);
        return object;
    }

    @Override
    public Database saveDatabase(Database object) {
        String query = " _database ";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.databaseId != 0) {
                lista.put("_database_id", object.databaseId);
            }
            if (object.url != null) {
                lista.put("url", object.url);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.table != null) {
                lista.put("tables", object.table);
            }
        }
        object = MAPPER.database(this.save(query, lista));
        object = getDatabase(object);
        return object;
    }

    @Override
    public Email setEmail(Email object) {
        String query = " update email set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("email_id", object.emailId);
            params.put("is_principal", object.isPrincipal);
            if (object.email != null) {
                params.put("email", object.email);
            }
            params.put("is_active", object.isActive);
        }
        object = MAPPER.email(this.set(query, params, conditions));
        object = getEmail(object);
        return object;
    }

    @Override
    public Phone setPhone(Phone object) {
        String query = " update phone set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("phone_id", object.phoneId);
            params.put("is_principal", object.isPrincipal);
            if (object.phone != null) {
                params.put("phone", object.phone);
            }
        }
        params.put("is_active", object.isActive);
        object = MAPPER.phone(this.set(query, params, conditions));
        object = getPhone(object);
        return object;
    }

    @Override
    public User setUser(User object) {
        String query = " update user set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("user_id", object.userId);
            if (object.creationDate != null) {
                params.put("creation_date", object.creationDate);
            }
            if (object.password != null) {
                params.put("password", object.password);
            }
            if (object.phones != null) {
                params.put("phones", object.phones);
            }
            if (object.name != null) {
                params.put("name", object.name);
            }

            if (object.surname != null) {
                params.put("surname", object.surname);
            }
            if (object.userType != null) {
                params.put("user_type", object.userType);
            }
            params.put("is_active", object.isActive);
            if (object.emails != null) {
                params.put("emails", object.emails);
            }
        }
        object = MAPPER.user(this.set(query, params, conditions));
        object = getUser(object);
        return object;
    }

    @Override
    public Level setLevel(Level object) {
        String query = " update level set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("level_id", object.levelId);
            params.put("is_principal", object.isPrincipal);
            if (object.name != null) {
                params.put("name", object.name);
            }
            if (object.number != 0) {
                params.put("number", object.number);
            }
            params.put("is_active", object.isActive);
        }
        object = MAPPER.level(this.set(query, params, conditions));
        object = getLevel(object);
        return object;
    }

    @Override
    public Query setQuery(Query object) {
        String query = " update query set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("query_id", object.queryId);
            if (object.creationDate != null) {
                params.put("creation_date", object.creationDate);
            }
            if (object.queryType != null) {
                params.put("query_type", object.queryType);
            }
            if (object.name != null) {
                params.put("name", object.name);
            }
        }
        object = MAPPER.query(this.set(query, params, conditions));
        object = getQuery(object);
        return object;
    }

    @Override
    public AttributeKind setAttributeKind(AttributeKind object) {
        String query = " update attribute_kind set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("attribute_kind_id", object.attributeKindId);
            if (object.maxValue != 0) {
                params.put("max_value", object.maxValue);
            }
            if (object.minValue != 0) {
                params.put("min_value", object.minValue);
            }
            if (object.name != null) {
                params.put("name ", object.name);
            }
            if (object.sqlSyntax != null) {
                params.put("sql_syntax", object.sqlSyntax);
            }
            if (object.description != null) {
                params.put("description", object.description);
            }
        }
        object = MAPPER.attributeKind(this.set(query, params, conditions));
        object = getAttributeKind(object);
        return object;
    }

    @Override
    public Attribute setAttribute(Attribute object) {
        String query = " update attribute set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("attribute_id", object.attributeId);
            if (object.attributeKind != null) {
                params.put("attribute_kind", object.attributeKind);
            }
            if (object.name != null) {
                params.put("name ", object.name);
            }
            if (object.tableId != 0) {
                params.put("_table_id", object.tableId);
            }
        }
        object = MAPPER.attribute(this.set(query, params, conditions));
        object = getAttribute(object);
        return object;
    }

    @Override
    public Table setTable(Table object) {
        String query = " update table set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("_table_id", object.tableId);
            if (object.databaseId != 0) {
                params.put("_database_id", object.databaseId);
            }
            if (object.attributes != null) {
                params.put("attributes", object.attributes);
            }
            if (object.name != null) {
                params.put("name", object.name);
            }
        }
        object = MAPPER.table(this.set(query, params, conditions));
        object = getTable(object);
        return object;
    }

    @Override
    public Database setDatabase(Database object) {
        String query = " update database set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        if (object != null) {
            conditions.put("_database_id", object.databaseId);
            if (object.url != null) {
                params.put("url", object.url);
            }
            if (object.table != null) {
                params.put("tables", object.table);
            }
            if (object.name != null) {
                params.put("name", object.name);
            }
        }
        object = MAPPER.database(this.set(query, params, conditions));
        object = getDatabase(object);
        return object;
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
    public Phone getPhone(Phone object) {
        Phone[] res = getPhoneList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Phone(0);
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
    public Level getLevel(Level object) {
        Level[] res = getLevelList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Level(0);
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
    public AttributeKind getAttributeKind(AttributeKind object) {
        AttributeKind[] res = getAttributeKindList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new AttributeKind(0);
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
    public Table getTable(Table object) {
        Table[] res = getTableList(object);
        if (res != null
                && res.length > 0) {
            return res[0];
        }
        return new Table(0);
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
}
