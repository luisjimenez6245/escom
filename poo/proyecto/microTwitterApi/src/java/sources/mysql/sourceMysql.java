/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.mysql;

import java.util.Date;
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
    public Language setLanguage(Language object) {
        String query = " update language set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("language_id", object.languageId);
        params.put("is_active", object.isActive);
        if (object.name != null) {
            params.put("name", object.name);
        }
        object = MAPPER.language(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Country setCountry(Country object) {
        String query = " update country set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("country_id", object.countryId);
        if (object.extension != null) {
            params.put("extension", object.extension);
        }
        if (object.name != null) {
            params.put("name", object.name);
        }
        params.put("is_active", object.isActive);
        if (object.language != null) {
            params.put("language", object.language);
        }
        object = MAPPER.country(this.set(query, params, conditions));
        return object;
    }

    @Override
    public File setFile(File object) {
        String query = " update file set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("file_id", object.fileId);
        if (object.extension != null) {
            params.put("extension", object.extension);
        }
        if (object.name != null) {
            params.put("name", object.name);
        }
        if (object.fileType != null) {
            params.put("file_type", object.fileType);
        }
        object = MAPPER.file(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Email setEmail(Email object) {
        String query = " update email set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("email_id", object.emailId);
        if (object.email != null) {
            params.put("email", object.email);
        }
        params.put("is_active", object.isActive);
        params.put("is_principal", object.isPrincipal);
        object = MAPPER.email(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Phone setPhone(Phone object) {
        String query = " update phone set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("phone_id", object.phoneId);
        params.put("is_active", object.isActive);
        if (object.country != null) {
            params.put("country", object.country);
        }
        if (object.phone != null) {
            params.put("phone", object.phone);
        }
        params.put("is_principal", object.isPrincipal);

        object = MAPPER.phone(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Word setWord(Word object) {
        String query = " update word set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("word_id", object.wordId);
        if (object.name != null) {
            params.put("name", object.name);
        }
        object = MAPPER.word(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Dictonary setDictonary(Dictonary object) {
        String query = " update dictonary set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("dictonary_id", object.dictonaryId);
        if (object.translate != null) {
            params.put("translate", object.translate);
        }
        if (object.word != null) {
            params.put("word", object.word);
        }
        if (object.language != null) {
            params.put("language", object.language);
        }
        object = MAPPER.dictonary(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Region setRegion(Region object) {
        String query = " update region set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("region_id", object.regionId);
        if (object.country != null) {
            params.put("country", object.country);
        }
        if (object.name != null) {
            params.put("name", object.name);
        }
        params.put("is_active", object.isActive);

        object = MAPPER.region(this.set(query, params, conditions));
        return object;
    }

    @Override
    public User setUser(User object) {
        String query = " update user set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("user_id", object.userId);
        if (object.password != null) {
            params.put("password", object.password);
        }
        if (object.userType != null) {
            params.put("user_type", object.userType);
        }
        if (object.creationDate != null) {
            params.put("creation_date", object.creationDate);
        }
        if (object.name != null) {
            params.put("name", object.name);
        }
        if (object.surname != null) {
            params.put("surname", object.surname);
        }
        params.put("is_active", object.isActive);

        if (object.emails != null) {
            params.put("emails", object.emails);
        }
        if (object.photo != null) {
            params.put("photo", object.photo);
        }
        if (object.phones != null) {
            params.put("phones", object.phones);
        }
        if (object.language != null) {
            params.put("language", object.language);
        }
        object = MAPPER.user(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Tweet setTweet(Tweet object) {
        String query = " update tweet set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("tweet_id", object.tweetId);
        if (object.content != null) {
            params.put("content", object.content);
        }
        params.put("is_coment", object.isComent);
        if (object.creationDate != null) {
            params.put("creation_date", object.creationDate);
        }
        if (object.parent != 0) {
            params.put("parent", object.parent);
        }
        if (object.user != null) {
            params.put("user", object.user);
        }
        if (object.media != null) {
            params.put("media", object.media);
        }
        params.put("is_retweet", object.isRetweet);

        object = MAPPER.tweet(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Like setLike(Like object) {
        String query = " update _like set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("like_id", object.likeId);
        if (object.tweet != null) {
            params.put("tweet", object.tweet);
        }
        if (object.user != null) {
            params.put("user", object.user);
        }
        if (object.date != null) {
            params.put("date", object.date);
        }
        object = MAPPER.like(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Relation setRelation(Relation object) {
        String query = " update relation set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("relation_id", object.relationId);
        if (object.creationDate != null) {
            params.put("creation_date", object.creationDate);
        }
        if (object.user != null) {
            params.put("user", object.user);
        }
        if (object.follows != null) {
            params.put("follows", object.follows);
        }
        if (object.relationType != null) {
            params.put("relation_type", object.relationType);
        }
        object = MAPPER.relation(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Notification setNotification(Notification object) {
        String query = " update notification set ";
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("notification_id", object.notificationId);
        params.put("visualized", object.visualized);
        if (object.content != null) {
            params.put("content", object.content);
        }
        if (object.creationDate != null) {
            params.put("creation_date", object.creationDate);
        }
        if (object.user != null) {
            params.put("user", object.user);
        }
        if (object.link != null) {
            params.put("link", object.link);
        }
        object = MAPPER.notification(this.set(query, params, conditions));
        return object;
    }

    @Override
    public Language saveLanguage(Language object) {
        Language helper = getLanguage(object);
        if (helper == null || helper.languageId == 0) {
            System.out.println("sss");
            String query = "language";
            HashMap<String, Object> lista = new HashMap<>();
            lista.put("is_active", object.isActive);
            if (object.name != null) {
                lista.put("name", object.name);
            }
            object = MAPPER.language(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Country saveCountry(Country object) {
        Country helper = getCountry(object);
        if (helper == null || helper.countryId == 0) {
            String query = "country";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.language != null) {
                lista.put("language_id", object.language.languageId);
            }
            if (object.extension != null) {
                lista.put("extension", object.extension);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            lista.put("is_active", object.isActive);
            object = MAPPER.country(this.save(query, lista));
            object = getCountry(object);
            return object;
        }
        return helper;
    }

    @Override
    public File saveFile(File object) {
        File helper = getFile(object);
        if (helper == null || helper.fileId == 0) {
            String query = "file";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.fileType != null) {
                lista.put("file_type", object.fileType.toString());
            }
            if (object.extension != null) {
                lista.put("extension", object.extension);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            object = MAPPER.file(this.save(query, lista));
            object = getFile(object);
            return object;
        }
        return helper;
    }

    @Override
    public Email saveEmail(Email object) {
        Email helper = getEmail(object);
        if (helper == null || helper.emailId == 0) {
            String query = "email";
            HashMap<String, Object> lista = new HashMap<>();
            lista.put("is_principal", object.isPrincipal);
            lista.put("is_active", object.isActive);
            if (object.email != null) {
                lista.put("email", object.email);
            }
            object = MAPPER.email(this.save(query, lista));
            object = getEmail(object);
            return object;
        }
        return helper;
    }

    @Override
    public Phone savePhone(Phone object) {
        Phone helper = getPhone(object);
        if (helper == null || helper.phoneId == 0) {
            String query = "phone";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.country != null) {
                lista.put("country_id", object.country.countryId);
            }
            lista.put("is_principal", object.isPrincipal);

            if (object.phone != null) {
                lista.put("phone", object.phone);
            }
            lista.put("is_active", object.isActive);
            object = MAPPER.phone(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Word saveWord(Word object) {
        Word helper = getWord(object);
        if (helper == null || helper.wordId == 0) {
            String query = "word";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.name != null) {
                lista.put("name", object.name);
            }
            object = MAPPER.word(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Dictonary saveDictonary(Dictonary object) {
        Dictonary helper = getDictonary(object);
        if (helper == null || helper.dictonaryId == 0) {
            String query = "dictonary";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.language != null) {
                lista.put("language_id", object.language.languageId);
            }
            if (object.translate != null) {
                lista.put("translate", object.translate);
            }
            if (object.word != null) {
                lista.put("word_id", object.word.wordId);
            }
            object = MAPPER.dictonary(this.save(query, lista));
            object = getDictonary(object);
            return object;
        }
        return helper;
    }

    @Override
    public Region saveRegion(Region object) {
        Region helper = getRegion(object);
        if (helper == null || helper.regionId == 0) {
            String query = "region";
            HashMap<String, Object> lista = new HashMap<>();
            lista.put("is_active", object.isActive);
            if (object.country != null) {
                lista.put("country_id", object.country.countryId);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            object = MAPPER.region(this.save(query, lista));
            object = getRegion(object);
            return object;
        }
        return helper;
    }

    @Override
    public User saveUser(User object) {
        User helper = getUser(object);
        if (helper == null || helper.userId == 0) {
            String query = "user";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.surname != null) {
                lista.put("surname", object.surname);
            }
            if (object.language != null) {
                lista.put("language", object.language);
            }
            if (object.userType != null) {
                lista.put("user_type", object.userType);
            }
            lista.put("creation_date", new Date());
            if (object.name != null) {
                lista.put("name", object.name);
            }
            lista.put("is_active", object.isActive);
            if (object.password != null) {
                lista.put("password", object.password);
            }
            if (object.photo != null) {
                lista.put("photo", object.photo.fileId);
            }
            object = MAPPER.user(this.save(query, lista));
            if (object.emails != null) {
                for (int i = 0; i < object.emails.length; ++i) {
                    object.emails[i].userId = object.userId;
                    object.emails[i] = saveEmail(object.emails[i]);
                }
            }
            if (object.phones != null) {
                for (int i = 0; i < object.phones.length; ++i) {
                    object.phones[i].userId = object.userId;
                    object.phones[i] = savePhone(object.phones[i]);
                }
            }
            object = getUser(object);
            return object;
        }
        return helper;
    }

    @Override
    public Tweet saveTweet(Tweet object) {
        Tweet helper = getTweet(object);
        if (helper == null || helper.tweetId == 0) {
            String query = "tweet";
            HashMap<String, Object> lista = new HashMap<>();
            lista.put("is_coment", object.isComent);
            if (object.parent == 0) {
                lista.put("parent", object.parent);
            }
            lista.put("is_retweet", object.isRetweet);
            if (object.media != null) {
                lista.put("media", object.media);
            }
            if (object.content != null) {
                lista.put("content", object.content);
            }
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.user != null) {
                lista.put("user", object.user);
            }
            object = MAPPER.tweet(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Like saveLike(Like object) {
        Like helper = getLike(object);
        if (helper == null || helper.likeId == 0) {
            String query = "_like";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.user != null) {
                lista.put("user", object.user);
            }
            if (object.date != null) {
                lista.put("date", object.date);
            }
            if (object.tweet != null) {
                lista.put("tweet", object.tweet);
            }
            object = MAPPER.like(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Relation saveRelation(Relation object) {
        Relation helper = getRelation(object);
        if (helper == null || helper.relationId == 0) {
            String query = "relation";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.relationType != null) {
                lista.put("relation_type", object.relationType);
            }
            if (object.follows != null) {
                lista.put("follows", object.follows);
            }
            if (object.user != null) {
                lista.put("user", object.user);
            }
            object = MAPPER.relation(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Notification saveNotification(Notification object) {
        Notification helper = getNotification(object);
        if (helper == null || helper.notificationId == 0) {
            String query = "notification";
            HashMap<String, Object> lista = new HashMap<>();
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.content != null) {
                lista.put("content", object.content);
            }
            lista.put("visualized", object.visualized);
            if (object.link != null) {
                lista.put("link", object.link);
            }
            if (object.user != null) {
                lista.put("user", object.user);
            }
            object = MAPPER.notification(this.save(query, lista));
            return object;
        }
        return helper;
    }

    @Override
    public Language[] getLanguageList(Language object) {
        String query = "select l.* from language l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.languageId != 0) {
                lista.put("language_id", object.languageId);
            }
        }
        return MAPPER.languageList(this.get(query, lista));
    }

    @Override
    public Country[] getCountryList(Country object) {
        String query = "select c.* from country c";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.extension != null) {
                lista.put("extension", object.extension);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.language != null) {
                lista.put("language_id", object.language.languageId);
            }
            if (object.countryId != 0) {
                lista.put("country_id", object.countryId);
            }
        }
        Country[] helper = MAPPER.countryList(this.get(query, lista));
        if (helper != null && helper.length > 0) {
            for (int i = 0; i < helper.length; ++i) {
                helper[i].language = getLanguage(helper[i].language);
            }
        }
        return helper;
    }

    @Override
    public File[] getFileList(File object) {
        String query = "select f.* from file f";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.extension != null) {
                lista.put("extension", object.extension);
            }
            if (object.fileType != null) {
                lista.put("file_type", object.fileType.toString());
            }
            if (object.fileId != 0) {
                lista.put("file_id", object.fileId);
            }
        }
        return MAPPER.fileList(this.get(query, lista));
    }

    @Override
    public Email[] getEmailList(Email object) {
        String query = "select e.* from email e";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.email != null) {
                lista.put("email", object.email);
            }
            if (object.userId != 0) {
                lista.put("user_id", object.userId);
            }
            if (object.emailId != 0) {
                lista.put("email_id", object.emailId);
            }
        }
        return MAPPER.emailList(this.get(query, lista));
    }

    @Override
    public Phone[] getPhoneList(Phone object) {
        String query = "select p.* from phone p";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.country != null) {
                lista.put("country", object.country);
            }
            if (object.phone != null) {
                lista.put("phone", object.phone);
            }
            if (object.userId != 0) {
                lista.put("phone_id", object.userId);
            }
            if (object.phoneId != 0) {
                lista.put("phone_id", object.phoneId);
            }
        }
        return MAPPER.phoneList(this.get(query, lista));
    }

    @Override
    public Word[] getWordList(Word object) {
        String query = "select w.* from word w";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.wordId != 0) {
                lista.put("word_id", object.wordId);
            }
        }
        return MAPPER.wordList(this.get(query, lista));
    }

    @Override
    public Dictonary[] getDictonaryList(Dictonary object) {
        String query = "select d.* from dictonary d";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.translate != null) {
                lista.put("translate", object.translate);
            }
            if (object.language != null) {
                lista.put("language_id", object.language.languageId);
            }
            if (object.word != null) {
                lista.put("word_id", object.word.wordId);
            }
            if (object.dictonaryId != 0) {
                lista.put("dictonary_id", object.dictonaryId);
            }
        }
        Dictonary[] helper = MAPPER.dictonaryList(this.get(query, lista));
        if (helper != null && helper.length > 0) {
            for (int i = 0; i < helper.length; ++i) {
                helper[i].language = getLanguage(helper[i].language);
                helper[i].word = getWord(helper[i].word);
            }
        }
        return helper;
    }

    @Override
    public Region[] getRegionList(Region object) {
        String query = "select r.* from region r";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.name != null) {
                lista.put("name", object.name);
            }
            lista.put("is_active", object.isActive);
            if (object.country != null) {
                lista.put("country_id", object.country.countryId);
            }
            if (object.regionId != 0) {
                lista.put("region_id", object.regionId);
            }
        }
        Region[] helper = MAPPER.regionList(this.get(query, lista));
        if (helper != null && helper.length > 0) {
            for (int i = 0; i < helper.length; ++i) {
                helper[i].country = getCountry(helper[i].country);
            }
        }
        return helper;
    }

    @Override
    public User[] getUserList(User object) {
        String query = "select u.* from user u";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.phones != null) {
                lista.put("phones", object.phones);
            }
            if (object.emails != null) {
                lista.put("emails", object.emails);
            }
            if (object.password != null) {
                lista.put("password", object.password);
            }
            if (object.name != null) {
                lista.put("name", object.name);
            }
            if (object.surname != null) {
                lista.put("surname", object.surname);
            }
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.photo != null) {
                lista.put("photo", object.photo.fileId);
            }
            lista.put("is_active", object.isActive);
            if (object.language != null) {
                lista.put("language_id", object.language.languageId);
            }
            if (object.userId != 0) {
                lista.put("user_id", object.userId);
            }
            if (object.userType != null) {
                lista.put("user_type", object.userType);
            }
        }
        return MAPPER.userList(this.get(query, lista));
    }

    @Override
    public Tweet[] getTweetList(Tweet object) {
        String query = "select t.* from tweet t";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.content != null) {
                lista.put("content", object.content);
            }
            lista.put("is_retweet", object.isRetweet);
            if (object.user != null) {
                lista.put("user_id", object.user.userId);
            }
            lista.put("is_coment", object.isComent);
            if (object.parent != 0) {
                lista.put("parent", object.parent);
            }
            if (object.tweetId != 0) {
                lista.put("tweet_id", object.tweetId);
            }
            if (object.media != null) {
                lista.put("media", object.media.fileId);
            }
        }
        return MAPPER.tweetList(this.get(query, lista));
    }

    @Override
    public Like[] getLikeList(Like object) {
        String query = "select l.* from _like l";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.date != null) {
                lista.put("date", object.date);
            }
            if (object.user != null) {
                lista.put("user_id", object.user.userId);
            }
            if (object.tweet != null) {
                lista.put("tweet_id", object.tweet.tweetId);
            }
            if (object.likeId != 0) {
                lista.put("like_id", object.likeId);
            }
        }
        return MAPPER.likeList(this.get(query, lista));
    }

    @Override
    public Relation[] getRelationList(Relation object) {
        String query = "select r.* from relation r";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.user != null) {
                lista.put("user", object.user);
            }
            if (object.relationId != 0) {
                lista.put("relation_id", object.relationId);
            }
            if (object.relationType != null) {
                lista.put("relation_type", object.relationType);
            }
            if (object.follows != null) {
                lista.put("follows", object.follows);
            }
        }
        return MAPPER.relationList(this.get(query, lista));
    }

    @Override
    public Notification[] getNotificationList(Notification object) {
        String query = "select n.* from notification n";
        HashMap<String, Object> lista = new HashMap<>();
        if (object != null) {
            if (object.creationDate != null) {
                lista.put("creation_date", object.creationDate);
            }
            if (object.content != null) {
                lista.put("content", object.content);
            }
            if (object.user != null) {
                lista.put("user_id", object.user.userId);
            }
            if (object.notificationId != 0) {
                lista.put("notification_id", object.notificationId);
            }
            lista.put("visualized", object.visualized);

            if (object.link != null) {
                lista.put("link", object.link);
            }
        }
        return MAPPER.notificationList(this.get(query, lista));
    }

    @Override
    public Language getLanguage(Language object) {
        Language[] res = getLanguageList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Language(0);
    }

    @Override
    public Country getCountry(Country object) {
        Country[] res = getCountryList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Country(0);
    }

    @Override
    public File getFile(File object) {
        File[] res = getFileList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new File(0);
    }

    @Override
    public Email getEmail(Email object) {
        Email[] res = getEmailList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Email(0);
    }

    @Override
    public Phone getPhone(Phone object) {
        Phone[] res = getPhoneList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Phone(0);
    }

    @Override
    public Word getWord(Word object) {
        Word[] res = getWordList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Word(0);
    }

    @Override
    public Dictonary getDictonary(Dictonary object) {
        Dictonary[] res = getDictonaryList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Dictonary(0);
    }

    @Override
    public Region getRegion(Region object) {
        Region[] res = getRegionList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Region(0);
    }

    @Override
    public User getUser(User object) {
        User[] res = getUserList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new User(0);
    }

    @Override
    public Tweet getTweet(Tweet object) {
        Tweet[] res = getTweetList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Tweet(0);
    }

    @Override
    public Like getLike(Like object) {
        Like[] res = getLikeList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Like(0);
    }

    @Override
    public Relation getRelation(Relation object) {
        Relation[] res = getRelationList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Relation(0);
    }

    @Override
    public Notification getNotification(Notification object) {
        Notification[] res = getNotificationList(object);
        if (res != null && res.length > 0) {
            return res[0];
        }
        return new Notification(0);
    }

    @Override
    public int deleteLanguage(int key) {
        String query = "language";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("languageId", key);
        }
        this.delete(query, lista);
        Language helper = getLanguage(new Language(key));
        if (helper == null || helper.languageId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteCountry(int key) {
        String query = "country";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("countryId", key);
        }
        this.delete(query, lista);
        Country helper = getCountry(new Country(key));
        if (helper == null || helper.countryId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteFile(int key) {
        String query = "file";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("fileId", key);
        }
        this.delete(query, lista);
        File helper = getFile(new File(key));
        if (helper == null || helper.fileId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteEmail(int key) {
        String query = "email";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("emailId", key);
        }
        if (key != 0) {
            lista.put("emailId", key);
        }
        this.delete(query, lista);
        Email helper = getEmail(new Email(key));
        if (helper == null || helper.emailId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deletePhone(int key) {
        String query = "phone";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("phoneId", key);
        }
        if (key != 0) {
            lista.put("phoneId", key);
        }
        this.delete(query, lista);
        Phone helper = getPhone(new Phone(key));
        if (helper == null || helper.phoneId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteWord(int key) {
        String query = "word";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("wordId", key);
        }
        this.delete(query, lista);
        Word helper = getWord(new Word(key));
        if (helper == null || helper.wordId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteDictonary(int key) {
        String query = "dictonary";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("dictonaryId", key);
        }
        this.delete(query, lista);
        Dictonary helper = getDictonary(new Dictonary(key));
        if (helper == null || helper.dictonaryId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteRegion(int key) {
        String query = "region";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("regionId", key);
        }
        this.delete(query, lista);
        Region helper = getRegion(new Region(key));
        if (helper == null || helper.regionId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteUser(int key) {
        String query = "user";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("userId", key);
        }
        this.delete(query, lista);
        User helper = getUser(new User(key));
        if (helper == null || helper.userId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteTweet(int key) {
        String query = "tweet";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("tweetId", key);
        }
        this.delete(query, lista);
        Tweet helper = getTweet(new Tweet(key));
        if (helper == null || helper.tweetId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteLike(int key) {
        String query = "_like";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("likeId", key);
        }
        this.delete(query, lista);
        Like helper = getLike(new Like(key));
        if (helper == null || helper.likeId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteRelation(int key) {
        String query = "relation";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("relationId", key);
        }
        this.delete(query, lista);
        Relation helper = getRelation(new Relation(key));
        if (helper == null || helper.relationId == 0) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteNotification(int key) {
        String query = "notification";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("notificationId", key);
        }
        this.delete(query, lista);
        Notification helper = getNotification(new Notification(key));
        if (helper == null || helper.notificationId == 0) {
            return key;
        }
        return 0;
    }

}
