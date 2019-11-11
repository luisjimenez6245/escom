/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.mysql;

import controllers.security.logger;
import java.util.List;
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
    private final logger LOGGER = new logger();

    @Override
    public Language saveLanguage(Language object) {
        String query = "insert into language ";
        HashMap<String, Object> lista = new HashMap<>();
        object.languageId = this.save(query, lista);
        return this.getLanguage(object);
    }

    @Override
    public Language setLanguage(Language object) {
        String query = "insert into language ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getLanguage(object);
    }

    @Override
    public Language getLanguage(Language object) {
        String query = "select l.* from language l";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.language(this.get(query, lista))
        return object;
    }

    @Override
    public Language[] getLanguageList(Language object) {
        String query = "select l.* from language l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Language> res = MAPPER.languageList(this.get(query, lista));
        return res.toArray(new Language[res.size()]);
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
        String query = "insert into country ";
        HashMap<String, Object> lista = new HashMap<>();
        object.countryId = this.save(query, lista);
        return this.getCountry(object);
    }

    @Override
    public Country setCountry(Country object) {
        String query = "insert into country ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getCountry(object);
    }

    @Override
    public Country getCountry(Country object) {
        String query = "select c.* from country c";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.country(this.get(query, lista))
        return object;
    }

    @Override
    public Country[] getCountryList(Country object) {
        String query = "select c.* from country c";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Country> res = MAPPER.countryList(this.get(query, lista));
        return res.toArray(new Country[res.size()]);
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
        String query = "insert into file ";
        HashMap<String, Object> lista = new HashMap<>();
        object.fileId = this.save(query, lista);
        return this.getFile(object);
    }

    @Override
    public File setFile(File object) {
        String query = "insert into file ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getFile(object);
    }

    @Override
    public File getFile(File object) {
        String query = "select f.* from file f";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.file(this.get(query, lista))
        return object;
    }

    @Override
    public File[] getFileList(File object) {
        String query = "select f.* from file f";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<File> res = MAPPER.fileList(this.get(query, lista));
        return res.toArray(new File[res.size()]);
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
        String query = "insert into email ";
        HashMap<String, Object> lista = new HashMap<>();
        object.emailId = this.save(query, lista);
        return this.getEmail(object);
    }

    @Override
    public Email setEmail(Email object) {
        String query = "insert into email ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getEmail(object);
    }

    @Override
    public Email getEmail(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.email(this.get(query, lista))
        return object;
    }

    @Override
    public Email[] getEmailList(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Email> res = MAPPER.emailList(this.get(query, lista));
        return res.toArray(new Email[res.size()]);
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
        String query = "insert into phone ";
        HashMap<String, Object> lista = new HashMap<>();
        object.phoneId = this.save(query, lista);
        return this.getPhone(object);
    }

    @Override
    public Phone setPhone(Phone object) {
        String query = "insert into phone ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getPhone(object);
    }

    @Override
    public Phone getPhone(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.phone(this.get(query, lista))
        return object;
    }

    @Override
    public Phone[] getPhoneList(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Phone> res = MAPPER.phoneList(this.get(query, lista));
        return res.toArray(new Phone[res.size()]);
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
        String query = "insert into word ";
        HashMap<String, Object> lista = new HashMap<>();
        object.wordId = this.save(query, lista);
        return this.getWord(object);
    }

    @Override
    public Word setWord(Word object) {
        String query = "insert into word ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getWord(object);
    }

    @Override
    public Word getWord(Word object) {
        String query = "select w.* from word w";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.word(this.get(query, lista))
        return object;
    }

    @Override
    public Word[] getWordList(Word object) {
        String query = "select w.* from word w";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Word> res = MAPPER.wordList(this.get(query, lista));
        return res.toArray(new Word[res.size()]);
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
        String query = "insert into dictonary ";
        HashMap<String, Object> lista = new HashMap<>();
        object.dictonaryId = this.save(query, lista);
        return this.getDictonary(object);
    }

    @Override
    public Dictonary setDictonary(Dictonary object) {
        String query = "insert into dictonary ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getDictonary(object);
    }

    @Override
    public Dictonary getDictonary(Dictonary object) {
        String query = "select d.* from dictonary d";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.dictonary(this.get(query, lista))
        return object;
    }

    @Override
    public Dictonary[] getDictonaryList(Dictonary object) {
        String query = "select d.* from dictonary d";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Dictonary> res = MAPPER.dictonaryList(this.get(query, lista));
        return res.toArray(new Dictonary[res.size()]);
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
        String query = "insert into region ";
        HashMap<String, Object> lista = new HashMap<>();
        object.regionId = this.save(query, lista);
        return this.getRegion(object);
    }

    @Override
    public Region setRegion(Region object) {
        String query = "insert into region ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getRegion(object);
    }

    @Override
    public Region getRegion(Region object) {
        String query = "select r.* from region r";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.region(this.get(query, lista))
        return object;
    }

    @Override
    public Region[] getRegionList(Region object) {
        String query = "select r.* from region r";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Region> res = MAPPER.regionList(this.get(query, lista));
        return res.toArray(new Region[res.size()]);
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
        String query = "insert into user ";
        HashMap<String, Object> lista = new HashMap<>();
        object.userId = this.save(query, lista);
        return this.getUser(object);
    }

    @Override
    public User setUser(User object) {
        String query = "insert into user ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getUser(object);
    }

    @Override
    public User getUser(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.user(this.get(query, lista))
        return object;
    }

    @Override
    public User[] getUserList(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<User> res = MAPPER.userList(this.get(query, lista));
        return res.toArray(new User[res.size()]);
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
        String query = "insert into tweet ";
        HashMap<String, Object> lista = new HashMap<>();
        object.tweetId = this.save(query, lista);
        return this.getTweet(object);
    }

    @Override
    public Tweet setTweet(Tweet object) {
        String query = "insert into tweet ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getTweet(object);
    }

    @Override
    public Tweet getTweet(Tweet object) {
        String query = "select t.* from tweet t";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.tweet(this.get(query, lista))
        return object;
    }

    @Override
    public Tweet[] getTweetList(Tweet object) {
        String query = "select t.* from tweet t";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Tweet> res = MAPPER.tweetList(this.get(query, lista));
        return res.toArray(new Tweet[res.size()]);
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
        String query = "insert into like ";
        HashMap<String, Object> lista = new HashMap<>();
        object.likeId = this.save(query, lista);
        return this.getLike(object);
    }

    @Override
    public Like setLike(Like object) {
        String query = "insert into like ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getLike(object);
    }

    @Override
    public Like getLike(Like object) {
        String query = "select l.* from like l";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.like(this.get(query, lista))
        return object;
    }

    @Override
    public Like[] getLikeList(Like object) {
        String query = "select l.* from like l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Like> res = MAPPER.likeList(this.get(query, lista));
        return res.toArray(new Like[res.size()]);
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
        String query = "insert into relation ";
        HashMap<String, Object> lista = new HashMap<>();
        object.relationId = this.save(query, lista);
        return this.getRelation(object);
    }

    @Override
    public Relation setRelation(Relation object) {
        String query = "insert into relation ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getRelation(object);
    }

    @Override
    public Relation getRelation(Relation object) {
        String query = "select r.* from relation r";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.relation(this.get(query, lista))
        return object;
    }

    @Override
    public Relation[] getRelationList(Relation object) {
        String query = "select r.* from relation r";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Relation> res = MAPPER.relationList(this.get(query, lista));
        return res.toArray(new Relation[res.size()]);
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
        String query = "insert into notification ";
        HashMap<String, Object> lista = new HashMap<>();
        object.notificationId = this.save(query, lista);
        return this.getNotification(object);
    }

    @Override
    public Notification setNotification(Notification object) {
        String query = "insert into notification ";
        HashMap<String, Object> lista = new HashMap<>();
        object = this.set(query, lista);
        return this.getNotification(object);
    }

    @Override
    public Notification getNotification(Notification object) {
        String query = "select n.* from notification n";
        HashMap<String, Object> lista = new HashMap<>();
        object = MAPPER.notification(this.get(query, lista))
        return object;
    }

    @Override
    public Notification[] getNotificationList(Notification object) {
        String query = "select n.* from notification n";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {

        }
        List<Notification> res = MAPPER.notificationList(this.get(query, lista));
        return res.toArray(new Notification[res.size()]);
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
