/*
* Contenido generado de pruebax
*/

package sources.requests;

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

public class sourceRequests extends executorRequests implements sources.requests.repositoryRequests {

    private final mapperRequests MAPPER = new mapperRequests();
    private final logger LOGGER = new logger();
    
    @Override
public Language getLanguage(){
return new Language(Integer.parseInt(request.getParameter("language_id") == null ? "0" : request.getParameter("language_id")));
}
@Override
public List<Language> getLanguageList(){
return null;
}

@Override
public Country getCountry(){
return new Country(Integer.parseInt(request.getParameter("country_id") == null ? "0" : request.getParameter("country_id")));
}
@Override
public List<Country> getCountryList(){
return null;
}

@Override
public File getFile(){
return new File(Integer.parseInt(request.getParameter("file_id") == null ? "0" : request.getParameter("file_id")));
}
@Override
public List<File> getFileList(){
return null;
}

@Override
public Email getEmail(){
return new Email(Integer.parseInt(request.getParameter("email_id") == null ? "0" : request.getParameter("email_id")));
}
@Override
public List<Email> getEmailList(){
return null;
}

@Override
public Phone getPhone(){
return new Phone(Integer.parseInt(request.getParameter("phone_id") == null ? "0" : request.getParameter("phone_id")));
}
@Override
public List<Phone> getPhoneList(){
return null;
}

@Override
public Word getWord(){
return new Word(Integer.parseInt(request.getParameter("word_id") == null ? "0" : request.getParameter("word_id")));
}
@Override
public List<Word> getWordList(){
return null;
}

@Override
public Dictonary getDictonary(){
return new Dictonary(Integer.parseInt(request.getParameter("dictonary_id") == null ? "0" : request.getParameter("dictonary_id")));
}
@Override
public List<Dictonary> getDictonaryList(){
return null;
}

@Override
public Region getRegion(){
return new Region(Integer.parseInt(request.getParameter("region_id") == null ? "0" : request.getParameter("region_id")));
}
@Override
public List<Region> getRegionList(){
return null;
}

@Override
public User getUser(){
return new User(Integer.parseInt(request.getParameter("user_id") == null ? "0" : request.getParameter("user_id")));
}
@Override
public List<User> getUserList(){
return null;
}

@Override
public Tweet getTweet(){
return new Tweet(Integer.parseInt(request.getParameter("tweet_id") == null ? "0" : request.getParameter("tweet_id")));
}
@Override
public List<Tweet> getTweetList(){
return null;
}

@Override
public Like getLike(){
return new Like(Integer.parseInt(request.getParameter("like_id") == null ? "0" : request.getParameter("like_id")));
}
@Override
public List<Like> getLikeList(){
return null;
}


}
