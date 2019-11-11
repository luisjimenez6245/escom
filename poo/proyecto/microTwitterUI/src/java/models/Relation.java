/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;
import models.enums.RelationType;
import java.util.Date;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Relation extends Model {

    public User user;
    public Date creationDate;
    public int relationId;
    public RelationType relationType;
    public User follows;

    public Relation(int relationId) {
        this.relationId = relationId;
    }

    public Relation build(User user, Date creationDate, RelationType relationType, User follows) {
        this.user = user;
        this.creationDate = creationDate;
        this.relationType = relationType;
        this.follows = follows;
        return this;
    }

}
