/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.mysql;

import java.util.HashMap;

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
public class sourceMysql extends executorMysql implements sources.mysql.repositoryMysql {

    private final mapperMysql MAPPER = new mapperMysql();

    public sourceMysql(String user, String password, String dbName, String url, String port) {
        super(user, password, dbName, url, port);
    }

    @Override
    public Language saveLanguage(Language object) {
        String query = "language";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        lista.put("is_active", object.isActive);
        object = MAPPER.language(this.save(query, lista));
        return object;
    }

    @Override
    public Language setLanguage(Language object) {
        String query = "update language set ";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("language_id", object.languageId);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        lista.put("is_active", object.isActive);
        object = MAPPER.language(this.set(query, lista));
        return object;
    }

    @Override
    public Language getLanguage(Language object) {
        String query = "select l.* from language l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.languageId != 0) {
                lista.put("language_id", object.languageId);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            lista.put("is_active", object.isActive);
        }
        object = MAPPER.language(this.get(query, lista));
        return object;
    }

    @Override
    public Language[] getLanguageList(Language object) {
        String query = "select l.* from language l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            lista.put("is_active", object.isActive);
        }
        return MAPPER.languageList(this.get(query, lista));
    }

    @Override
    public int deleteLanguage(int key) {
        String query = "select l.* from language l";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("language.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Country saveCountry(Country object) {
        String query = "country";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        lista.put("is_active", object.isActive);
        object = MAPPER.country(this.save(query, lista));
        if (object.language != null) {
            object.language = saveLanguage(object.language);
        }
        return (object);
    }

    @Override
    public Country setCountry(Country object) {
        String query = "update country set ";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.country(this.set(query, lista));
        return (object);
    }

    @Override
    public Country getCountry(Country object) {
        String query = "select c.* from country c";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.country(this.get(query, lista));
        return object;
    }

    @Override
    public Country[] getCountryList(Country object) {
        String query = "select c.* from country c";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.countryList(this.get(query, lista));
    }

    @Override
    public int deleteCountry(int key) {
        String query = "select c.* from country c";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("country.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public File saveFile(File object) {
        String query = "file";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.file(this.save(query, lista));
        return (object);
    }

    @Override
    public File setFile(File object) {
        String query = "file";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.file(this.set(query, lista));
        return (object);
    }

    @Override
    public File getFile(File object) {
        String query = "select f.* from file f";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.file(this.get(query, lista));
        return object;
    }

    @Override
    public File[] getFileList(File object) {
        String query = "select f.* from file f";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.fileList(this.get(query, lista));
    }

    @Override
    public int deleteFile(int key) {
        String query = "select f.* from file f";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("file.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Email saveEmail(Email object) {
        String query = "email";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.email(this.save(query, lista));
        return (object);
    }

    @Override
    public Email setEmail(Email object) {
        String query = "email";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.email(this.set(query, lista));
        return (object);
    }

    @Override
    public Email getEmail(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.email(this.get(query, lista));
        return object;
    }

    @Override
    public Email[] getEmailList(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.emailList(this.get(query, lista));
    }

    @Override
    public int deleteEmail(int key) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("email.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Phone savePhone(Phone object) {
        String query = "phone";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.phone(this.save(query, lista));
        return (object);
    }

    @Override
    public Phone setPhone(Phone object) {
        String query = "phone";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.phone(this.set(query, lista));
        return (object);
    }

    @Override
    public Phone getPhone(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.phone(this.get(query, lista));
        return object;
    }

    @Override
    public Phone[] getPhoneList(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.phoneList(this.get(query, lista));
    }

    @Override
    public int deletePhone(int key) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("phone.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Word saveWord(Word object) {
        String query = "word";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.word(this.save(query, lista));
        return (object);
    }

    @Override
    public Word setWord(Word object) {
        String query = "word";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.word(this.set(query, lista));
        return (object);
    }

    @Override
    public Word getWord(Word object) {
        String query = "select w.* from word w";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.word(this.get(query, lista));
        return object;
    }

    @Override
    public Word[] getWordList(Word object) {
        String query = "select w.* from word w";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.wordList(this.get(query, lista));
    }

    @Override
    public int deleteWord(int key) {
        String query = "select w.* from word w";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("word.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Dictonary saveDictonary(Dictonary object) {
        String query = "dictonary";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.dictonary(this.save(query, lista));
        return (object);
    }

    @Override
    public Dictonary setDictonary(Dictonary object) {
        String query = "dictonary";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.dictonary(this.set(query, lista));
        return (object);
    }

    @Override
    public Dictonary getDictonary(Dictonary object) {
        String query = "select d.* from dictonary d";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.dictonary(this.get(query, lista));
        return object;
    }

    @Override
    public Dictonary[] getDictonaryList(Dictonary object) {
        String query = "select d.* from dictonary d";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.dictonaryList(this.get(query, lista));
    }

    @Override
    public int deleteDictonary(int key) {
        String query = "select d.* from dictonary d";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("dictonary.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Region saveRegion(Region object) {
        String query = "region";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.region(this.save(query, lista));
        return (object);
    }

    @Override
    public Region setRegion(Region object) {
        String query = "region";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.region(this.set(query, lista));
        return (object);
    }

    @Override
    public Region getRegion(Region object) {
        String query = "select r.* from region r";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.region(this.get(query, lista));
        return object;
    }

    @Override
    public Region[] getRegionList(Region object) {
        String query = "select r.* from region r";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.regionList(this.get(query, lista));
    }

    @Override
    public int deleteRegion(int key) {
        String query = "select r.* from region r";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("region.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public User saveUser(User object) {
        String query = "user";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.user(this.save(query, lista));
        return (object);
    }

    @Override
    public User setUser(User object) {
        String query = "user";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.user(this.set(query, lista));
        return this.getUser(object);
    }

    @Override
    public User getUser(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.user(this.get(query, lista));
        return object;
    }

    @Override
    public User[] getUserList(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.userList(this.get(query, lista));
    }

    @Override
    public int deleteUser(int key) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("user.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Tweet saveTweet(Tweet object) {
        String query = "tweet";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.tweet(this.save(query, lista));
        return (object);
    }

    @Override
    public Tweet setTweet(Tweet object) {
        String query = "tweet";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.tweet(this.set(query, lista));
        return this.getTweet(object);
    }

    @Override
    public Tweet getTweet(Tweet object) {
        String query = "select t.* from tweet t";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.tweet(this.get(query, lista));
        return object;
    }

    @Override
    public Tweet[] getTweetList(Tweet object) {
        String query = "select t.* from tweet t";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.tweetList(this.get(query, lista));
    }

    @Override
    public int deleteTweet(int key) {
        String query = "select t.* from tweet t";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("tweet.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Like saveLike(Like object) {
        String query = "like";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.like(this.save(query, lista));
        return (object);
    }

    @Override
    public Like setLike(Like object) {
        String query = "like";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.like(this.set(query, lista));
        return (object);
    }

    @Override
    public Like getLike(Like object) {
        String query = "select l.* from like l";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.like(this.get(query, lista));
        return object;
    }

    @Override
    public Like[] getLikeList(Like object) {
        String query = "select l.* from like l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.likeList(this.get(query, lista));
    }

    @Override
    public int deleteLike(int key) {
        String query = "select l.* from like l";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("like.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Relation saveRelation(Relation object) {
        String query = "relation";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.relation(this.save(query, lista));
        return (object);
    }

    @Override
    public Relation setRelation(Relation object) {
        String query = "relation";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.relation(this.set(query, lista));
        return (object);
    }

    @Override
    public Relation getRelation(Relation object) {
        String query = "select r.* from relation r";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.relation(this.get(query, lista));
        return object;
    }

    @Override
    public Relation[] getRelationList(Relation object) {
        String query = "select r.* from relation r";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.relationList(this.get(query, lista));
    }

    @Override
    public int deleteRelation(int key) {
        String query = "select r.* from relation r";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("relation.id", "" + key);
        this.delete(query, lista);
        return key;
    }

    @Override
    public Notification saveNotification(Notification object) {
        String query = "notification";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.notification(this.save(query, lista));
        return (object);
    }

    @Override
    public Notification setNotification(Notification object) {
        String query = "notification";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.notification(this.set(query, lista));
        return (object);
    }

    @Override
    public Notification getNotification(Notification object) {
        String query = "select n.* from notification n";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.notification(this.get(query, lista));
        return object;
    }

    @Override
    public Notification[] getNotificationList(Notification object) {
        String query = "select n.* from notification n";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        return MAPPER.notificationList(this.get(query, lista));
    }

    @Override
    public int deleteNotification(int key) {
        String query = "select n.* from notification n";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("notification.id", "" + key);
        this.delete(query, lista);
        return key;
    }

}
