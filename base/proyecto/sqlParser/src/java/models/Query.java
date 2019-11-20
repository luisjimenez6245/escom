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
        return this;
    }

}
