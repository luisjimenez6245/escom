/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.requests;

import controllers.security.logger;


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
public class sourceRequests extends executorRequests implements sources.requests.repositoryRequests {

    private final mapperRequests MAPPER = new mapperRequests();
    private final logger LOGGER = new logger();

    @Override
    public Language getLanguage() {
        return new Language(Integer.parseInt(request.getParameter("languageId") == null ? "0" : request.getParameter("languageId")));
    }

    @Override
    public Language[] getLanguageList() {
        return null;
    }

    @Override
    public Country getCountry() {
        return new Country(Integer.parseInt(request.getParameter("countryId") == null ? "0" : request.getParameter("countryId")));
    }

    @Override
    public Country[] getCountryList() {
        return null;
    }

    @Override
    public File getFile() {
        return new File(Integer.parseInt(request.getParameter("fileId") == null ? "0" : request.getParameter("fileId")));
    }

    @Override
    public File[] getFileList() {
        return null;
    }

    @Override
    public Email getEmail() {
        return new Email(Integer.parseInt(request.getParameter("emailId") == null ? "0" : request.getParameter("emailId")));
    }

    @Override
    public Email[] getEmailList() {
        return null;
    }

    @Override
    public Phone getPhone() {
        return new Phone(Integer.parseInt(request.getParameter("phoneId") == null ? "0" : request.getParameter("phoneId")));
    }

    @Override
    public Phone[] getPhoneList() {
        return null;
    }

    @Override
    public Word getWord() {
        return new Word(Integer.parseInt(request.getParameter("wordId") == null ? "0" : request.getParameter("wordId")));
    }

    @Override
    public Word[] getWordList() {
        return null;
    }

    @Override
    public Dictonary getDictonary() {
        return new Dictonary(Integer.parseInt(request.getParameter("dictonaryId") == null ? "0" : request.getParameter("dictonaryId")));
    }

    @Override
    public Dictonary[] getDictonaryList() {
        return null;
    }

    @Override
    public Region getRegion() {
        return new Region(Integer.parseInt(request.getParameter("regionId") == null ? "0" : request.getParameter("regionId")));
    }

    @Override
    public Region[] getRegionList() {
        return null;
    }

    @Override
    public User getUser() {
        return new User(Integer.parseInt(request.getParameter("userId") == null ? "0" : request.getParameter("userId")));
    }

    @Override
    public User[] getUserList() {
        return null;
    }

    @Override
    public Tweet getTweet() {
        return new Tweet(Integer.parseInt(request.getParameter("tweetId") == null ? "0" : request.getParameter("tweetId")));
    }

    @Override
    public Tweet[] getTweetList() {
        return null;
    }

    @Override
    public Like getLike() {
        return new Like(Integer.parseInt(request.getParameter("likeId") == null ? "0" : request.getParameter("likeId")));
    }

    @Override
    public Like[] getLikeList() {
        return null;
    }

    @Override
    public Relation getRelation() {
        return new Relation(Integer.parseInt(request.getParameter("relationId") == null ? "0" : request.getParameter("relationId")));
    }

    @Override
    public Relation[] getRelationList() {
        return null;
    }

    @Override
    public Notification getNotification() {
        return new Notification(Integer.parseInt(request.getParameter("notificationId") == null ? "0" : request.getParameter("notificationId")));
    }

    @Override
    public Notification[] getNotificationList() {
        return null;
    }

}
