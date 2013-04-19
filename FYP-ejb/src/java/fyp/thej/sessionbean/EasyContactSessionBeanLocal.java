/*
 * Advance Web Technology ECWI604 - Course Work 2
 */
package fyp.thej.sessionbean;

import fyp.thej.model.User;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Thejanee Walgamage <2008061>
 */
@Local
public interface EasyContactSessionBeanLocal {

    String saveAllFriends(String friendsString);

    boolean authenticateUser(String username, String password);

    String signup(User user);

    String backupContacts(String contactStr, String username);

    boolean getImagesFromAndroid(String friendDetails, String userDetails, String userFbDetails);

    User isUserExist(int userId);

    int getLastRecordId(String tableName, String columnName);

    User saveUser(User user);

    boolean convertStringtoImage(String imageString, String imageSavePath, String folderPath);

    User editUser(User editUser, User newUser);

    boolean doesImgeExists(String imageName);

    String saveEditedUsed(User editedUser);

    User getUserbyUsername(String username);

    User isFbUserExists(int fbId);

    String recognizeFaces(String faces);

    
}
