/*
* Contenido de microTwitterUI generado por $author$
 */
package sources.api;

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
public interface repositoryApi {

    public Language saveLanguage(Language object);

    public Language setLanguage(Language object);

    public Language getLanguage(Language object);

    public Language[] getLanguageList(Language object);

    public int deleteLanguage(int key);

    public Country saveCountry(Country object);

    public Country setCountry(Country object);

    public Country getCountry(Country object);

    public Country[] getCountryList(Country object);

    public int deleteCountry(int key);

    public File saveFile(File object);

    public File setFile(File object);

    public File getFile(File object);

    public File[] getFileList(File object);

    public int deleteFile(int key);

    public Email saveEmail(Email object);

    public Email setEmail(Email object);

    public Email getEmail(Email object);

    public Email[] getEmailList(Email object);

    public int deleteEmail(int key);

    public Phone savePhone(Phone object);

    public Phone setPhone(Phone object);

    public Phone getPhone(Phone object);

    public Phone[] getPhoneList(Phone object);

    public int deletePhone(int key);

    public Word saveWord(Word object);

    public Word setWord(Word object);

    public Word getWord(Word object);

    public Word[] getWordList(Word object);

    public int deleteWord(int key);

    public Dictonary saveDictonary(Dictonary object);

    public Dictonary setDictonary(Dictonary object);

    public Dictonary getDictonary(Dictonary object);

    public Dictonary[] getDictonaryList(Dictonary object);

    public int deleteDictonary(int key);

    public Region saveRegion(Region object);

    public Region setRegion(Region object);

    public Region getRegion(Region object);

    public Region[] getRegionList(Region object);

    public int deleteRegion(int key);

    public User saveUser(User object);

    public User setUser(User object);

    public User getUser(User object);

    public User[] getUserList(User object);

    public int deleteUser(int key);

    public Tweet saveTweet(Tweet object);

    public Tweet setTweet(Tweet object);

    public Tweet getTweet(Tweet object);

    public Tweet[] getTweetList(Tweet object);

    public int deleteTweet(int key);

    public Like saveLike(Like object);

    public Like setLike(Like object);

    public Like getLike(Like object);

    public Like[] getLikeList(Like object);

    public int deleteLike(int key);

    public Relation saveRelation(Relation object);

    public Relation setRelation(Relation object);

    public Relation getRelation(Relation object);

    public Relation[] getRelationList(Relation object);

    public int deleteRelation(int key);

    public Notification saveNotification(Notification object);

    public Notification setNotification(Notification object);

    public Notification getNotification(Notification object);

    public Notification[] getNotificationList(Notification object);

    public int deleteNotification(int key);

}
