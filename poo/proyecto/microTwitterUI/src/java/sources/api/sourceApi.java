/*
* Contenido de microTwitterUI generado por $author$
 */
package sources.api;

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
public class sourceApi extends executorApi implements sources.api.repositoryApi {

    private final mapperApi MAPPER = new mapperApi();

    @Override
    public Language saveLanguage(Language object) {
        String url = "languages";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getLanguage(this.save(url, lista, null));
    }

    @Override
    public Country saveCountry(Country object) {
        String url = "countries";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        return MAPPER.getCountry(this.save(url, lista, null));
    }

    @Override
    public File saveFile(File object) {
        String url = "files";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.fileType != null) {
            lista.put("fileType", object.fileType);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        return MAPPER.getFile(this.save(url, lista, null));
    }

    @Override
    public Email saveEmail(Email object) {
        String url = "emails";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.email != null) {
            lista.put("email", object.email);
        }
        lista.put("isPrincipal", object.isPrincipal);
        return MAPPER.getEmail(this.save(url, lista, null));
    }

    @Override
    public Phone savePhone(Phone object) {
        String url = "phones";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.country != null) {
            lista.put("country", object.country);
        }
        if (object.phone != null) {
            lista.put("phone", object.phone);
        }
        lista.put("isPrincipal", object.isPrincipal);
        return MAPPER.getPhone(this.save(url, lista, null));
    }

    @Override
    public Word saveWord(Word object) {
        String url = "words";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getWord(this.save(url, lista, null));
    }

    @Override
    public Dictonary saveDictonary(Dictonary object) {
        String url = "dictonaries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.word != null) {
            lista.put("word", object.word);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.translate != null) {
            lista.put("translate", object.translate);
        }
        return MAPPER.getDictonary(this.save(url, lista, null));
    }

    @Override
    public Region saveRegion(Region object) {
        String url = "regions";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.country != null) {
            lista.put("country", object.country);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getRegion(this.save(url, lista, null));
    }

    @Override
    public User saveUser(User object) {
        String url = "users";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.phones != null) {
            lista.put("phones", object.phones);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.surname != null) {
            lista.put("surname", object.surname);
        }
        if (object.password != null) {
            lista.put("password", object.password);
        }
        if (object.userType != null) {
            lista.put("userType", object.userType);
        }
        if (object.photo != null) {
            lista.put("photo", object.photo);
        }
        if (object.emails != null) {
            lista.put("emails", object.emails);
        }
        return MAPPER.getUser(this.save(url, lista, null));
    }

    @Override
    public Tweet saveTweet(Tweet object) {
        String url = "tweets";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.media != null) {
            lista.put("media", object.media);
        }
        lista.put("isRetweet", object.isRetweet);
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        lista.put("isComent", object.isComent);
        if (object.parent != 0) {
            lista.put("parent", object.parent);
        }
        if (object.content != null) {
            lista.put("content", object.content);
        }
        return MAPPER.getTweet(this.save(url, lista, null));
    }

    @Override
    public Like saveLike(Like object) {
        String url = "likes";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.tweet != null) {
            lista.put("tweet", object.tweet);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.date != null) {
            lista.put("date", object.date);
        }
        return MAPPER.getLike(this.save(url, lista, null));
    }

    @Override
    public Relation saveRelation(Relation object) {
        String url = "relations";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.relationType != null) {
            lista.put("relationType", object.relationType);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.follows != null) {
            lista.put("follows", object.follows);
        }
        return MAPPER.getRelation(this.save(url, lista, null));
    }

    @Override
    public Notification saveNotification(Notification object) {
        String url = "notifications";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        lista.put("visualized", object.visualized);
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.link != null) {
            lista.put("link", object.link);
        }
        if (object.content != null) {
            lista.put("content", object.content);
        }
        return MAPPER.getNotification(this.save(url, lista, null));
    }

    @Override
    public Language setLanguage(Language object) {
        String url = "languages";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        lista.put("languageId", object.languageId);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getLanguage(this.set(url, lista, null));
    }

    @Override
    public Country setCountry(Country object) {
        String url = "countries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        lista.put("isActive", object.isActive);
        lista.put("countryId", object.countryId);
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        return MAPPER.getCountry(this.set(url, lista, null));
    }

    @Override
    public File setFile(File object) {
        String url = "files";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        lista.put("fileId", object.fileId);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.fileType != null) {
            lista.put("fileType", object.fileType);
        }
        return MAPPER.getFile(this.set(url, lista, null));
    }

    @Override
    public Email setEmail(Email object) {
        String url = "emails";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.email != null) {
            lista.put("email", object.email);
        }
        lista.put("isPrincipal", object.isPrincipal);
        lista.put("isActive", object.isActive);
        lista.put("emailId", object.emailId);
        lista.put("emailId", object.emailId);
        return MAPPER.getEmail(this.set(url, lista, null));
    }

    @Override
    public Phone setPhone(Phone object) {
        String url = "phones";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isPrincipal", object.isPrincipal);
        if (object.country != null) {
            lista.put("country", object.country);
        }
        lista.put("isActive", object.isActive);
        lista.put("phoneId", object.phoneId);
        if (object.phone != null) {
            lista.put("phone", object.phone);
        }
        lista.put("phoneId", object.phoneId);
        return MAPPER.getPhone(this.set(url, lista, null));
    }

    @Override
    public Word setWord(Word object) {
        String url = "words";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("wordId", object.wordId);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getWord(this.set(url, lista, null));
    }

    @Override
    public Dictonary setDictonary(Dictonary object) {
        String url = "dictonaries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.word != null) {
            lista.put("word", object.word);
        }
        lista.put("dictonaryId", object.dictonaryId);
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.translate != null) {
            lista.put("translate", object.translate);
        }
        return MAPPER.getDictonary(this.set(url, lista, null));
    }

    @Override
    public Region setRegion(Region object) {
        String url = "regions";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.country != null) {
            lista.put("country", object.country);
        }
        lista.put("regionId", object.regionId);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getRegion(this.set(url, lista, null));
    }

    @Override
    public User setUser(User object) {
        String url = "users";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.photo != null) {
            lista.put("photo", object.photo);
        }
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.password != null) {
            lista.put("password", object.password);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        lista.put("isActive", object.isActive);
        lista.put("userId", object.userId);
        if (object.surname != null) {
            lista.put("surname", object.surname);
        }
        if (object.emails != null) {
            lista.put("emails", object.emails);
        }
        if (object.userType != null) {
            lista.put("userType", object.userType);
        }
        if (object.phones != null) {
            lista.put("phones", object.phones);
        }
        return MAPPER.getUser(this.set(url, lista, null));
    }

    @Override
    public Tweet setTweet(Tweet object) {
        String url = "tweets";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.content != null) {
            lista.put("content", object.content);
        }
        lista.put("isComent", object.isComent);
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        lista.put("tweetId", object.tweetId);
        if (object.parent != 0) {
            lista.put("parent", object.parent);
        }
        lista.put("isRetweet", object.isRetweet);
        if (object.media != null) {
            lista.put("media", object.media);
        }
        return MAPPER.getTweet(this.set(url, lista, null));
    }

    @Override
    public Like setLike(Like object) {
        String url = "likes";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.user != null) {
            lista.put("user", object.user);
        }
        lista.put("likeId", object.likeId);
        if (object.tweet != null) {
            lista.put("tweet", object.tweet);
        }
        if (object.date != null) {
            lista.put("date", object.date);
        }
        return MAPPER.getLike(this.set(url, lista, null));
    }

    @Override
    public Relation setRelation(Relation object) {
        String url = "relations";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.follows != null) {
            lista.put("follows", object.follows);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        lista.put("relationId", object.relationId);
        if (object.relationType != null) {
            lista.put("relationType", object.relationType);
        }
        return MAPPER.getRelation(this.set(url, lista, null));
    }

    @Override
    public Notification setNotification(Notification object) {
        String url = "notifications";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.content != null) {
            lista.put("content", object.content);
        }
        if (object.link != null) {
            lista.put("link", object.link);
        }
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        lista.put("visualized", object.visualized);
        if (object.user != null) {
            lista.put("user", object.user);
        }
        lista.put("notificationId", object.notificationId);
        return MAPPER.getNotification(this.set(url, lista, null));
    }

    @Override
    public Language getLanguage(Language object) {
        String url = "languages";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isActive", object.isActive);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.languageId != 0) {
            lista.put("languageId", object.languageId);
        }
        return MAPPER.getLanguage(this.get(url, lista));
    }

    @Override
    public Country getCountry(Country object) {
        String url = "countries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.countryId != 0) {
            lista.put("countryId", object.countryId);
        }
        lista.put("isActive", object.isActive);
        if (object.language != null) {
            lista.put("language", object.language);
        }
        return MAPPER.getCountry(this.get(url, lista));
    }

    @Override
    public File getFile(File object) {
        String url = "files";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.fileType != null) {
            lista.put("fileType", object.fileType);
        }
        if (object.fileId != 0) {
            lista.put("fileId", object.fileId);
        }
        return MAPPER.getFile(this.get(url, lista));
    }

    @Override
    public Email getEmail(Email object) {
        String url = "emails";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.emailId != 0) {
            lista.put("emailId", object.emailId);
        }
        if (object.emailId != 0) {
            lista.put("emailId", object.emailId);
        }
        lista.put("isActive", object.isActive);
        lista.put("isPrincipal", object.isPrincipal);
        if (object.email != null) {
            lista.put("email", object.email);
        }
        return MAPPER.getEmail(this.get(url, lista));
    }

    @Override
    public Phone getPhone(Phone object) {
        String url = "phones";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.phoneId != 0) {
            lista.put("phoneId", object.phoneId);
        }
        if (object.phoneId != 0) {
            lista.put("phoneId", object.phoneId);
        }
        if (object.country != null) {
            lista.put("country", object.country);
        }
        lista.put("isActive", object.isActive);
        lista.put("isPrincipal", object.isPrincipal);

        if (object.phone != null) {
            lista.put("phone", object.phone);
        }
        return MAPPER.getPhone(this.get(url, lista));
    }

    @Override
    public Word getWord(Word object) {
        String url = "words";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.wordId != 0) {
            lista.put("wordId", object.wordId);
        }
        return MAPPER.getWord(this.get(url, lista));
    }

    @Override
    public Dictonary getDictonary(Dictonary object) {
        String url = "dictonaries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.word != null) {
            lista.put("word", object.word);
        }
        if (object.translate != null) {
            lista.put("translate", object.translate);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.dictonaryId != 0) {
            lista.put("dictonaryId", object.dictonaryId);
        }
        return MAPPER.getDictonary(this.get(url, lista));
    }

    @Override
    public Region getRegion(Region object) {
        String url = "regions";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.country != null) {
            lista.put("country", object.country);
        }
        lista.put("isActive", object.isActive);
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.regionId != 0) {
            lista.put("regionId", object.regionId);
        }
        return MAPPER.getRegion(this.get(url, lista));
    }

    @Override
    public User getUser(User object) {
        String url = "users";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.userId != 0) {
            lista.put("userId", object.userId);
        }
        lista.put("isActive", object.isActive);

        if (object.emails != null) {
            lista.put("emails", object.emails);
        }
        if (object.phones != null) {
            lista.put("phones", object.phones);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.password != null) {
            lista.put("password", object.password);
        }
        if (object.userType != null) {
            lista.put("userType", object.userType);
        }
        if (object.photo != null) {
            lista.put("photo", object.photo);
        }
        if (object.surname != null) {
            lista.put("surname", object.surname);
        }
        return MAPPER.getUser(this.get(url, lista));
    }

    @Override
    public Tweet getTweet(Tweet object) {
        String url = "tweets";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        lista.put("isRetweet", object.isRetweet);
        lista.put("isComent", object.isComent);
        if (object.tweetId != 0) {
            lista.put("tweetId", object.tweetId);
        }
        if (object.media != null) {
            lista.put("media", object.media);
        }
        if (object.parent != 0) {
            lista.put("parent", object.parent);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.content != null) {
            lista.put("content", object.content);
        }
        return MAPPER.getTweet(this.get(url, lista));
    }

    @Override
    public Like getLike(Like object) {
        String url = "likes";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.date != null) {
            lista.put("date", object.date);
        }
        if (object.tweet != null) {
            lista.put("tweet", object.tweet);
        }
        if (object.likeId != 0) {
            lista.put("likeId", object.likeId);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        return MAPPER.getLike(this.get(url, lista));
    }

    @Override
    public Relation getRelation(Relation object) {
        String url = "relations";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.relationId != 0) {
            lista.put("relationId", object.relationId);
        }
        if (object.follows != null) {
            lista.put("follows", object.follows);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.relationType != null) {
            lista.put("relationType", object.relationType);
        }
        return MAPPER.getRelation(this.get(url, lista));
    }

    @Override
    public Notification getNotification(Notification object) {
        String url = "notifications";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.notificationId != 0) {
            lista.put("notificationId", object.notificationId);
        }
        if (object.link != null) {
            lista.put("link", object.link);
        }
        lista.put("visualized", object.visualized);

        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.content != null) {
            lista.put("content", object.content);
        }
        return MAPPER.getNotification(this.get(url, lista));
    }

    @Override
    public Language[] getLanguageList(Language object) {
        String url = "languages";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.languageId != 0) {
            lista.put("languageId", object.languageId);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        lista.put("isActive", object.isActive);
        return MAPPER.getLanguageList(this.getList(url, lista));
    }

    @Override
    public Country[] getCountryList(Country object) {
        String url = "countries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.name != null) {
            lista.put("name", object.name);
        }
        lista.put("isActive", object.isActive);
        if (object.countryId != 0) {
            lista.put("countryId", object.countryId);
        }
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        return MAPPER.getCountryList(this.getList(url, lista));
    }

    @Override
    public File[] getFileList(File object) {
        String url = "files";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.extension != null) {
            lista.put("extension", object.extension);
        }
        if (object.fileId != 0) {
            lista.put("fileId", object.fileId);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.fileType != null) {
            lista.put("fileType", object.fileType);
        }
        return MAPPER.getFileList(this.getList(url, lista));
    }

    @Override
    public Email[] getEmailList(Email object) {
        String url = "emails";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isPrincipal", object.isPrincipal);

        lista.put("isActive", object.isActive);
        if (object.email != null) {
            lista.put("email", object.email);
        }
        if (object.emailId != 0) {
            lista.put("emailId", object.emailId);
        }
        if (object.emailId != 0) {
            lista.put("emailId", object.emailId);
        }
        return MAPPER.getEmailList(this.getList(url, lista));
    }

    @Override
    public Phone[] getPhoneList(Phone object) {
        String url = "phones";
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("isPrincipal", object.isPrincipal);
        lista.put("isActive", object.isActive);
        if (object.country != null) {
            lista.put("country", object.country);
        }
        if (object.phoneId != 0) {
            lista.put("phoneId", object.phoneId);
        }
        if (object.phone != null) {
            lista.put("phone", object.phone);
        }
        if (object.phoneId != 0) {
            lista.put("phoneId", object.phoneId);
        }
        return MAPPER.getPhoneList(this.getList(url, lista));
    }

    @Override
    public Word[] getWordList(Word object) {
        String url = "words";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.wordId != 0) {
            lista.put("wordId", object.wordId);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        return MAPPER.getWordList(this.getList(url, lista));
    }

    @Override
    public Dictonary[] getDictonaryList(Dictonary object) {
        String url = "dictonaries";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.word != null) {
            lista.put("word", object.word);
        }
        if (object.translate != null) {
            lista.put("translate", object.translate);
        }
        if (object.dictonaryId != 0) {
            lista.put("dictonaryId", object.dictonaryId);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        return MAPPER.getDictonaryList(this.getList(url, lista));
    }

    @Override
    public Region[] getRegionList(Region object) {
        String url = "regions";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.country != null) {
            lista.put("country", object.country);
        }
        if (object.regionId != 0) {
            lista.put("regionId", object.regionId);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        lista.put("isActive", object.isActive);
        return MAPPER.getRegionList(this.getList(url, lista));
    }

    @Override
    public User[] getUserList(User object) {
        String url = "users";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.surname != null) {
            lista.put("surname", object.surname);
        }
        if (object.name != null) {
            lista.put("name", object.name);
        }
        if (object.userType != null) {
            lista.put("userType", object.userType);
        }
        lista.put("isActive", object.isActive);
        if (object.phones != null) {
            lista.put("phones", object.phones);
        }
        if (object.language != null) {
            lista.put("language", object.language);
        }
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.userId != 0) {
            lista.put("userId", object.userId);
        }
        if (object.password != null) {
            lista.put("password", object.password);
        }
        if (object.photo != null) {
            lista.put("photo", object.photo);
        }
        if (object.emails != null) {
            lista.put("emails", object.emails);
        }
        return MAPPER.getUserList(this.getList(url, lista));
    }

    @Override
    public Tweet[] getTweetList(Tweet object) {
        String url = "tweets";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.media != null) {
            lista.put("media", object.media);
        }
        if (object.parent != 0) {
            lista.put("parent", object.parent);
        }
        lista.put("isRetweet", object.isRetweet);
        lista.put("isComent", object.isComent);
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.tweetId != 0) {
            lista.put("tweetId", object.tweetId);
        }
        if (object.content != null) {
            lista.put("content", object.content);
        }
        return MAPPER.getTweetList(this.getList(url, lista));
    }

    @Override
    public Like[] getLikeList(Like object) {
        String url = "likes";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.tweet != null) {
            lista.put("tweet", object.tweet);
        }
        if (object.likeId != 0) {
            lista.put("likeId", object.likeId);
        }
        if (object.date != null) {
            lista.put("date", object.date);
        }
        return MAPPER.getLikeList(this.getList(url, lista));
    }

    @Override
    public Relation[] getRelationList(Relation object) {
        String url = "relations";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.relationType != null) {
            lista.put("relationType", object.relationType);
        }
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.relationId != 0) {
            lista.put("relationId", object.relationId);
        }
        if (object.follows != null) {
            lista.put("follows", object.follows);
        }
        return MAPPER.getRelationList(this.getList(url, lista));
    }

    @Override
    public Notification[] getNotificationList(Notification object) {
        String url = "notifications";
        HashMap<String, Object> lista = new HashMap<>();
        if (object.creationDate != null) {
            lista.put("creationDate", object.creationDate);
        }
        lista.put("visualized", object.visualized);
        if (object.user != null) {
            lista.put("user", object.user);
        }
        if (object.notificationId != 0) {
            lista.put("notificationId", object.notificationId);
        }
        if (object.link != null) {
            lista.put("link", object.link);
        }
        if (object.content != null) {
            lista.put("content", object.content);
        }
        return MAPPER.getNotificationList(this.getList(url, lista));
    }

    @Override
    public int deleteLanguage(int key) {
        String url = "languages";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("languageId", key);
        }
        if (MAPPER.getLanguage(this.delete(url, lista)).languageId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteCountry(int key) {
        String url = "countries";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("countryId", key);
        }
        if (MAPPER.getCountry(this.delete(url, lista)).countryId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteFile(int key) {
        String url = "files";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("fileId", key);
        }
        if (MAPPER.getFile(this.delete(url, lista)).fileId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteEmail(int key) {
        String url = "emails";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("emailId", key);
        }
        if (key != 0) {
            lista.put("emailId", key);
        }
        if (MAPPER.getEmail(this.delete(url, lista)).emailId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deletePhone(int key) {
        String url = "phones";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("phoneId", key);
        }
        if (key != 0) {
            lista.put("phoneId", key);
        }
        if (MAPPER.getPhone(this.delete(url, lista)).phoneId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteWord(int key) {
        String url = "words";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("wordId", key);
        }
        if (MAPPER.getWord(this.delete(url, lista)).wordId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteDictonary(int key) {
        String url = "dictonaries";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("dictonaryId", key);
        }
        if (MAPPER.getDictonary(this.delete(url, lista)).dictonaryId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteRegion(int key) {
        String url = "regions";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("regionId", key);
        }
        if (MAPPER.getRegion(this.delete(url, lista)).regionId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteUser(int key) {
        String url = "users";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("userId", key);
        }
        if (MAPPER.getUser(this.delete(url, lista)).userId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteTweet(int key) {
        String url = "tweets";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("tweetId", key);
        }
        if (MAPPER.getTweet(this.delete(url, lista)).tweetId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteLike(int key) {
        String url = "likes";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("likeId", key);
        }
        if (MAPPER.getLike(this.delete(url, lista)).likeId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteRelation(int key) {
        String url = "relations";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("relationId", key);
        }
        if (MAPPER.getRelation(this.delete(url, lista)).relationId == key) {
            return key;
        }
        return 0;
    }

    @Override
    public int deleteNotification(int key) {
        String url = "notifications";
        HashMap<String, Object> lista = new HashMap<>();
        if (key != 0) {
            lista.put("notificationId", key);
        }
        if (MAPPER.getNotification(this.delete(url, lista)).notificationId == key) {
            return key;
        }
        return 0;
    }

}
