/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package models;

import java.util.Date;
import models.utils.Model;
import models.enums.QueryType;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Query extends Model {

    public Date creationDate;
    public QueryType queryType;
    public String name;
    public int queryId;

    public Query(int queryId) {
        this.queryId = queryId;
    }

    public Query build(Date creationDate, QueryType queryType, String name) {
        this.creationDate = creationDate;
        this.queryType = queryType;
        this.name = name;
        setType();
        return this;
    }

    public void setType() {
        if (name != null) {
            String helper = name.replace(" ", "");
            helper = helper.toLowerCase();
            if (helper.startsWith("insert")) {
                this.queryType = QueryType.INSERT;
            } else if (helper.startsWith("select")) {
                this.queryType = QueryType.SELECT;
            } else if (helper.startsWith("update")) {
                this.queryType = QueryType.UPDATE;
            } else if (helper.startsWith("create")) {
                this.queryType = QueryType.CREATE;
            } else if (helper.startsWith("delete")) {
                this.queryType = QueryType.DELETE;
            } else if (helper.startsWith("drop")) {
                this.queryType = QueryType.DROP;
            } else if (helper.startsWith("describe")) {
                this.queryType = QueryType.DESCRIBE;
            } else if (helper.startsWith("alter")) {
                this.queryType = QueryType.ALTER;
            } else if (helper.startsWith("show")) {
                this.queryType = QueryType.SHOW;
            } else {
                this.queryType = QueryType.UNKNOWN;
            }
        }

    }

}
