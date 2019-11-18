/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Like;
import models.User;

import models.Language;
import models.Country;
import models.File;
import models.Email;
import models.Phone;
import models.Word;
import models.Dictonary;
import models.Region;
import models.Tweet;
import models.Relation;
import models.Notification;
import models.enums.FileType;
import models.enums.UserType;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class mapperMysql {
    
    public Language language(ResultSet res) {
        Language[] l = languageList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Language(0);
    }
    
    public Country country(ResultSet res) {
        Country[] l = countryList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Country(0);
    }
    
    public File file(ResultSet res) {
        File[] l = fileList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new File(0);
    }
    
    public Email email(ResultSet res) {
        Email[] l = emailList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Email(0);
    }
    
    public Phone phone(ResultSet res) {
        Phone[] l = phoneList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Phone(0);
    }
    
    public Word word(ResultSet res) {
        Word[] l = wordList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Word(0);
    }
    
    public Dictonary dictonary(ResultSet res) {
        Dictonary[] l = dictonaryList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Dictonary(0);
    }
    
    public Region region(ResultSet res) {
        Region[] l = regionList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Region(0);
    }
    
    public Tweet tweet(ResultSet res) {
        Tweet[] l = tweetList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Tweet(0);
    }
    
    public Relation relation(ResultSet res) {
        Relation[] l = relationList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Relation(0);
    }
    
    public Notification notification(ResultSet res) {
        Notification[] l = notificationList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Notification(0);
    }
    
    public User user(ResultSet res) {
        User[] l = userList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new User(0);
    }
    
    public Like like(ResultSet res) {
        Like[] l = likeList(res);
        if (l != null && l.length > 0) {
            return l[0];
        }
        return new Like(0);
    }
    
    public File[] fileList(ResultSet res) {
        try {
            List<File> li = new ArrayList<>();
            while (res.next()) {
                li.add(new File(res.getInt("file_id")).build(res.getString("name"), FileType.valueOf(res.getString("file_type")), res.getString("extension")));
            }
            return (li.size() >= 1) ? li.toArray(new File[li.size()]) : new File[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Email[] emailList(ResultSet res) {
        try {
            List<Email> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Email(res.getInt("email_id")).build(res.getInt("user_id"),res.getBoolean("is_valid"), res.getBoolean("is_principal"), res.getBoolean("is_active"), res.getString("email")));
            }
            return (li.size() >= 1) ? li.toArray(new Email[li.size()]) : new Email[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Phone[] phoneList(ResultSet res) {
        try {
            List<Phone> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Phone(res.getInt("phone_id")).build(res.getInt("user_id"),res.getBoolean("is_valid"),res.getString("email"), res.getBoolean("is_principal"), res.getBoolean("is_active"), new Country(res.getInt("country_id"))));
            }
            return (li.size() >= 1) ? li.toArray(new Phone[li.size()]) : new Phone[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Word[] wordList(ResultSet res) {
        try {
            List<Word> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Word(res.getInt("word_id")).build(res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new Word[li.size()]) : new Word[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Dictonary[] dictonaryList(ResultSet res) {
        try {
            List<Dictonary> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Dictonary(res.getInt("dictonary_id"))
                        .build(res.getString("translate"), new Language(res.getInt("language_id")), new Word(res.getInt("word_id"))));
            }
            return (li.size() >= 1) ? li.toArray(new Dictonary[li.size()]) : new Dictonary[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Region[] regionList(ResultSet res) {
        try {
            List<Region> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Region(res.getInt("region_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Region[li.size()]) : new Region[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Tweet[] tweetList(ResultSet res) {
        try {
            List<Tweet> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Tweet(res.getInt("tweet_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Tweet[li.size()]) : new Tweet[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Relation[] relationList(ResultSet res) {
        try {
            List<Relation> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Relation(res.getInt("relation_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Relation[li.size()]) : new Relation[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Notification[] notificationList(ResultSet res) {
        try {
            List<Notification> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Notification(res.getInt("notification_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Notification[li.size()]) : new Notification[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User[] userList(ResultSet res) {
        try {
            List<User> li = new ArrayList<>();
            while (res.next()) {
                li.add(new User(res.getInt("user_id"))
                        .build(UserType.valueOf(res.getString("user_type")), res.getDate("creation_date"), new Language(res.getInt("language_id")), null , res.getBoolean("is_active"),new File(res.getInt("photo")), res.getString("password"), res.getString("surname"), res.getString("name"), null));
            }
            return (li.size() >= 1) ? li.toArray(new User[li.size()]) : new User[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Like[] likeList(ResultSet res) {
        try {
            List<Like> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Like(res.getInt("like_id")));
            }
            return (li.size() >= 1) ? li.toArray(new Like[li.size()]) : new Like[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Language[] languageList(ResultSet res) {
        try {
            List<Language> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Language(res.getInt("language_id")).build(res.getBoolean("is_active"), res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new Language[li.size()]) : new Language[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public Country[] countryList(ResultSet res) {
        try {
            List<Country> li = new ArrayList<>();
            while (res.next()) {
                li.add(new Country(res.getInt("country_id")).build(new Language(res.getInt("language_id")), res.getBoolean("is_active"), res.getString("extension"), res.getString("name")));
            }
            return (li.size() >= 1) ? li.toArray(new Country[li.size()]) : new Country[0];
        } catch (SQLException ex) {
            Logger.getLogger(mapperMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
