/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.requests;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;

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
import models.enums.FileType;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class sourceRequests extends executorRequests implements sources.requests.repositoryRequests {

    private final Gson JSON = new Gson();

    public sourceRequests(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Language getLanguage() {
        Language l = new Language(Integer.parseInt(request.getParameter("languageId") == null ? "0" : request.getParameter("languageId")));
        if (request.getParameter("name") != null) {
            l.name = request.getParameter("name");
        }
        if (request.getParameter("isActive") != null) {
            l.isActive = Boolean.parseBoolean(request.getParameter("isActive"));
        }
        return l;
    }

    @Override
    public Language[] getLanguageList() {
        return null;
    }

    @Override
    public Country getCountry() {
        Country c = new Country(Integer.parseInt(request.getParameter("countryId") == null ? "0" : request.getParameter("countryId")));
        if (request.getParameter("name") != null) {
            c.name = request.getParameter("name");
        }
        if (request.getParameter("isActive") != null) {
            c.isActive = Boolean.parseBoolean(request.getParameter("isActive"));
        }
        c.language = getLanguage();
        if (request.getParameter("extension") != null) {
            c.extension = request.getParameter("extension");
        }
        return c;
    }

    @Override
    public Country[] getCountryList() {
        return null;
    }

    @Override
    public File getFile() {
        File f = new File(Integer.parseInt(request.getParameter("fileId") == null ? "0" : request.getParameter("fileId")));
        if (request.getParameter("name") != null) {
            f.name = request.getParameter("name");
        }
        if (request.getParameter("fileType") != null) {
            f.fileType = FileType.valueOf(request.getParameter("fileType"));
        }
        if (request.getParameter("extension") != null) {
            f.extension = request.getParameter("extension");
        }
        return f;
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
        if (request.getParameter("emails") != null) {
            return JSON.fromJson(request.getParameter("emails"), Email[].class);
        }
        return new Email[0];
    }

    @Override
    public Phone getPhone() {
        return new Phone(Integer.parseInt(request.getParameter("phoneId") == null ? "0" : request.getParameter("phoneId")));
    }

    @Override
    public Phone[] getPhoneList() {
        if (request.getParameter("phones") != null) {
            return JSON.fromJson(request.getParameter("phones"), Phone[].class);
        }
        return new Phone[0];
    }

    @Override
    public Word getWord() {
        Word w = new Word(Integer.parseInt(request.getParameter("wordId") == null ? "0" : request.getParameter("wordId")));
        if (request.getParameter("name") != null) {
            w.name = request.getParameter("name");
        }
        return w;
    }

    @Override
    public Word[] getWordList() {
        return null;
    }

    @Override
    public Dictonary getDictonary() {
        Dictonary d = new Dictonary(Integer.parseInt(request.getParameter("dictonaryId") == null ? "0" : request.getParameter("dictonaryId")));
        if (request.getParameter("translate") != null) {
            d.translate = request.getParameter("translate");
        }
        d.language = getLanguage();
        d.word = getWord();
        return d;
    }

    @Override
    public Dictonary[] getDictonaryList() {
        return null;
    }

    @Override
    public Region getRegion() {
        Region r = new Region(Integer.parseInt(request.getParameter("regionId") == null ? "0" : request.getParameter("regionId")));
        if (request.getParameter("name") != null) {
            r.name = request.getParameter("name");
        }
        if (request.getParameter("isActive") != null) {
            r.isActive = Boolean.parseBoolean(request.getParameter("isActive"));
        }
        r.country = getCountry();
        return r;
    }

    @Override
    public Region[] getRegionList() {
        return null;
    }

    @Override
    public User getUser() {
        User u =  new User(Integer.parseInt(request.getParameter("userId") == null ? "0" : request.getParameter("userId")));
        return u ;
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
