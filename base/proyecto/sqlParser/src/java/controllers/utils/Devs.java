package controllers.utils;

import models.AttributeKind;
import sources.mysql.repositoryMysql;
import sources.requests.repositoryRequests;

/**
 *
 * @author luis
 */
public class Devs extends iController {

    public Devs(repositoryMysql source) {
        super(source);
    }

    @Override
    public void get(String name, repositoryRequests repository) {
        System.out.println(name);
        if (name.equals("attribute")) {
            res = JSON.toJson(source.getAttribute(repository.getAttribute()));
        }
        if (name.equals("attribute_kind")) {
            res = JSON.toJson(source.getAttributeKind(repository.getAttributeKind()));
        }
        if (name.equals("database")) {
            res = JSON.toJson(source.getDatabase(repository.getDatabase()));
        }
        if (name.equals("email")) {
            res = JSON.toJson(source.getEmail(repository.getEmail()));
        }
        if (name.equals("level")) {
            res = JSON.toJson(source.getLevel(repository.getLevel()));
        }
        if (name.equals("phone")) {
            res = JSON.toJson(source.getPhone(repository.getPhone()));
        }
        if (name.equals("query")) {
            res = JSON.toJson(source.getQuery(repository.getQuery()));
        }
        if (name.equals("table")) {
            res = JSON.toJson(source.getTable(repository.getTable()));
        }
        if (name.equals("user")) {
            res = JSON.toJson(source.getUser(repository.getUser()));
        }

    }

    @Override
    public void getList(String name, repositoryRequests repository) {
        if (name.equals("attribute")) {
            res = JSON.toJson(source.getAttributeList(repository.getAttribute()));
        }
        if (name.equals("attribute_kind")) {
            res = JSON.toJson(source.getAttributeKindList(repository.getAttributeKind()));
        }
        if (name.equals("database")) {
            res = JSON.toJson(source.getDatabaseList(repository.getDatabase()));
        }
        if (name.equals("email")) {
            res = JSON.toJson(source.getEmailList(repository.getEmail()));
        }
        if (name.equals("level")) {
            res = JSON.toJson(source.getLevelList(repository.getLevel()));
        }
        if (name.equals("phone")) {
            res = JSON.toJson(source.getPhoneList(repository.getPhone()));
        }
        if (name.equals("query")) {
            res = JSON.toJson(source.getQueryList(repository.getQuery()));
        }
        if (name.equals("table")) {
            res = JSON.toJson(source.getTableList(repository.getTable()));
        }
        if (name.equals("user")) {
            res = JSON.toJson(source.getUserList(repository.getUser()));
        }
    }

    @Override
    public void save(String name, repositoryRequests repository) {
        if (name.equals("attribute")) {
            res = JSON.toJson(source.saveAttribute(repository.getAttribute()));
        }
        if (name.equals("attribute_kind")) {
            res = JSON.toJson(source.saveAttributeKind(repository.getAttributeKind()));
        }
        if (name.equals("database")) {
            res = JSON.toJson(source.saveDatabase(repository.getDatabase()));
        }
        if (name.equals("email")) {
            res = JSON.toJson(source.saveEmail(repository.getEmail()));
        }
        if (name.equals("level")) {
            res = JSON.toJson(source.saveLevel(repository.getLevel()));
        }
        if (name.equals("phone")) {
            res = JSON.toJson(source.savePhone(repository.getPhone()));
        }
        if (name.equals("query")) {
            res = JSON.toJson(source.saveQuery(repository.getQuery()));
        }
        if (name.equals("table")) {
            res = JSON.toJson(source.saveTable(repository.getTable()));
        }
        if (name.equals("user")) {
            res = JSON.toJson(source.saveUser(repository.getUser()));
        }
    }

    @Override
    public void delete(String name, repositoryRequests repository) {
        if (name.equals("attribute")) {
            res = JSON.toJson(source.deleteAttribute((repository.getAttribute()).attributeId));
        }
        if (name.equals("attribute_kind")) {
            res = JSON.toJson(source.deleteAttributeKind(((AttributeKind) repository.getAttributeKind()).attributeKindId));
        }
        if (name.equals("database")) {
            res = JSON.toJson(source.deleteDatabase(repository.getDatabase().databaseId));
        }
        if (name.equals("email")) {
            res = JSON.toJson(source.deleteEmail((repository.getEmail()).emailId));
        }
        if (name.equals("level")) {
            res = JSON.toJson(source.deleteLevel((repository.getLevel()).levelId));
        }
        if (name.equals("phone")) {
            res = JSON.toJson(source.deletePhone((repository.getPhone()).phoneId));
        }
        if (name.equals("query")) {
            res = JSON.toJson(source.deleteQuery((repository.getQuery()).queryId));
        }
        if (name.equals("table")) {
            res = JSON.toJson(source.deleteTable((repository.getTable()).tableId));
        }
        if (name.equals("user")) {
            res = JSON.toJson(source.deleteUser((repository.getUser()).userId));
        }
    }

    @Override
    public void update(String name, repositoryRequests repository) {
        if (name.equals("attribute")) {
            res = JSON.toJson(source.setAttribute(repository.getAttribute()));
        }
        if (name.equals("attribute_kind")) {
            res = JSON.toJson(source.setAttributeKind(repository.getAttributeKind()));
        }
        if (name.equals("database")) {
            res = JSON.toJson(source.setDatabase(repository.getDatabase()));
        }
        if (name.equals("email")) {
            res = JSON.toJson(source.setEmail(repository.getEmail()));
        }
        if (name.equals("level")) {
            res = JSON.toJson(source.setLevel(repository.getLevel()));
        }
        if (name.equals("phone")) {
            res = JSON.toJson(source.setPhone(repository.getPhone()));
        }
        if (name.equals("query")) {
            res = JSON.toJson(source.setQuery(repository.getQuery()));
        }
        if (name.equals("table")) {
            res = JSON.toJson(source.setTable(repository.getTable()));
        }
        if (name.equals("user")) {
            res = JSON.toJson(source.setUser(repository.getUser()));
        }
    }

}
