/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;
import java.util.Date;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Notification extends Model {

    public String link;
    public boolean visualized;
    public User user;
    public Date creationDate;
    public int notificationId;
    public String content;

    public Notification(int notificationId) {
        this.notificationId = notificationId;
    }

    public Notification build(String link, boolean visualized, User user, Date creationDate, String content) {
        this.link = link;
        this.visualized = visualized;
        this.user = user;
        this.creationDate = creationDate;
        this.content = content;
        return this;
    }

}
