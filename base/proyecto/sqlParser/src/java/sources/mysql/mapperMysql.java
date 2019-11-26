/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package sources.mysql;

import controllers.security.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Email;
import models.Phone;
import models.User;
import models.Level;
import models.Query;
import models.AttributeKind;
import models.Attribute;
import models.Table;
import models.Database;
import models.enums.QueryType;
import models.enums.UserType;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class mapperMysql {

    private final Logger LOGGER = new Logger();

    public Email[] emailList(ResultSet res) {
        try {
            List<Email> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Email(res.getInt("email_id")).build(res.getString("email"), res.getBoolean("is_active"), res.getBoolean("is_principal"), res.getBoolean("is_valid"), res.getInt("user_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Email[li.size()]) : new Email[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public Phone[] phoneList(ResultSet res) {
        try {
            List<Phone> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Phone(res.getInt("phone_id")).build(res.getString("phone"), res.getBoolean("is_active"), res.getBoolean("is_principal"), res.getBoolean("is_valid"), res.getInt("user_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Phone[li.size()]) : new Phone[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);

        }
        return null;
    }

    public User[] userList(ResultSet res) {
        try {
            List<User> li = new ArrayList<>();
            while (res.next()) {
                li.add(new User(res.getInt("user_id")).build(null, res.getString("surname"), res.getDate("creation_date"), res.getBoolean("is_active"), null, UserType.valueOf(res.getString("user_type")),
                        res.getString("password"), res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new User[li.size()]) : new User[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public Level[] levelList(ResultSet res) {
        try {
            List<Level> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Level(res.getInt("level_id")).build(
                        res.getBoolean("is_active"),
                        res.getBoolean("is_principal"),
                        res.getInt("number"),
                        res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new Level[li.size()]) : new Level[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public Query[] queryList(ResultSet res) {
        try {
            List<Query> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Query(res.getInt("query_id")).build(res.getDate("creation_date"), QueryType.valueOf(res.getString("query_type")), res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new Query[li.size()]) : new Query[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public AttributeKind[] attributeKindList(ResultSet res) {
        try {
            List<AttributeKind> li = new ArrayList<>();
            while (res.next()) {
                li.add(new AttributeKind(res.getInt("attribute_kind_id")).build(res.getInt("min_value"), res.getInt("max_value"), res.getString("name"), res.getString("description"), res.getString("sql_syntax")));
            }
            return (li.size() >= 1) ? li.toArray(new AttributeKind[li.size()]) : new AttributeKind[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public Attribute[] attributeList(ResultSet res) {
        try {
            List<Attribute> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Attribute(res.getInt("attribute_id")).build(new AttributeKind(res.getInt("attribute_kind")), res.getString("name"), res.getInt("table_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Attribute[li.size()]) : new Attribute[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);

        }
        return null;
    }

    public Table[] tableList(ResultSet res) {
        try {
            List<Table> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Table(res.getInt("table_id")).build(null, res.getInt("database_id"), res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new Table[li.size()]) : new Table[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        return null;
    }

    public Database[] databaseList(ResultSet res) {
        try {
            List<Database> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Database(res.getInt("database_id")).build(null, res.getString("url"), res.getString("name"), res.getInt("user_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Database[li.size()]) : new Database[0];
        } catch (SQLException ex) {
            LOGGER.error(ex);

        }
        return null;
    }

    public Email email(ResultSet res) {
        Email[] l = emailList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Email(0);
    }

    public Phone phone(ResultSet res) {
        Phone[] l = phoneList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Phone(0);
    }

    public User user(ResultSet res) {
        User[] l = userList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new User(0);
    }

    public Level level(ResultSet res) {
        Level[] l = levelList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Level(0);
    }

    public Query query(ResultSet res) {
        Query[] l = queryList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Query(0);
    }

    public AttributeKind attributeKind(ResultSet res) {
        AttributeKind[] l = attributeKindList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new AttributeKind(0);
    }

    public Attribute attribute(ResultSet res) {
        Attribute[] l = attributeList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Attribute(0);
    }

    public Table table(ResultSet res) {
        Table[] l = tableList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Table(0);
    }

    public Database database(ResultSet res) {
        Database[] l = databaseList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Database(0);
    }

}
