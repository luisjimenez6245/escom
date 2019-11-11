/*
* Contenido generado de pruebax
*/

package sources.requests;

import java.util.List;
import/ objectsLanguage;
import/ objectsCountry;
import/ objectsFile;
import/ objectsEmail;
import/ objectsPhone;
import/ objectsWord;
import/ objectsDictonary;
import/ objectsRegion;
import/ objectsUser;
import/ objectsTweet;
import/ objectsLike;



/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public interface repositoryRequests {

    public Language getLanguage();
public List<Language> getLanguageList();

public Country getCountry();
public List<Country> getCountryList();

public File getFile();
public List<File> getFileList();

public Email getEmail();
public List<Email> getEmailList();

public Phone getPhone();
public List<Phone> getPhoneList();

public Word getWord();
public List<Word> getWordList();

public Dictonary getDictonary();
public List<Dictonary> getDictonaryList();

public Region getRegion();
public List<Region> getRegionList();

public User getUser();
public List<User> getUserList();

public Tweet getTweet();
public List<Tweet> getTweetList();

public Like getLike();
public List<Like> getLikeList();


   
}
