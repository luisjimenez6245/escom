/*
* Contenido de microTwitterUI generado por $author$
*/

package sources.requests;

import objects.Language;
import objects.Country;
import objects.File;
import objects.Email;
import objects.Phone;
import objects.Word;
import objects.Dictonary;
import objects.Region;
import objects.User;
import objects.Tweet;
import objects.Like;
import objects.Relation;
import objects.Notification;



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
