/*
* Contenido generado de pruebax
*/

package sources.mysql;

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

public interface repositoryMysql {

    public Language saveLanguage(Language object);
public Language setLanguage(Language object);
public Language getLanguage(Language object);
public List<Language> getLanguageList(Language object);
public int deleteLanguage(int key);

public Country saveCountry(Country object);
public Country setCountry(Country object);
public Country getCountry(Country object);
public List<Country> getCountryList(Country object);
public int deleteCountry(int key);

public File saveFile(File object);
public File setFile(File object);
public File getFile(File object);
public List<File> getFileList(File object);
public int deleteFile(int key);

public Email saveEmail(Email object);
public Email setEmail(Email object);
public Email getEmail(Email object);
public List<Email> getEmailList(Email object);
public int deleteEmail(int key);

public Phone savePhone(Phone object);
public Phone setPhone(Phone object);
public Phone getPhone(Phone object);
public List<Phone> getPhoneList(Phone object);
public int deletePhone(int key);

public Word saveWord(Word object);
public Word setWord(Word object);
public Word getWord(Word object);
public List<Word> getWordList(Word object);
public int deleteWord(int key);

public Dictonary saveDictonary(Dictonary object);
public Dictonary setDictonary(Dictonary object);
public Dictonary getDictonary(Dictonary object);
public List<Dictonary> getDictonaryList(Dictonary object);
public int deleteDictonary(int key);

public Region saveRegion(Region object);
public Region setRegion(Region object);
public Region getRegion(Region object);
public List<Region> getRegionList(Region object);
public int deleteRegion(int key);

public User saveUser(User object);
public User setUser(User object);
public User getUser(User object);
public List<User> getUserList(User object);
public int deleteUser(int key);

public Tweet saveTweet(Tweet object);
public Tweet setTweet(Tweet object);
public Tweet getTweet(Tweet object);
public List<Tweet> getTweetList(Tweet object);
public int deleteTweet(int key);

public Like saveLike(Like object);
public Like setLike(Like object);
public Like getLike(Like object);
public List<Like> getLikeList(Like object);
public int deleteLike(int key);


   
}
