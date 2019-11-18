/*
* Contenido de microTwitterUI generado por $author$
 */
package sources.api;

import com.google.gson.Gson;

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
public class mapperApi {

    private final Gson JSON = new Gson();

    public Language getLanguage(String json) {
        if (json != null) {
            return JSON.fromJson(json, Language.class);
        }
        return null;
    }

    public Country getCountry(String json) {
        if (json != null) {
            return JSON.fromJson(json, Country.class);
        }
        return null;
    }

    public File getFile(String json) {
        if (json != null) {
            return JSON.fromJson(json, File.class);
        }
        return null;
    }

    public Email getEmail(String json) {
        if (json != null) {
            return JSON.fromJson(json, Email.class);
        }
        return null;
    }

    public Phone getPhone(String json) {
        if (json != null) {
            return JSON.fromJson(json, Phone.class);
        }
        return null;
    }

    public Word getWord(String json) {
        if (json != null) {
            return JSON.fromJson(json, Word.class);
        }
        return null;
    }

    public Dictonary getDictonary(String json) {
        if (json != null) {
            return JSON.fromJson(json, Dictonary.class);
        }
        return null;
    }

    public Region getRegion(String json) {
        if (json != null) {
            return JSON.fromJson(json, Region.class);
        }
        return null;
    }

    public User getUser(String json) {
        if (json != null) {
            return JSON.fromJson(json, User.class);
        }
        return null;
    }

    public Tweet getTweet(String json) {
        if (json != null) {
            return JSON.fromJson(json, Tweet.class);
        }
        return null;
    }

    public Like getLike(String json) {
        if (json != null) {
            return JSON.fromJson(json, Like.class);
        }
        return null;
    }

    public Relation getRelation(String json) {
        if (json != null) {
            return JSON.fromJson(json, Relation.class);
        }
        return null;
    }

    public Notification getNotification(String json) {
        if (json != null) {
            return JSON.fromJson(json, Notification.class);
        }
        return null;
    }

    public Language[] getLanguageList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Language[].class);
        }
        return null;
    }

    public Country[] getCountryList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Country[].class);
        }
        return null;
    }

    public File[] getFileList(String json) {
        if (json != null) {
            return JSON.fromJson(json, File[].class);
        }
        return null;
    }

    public Email[] getEmailList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Email[].class);
        }
        return null;
    }

    public Phone[] getPhoneList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Phone[].class);
        }
        return null;
    }

    public Word[] getWordList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Word[].class);
        }
        return null;
    }

    public Dictonary[] getDictonaryList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Dictonary[].class);
        }
        return null;
    }

    public Region[] getRegionList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Region[].class);
        }
        return null;
    }

    public User[] getUserList(String json) {
        if (json != null) {
            return JSON.fromJson(json, User[].class);
        }
        return null;
    }

    public Tweet[] getTweetList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Tweet[].class);
        }
        return null;
    }

    public Like[] getLikeList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Like[].class);
        }
        return null;
    }

    public Relation[] getRelationList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Relation[].class);
        }
        return null;
    }

    public Notification[] getNotificationList(String json) {
        if (json != null) {
            return JSON.fromJson(json, Notification[].class);
        }
        return null;
    }

}
