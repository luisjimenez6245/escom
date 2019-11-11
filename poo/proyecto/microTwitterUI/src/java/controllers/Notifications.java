/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Notification;
import sources.api.sourceApi;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Notifications extends iController<Notification>{

    public Notifications(sourceApi source){
        super(source);
    }

    @Override
    public void get(Notification object) {
        res = JSON.toJson(source.getNotification(object));
    }

    @Override
    public void getList(Notification object) {
        res = JSON.toJson(source.getNotificationList(object));
    }

    @Override
    public void save(Notification object) {
        res = JSON.toJson(source.getNotification(object));
    }

    @Override
    public void delete(Notification object) {
        res = "" + source.deleteNotification(object.notificationId);
    }

    @Override
    public void update(Notification object) {
        res = JSON.toJson(source.setNotification(object));
    }
    
}
