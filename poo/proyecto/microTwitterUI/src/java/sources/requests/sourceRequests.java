/*
* Contenido de microTwitterUI generado por $author$
*/

package sources.requests;

import controllers.security.logger;
import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;


import objects.Language;
import objects.Country;
import objects.File;
import objects.Email;
import objects.Phone;
import objects.Word;
import objects.Dictonary;
import objects.Region;
import objects.User;
import objects.Tweet;
import objects.Like;
import objects.Relation;
import objects.Notification;


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
public Language[] getLanguageList(){
return null;
}

@Override
public Country getCountry(){
return new Country(Integer.parseInt(request.getParameter("country_id") == null ? "0" : request.getParameter("country_id")));
}
@Override
public Country[] getCountryList(){
return null;
}

@Override
public File getFile(){
return new File(Integer.parseInt(request.getParameter("file_id") == null ? "0" : request.getParameter("file_id")));
}
@Override
public File[] getFileList(){
return null;
}

@Override
public Email getEmail(){
return new Email(Integer.parseInt(request.getParameter("email_id") == null ? "0" : request.getParameter("email_id")));
}
@Override
public Email[] getEmailList(){
return null;
}

@Override
public Phone getPhone(){
return new Phone(Integer.parseInt(request.getParameter("phone_id") == null ? "0" : request.getParameter("phone_id")));
}
@Override
public Phone[] getPhoneList(){
return null;
}

@Override
public Word getWord(){
return new Word(Integer.parseInt(request.getParameter("word_id") == null ? "0" : request.getParameter("word_id")));
}
@Override
public Word[] getWordList(){
return null;
}

@Override
public Dictonary getDictonary(){
return new Dictonary(Integer.parseInt(request.getParameter("dictonary_id") == null ? "0" : request.getParameter("dictonary_id")));
}
@Override
public Dictonary[] getDictonaryList(){
return null;
}

@Override
public Region getRegion(){
return new Region(Integer.parseInt(request.getParameter("region_id") == null ? "0" : request.getParameter("region_id")));
}
@Override
public Region[] getRegionList(){
return null;
}

@Override
public User getUser(){
return new User(Integer.parseInt(request.getParameter("user_id") == null ? "0" : request.getParameter("user_id")));
}
@Override
public User[] getUserList(){
return null;
}

@Override
public Tweet getTweet(){
return new Tweet(Integer.parseInt(request.getParameter("tweet_id") == null ? "0" : request.getParameter("tweet_id")));
}
@Override
public Tweet[] getTweetList(){
return null;
}

@Override
public Like getLike(){
return new Like(Integer.parseInt(request.getParameter("like_id") == null ? "0" : request.getParameter("like_id")));
}
@Override
public Like[] getLikeList(){
return null;
}

@Override
public Relation getRelation(){
return new Relation(Integer.parseInt(request.getParameter("relation_id") == null ? "0" : request.getParameter("relation_id")));
}
@Override
public Relation[] getRelationList(){
return null;
}

@Override
public Notification getNotification(){
return new Notification(Integer.parseInt(request.getParameter("notification_id") == null ? "0" : request.getParameter("notification_id")));
}
@Override
public Notification[] getNotificationList(){
return null;
}


}
