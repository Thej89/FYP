/*
 * Final Year Project(EasyContact)
 */
package fyp.thej.sessionbean;

import fyp.thej.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Thejanee Walgamage <2008061>
 */
@WebService(serviceName = "EasyContactWebservice1")
@Stateless()
public class EasyContactWebservice1 {

    @EJB
    private EasyContactSessionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "saveAllFriends")
    public String saveAllFriends(@WebParam(name = "friendsString") String friendsString) {
        return ejbRef.saveAllFriends(friendsString);
    }

    @WebMethod(operationName = "authenticateUser")
    public boolean authenticateUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.authenticateUser(username, password);
    }

//     @WebMethod(operationName = "signup")
//    public String signup(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
//        return ejbRef.signup(user);
//    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "signup")
    public String signup(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "firstname") String firstname, @WebParam(name = "email") String email) {
        User user = new User();
        user.setUserEmail(email);
        user.setUserFirstName(firstname);
        user.setPassword(password);
        user.setUsername(username);
        return ejbRef.signup(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "saveUserDetails")
    public boolean saveUserDetails(@WebParam(name = "friendDetails") String friendDetails, @WebParam(name = "userDetails") String userDetails, @WebParam(name = "userFbDetails") String userFbDetails) {
        return ejbRef.getImagesFromAndroid(friendDetails, userDetails, userFbDetails);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "backupContacts")
    public String backupContacts(@WebParam(name = "xmlString") String xmlString, @WebParam(name = "username") String username) {
        System.out.println("test");
        return ejbRef.backupContacts(xmlString, username);
    }
}
