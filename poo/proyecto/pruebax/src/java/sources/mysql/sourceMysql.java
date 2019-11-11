/*
* Contenido generado de pruebax
*/

package sources.mysql;

import controllers.security.logger;
import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;


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

public class sourceMysql extends executorMysql implements sources.mysql.repositoryMysql {

    private final mapperMysql MAPPER = new mapperMysql();
    private final logger LOGGER = new logger();
    
    @Override
public Language saveLanguage(Language object){
try {
this.conectar();
String query="insert into language ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.language_id = this.save(query,lista);
this.cierraConexion();
return this.getLanguage(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Language setLanguage(Language object){
try {
this.conectar();
String query="insert into language ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getLanguage(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Language getLanguage(Language object){
try {
this.conectar();
String query = "select l.* from language l";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.language(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Language> getLanguageList(Language object){
try {
this.conectar();
String query = "select l.* from language l";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Language>res=MAPPER.languageList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteLanguage(int key){
try {
this.conectar();
String query = "select l.* from language l";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("language.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Country saveCountry(Country object){
try {
this.conectar();
String query="insert into country ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.country_id = this.save(query,lista);
this.cierraConexion();
return this.getCountry(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Country setCountry(Country object){
try {
this.conectar();
String query="insert into country ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getCountry(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Country getCountry(Country object){
try {
this.conectar();
String query = "select c.* from country c";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.country(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Country> getCountryList(Country object){
try {
this.conectar();
String query = "select c.* from country c";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Country>res=MAPPER.countryList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteCountry(int key){
try {
this.conectar();
String query = "select c.* from country c";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("country.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public File saveFile(File object){
try {
this.conectar();
String query="insert into file ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.file_id = this.save(query,lista);
this.cierraConexion();
return this.getFile(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public File setFile(File object){
try {
this.conectar();
String query="insert into file ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getFile(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public File getFile(File object){
try {
this.conectar();
String query = "select f.* from file f";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.file(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<File> getFileList(File object){
try {
this.conectar();
String query = "select f.* from file f";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<File>res=MAPPER.fileList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteFile(int key){
try {
this.conectar();
String query = "select f.* from file f";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("file.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Email saveEmail(Email object){
try {
this.conectar();
String query="insert into email ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.email_id = this.save(query,lista);
this.cierraConexion();
return this.getEmail(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Email setEmail(Email object){
try {
this.conectar();
String query="insert into email ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getEmail(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Email getEmail(Email object){
try {
this.conectar();
String query = "select e.* from email e";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.email(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Email> getEmailList(Email object){
try {
this.conectar();
String query = "select e.* from email e";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Email>res=MAPPER.emailList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteEmail(int key){
try {
this.conectar();
String query = "select e.* from email e";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("email.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Phone savePhone(Phone object){
try {
this.conectar();
String query="insert into phone ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.phone_id = this.save(query,lista);
this.cierraConexion();
return this.getPhone(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Phone setPhone(Phone object){
try {
this.conectar();
String query="insert into phone ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getPhone(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Phone getPhone(Phone object){
try {
this.conectar();
String query = "select p.* from phone p";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.phone(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Phone> getPhoneList(Phone object){
try {
this.conectar();
String query = "select p.* from phone p";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Phone>res=MAPPER.phoneList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deletePhone(int key){
try {
this.conectar();
String query = "select p.* from phone p";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("phone.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Word saveWord(Word object){
try {
this.conectar();
String query="insert into word ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.word_id = this.save(query,lista);
this.cierraConexion();
return this.getWord(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Word setWord(Word object){
try {
this.conectar();
String query="insert into word ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getWord(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Word getWord(Word object){
try {
this.conectar();
String query = "select w.* from word w";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.word(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Word> getWordList(Word object){
try {
this.conectar();
String query = "select w.* from word w";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Word>res=MAPPER.wordList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteWord(int key){
try {
this.conectar();
String query = "select w.* from word w";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("word.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Dictonary saveDictonary(Dictonary object){
try {
this.conectar();
String query="insert into dictonary ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.dictonary_id = this.save(query,lista);
this.cierraConexion();
return this.getDictonary(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Dictonary setDictonary(Dictonary object){
try {
this.conectar();
String query="insert into dictonary ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getDictonary(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Dictonary getDictonary(Dictonary object){
try {
this.conectar();
String query = "select d.* from dictonary d";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.dictonary(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Dictonary> getDictonaryList(Dictonary object){
try {
this.conectar();
String query = "select d.* from dictonary d";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Dictonary>res=MAPPER.dictonaryList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteDictonary(int key){
try {
this.conectar();
String query = "select d.* from dictonary d";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("dictonary.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Region saveRegion(Region object){
try {
this.conectar();
String query="insert into region ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.region_id = this.save(query,lista);
this.cierraConexion();
return this.getRegion(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Region setRegion(Region object){
try {
this.conectar();
String query="insert into region ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getRegion(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Region getRegion(Region object){
try {
this.conectar();
String query = "select r.* from region r";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.region(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Region> getRegionList(Region object){
try {
this.conectar();
String query = "select r.* from region r";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Region>res=MAPPER.regionList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteRegion(int key){
try {
this.conectar();
String query = "select r.* from region r";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("region.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public User saveUser(User object){
try {
this.conectar();
String query="insert into user ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.user_id = this.save(query,lista);
this.cierraConexion();
return this.getUser(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public User setUser(User object){
try {
this.conectar();
String query="insert into user ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getUser(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public User getUser(User object){
try {
this.conectar();
String query = "select u.* from user u";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.user(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<User> getUserList(User object){
try {
this.conectar();
String query = "select u.* from user u";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<User>res=MAPPER.userList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteUser(int key){
try {
this.conectar();
String query = "select u.* from user u";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("user.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Tweet saveTweet(Tweet object){
try {
this.conectar();
String query="insert into tweet ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.tweet_id = this.save(query,lista);
this.cierraConexion();
return this.getTweet(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Tweet setTweet(Tweet object){
try {
this.conectar();
String query="insert into tweet ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getTweet(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Tweet getTweet(Tweet object){
try {
this.conectar();
String query = "select t.* from tweet t";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.tweet(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Tweet> getTweetList(Tweet object){
try {
this.conectar();
String query = "select t.* from tweet t";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Tweet>res=MAPPER.tweetList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteTweet(int key){
try {
this.conectar();
String query = "select t.* from tweet t";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("tweet.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}


@Override
public Like saveLike(Like object){
try {
this.conectar();
String query="insert into like ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object.like_id = this.save(query,lista);
this.cierraConexion();
return this.getLike(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Like setLike(Like object){
try {
this.conectar();
String query="insert into like ";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
object = this.set(query,lista);
this.cierraConexion();
return this.getLike(object);
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public Like getLike(Like object){
try {
this.conectar();
String query = "select l.* from like l";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
$list$
oobject = MAPPER.like(this.get(query,lista))
this.cierraConexion();
return object;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public List<Like> getLikeList(Like object){
try {
this.conectar();
String query = "select l.* from like l";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
if (object != null) {
$list$
}
List<Like>res=MAPPER.likeList(this.get(query,lista));
this.cierraConexion();
return res;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return null;
}

@Override
public int deleteLike(int key){
try {
this.conectar();
String query = "select l.* from like l";
ArrayList<Pair<String,String>> lista= new ArrayList<>();
parametros.add(new Pair<>("like.id",""+key));
this.delete(query, parametros);
this.cierraConexion();
return key;
} catch(Exception ex){
LOGGER.errorBd(ex);
}
return -1;
}



}
