/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.requests;

import models.Language;
import models.Country;
import models.File;
import models.Email;
import models.Phone;
import models.Word;
import models.Dictonary;
import models.Region;
import models.User;
import models.Tweet;
import models.Like;
import models.Relation;
import models.Notification;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public interface repositoryRequests {

    public Language getLanguage();

    public Language[] getLanguageList();

    public Country getCountry();

    public Country[] getCountryList();

    public File getFile();

    public File[] getFileList();

    public Email getEmail();

    public Email[] getEmailList();

    public Phone getPhone();

    public Phone[] getPhoneList();

    public Word getWord();

    public Word[] getWordList();

    public Dictonary getDictonary();

    public Dictonary[] getDictonaryList();

    public Region getRegion();

    public Region[] getRegionList();

    public User getUser();

    public User[] getUserList();

    public Tweet getTweet();

    public Tweet[] getTweetList();

    public Like getLike();

    public Like[] getLikeList();

    public Relation getRelation();

    public Relation[] getRelationList();

    public Notification getNotification();

    public Notification[] getNotificationList();

}
